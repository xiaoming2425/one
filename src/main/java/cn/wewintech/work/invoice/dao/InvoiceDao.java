package cn.wewintech.work.invoice.dao;

import cn.wewintech.work.invoice.domain.InvoiceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 开票申请
 * @author 
 * @email 
 * @date 2020-06-02 14:43:34
 */
@Mapper
public interface InvoiceDao {

	InvoiceDO get(String id);
	
	List<InvoiceDO> find(String id);
	
	List<InvoiceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(InvoiceDO invoice);
	
	int saveInvoice(InvoiceDO invoice);
	
	int update(InvoiceDO invoice);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
