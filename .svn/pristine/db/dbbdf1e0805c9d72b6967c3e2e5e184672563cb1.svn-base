package cn.wewintech.activiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wewintech.activiti.dao.BusiAuditDao;
import cn.wewintech.activiti.domain.AuditInfoRO;
import cn.wewintech.activiti.service.BusiAuditService;

@Service
public class BusiAuditServiceImpl implements BusiAuditService {
	@Autowired
	private BusiAuditDao busiAuditDao;

	@Override
	public void insertAuditRecord(AuditInfoRO auditInfoRO) {
		// TODO Auto-generated method stub
		busiAuditDao.insertAuditRecord(auditInfoRO);
	}

	@Override
	public List<AuditInfoRO> findAuditInfoList(String id) {
		// TODO Auto-generated method stub
		List<AuditInfoRO> findAuditInfoList = busiAuditDao.findAuditInfoList(id);
		return findAuditInfoList;
	}

}
