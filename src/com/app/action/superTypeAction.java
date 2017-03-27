package com.app.action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.app.entities.superType;
import com.app.serverImpl.superMarketServerImpl;
import com.app.serverImpl.superTypeServerImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class superTypeAction extends ActionSupport implements ModelDriven{
    private superType supertype;
	public superType getSupertype() {
		return supertype;
	}
	private superTypeServerImpl supertypeserverimpl =  new superTypeServerImpl();

	private Integer id;
	private  String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	private List<superType> allsupertype = new LinkedList<superType>();
	public List<superType> getAllsupertype() {
		return allsupertype;
	}
	public void setAllsupertype(List<superType> allsupertype) {
		this.allsupertype = allsupertype;
	}
	public void setSupertype(superType supertype) {
		this.supertype = supertype;
	}
	public void setSupertypeserverimpl(superTypeServerImpl supertypeserverimpl) {
		this.supertypeserverimpl = supertypeserverimpl;
	}
	@Override
	public Object getModel() {
		if(supertype == null){
			supertype = new superType();
	       }
	       return supertype;
	}
	
	public String add()
	{
		supertypeserverimpl = new superTypeServerImpl();
		supertypeserverimpl.add(supertype);
		result  = "类别添加成功";
		return "add";
	}
	public String addTypePage()
	{
		
		return "addTypePage";
	}
   public String getAllTypePage()
   {
	   allsupertype = supertypeserverimpl.getAll();
	   
	   return "getAllTypePage";
   }
   public String deleteType()
   {
	   
	  result  = supertypeserverimpl.deleteTypeById(id);
	   return "deleteType";
   }
   public String getmodifyType()
   {
	   supertype = supertypeserverimpl.getById(id);
	   return "getmodifyType";
   }
   public String modifyType()
   {
	   id = supertype.getTypeId();
	   result = supertypeserverimpl.updateTypeById(id, supertype);
	   return "modifyType";
   }
}
