package com.devesh.coverter.domain;

import java.util.List;

public class PlanType {
	
	private String planId;
	private List<ContractNwExInfo> conNwExInfo;
	
	
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public List<ContractNwExInfo> getListConNwExInfo() {
		return conNwExInfo;
	}
	public void setListConNwExInfo(List<ContractNwExInfo> conNwExInfo) {
		this.conNwExInfo = conNwExInfo;
	}
	
	@Override
	public String toString() {
		return "PlanType [planId=" + planId + ", listConNwExInfo=" + conNwExInfo + "]";
	}
	
	

}
