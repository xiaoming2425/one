package cn.wewintech.common.core;

import java.util.Date;

import cn.wewintech.common.utils.ShiroUtils;
import cn.wewintech.common.utils.DateUtils;
import cn.wewintech.common.utils.IdUtils;
import cn.wewintech.common.utils.TextUtils;

public class DataModel {
    private String id;
    private String remarks;
    private String delFlag;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    
    private String taskId;
    private String processInstanceId;
    
    
    
    public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public void addData() {
        if (TextUtils.isEmpty(this.id)) {
            this.id = IdUtils.getUuid();
        }
        this.delFlag = "0";
        this.createBy = ShiroUtils.getUserId().toString();
        this.createDate = DateUtils.getCurrentTimestamp();
    }

    public void addData(String creator) {
        if (TextUtils.isEmpty(this.id)) {
            this.id = IdUtils.getUuid();
        }
        this.delFlag = "0";
        this.createBy = creator;
        this.createDate = DateUtils.getCurrentTimestamp();
    }

    public void editData() {
        this.updateBy = ShiroUtils.getUserId().toString();
        this.updateDate = DateUtils.getCurrentTimestamp();
    }

    public void editData(String updater) {
        this.updateBy = updater;
        this.updateDate = DateUtils.getCurrentTimestamp();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
