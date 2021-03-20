package cn.wewintech.common.domain;

import java.io.Serializable;
import java.util.Date;
import cn.wewintech.common.core.DataModel;


/**
 * 流水号生成
 * 
 * @author 
 * @email 
 * @date 2020-05-15 16:24:23
 */
public class SeqnoDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号类别
	private String categoryCode;
	//
	private String categoryName;
	//
	private String seqnoCode;
	//
	private String seqnoName;
	//规则
	private String rule;
	//生成类型
	//private Integer genType;
	//流水号长度
	private Integer noLength;
	//当前日期
	//private String curDate;
	//初始值
	//private Long initValue;
	//当前值
	//private Long curValue;
	//步长
	//private Integer step;
	//是否自动生成
	private String status;
	private String genName;
	private Long maxValue;
	private Long newCurValue;
	  
	private Integer initValue = Integer.valueOf(1);
	private Long curValue = Long.valueOf("1");
	private String curDate = "";
	  
	private Integer step = Integer.valueOf(1);
	private Integer genType = Integer.valueOf(1);

	public String getGenName() {
		return genName;
	}
	public void setGenName(String genName) {
		this.genName = genName;
	}
	/**
	 * 设置：编号类别
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * 获取：编号类别
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 设置：
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：
	 */
	public void setSeqnoCode(String seqnoCode) {
		this.seqnoCode = seqnoCode;
	}
	/**
	 * 获取：
	 */
	public String getSeqnoCode() {
		return seqnoCode;
	}
	/**
	 * 设置：
	 */
	public void setSeqnoName(String seqnoName) {
		this.seqnoName = seqnoName;
	}
	/**
	 * 获取：
	 */
	public String getSeqnoName() {
		return seqnoName;
	}
	/**
	 * 设置：规则
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}
	/**
	 * 获取：规则
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * 设置：生成类型
	 */
	public void setGenType(Integer genType) {
		this.genType = genType;
	}
	/**
	 * 获取：生成类型
	 */
	public Integer getGenType() {
		return genType;
	}
	
	public Integer getNoLength() {
		return noLength;
	}
	public void setNoLength(Integer noLength) {
		this.noLength = noLength;
	}
	/**
	 * 设置：当前日期
	 */
	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}
	/**
	 * 获取：当前日期
	 */
	public String getCurDate() {
		return curDate;
	}
	
	public Long getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
	}
	public Long getNewCurValue() {
		return newCurValue;
	}
	public void setNewCurValue(Long newCurValue) {
		this.newCurValue = newCurValue;
	}
	public Integer getInitValue() {
		return initValue;
	}
	public void setInitValue(Integer initValue) {
		this.initValue = initValue;
	}
	/**
	 * 设置：当前值
	 */
	public void setCurValue(Long curValue) {
		this.curValue = curValue;
	}
	/**
	 * 获取：当前值
	 */
	public Long getCurValue() {
		return curValue;
	}
	/**
	 * 设置：步长
	 */
	public void setStep(Integer step) {
		this.step = step;
	}
	/**
	 * 获取：步长
	 */
	public Integer getStep() {
		return step;
	}
	/**
	 * 设置：是否自动生成
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：是否自动生成
	 */
	public String getStatus() {
		return status;
	}
}
