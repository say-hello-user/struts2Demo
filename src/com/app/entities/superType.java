package com.app.entities;

public class superType {
	private Integer typeId;
	private String typeName;
	
	
	@Override
	public String toString() {
		return "superType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public superType() {
		super();
		// TODO Auto-generated constructor stub
	}
}
