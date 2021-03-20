package cn.wewintech.work.receipt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.work.receipt.dao.ReceiptDao;
import cn.wewintech.work.receipt.domain.ReceiptDO;
import cn.wewintech.work.receipt.service.ReceiptService;



@Service
public class ReceiptServiceImpl implements ReceiptService {
	@Autowired
	private ReceiptDao receiptDao;
	
	@Override
	public ReceiptDO get(String id){
		return receiptDao.get(id);
	}
	
	@Override
	public List<ReceiptDO> list(Map<String, Object> map){
		return receiptDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return receiptDao.count(map);
	}
	
	@Override
	public int save(ReceiptDO receipt){
		receipt.addData();
		return receiptDao.save(receipt);
	}
	
	@Override
	public int update(ReceiptDO receipt){
		receipt.editData();
		return receiptDao.update(receipt);
	}
	
	@Override
	public int remove(String id){
		return receiptDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return receiptDao.batchRemove(ids);
	}
	
}
