package cn.wewintech.activiti.domain;

import java.io.File;
import java.io.Serializable;

import cn.wewintech.common.core.DataModel;



public class AuditInfoRO extends DataModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private String busiRecordId;
	private String procInsId;
	private String taskDefKey;
	private String taskName;
	private String auditOperateType;

	private String auditOpinion;
	private String auditUserId;
	private String auditUsername;

	public String getBusiRecordId() {
		return this.busiRecordId;
	}

	public void setBusiRecordId(String busiRecordId) {
		this.busiRecordId = busiRecordId;
	}

	public String getProcInsId() {
		return this.procInsId;
	}

	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}

	public String getTaskDefKey() {
		return this.taskDefKey;
	}

	public void setTaskDefKey(String taskDefKey) {
		this.taskDefKey = taskDefKey;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getAuditOperateType() {
		return this.auditOperateType;
	}

	public void setAuditOperateType(String auditOperateType) {
		this.auditOperateType = auditOperateType;
	}

	public String getAuditOpinion() {
		return this.auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	public String getAuditUserId() {
		return this.auditUserId;
	}

	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}

	public String getAuditUsername() {
		return this.auditUsername;
	}

	public void setAuditUsername(String auditUsername) {
		this.auditUsername = auditUsername;
	}







}
