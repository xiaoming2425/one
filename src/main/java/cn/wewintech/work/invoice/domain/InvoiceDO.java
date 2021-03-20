package cn.wewintech.work.invoice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.wewintech.common.core.DataModel;


/**
 * 开票申请
 * 
 * @author 
 * @email 
 * @date 2020-06-02 14:43:34
 */
public class InvoiceDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//申请编号
	private String applyNo;
	//发票种类(1.增值税发票2.普通发票)
	private String invoiceType;
	//经营模式（1.自营2.合作3.挂靠）
	private String specializeType;
	//回款方式（1.转账2.现金）
	private String backCostType;
	//合同进展 1已签 2待签 3无合同
	private String contractProgress;
	//开具单位名称
	private String companyName;
	//纳税人识别号
	private String identificationNo;
	//地址
	private String address;
	//电话
	private String phoneNo;
	//开户行
	private String bank;
	//账号
	private String account;
	//开票申请人
	private String invoiceApplyId;
	//申请日期
	private Date applyDate;
	//开票人
	private String doInvociceId;
	//开票日期
	private Date doInvoiceDate;
	//审核状态
	private String auditState;
	private String str;
	private String invoiceName;
	private BigDecimal amount;
	private String projectName;
	private String invoiceId;
	
	private List<InvoiceProject> invos=new ArrayList<InvoiceProject>();

	public List<InvoiceProject> getInvos() {
		return invos;
	}
	public void setInvos(List<InvoiceProject> invos) {
		this.invos = invos;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getInvoiceName() {
		return invoiceName;
	}
	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
	 * 设置：发票种类(1.增值税发票2.普通发票)
	 */
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	/**
	 * 获取：发票种类(1.增值税发票2.普通发票)
	 */
	public String getInvoiceType() {
		return invoiceType;
	}
	/**
	 * 设置：经营模式（1.自营2.合作3.挂靠）
	 */
	public void setSpecializeType(String specializeType) {
		this.specializeType = specializeType;
	}
	/**
	 * 获取：经营模式（1.自营2.合作3.挂靠）
	 */
	public String getSpecializeType() {
		return specializeType;
	}
	/**
	 * 设置：回款方式（1.转账2.现金）
	 */
	public void setBackCostType(String backCostType) {
		this.backCostType = backCostType;
	}
	/**
	 * 获取：回款方式（1.转账2.现金）
	 */
	public String getBackCostType() {
		return backCostType;
	}
	/**
	 * 设置：合同进展 1已签 2待签 3无合同
	 */
	public void setContractProgress(String contractProgress) {
		this.contractProgress = contractProgress;
	}
	/**
	 * 获取：合同进展 1已签 2待签 3无合同
	 */
	public String getContractProgress() {
		return contractProgress;
	}
	/**
	 * 设置：开具单位名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：开具单位名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：纳税人识别号
	 */
	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}
	/**
	 * 获取：纳税人识别号
	 */
	public String getIdentificationNo() {
		return identificationNo;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：电话
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * 获取：电话
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * 设置：开户行
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * 获取：开户行
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 设置：账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：账号
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：开票申请人
	 */
	public void setInvoiceApplyId(String invoiceApplyId) {
		this.invoiceApplyId = invoiceApplyId;
	}
	/**
	 * 获取：开票申请人
	 */
	public String getInvoiceApplyId() {
		return invoiceApplyId;
	}
	/**
	 * 设置：申请日期
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	/**
	 * 获取：申请日期
	 */
	public Date getApplyDate() {
		return applyDate;
	}
	/**
	 * 设置：开票人
	 */
	public void setDoInvociceId(String doInvociceId) {
		this.doInvociceId = doInvociceId;
	}
	/**
	 * 获取：开票人
	 */
	public String getDoInvociceId() {
		return doInvociceId;
	}
	/**
	 * 设置：开票日期
	 */
	public void setDoInvoiceDate(Date doInvoiceDate) {
		this.doInvoiceDate = doInvoiceDate;
	}
	/**
	 * 获取：开票日期
	 */
	public Date getDoInvoiceDate() {
		return doInvoiceDate;
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
