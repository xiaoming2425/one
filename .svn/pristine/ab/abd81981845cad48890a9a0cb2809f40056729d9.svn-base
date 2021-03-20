package cn.wewintech.work.payAmount.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.work.payAmount.dao.PayAmountDao;
import cn.wewintech.work.payAmount.domain.PayAmountDO;
import cn.wewintech.work.payAmount.service.PayAmountService;



@Service
public class PayAmountServiceImpl implements PayAmountService {
	@Autowired
	private PayAmountDao payAmountDao;
	
	@Override
	public PayAmountDO get(String id){
		return payAmountDao.get(id);
	}
	
	@Override
	public List<PayAmountDO> list(Map<String, Object> map){
		return payAmountDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return payAmountDao.count(map);
	}
	
	@Override
	public int save(PayAmountDO payAmount){
		payAmount.addData();
		return payAmountDao.save(payAmount);
	}
	
	@Override
	public int update(PayAmountDO payAmount){
		payAmount.editData();
		return payAmountDao.update(payAmount);
	}
	
	@Override
	public int remove(String id){
		return payAmountDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return payAmountDao.batchRemove(ids);
	}
	
}
