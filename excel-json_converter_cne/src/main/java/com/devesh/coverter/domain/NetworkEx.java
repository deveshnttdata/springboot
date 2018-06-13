package com.devesh.coverter.domain;

public class NetworkEx {

	private String policyId;
	private String nwExType;
	
	
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getNwExType() {
		return nwExType;
	}
	public void setNwExType(String nwExType) {
		this.nwExType = nwExType;
	}
	@Override
	public String toString() {
		return "NetworkEx [policyId=" + policyId + ", nwExType=" + nwExType + "]";
	}
	
	
	
}
