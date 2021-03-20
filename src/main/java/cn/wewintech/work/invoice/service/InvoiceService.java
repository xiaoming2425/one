package cn.wewintech.work.invoice.service;

import cn.wewintech.work.invoice.domain.InvoiceDO;

import java.util.List;
import java.util.Map;

/**
 * 开票申请
 * 
 * @author 
 * @email 
 * @date 2020-06-02 14:43:34
 */
public interface InvoiceService {
	
	InvoiceDO get(String id);
	
	List<InvoiceDO> find(String id);
	
	List<InvoiceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(InvoiceDO invoice);
	
	int update(InvoiceDO invoice);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	int saveInvoice(InvoiceDO invoice);
}
