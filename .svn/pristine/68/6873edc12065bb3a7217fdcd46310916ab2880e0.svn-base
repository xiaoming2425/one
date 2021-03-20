package cn.wewintech.work.print.service;

import cn.wewintech.work.print.domain.PrintPaperDO;

import java.util.List;
import java.util.Map;

/**
 * 打图申请
 * 
 * @author 
 * @email 
 * @date 2020-06-04 09:57:59
 */
public interface PrintPaperService {
	
	PrintPaperDO get(String id);
	
	List<PrintPaperDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PrintPaperDO printPaper);
	
	int update(PrintPaperDO printPaper);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
List<PrintPaperDO> findPrintTimes(Map<String,Object> map);
	
	int insertPrintTimes(PrintPaperDO printPaper);
	 
	int updatePrintTimes(PrintPaperDO printPaper);
}
