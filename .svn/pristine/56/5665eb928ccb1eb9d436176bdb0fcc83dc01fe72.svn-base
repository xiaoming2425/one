package cn.wewintech.sale.customerback.dao;

import cn.wewintech.sale.customerback.domain.CustomerBackDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 客户回访
 * @author 
 * @email 
 * @date 2020-05-12 09:19:30
 */
@Mapper
public interface CustomerBackDao {

	CustomerBackDO get(String id);
	
	List<CustomerBackDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CustomerBackDO customerBack);
	
	int update(CustomerBackDO customerBack);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
