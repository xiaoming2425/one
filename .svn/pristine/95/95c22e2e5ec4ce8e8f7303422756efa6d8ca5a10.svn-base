package cn.wewintech.sale.customerback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.sale.customerback.dao.CustomerBackDao;
import cn.wewintech.sale.customerback.domain.CustomerBackDO;
import cn.wewintech.sale.customerback.service.CustomerBackService;



@Service
public class CustomerBackServiceImpl implements CustomerBackService {
	@Autowired
	private CustomerBackDao customerBackDao;
	
	@Override
	public CustomerBackDO get(String id){
		return customerBackDao.get(id);
	}
	
	@Override
	public List<CustomerBackDO> list(Map<String, Object> map){
		return customerBackDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return customerBackDao.count(map);
	}
	
	@Override
	public int save(CustomerBackDO customerBack){
		customerBack.addData();
		return customerBackDao.save(customerBack);
	}
	
	@Override
	public int update(CustomerBackDO customerBack){
		customerBack.editData();
		return customerBackDao.update(customerBack);
	}
	
	@Override
	public int remove(String id){
		return customerBackDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return customerBackDao.batchRemove(ids);
	}
	
}
