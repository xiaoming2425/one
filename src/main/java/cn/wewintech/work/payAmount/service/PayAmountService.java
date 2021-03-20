package cn.wewintech.work.payAmount.service;

import cn.wewintech.work.payAmount.domain.PayAmountDO;

import java.util.List;
import java.util.Map;

/**
 * 付款申请
 * 
 * @author 
 * @email 
 * @date 2020-06-03 20:20:35
 */
public interface PayAmountService {
	
	PayAmountDO get(String id);
	
	List<PayAmountDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PayAmountDO payAmount);
	
	int update(PayAmountDO payAmount);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
