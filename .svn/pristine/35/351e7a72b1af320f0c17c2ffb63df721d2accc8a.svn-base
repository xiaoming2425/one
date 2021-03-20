package cn.wewintech.work.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.work.car.dao.CarDao;
import cn.wewintech.work.car.domain.CarDO;
import cn.wewintech.work.car.service.CarService;



@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDao carDao;
	
	@Override
	public CarDO get(String id){
		return carDao.get(id);
	}
	
	@Override
	public List<CarDO> list(Map<String, Object> map){
		return carDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return carDao.count(map);
	}
	
	@Override
	public int save(CarDO car){
		car.addData();
		return carDao.save(car);
	}
	
	@Override
	public int update(CarDO car){
		car.editData();
		return carDao.update(car);
	}
	
	@Override
	public int remove(String id){
		return carDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return carDao.batchRemove(ids);
	}
	
}
