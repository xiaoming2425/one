package cn.wewintech.work.backAccount.dao;

import cn.wewintech.work.backAccount.domain.BackAccountAssureDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 回款申请确认
 * @author 
 * @email 
 * @date 2020-06-03 17:37:08
 */
@Mapper
public interface BackAccountAssureDao {

	BackAccountAssureDO get(String id);
	
	List<BackAccountAssureDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(BackAccountAssureDO backAccountAssure);
	
	int update(BackAccountAssureDO backAccountAssure);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
