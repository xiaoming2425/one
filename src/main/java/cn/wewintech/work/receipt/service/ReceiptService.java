package cn.wewintech.work.receipt.service;

import cn.wewintech.work.receipt.domain.ReceiptDO;

import java.util.List;
import java.util.Map;

/**
 * 报销申请
 * 
 * @author 
 * @email 
 * @date 2020-06-02 10:33:30
 */
public interface ReceiptService {
	
	ReceiptDO get(String id);
	
	List<ReceiptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReceiptDO receipt);
	
	int update(ReceiptDO receipt);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
