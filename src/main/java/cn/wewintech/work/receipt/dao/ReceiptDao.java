package cn.wewintech.work.receipt.dao;

import cn.wewintech.work.receipt.domain.ReceiptDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 报销申请
 * @author 
 * @email 
 * @date 2020-06-02 10:33:30
 */
@Mapper
public interface ReceiptDao {

	ReceiptDO get(String id);
	
	List<ReceiptDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ReceiptDO receipt);
	
	int update(ReceiptDO receipt);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
