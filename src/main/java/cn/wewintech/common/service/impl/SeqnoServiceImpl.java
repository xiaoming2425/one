package cn.wewintech.common.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.wewintech.common.dao.SeqnoDao;
import cn.wewintech.common.domain.SeqnoDO;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.Constant;
import cn.wewintech.common.utils.xss.DateUtils;




@Service
public class SeqnoServiceImpl implements SeqnoService {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SeqnoDao seqnoDao;
	
	@Override
	public SeqnoDO get(String id){
		return seqnoDao.get(id);
	}
	
	@Override
	public List<SeqnoDO> list(Map<String, Object> map){
		return seqnoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return seqnoDao.count(map);
	}
	
	@Override
	public int save(SeqnoDO seqno){
		seqno.addData();
		return seqnoDao.save(seqno);
	}
	
	@Override
	public int update(SeqnoDO seqno){
		seqno.editData();
		return seqnoDao.update(seqno);
	}
	
	@Override
	public int remove(String id){
		return seqnoDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return seqnoDao.batchRemove(ids);
	}
	
	/**
	 * 根据编号的code获取下个编号,(同时数据库会更新) 
	 * 如果返回null，则说明该编号的应用机构未设置用户所在机构， 或者该编号未设置自动生成
	 * 
	 * @param code
	 * @return
	 */
	@Override
	public String nextId(String code) {
        return nextIdNew(code, true);
	}
	
	 /**
     * 根据编号的code获取下个编号,(同时数据库会更新) 如果返回null，则说明该编号的应用机构未设置用户所在机构，
     * 或者(ignoreStatusFlag:false)时该编号未设置自动生成
     * 
     * @param code
     * @param ignoreStatusFlag
     *            true:自动生成未开启也获取编号
     * @return
     */
 
