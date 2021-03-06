package cn.wewintech.work.print.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.wewintech.work.print.dao.PrintPaperDao;
import cn.wewintech.work.print.domain.PrintPaperDO;
import cn.wewintech.work.print.service.PrintPaperService;



@Service
public class PrintPaperServiceImpl implements PrintPaperService {
	@Autowired
	private PrintPaperDao printPaperDao;
	
	@Override
	public PrintPaperDO get(String id){
		return printPaperDao.get(id);
	}
	
	@Override
	public List<PrintPaperDO> list(Map<String, Object> map){
		return printPaperDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return printPaperDao.count(map);
	}
	
	@Override
	public int save(PrintPaperDO printPaper){
		printPaper.addData();
		return printPaperDao.save(printPaper);
	}
	
	@Override
	public int update(PrintPaperDO printPaper){
		printPaper.editData();
		return printPaperDao.update(printPaper);
	}
	
	@Override
	public int remove(String id){
		return printPaperDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return printPaperDao.batchRemove(ids);
	}

	@Override
	public List<PrintPaperDO> findPrintTimes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return printPaperDao.findPrintTimes(map);
	}

	@Override
	public int insertPrintTimes(PrintPaperDO printPaper) {
		// TODO Auto-generated method stub
		return printPaperDao.insertPrintTimes(printPaper);
	}

	@Override
	public int updatePrintTimes(PrintPaperDO printPaper) {
		// TODO Auto-generated method stub
		return printPaperDao.updatePrintTimes(printPaper);
	}
	
}
