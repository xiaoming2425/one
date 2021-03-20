package cn.wewintech.project.project.service;

import cn.wewintech.project.project.domain.ProjectManageDO;

import java.util.List;
import java.util.Map;

/**
 * 任务计划管理
 * 
 * @author 
 * @email 
 * @date 2020-05-28 09:05:26
 */
public interface ProjectManageService {
	
	ProjectManageDO get(String id);
	
	List<ProjectManageDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProjectManageDO projectManage);
	
	int update(ProjectManageDO projectManage);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	List<ProjectManageDO> listManager(Map<String,Object> map);
}
