<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'type-add.jsp' starting page</title>
    
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
   <s:form action="" method="post">
		<table width="80%" border="1px" cellpadding="0" cellspacing="0">  
        <thead>  
            <tr>  
                <th>类别编号</th>
                <th>类别名称</th>
                <th>类别操作</th>
                <th>类别操作</th>
            </tr>  
        </thead>  
        <tbody>  
  <s:iterator id="li" value="allsupertype">
                  <tr>  
                    <td> <s:property value="#li.typeId" /></td>
            	     <td><s:property value="#li.typeName" /> </td>
            	     <td>
            	<a href="type-deleteType.action?id=${li.typeId}">删除商品类别</a>
            	</td>
            	<td>
            	<a href="type-getmodifyType.action?id=${li.typeId }">修改商品类别</a>
            	</td> 
                </tr> 
  </s:iterator>
         
   
        </tbody>  
    </table>
    <a href="type-addTypePage.action">添加商品类别</a>
	</s:form>
  </body>
</html>