    public String nextIdNew(String code, boolean ignoreStatusFlag) {
        Result result = getResultNew(code, ignoreStatusFlag);
        if (result != null) {
            int i = 0;
            while (result.getResult() == 0) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++i;
                result = getResultNew(code, ignoreStatusFlag);
            }
            if (i > 0) {
                logger.error("nextId:" + code + ",i:" + i);
            }

            return result.getNo();
        }
        return null;
    }
    
    
    private Result getResultNew(String code, boolean ignoreStatusFlag) {
        SeqnoDO seqno = this.getCurrentSeqNo(code, true, ignoreStatusFlag);
        if (seqno != null) {
            seqno.editData();
            int i = seqnoDao.updateNo(seqno);

            Result result = new Result();
            if (i > 0) {
                String rtn = getByRule(seqno.getRule(), seqno.getNoLength(), seqno.getMaxValue(), false);
                result = new Result();
                result.setResult(1);
                result.setNo(rtn);
            }
            return result;
        }
        return null;
    }
    
    /**
     * 
     * @param code
     *            编号code
     * @param updateFlag
     *            是否需要更新编号的历史记录
     * @param ignoreStatusFlag
     *            无论是否自动编号都获取下一个编号
     * @return
     */
    private SeqnoDO getCurrentSeqNo(String code, boolean updateFlag, boolean ignoreStatusFlag) {
		SeqnoDO seqno = getCurrentUserSeqNoByCode(code);
		// 获取流水号生成规则
        if (ignoreStatusFlag) {
        	Date workDay = new Date(System.currentTimeMillis());
			int step = seqno.getStep();

			// 生成类型 (1按日生成  2按月生成  3按年生成 )
			int genType = seqno.getGenType();
			Long maxValue = seqno.getCurValue();
			Long newCurValue = null;
			if (maxValue == null) {
				maxValue = new Long(seqno.getInitValue());
			}
			// 按日生成
			if (genType == 1) {
				// 系统当前日期
				String curDay = DateFormatUtils.format(workDay, "yyyyMMdd");
				SeqnoDO historySeqnoQuery = new SeqnoDO();
				historySeqnoQuery.setSeqnoCode(code);
				historySeqnoQuery.setCurDate(curDay);
				SeqnoDO historySeqnoResult = seqnoDao.getHistorySeqNo(historySeqnoQuery);
				// 历史记录不为空，则取历史记录的最大值
				if(historySeqnoResult != null) {
					Long historyMaxValue = historySeqnoResult.getCurValue();
					maxValue = historyMaxValue + step;
					// 是否更新编号历史记录
					historySeqnoResult.setCurValue(maxValue);
					saveSeqNoHistory(historySeqnoResult,updateFlag);
				}else {
					String oldDate = seqno.getCurDate();
					if (!(curDay.equals(oldDate))) {
						// 插入该编号的历史记录
						saveSeqNoHistory(seqno,updateFlag);
						seqno.setCurDate(curDay);
						maxValue = new Long(seqno.getInitValue());
					} else {
						maxValue = maxValue + step;
					}
					newCurValue = maxValue;
				}
				// 按月生成
			} else if (genType == 2) {
				// 历史记录不为空，则取历史记录的最大值
				SeqnoDO historySeqnoQuery = new SeqnoDO();
				String curDay = DateFormatUtils.format(workDay, "yyyyMM01");
				historySeqnoQuery.setSeqnoCode(code);
				historySeqnoQuery.setCurDate(curDay);
				SeqnoDO historySeqnoResult = seqnoDao.getHistorySeqNo(historySeqnoQuery);
				if(historySeqnoResult != null) {
					Long historyMaxValue = historySeqnoResult.getCurValue();
					maxValue = historyMaxValue + step;
					// 是否更新编号历史记录
					historySeqnoResult.setCurValue(maxValue);
					saveSeqNoHistory(historySeqnoResult,updateFlag);
				}else {
					// 系统当前年月
					String curYearMonth = DateFormatUtils.format(workDay, "yyyyMM");
					if (!StringUtils.isEmpty(seqno.getCurDate())) {
						String oldYearMonth = seqno.getCurDate().substring(0, 6);
						if (!(curYearMonth.equals(oldYearMonth))) {
							// 插入该编号的历史记录
							saveSeqNoHistory(seqno,updateFlag);
							seqno.setCurDate(DateFormatUtils.format(workDay,
									"yyyyMMdd"));
							maxValue = new Long(seqno.getInitValue());
						} else {
							maxValue = maxValue + step;
						}
						newCurValue = maxValue;
					}
				}
				// 按年生成
			} else if (genType == 3) {
				// 历史记录不为空，则取历史记录的最大值
				SeqnoDO historySeqnoQuery = new SeqnoDO();
				String curDay = DateFormatUtils.format(workDay, "yyyy0101");
				historySeqnoQuery.setSeqnoCode(code);
				historySeqnoQuery.setCurDate(curDay);
				SeqnoDO historySeqnoResult = seqnoDao.getHistorySeqNo(historySeqnoQuery);
				if(historySeqnoResult != null) {
					Long historyMaxValue = historySeqnoResult.getCurValue();
					maxValue = historyMaxValue + step;
					// 是否更新编号历史记录
					historySeqnoResult.setCurValue(maxValue);
					saveSeqNoHistory(historySeqnoResult,updateFlag);
				}else {
					// 系统当前年
					String curYear = DateFormatUtils.format(workDay, "yyyy");
					if (!StringUtils.isEmpty(seqno.getCurDate())) {
						String oldYear = seqno.getCurDate().substring(0, 4);
						if (!(curYear.equals(oldYear))) {
							// 插入该编号的历史记录
							saveSeqNoHistory(seqno,updateFlag);
							seqno.setCurDate(DateFormatUtils.format(workDay,
									"yyyyMMdd"));
							maxValue = new Long(seqno.getInitValue());
						} else {
							maxValue = maxValue + step;
						}
						newCurValue = maxValue;
					}else{//如果旧的年份为空
						String oldYear = "";
						if (!(curYear.equals(oldYear))) {
							// 插入该编号的历史记录
							saveSeqNoHistory(seqno,updateFlag);
							seqno.setCurDate(DateFormatUtils.format(workDay,
									"yyyyMMdd"));
							maxValue = new Long(seqno.getInitValue());
						} else {
							maxValue = maxValue + step;
						}
						newCurValue = maxValue;
					}
				}
			} else {
				maxValue = maxValue + step;
				newCurValue = maxValue;
			}

			seqno.setMaxValue(maxValue);
			seqno.setNewCurValue(newCurValue);
			return seqno;
		}
		return null;
	}
    
    
    
    /**
	 * 生成规则
	 * 
	 * @param rule
	 *            生成规则
	 * @param length
	 *            流水号长度
	 * @param curValue
	 *            流水号现在的值
	 * @param encrypt 
	 * 			    流水号是否显示*
	 * @return
	 */
	public String getByRule(String rule, int length, Long curValue,boolean encrypt) {
		String seqNo = getSeqNo(curValue, length);
		if(encrypt) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i < seqNo.length(); i++) {
				sb.append("*");
			}
			seqNo = sb.toString();
		}
		
		
		Date workDay = new Date(System.currentTimeMillis());
		// 参数：年
		if (rule.contains(Constant.PARAM_YEAR)) {
			rule = rule.replace(Constant.PARAM_YEAR,
					DateFormatUtils.format(workDay, "yyyy"));
		}
		// 参数：月
		if (rule.contains(Constant.PARAM_MONTH)) {
			rule = rule.replace(Constant.PARAM_MONTH,
					DateFormatUtils.format(workDay, "MM"));
		}
		// 参数：日
		if (rule.contains(Constant.PARAM_DAY)) {
			rule = rule.replace(Constant.PARAM_DAY,
					DateFormatUtils.format(workDay, "dd"));
		}
		// 参数：时
		if (rule.contains(Constant.PARAM_HOUR)) {
			rule = rule.replace(Constant.PARAM_HOUR, DateUtils.getHour());
		}
		// 参数：分
		if (rule.contains(Constant.PARAM_MINUTE)) {
			rule = rule.replace(Constant.PARAM_MINUTE, DateUtils.getMinute());
		}
		// 参数：秒
		if (rule.contains(Constant.PARAM_SECONDS)) {
			rule = rule.replace(Constant.PARAM_SECONDS, DateUtils.getSeconds());
		}
		// 参数：流水号
		if (rule.contains(Constant.PARAM_COUNT)) {
			rule = rule.replace(Constant.PARAM_COUNT, seqNo);
		}

		return rule;
	}
	
	/**
	 * 自增序号
	 * 
	 * @param curValue
	 * @param length
	 * @return
	 */
	private static String getSeqNo(Long curValue, int length) {
		if (curValue == null) {
			curValue = Long.valueOf("1");
		}
		String tmp = String.valueOf(curValue);
		int len = length - tmp.length();

		String rtn = "";
		for (int i = 0; i < len; i++) {
			rtn += "0";
		}
		return rtn + tmp;
	}
	
	public void saveSeqNoHistory(SeqnoDO seqno, boolean flag) {
		if(flag) {
			seqnoDao.deleteSeqNoHistory(seqno);
			seqnoDao.insertSeqNoHistory(seqno);
		}
	}
	
	
	/**
	 * 查询当前用户所在机构的编号
	 * 
	 * @return
	 */
	public SeqnoDO getCurrentUserSeqNoByCode(String code) {
			return getByCode(code);
	}
	
	/**
	 * 通过编号的编码查询编号信息，
	 * 
	 * @param code
	 * @return
	 */
	public SeqnoDO getByCode(String code) {
		SeqnoDO seqNo = new SeqnoDO();
		seqNo.setSeqnoCode(code);
		SeqnoDO resultNo = seqnoDao.getByCode(seqNo);
		return resultNo;
	}
	

	
	/**
	 * 流水号生成结果
	 * 
	 * @author Administrator
	 *
	 */
	class Result {
		private int result;
		private String no;

		Result() {
			this.result = 0;
			this.no = "";
		}

		public int getResult() {
			return this.result;
		}

		public void setResult(int result) {
			this.result = result;
		}

		public String getNo() {
			return this.no;
		}

		public void setNo(String no) {
			this.no = no;
		}
	}
	
}
