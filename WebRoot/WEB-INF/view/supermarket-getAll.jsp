<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@  taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'supermarket-getAll.jsp' starting page</title>
    
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
  <h1 align="center">所有商品</h1>
   <s:form action="" method="post">
		<table width="80%" border="1px" cellpadding="0" cellspacing="0">  
        <thead>  
            <tr>  
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品单价</th>
                <th>商品所属类别</th>
                <th>商品来源</th>
                <th>商品存储条件</th>
                <th>商品状态</th>
                <th>商品操作</th>
                 <th>商品操作</th>
            </tr>  
        </thead>  
        <tbody>  
           <s:iterator id="li" value="allsupermarket">
            <tr>
            	<td><s:property value="#li.superId" /></td>
            	<td><s:property value="#li.superName" /></td>
            	<td><s:property value="#li.superPrice" /></td>            	
            	<td><s:property value="#li.typeName" /></td>
            	        	
            	<td>
            	 <s:if test="#li.superFrom==1">自产</s:if>
                 <s:elseif test="#li.superFrom==2">代售</s:elseif >
                   <s:elseif test="#li.superFrom==3">厂家直销</s:elseif >
                    <s:elseif test="#li.superFrom==4">自营</s:elseif >
            	</td>
            	
            	
            	<td><s:property value="#li.superCondition" /></td>
            	
            	
            	<td>
            	 <s:if test="#li.superStatus=='in'">上架</s:if>
                 <s:elseif test="#li.superStatus=='out'">下架</s:elseif >
            	</td>
            	
            	<td>
            	<a href="supermarket-deleteSuperMarket?id=${li.superId }">删除商品</a>
            	</td>
            	<td>
            	<a href="supermarket-getmodifySuperMarket?id=${li.superId }">修改商品</a>
            	</td>
            </tr>
            </s:iterator>
          
        </tbody>  
    </table> 
     <a href="supermarket-addSuperMarketPage.action">添加商品</a>
	</s:form>
  </body>
</html>
