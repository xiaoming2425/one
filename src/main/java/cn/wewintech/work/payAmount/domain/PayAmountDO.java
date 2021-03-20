package cn.wewintech.work.payAmount.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import cn.wewintech.common.core.DataModel;


/**
 * 付款申请
 * 
 * @author 
 * @email 
 * @date 2020-06-03 20:20:35
 */
public class PayAmountDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//申请编号
	private String applyNo;
	//申请人
	private String applyId;
	//付款对象
	private String payName;
	//付款账户
	private String payAccount;
	//付款金额
	private BigDecimal contractAmount;
	//审核状态
	private String auditState;

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
	 * 设置：付款对象
	 */
	public void setPayName(String payName) {
		this.payName = payName;
	}
	/**
	 * 获取：付款对象
	 */
	public String getPayName() {
		return payName;
	}
	/**
	 * 设置：付款账户
	 */
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	/**
	 * 获取：付款账户
	 */
	public String getPayAccount() {
		return payAccount;
	}
	/**
	 * 设置：付款金额
	 */
	public void setContractAmount(BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}
	/**
	 * 获取：付款金额
	 */
	public BigDecimal getContractAmount() {
		return contractAmount;
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
