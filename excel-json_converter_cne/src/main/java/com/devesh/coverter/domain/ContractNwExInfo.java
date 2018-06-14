package com.devesh.coverter.domain;

import java.util.List;

public class ContractNwExInfo {

	private String overrideTierLevel;
	private List<NetworkEx> networkEx;
	
	
	public String getOverrideTierLevel() {
		return overrideTierLevel;
	}
	public void setOverrideTierLevel(String overrideTierLevel) {
		this.overrideTierLevel = overrideTierLevel;
	}
	public List<NetworkEx> getListNwEx() {
		return networkEx;
	}
	public void setListNwEx(List<NetworkEx> networkEx) {
		this.networkEx = networkEx;
	}
	@Override
	public String toString() {
		return "ContractNwExInfo [overrideTierLevel=" + overrideTierLevel + ", networkEx=" + networkEx + "]";
	}
	
	
	
	
}
