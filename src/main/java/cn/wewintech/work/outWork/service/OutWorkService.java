package cn.wewintech.work.outWork.service;

import cn.wewintech.work.outWork.domain.OutWorkDO;

import java.util.List;
import java.util.Map;

/**
 * 出差申请
 * 
 * @author 
 * @email 
 * @date 2020-06-01 17:32:09
 */
public interface OutWorkService {
	
	OutWorkDO get(String id);
	
	List<OutWorkDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OutWorkDO outWork);
	
	int update(OutWorkDO outWork);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
