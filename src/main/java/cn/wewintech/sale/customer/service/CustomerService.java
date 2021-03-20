package cn.wewintech.sale.customer.service;

import cn.wewintech.common.domain.TreeNode;
import cn.wewintech.sale.customer.domain.CustomerDO;
import cn.wewintech.system.domain.DeptDO;
import cn.wewintech.system.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * 客户表
 * 
 * @author 
 * @email 
 * @date 2020-05-11 16:54:44
 */
public interface CustomerService {
	
	CustomerDO get(String id);
	
	List<CustomerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CustomerDO customer);
	
	int update(CustomerDO customer);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	List<TreeNode> findDeptList ();
	
	List<UserDO> findAllList();
}
