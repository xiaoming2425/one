package cn.wewintech.project.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.project.project.dao.ProjectDao;
import cn.wewintech.project.project.domain.ProjectDO;
import cn.wewintech.project.project.service.ProjectService;



@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public ProjectDO get(String id){
		return projectDao.get(id);
	}
	
	@Override
	public List<ProjectDO> list(Map<String, Object> map){
		return projectDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return projectDao.count(map);
	}
	
	@Override
	public int save(ProjectDO project){
		project.addData();
		return projectDao.save(project);
	}
	
	@Override
	public int update(ProjectDO project){
		project.editData();
		return projectDao.update(project);
	}
	
	@Override
	public int remove(String id){
		return projectDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return projectDao.batchRemove(ids);
	}

	@Override
	public ProjectDO getByProjectPlanId(String id) {
		// TODO Auto-generated method stub
		
		return projectDao.getByProjectPlanId(id);
	}
	
}
