package cn.wewintech.work.receipt.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import cn.wewintech.common.core.DataModel;


/**
 * 报销申请
 * 
 * @author 
 * @email 
 * @date 2020-06-02 10:33:30
 */
public class ReceiptDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//申请编号
	private String applyNo;
	//申请人
	private String applyId;
	//发生日
	private Date productDate;
	//归属部门
	private String departmentId;
	//费用类型(1.差旅费2.办公费3.招待费)
	private String costType;
	//金额
	private BigDecimal amount;
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
	 * 设置：发生日
	 */
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	/**
	 * 获取：发生日
	 */
	public Date getProductDate() {
		return productDate;
	}
	/**
	 * 设置：归属部门
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * 获取：归属部门
	 */
	public String getDepartmentId() {
		return departmentId;
	}
	/**
	 * 设置：费用类型(1.差旅费2.办公费3.招待费)
	 */
	public void setCostType(String costType) {
		this.costType = costType;
	}
	/**
	 * 获取：费用类型(1.差旅费2.办公费3.招待费)
	 */
	public String getCostType() {
		return costType;
	}
	/**
	 * 设置：金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：金额
	 */
	public BigDecimal getAmount() {
		return amount;
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
