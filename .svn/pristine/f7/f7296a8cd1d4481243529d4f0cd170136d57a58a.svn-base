package cn.wewintech.project.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.project.project.dao.TechnicalEconomyDao;
import cn.wewintech.project.project.domain.TechnicalEconomyDO;
import cn.wewintech.project.project.service.TechnicalEconomyService;



@Service
public class TechnicalEconomyServiceImpl implements TechnicalEconomyService {
	@Autowired
	private TechnicalEconomyDao technicalEconomyDao;
	
	@Override
	public TechnicalEconomyDO get(String id){
		return technicalEconomyDao.get(id);
	}
	
	@Override
	public List<TechnicalEconomyDO> list(Map<String, Object> map){
		return technicalEconomyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return technicalEconomyDao.count(map);
	}
	
	@Override
	public int save(TechnicalEconomyDO technicalEconomy){
		technicalEconomy.addData();
		return technicalEconomyDao.save(technicalEconomy);
	}
	
	@Override
	public int update(TechnicalEconomyDO technicalEconomy){
		technicalEconomy.editData();
		return technicalEconomyDao.update(technicalEconomy);
	}
	
	@Override
	public int remove(String id){
		return technicalEconomyDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return technicalEconomyDao.batchRemove(ids);
	}
	
}
