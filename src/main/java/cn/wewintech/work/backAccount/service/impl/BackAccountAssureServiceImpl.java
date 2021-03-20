package cn.wewintech.work.backAccount.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.work.backAccount.dao.BackAccountAssureDao;
import cn.wewintech.work.backAccount.domain.BackAccountAssureDO;
import cn.wewintech.work.backAccount.service.BackAccountAssureService;



@Service
public class BackAccountAssureServiceImpl implements BackAccountAssureService {
	@Autowired
	private BackAccountAssureDao backAccountAssureDao;
	
	@Override
	public BackAccountAssureDO get(String id){
		return backAccountAssureDao.get(id);
	}
	
	@Override
	public List<BackAccountAssureDO> list(Map<String, Object> map){
		return backAccountAssureDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return backAccountAssureDao.count(map);
	}
	
	@Override
	public int save(BackAccountAssureDO backAccountAssure){
		backAccountAssure.addData();
		return backAccountAssureDao.save(backAccountAssure);
	}
	
	@Override
	public int update(BackAccountAssureDO backAccountAssure){
		backAccountAssure.editData();
		return backAccountAssureDao.update(backAccountAssure);
	}
	
	@Override
	public int remove(String id){
		return backAccountAssureDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return backAccountAssureDao.batchRemove(ids);
	}
	
}
