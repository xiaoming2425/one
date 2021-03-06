package cn.wewintech.work.print.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import cn.wewintech.common.core.DataModel;


/**
 * 打图申请
 * 
 * @author 
 * @email 
 * @date 2020-06-04 09:57:59
 */
public class PrintPaperDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//申请编号
	private String applyNo;
	//申请人
	private String applyId;
	//项目名称
	private String projectId;
	//图纸名称
	private String paperName;
	//打图金额
	private BigDecimal printAmount;
	//打图次数
	private Integer printTimes;
	//审核状态
	private String auditState;
	private String projectName;

	private String userId;
	private int times;
	
	

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
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
	 * 设置：图纸名称
	 */
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	/**
	 * 获取：图纸名称
	 */
	public String getPaperName() {
		return paperName;
	}
	/**
	 * 设置：打图金额
	 */
	public void setPrintAmount(BigDecimal printAmount) {
		this.printAmount = printAmount;
	}
	/**
	 * 获取：打图金额
	 */
	public BigDecimal getPrintAmount() {
		return printAmount;
	}
	/**
	 * 设置：打图次数
	 */
	public void setPrintTimes(Integer printTimes) {
		this.printTimes = printTimes;
	}
	/**
	 * 获取：打图次数
	 */
	public Integer getPrintTimes() {
		return printTimes;
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
}
