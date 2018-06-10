package com.devesh.coverter.domain;

import java.util.Date;

public class ProviderNetworkInformation {

	Date networkEffDate;
	Date networkEndDate;
	String pnc;	
	
	public ProviderNetworkInformation() {
		
	}
	
	public Date getNetworkEffDate() {
		return networkEffDate;
	}
	public void setNetworkEffDate(Date networkEffDate) {
		this.networkEffDate = networkEffDate;
	}
	public Date getNetworkEndDate() {
		return networkEndDate;
	}
	public void setNetworkEndDate(Date networkEndDate) {
		this.networkEndDate = networkEndDate;
	}
	public String getPnc() {
		return pnc;
	}
	public void setPnc(String pnc) {
		this.pnc = pnc;
	}
	
	
}
