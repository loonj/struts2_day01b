package com.itheima.domain;


public class Customer  {
	

	private Integer custId;
	private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;
	private String custAddress;
	private String custPhone;

	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
//	@Override
//	public String toString() {
//		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
//				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custAddress=" + custAddress
//				+ ", custPhone=" + custPhone + "]";
//	}
	
}
