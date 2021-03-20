package cn.wewintech.work.invoice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.work.invoice.dao.InvoiceDao;
import cn.wewintech.work.invoice.domain.InvoiceDO;
import cn.wewintech.work.invoice.service.InvoiceService;



@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceDao invoiceDao;
	
	@Override
	public InvoiceDO get(String id){
		return invoiceDao.get(id);
	}
	
	@Override
	public List<InvoiceDO> list(Map<String, Object> map){
		return invoiceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return invoiceDao.count(map);
	}
	
	@Override
	public int save(InvoiceDO invoice){
		invoice.addData();
		return invoiceDao.save(invoice);
	}
	
	@Override
	public int update(InvoiceDO invoice){
		invoice.editData();
		return invoiceDao.update(invoice);
	}
	
	@Override
	public int remove(String id){
		return invoiceDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return invoiceDao.batchRemove(ids);
	}

	@Override
	public int saveInvoice(InvoiceDO invoice) {
		// TODO Auto-generated method stub
		return invoiceDao.saveInvoice(invoice);
	}

	@Override
	public List<InvoiceDO> find(String id) {
		// TODO Auto-generated method stub
		return invoiceDao.find(id);
	}
	
}
