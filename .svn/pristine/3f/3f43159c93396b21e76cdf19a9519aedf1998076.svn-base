package cn.wewintech.work.outWork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.work.outWork.dao.OutWorkDao;
import cn.wewintech.work.outWork.domain.OutWorkDO;
import cn.wewintech.work.outWork.service.OutWorkService;



@Service
public class OutWorkServiceImpl implements OutWorkService {
	@Autowired
	private OutWorkDao outWorkDao;
	
	@Override
	public OutWorkDO get(String id){
		return outWorkDao.get(id);
	}
	
	@Override
	public List<OutWorkDO> list(Map<String, Object> map){
		return outWorkDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return outWorkDao.count(map);
	}
	
	@Override
	public int save(OutWorkDO outWork){
		outWork.addData();
		return outWorkDao.save(outWork);
	}
	
	@Override
	public int update(OutWorkDO outWork){
		outWork.editData();
		return outWorkDao.update(outWork);
	}
	
	@Override
	public int remove(String id){
		return outWorkDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return outWorkDao.batchRemove(ids);
	}
	
}
