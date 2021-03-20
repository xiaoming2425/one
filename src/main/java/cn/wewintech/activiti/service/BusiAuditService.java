package cn.wewintech.activiti.service;

import java.util.List;

import cn.wewintech.activiti.domain.AuditInfoRO;

public interface BusiAuditService {

	 void insertAuditRecord(AuditInfoRO auditInfoRO);

	List<AuditInfoRO> findAuditInfoList(String id);
}
