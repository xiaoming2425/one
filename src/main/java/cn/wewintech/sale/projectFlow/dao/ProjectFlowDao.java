package cn.wewintech.sale.projectFlow.dao;

import cn.wewintech.sale.projectFlow.domain.ProjectFlowDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 
 * @email 
 * @date 2020-06-01 11:52:24
 */
@Mapper
public interface ProjectFlowDao {

	ProjectFlowDO get(String id);
	
	List<ProjectFlowDO> list(Map<String,Object> map);
	
	List<ProjectFlowDO> flowlist(String id);
	
	int count(Map<String,Object> map);
	
	int save(ProjectFlowDO projectFlow);
	
	int flowSave(ProjectFlowDO projectFlow);
	
	int update(ProjectFlowDO projectFlow);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
