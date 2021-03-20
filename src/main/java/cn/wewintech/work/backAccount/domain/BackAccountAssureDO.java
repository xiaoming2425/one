package cn.wewintech.work.backAccount.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import cn.wewintech.common.core.DataModel;


/**
 * 回款申请确认
 * 
 * @author 
 * @email 
 * @date 2020-06-03 17:37:08
 */
public class BackAccountAssureDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//申请编号
	private String applyNo;
	//申请人
	private String applyId;
	//项目名称
	private String projectId;
	//回款阶段
	private String backProgress;
	//回款金额
	private BigDecimal backAmount;
	//审核状态
	private String auditState;
	//确认结果(1.确认到账2.未到账)
	private String result;

	/**
	 * 设置：申请编号
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	/**
	 * 获取：申请编号
	 */
	public String getApplyNo() {
		return applyNo;
	}
	/**
	 * 设置：申请人
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	/**
	 * 获取：申请人
	 */
	public String getApplyId() {
		return applyId;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * 设置：回款阶段
	 */
	public void setBackProgress(String backProgress) {
		this.backProgress = backProgress;
	}
	/**
	 * 获取：回款阶段
	 */
	public String getBackProgress() {
		return backProgress;
	}
	/**
	 * 设置：回款金额
	 */
	public void setBackAmount(BigDecimal backAmount) {
		this.backAmount = backAmount;
	}
	/**
	 * 获取：回款金额
	 */
	public BigDecimal getBackAmount() {
		return backAmount;
	}
	/**
	 * 设置：审核状态
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
	/**
	 * 获取：审核状态
	 */
	public String getAuditState() {
		return auditState;
	}
	/**
	 * 设置：确认结果(1.确认到账2.未到账)
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 获取：确认结果(1.确认到账2.未到账)
	 */
	public String getResult() {
		return result;
	}
}
