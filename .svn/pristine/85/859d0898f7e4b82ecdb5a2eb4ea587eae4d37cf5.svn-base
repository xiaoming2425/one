package cn.wewintech.work.car.dao;

import cn.wewintech.work.car.domain.CarDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用车申请
 * @author 
 * @email 
 * @date 2020-06-02 09:46:05
 */
@Mapper
public interface CarDao {

	CarDO get(String id);
	
	List<CarDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CarDO car);
	
	int update(CarDO car);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
