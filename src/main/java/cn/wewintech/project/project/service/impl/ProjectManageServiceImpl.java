package cn.wewintech.project.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.project.project.dao.ProjectManageDao;
import cn.wewintech.project.project.domain.ProjectManageDO;
import cn.wewintech.project.project.service.ProjectManageService;



@Service
public class ProjectManageServiceImpl implements ProjectManageService {
	@Autowired
	private ProjectManageDao projectManageDao;
	
	@Override
	public ProjectManageDO get(String id){
		return projectManageDao.get(id);
	}
	
	@Override
	public List<ProjectManageDO> list(Map<String, Object> map){
		return projectManageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return projectManageDao.count(map);
	}
	
	@Override
	public int save(ProjectManageDO projectManage){
		projectManage.addData();
		return projectManageDao.save(projectManage);
	}
	
	@Override
	public int update(ProjectManageDO projectManage){
		projectManage.editData();
		return projectManageDao.update(projectManage);
	}
	
	@Override
	public int remove(String id){
		return projectManageDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return projectManageDao.batchRemove(ids);
	}

	@Override
	public List<ProjectManageDO> listManager(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		return projectManageDao.listManager(map);
	}
	
}
