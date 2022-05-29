package com.atom.webfunction;

public class CloudFuntions {

	private String functionId;
	private String functionDescription;
	private int functionCharges;

	public CloudFuntions(String functionId, String functionDescription, int functionCharges) {
		super();
		this.functionId = functionId;
		this.functionDescription = functionDescription;
		this.functionCharges = functionCharges;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getFunctionDescription() {
		return functionDescription;
	}

	public void setFunctionDescription(String functionDescription) {
		this.functionDescription = functionDescription;
	}

	public int getFunctionCharges() {
		return functionCharges;
	}

	public void setFunctionCharges(int functionCharges) {
		this.functionCharges = functionCharges;
	}

}
