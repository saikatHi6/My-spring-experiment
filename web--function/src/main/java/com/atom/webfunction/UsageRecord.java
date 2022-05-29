package com.atom.webfunction;

public class UsageRecord {
	
	private String cloudId;
	private String usegMonth;
	private String usageDuration;
	
	
	public UsageRecord(String cloudId, String usegMonth, String usageDuration) {
		super();
		this.cloudId = cloudId;
		this.usegMonth = usegMonth;
		this.usageDuration = usageDuration;
	}
	public String getCloudId() {
		return cloudId;
	}
	public void setCloudId(String cloudId) {
		this.cloudId = cloudId;
	}
	public String getUsegMonth() {
		return usegMonth;
	}
	public void setUsegMonth(String usegMonth) {
		this.usegMonth = usegMonth;
	}
	public String getUsageDuration() {
		return usageDuration;
	}
	public void setUsageDuration(String usageDuration) {
		this.usageDuration = usageDuration;
	}
	
	

}
