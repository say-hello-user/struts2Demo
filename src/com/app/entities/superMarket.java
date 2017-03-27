package com.app.entities;

public class superMarket {
	private Integer superId;
	private String superName;
    private double superPrice;
    private Integer superType;
    private Integer superFrom;
    private String superCondition;
    private String superStatus;
    private String typeName;
    public Integer getSuperId() {
		return superId;
	}
	public void setSuperId(Integer superId) {
		this.superId = superId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getSuperName() {
		return superName;
	}
	public void setSuperName(String superName) {
		this.superName = superName;
	}
	public double getSuperPrice() {
		return superPrice;
	}
	public void setSuperPrice(double superPrice) {
		this.superPrice = superPrice;
	}
	public Integer getSuperType() {
		return superType;
	}
	public void setSuperType(Integer superType) {
		this.superType = superType;
	}
	public Integer getSuperFrom() {
		return superFrom;
	}
	public void setSuperFrom(Integer superFrom) {
		this.superFrom = superFrom;
	}
	public String getSuperCondition() {
		return superCondition;
	}
	public void setSuperCondition(String superCondition) {
		this.superCondition = superCondition;
	}
	public String getSuperStatus() {
		return superStatus;
	}
	public void setSuperStatus(String superStatus) {
		this.superStatus = superStatus;
	}
	public superMarket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "superMarket [superName=" + superName + ", superPrice="
				+ superPrice + ", superType=" + superType + ", superFrom="
				+ superFrom + ", superCondition=" + superCondition
				+ ", superStatus=" + superStatus + "]";
	}
}
