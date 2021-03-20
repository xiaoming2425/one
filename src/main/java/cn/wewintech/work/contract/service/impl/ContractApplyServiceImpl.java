package cn.wewintech.work.contract.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.work.contract.dao.ContractApplyDao;
import cn.wewintech.work.contract.domain.ContractApplyDO;
import cn.wewintech.work.contract.service.ContractApplyService;



@Service
public class ContractApplyServiceImpl implements ContractApplyService {
	@Autowired
	private ContractApplyDao contractApplyDao;
	
	@Override
	public ContractApplyDO get(String id){
		return contractApplyDao.get(id);
	}
	
	@Override
	public List<ContractApplyDO> list(Map<String, Object> map){
		return contractApplyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return contractApplyDao.count(map);
	}
	
	@Override
	public int save(ContractApplyDO contractApply){
		contractApply.addData();
		return contractApplyDao.save(contractApply);
	}
	
	@Override
	public int update(ContractApplyDO contractApply){
		contractApply.editData();
		return contractApplyDao.update(contractApply);
	}
	
	@Override
	public int remove(String id){
		return contractApplyDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return contractApplyDao.batchRemove(ids);
	}
	
}
