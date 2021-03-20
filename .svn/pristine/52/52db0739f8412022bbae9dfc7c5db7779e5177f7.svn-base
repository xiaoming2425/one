package cn.wewintech.project.project.dao;

import cn.wewintech.project.project.domain.ProjectDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 项目申请
 * @author 
 * @email 
 * @date 2020-05-25 09:00:27
 */
@Mapper
public interface ProjectDao {

	ProjectDO get(String id);
	
	List<ProjectDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProjectDO project);
	
	int update(ProjectDO project);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	ProjectDO getByProjectPlanId(String id);
}
