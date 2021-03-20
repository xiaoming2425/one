package cn.wewintech.project.project.service;

import cn.wewintech.project.project.domain.TechnicalEconomyDO;

import java.util.List;
import java.util.Map;

/**
 * 技经确认
 * 
 * @author 
 * @email 
 * @date 2020-05-29 17:03:47
 */
public interface TechnicalEconomyService {
	
	TechnicalEconomyDO get(String id);
	
	List<TechnicalEconomyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TechnicalEconomyDO technicalEconomy);
	
	int update(TechnicalEconomyDO technicalEconomy);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
