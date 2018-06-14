package com.devesh.coverter.domain;

import java.util.Date;

public class ProviderNetworkInformation {

	String networkEffDate;
	String networkEndDate;
	String pnc;	
	
	public ProviderNetworkInformation() {
		
	}
	
	public String getNetworkEffDate() {
		return networkEffDate;
	}
	public void setNetworkEffDate(String networkEffDate) {
		this.networkEffDate = networkEffDate;
	}
	public String getNetworkEndDate() {
		return networkEndDate;
	}
	public void setNetworkEndDate(String networkEndDate) {
		this.networkEndDate = networkEndDate;
	}
	public String getPnc() {
		return pnc;
	}
	public void setPnc(String pnc) {
		this.pnc = pnc;
	}
	
	
}
