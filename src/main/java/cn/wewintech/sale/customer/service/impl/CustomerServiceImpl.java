package cn.wewintech.sale.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.common.domain.TreeNode;
import cn.wewintech.sale.customer.dao.CustomerDao;
import cn.wewintech.sale.customer.domain.CustomerDO;
import cn.wewintech.sale.customer.service.CustomerService;
import cn.wewintech.system.domain.DeptDO;
import cn.wewintech.system.domain.UserDO;



@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CustomerDO get(String id){
		return customerDao.get(id);
	}
	
	@Override
	public List<CustomerDO> list(Map<String, Object> map){
		return customerDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return customerDao.count(map);
	}
	
	@Override
	public int save(CustomerDO customer){
		customer.addData();
		return customerDao.save(customer);
	}
	
	@Override
	public int update(CustomerDO customer){
		customer.editData();
		return customerDao.update(customer);
	}
	
	@Override
	public int remove(String id){
		return customerDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return customerDao.batchRemove(ids);
	}

	@Override
	public List<TreeNode> findDeptList() {
		// TODO Auto-generated method stub
		
		return customerDao.findDeptList();
	}

	@Override
	public List<UserDO> findAllList() {
		// TODO Auto-generated method stub
		return customerDao.findAllList();
	}
	
}
