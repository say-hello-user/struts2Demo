package com.app.action;

import java.util.LinkedList;
import java.util.List;

import com.app.entities.superMarket;
import com.app.entities.superType;
import com.app.serverImpl.superMarketServerImpl;
import com.app.serverImpl.superTypeServerImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class superMarketAction extends ActionSupport implements ModelDriven{
    private superMarket  supermarket;
	private superMarketServerImpl supermarketserverimpl =  new superMarketServerImpl() ;
    private List<superMarket> allsupermarket = new LinkedList<superMarket>();
    private superTypeServerImpl supertypeserverimpl = new superTypeServerImpl();
    private List<String> storage = new LinkedList<String>();
    private String result;
    private Integer id;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
    public List<superType> getAllsupertype() {
		return allsupertype;
	}
	public void setAllsupertype(List<superType> allsupertype) {
		this.allsupertype = allsupertype;
	}
	private List<superType> allsupertype = new LinkedList<superType>();
	public List<superMarket> getAllsupermarket() {
		return allsupermarket;
	}
	public superMarket getSupermarket() {
		return supermarket;
	}
	public void setAllsupermarket(List<superMarket> allsupermarket) {
		this.allsupermarket = allsupermarket;
	}
	public superMarket supermarket() {
		return supermarket;
	}
	public void setSupermarket(superMarket supermarket) {
		this.supermarket = supermarket;
	}
	public void setSupermarketserverimpl(superMarketServerImpl supermarketserverimpl) {
		this.supermarketserverimpl = supermarketserverimpl;
	}
	@Override
	public Object getModel() {
		if(supermarket == null){
			supermarket = new superMarket();
	       }
	       return supermarket;
	}
    public String add()
    {
    	String superCondition = supermarket.getSuperCondition();
    	String[] sourceStrArray = superCondition.split(", ");
    	String condition = "";
    	for(int i =0;i<sourceStrArray.length;i++)
    	{
    		condition =  condition + sourceStrArray[i]+"|";    	
    	}
    	supermarket.setSuperCondition(condition);
    	supermarketserverimpl.add(supermarket);
    	result = "商品添加成功";
    	return "add";
    }
   
	public String addSuperMarketPage()
	{
		System.out.println("********************");
  	   allsupertype = supertypeserverimpl.getAll();
  	 System.out.println(allsupertype);
		return "addSuperMarketPage";
	}
    public String getAllSuperMarketPage()
    {
    	System.out.println("------------------------------------");
    	allsupermarket = supermarketserverimpl.getAll();
    	for(superMarket item:allsupermarket)
    	{
    	String condition = item.getSuperCondition();
    	String[] sourceStrArray = condition.split("|");
    	String newcondition = "";
    	for(int i =0;i<sourceStrArray.length;i++)
    	{
    		if(sourceStrArray[i].equals("a"))
    		{
    			newcondition = newcondition + "冷藏,";
    		}
    		if(sourceStrArray[i].equals("b"))
    		{
    			newcondition = newcondition + "保鲜剂,";
    		}
    		if(sourceStrArray[i].equals("c"))
    		{
    			newcondition = newcondition + "保鲜薄膜,";
    		}
    		if(sourceStrArray[i].equals("d"))
    		{
    			newcondition = newcondition + "定期整理";
    		}
    	}
    	item.setSuperCondition(newcondition);
    	}
    	return "getAllSuperMarketPage";
    }
    public String deleteSuperMarket()
    {
    	result = supermarketserverimpl.deletesuperMarketById(id);
    	return "deleteSuperMarket";
    }
    public String getmodifySuperMarket()
    {
    	  allsupertype = supertypeserverimpl.getAll();
    	supermarket = supermarketserverimpl.getsuperMarketById(id);
    	return "getmodifySuperMarket";
    }
    public String modifySuperMarket()
    {
    	id=supermarket.getSuperId();
    	result = supermarketserverimpl.updatesuperMarketById(id, supermarket);
    	return "modifySuperMarket";
    }
}
