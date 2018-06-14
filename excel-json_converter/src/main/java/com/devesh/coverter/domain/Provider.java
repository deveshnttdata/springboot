package com.devesh.coverter.domain;

import java.util.Date;
import java.util.List;

public class Provider {

	String corpEntCd;
	double pfin;
	String pfinStartDate;
	String pfinEndDate;
	List<ProviderNetworkInformation> listProviderNetworkInfo;
	String unsolicated;
	
	public Provider() {
	}
	
	
	@Override
	public String toString() {
		return "Provider [corpEntCd=" + corpEntCd + ", pfin=" + pfin + ", pfinStartDate=" + pfinStartDate
				+ ", pfinEndDate=" + pfinEndDate + ", listProviderNetworkInfo=" + listProviderNetworkInfo
				+ ", unsolicated=" + unsolicated + "]";
	}
	public String getCorpEntCd() {
		return corpEntCd;
	}
	public void setCorpEntCd(String corpEntCd) {
		this.corpEntCd = corpEntCd;
	}
	public double getPfin() {
		return pfin;
	}
	public void setPfin(double pfin) {
		this.pfin = pfin;
	}
	public String getPfinStartDate() {
		return pfinStartDate;
	}
	public void setPfinStartDate(String pfinStartDate) {
		this.pfinStartDate = pfinStartDate;
	}
	public String getPfinEndDate() {
		return pfinEndDate;
	}
	public void setPfinEndDate(String pfinEndDate) {
		this.pfinEndDate = pfinEndDate;
	}
	public List<ProviderNetworkInformation> getListProviderNetworkInfo() {
		return listProviderNetworkInfo;
	}
	public void setListProviderNetworkInfo(List<ProviderNetworkInformation> listProviderNetworkInfo) {
		this.listProviderNetworkInfo = listProviderNetworkInfo;
	}
	public String getUnsolicated() {
		return unsolicated;
	}
	public void setUnsolicated(String unsolicated) {
		this.unsolicated = unsolicated;
	}
	
	
}
