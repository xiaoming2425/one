package cn.wewintech.sale.projectFlow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.sale.projectFlow.dao.ProjectFlowDao;
import cn.wewintech.sale.projectFlow.domain.ProjectFlowDO;
import cn.wewintech.sale.projectFlow.service.ProjectFlowService;



@Service
public class ProjectFlowServiceImpl implements ProjectFlowService {
	@Autowired
	private ProjectFlowDao projectFlowDao;
	
	@Override
	public ProjectFlowDO get(String id){
		return projectFlowDao.get(id);
	}
	
	@Override
	public List<ProjectFlowDO> list(Map<String, Object> map){
		return projectFlowDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return projectFlowDao.count(map);
	}
	
	@Override
	public int save(ProjectFlowDO projectFlow){
		projectFlow.addData();
		return projectFlowDao.save(projectFlow);
	}
	
	@Override
	public int update(ProjectFlowDO projectFlow){
		projectFlow.editData();
		return projectFlowDao.update(projectFlow);
	}
	
	@Override
	public int remove(String id){
		return projectFlowDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return projectFlowDao.batchRemove(ids);
	}

	@Override
	public List<ProjectFlowDO> flowlist(String id) {
		// TODO Auto-generated method stub
		return projectFlowDao.flowlist(id);
	}

	@Override
	public int flowSave(ProjectFlowDO projectFlow) {
		// TODO Auto-generated method stub
		projectFlow.addData();
		return projectFlowDao.flowSave(projectFlow);
	}
	
}
