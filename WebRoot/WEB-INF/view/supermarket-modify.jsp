<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@  taglib prefix="s" uri="/struts-tags" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'supermarket-add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1 align="center">修改商品</h1>
   <div style="margin:0 auto; position:relative; width:600px;">
     <s:form action="supermarket-modifySuperMarket.action" method="post">
    <s:textfield name="supermarket.superId" label="商品编号"></s:textfield> 
    	<s:textfield name="supermarket.superName" label="商品名称"></s:textfield> 
    	<s:textfield name="supermarket.superPrice" label="商品单价"></s:textfield> 
	 
    	  <s:select name="supermarket.superType" list="allsupertype" listKey="typeId" listValue="typeName" label="商品所属类别"></s:select>    
         
    	<s:radio name="supermarket.superFrom" list="#{1:'自产',2:'代售',3:'厂家直销',4:'自营' }" label="商品来源"></s:radio>
    	<s:checkboxlist name="supermarket.superCondition" list="#{'a':'冷藏','b':'保鲜剂','c':'保鲜薄膜','d':'定期整理'}"  label="商品存储条件"></s:checkboxlist> 
    	<s:radio name="supermarket.superStatus" list="#{'in':'上架','out':'下架' }" label="商品状态"></s:radio>
    	<s:submit value="提交"></s:submit>

    </s:form>
    </div>
  </body>
</html>
