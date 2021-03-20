package cn.wewintech.work.contract.dao;

import cn.wewintech.work.contract.domain.ContractApplyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 合同申请
 * @author 
 * @email 
 * @date 2020-06-03 16:02:37
 */
@Mapper
public interface ContractApplyDao {

	ContractApplyDO get(String id);
	
	List<ContractApplyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ContractApplyDO contractApply);
	
	int update(ContractApplyDO contractApply);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
