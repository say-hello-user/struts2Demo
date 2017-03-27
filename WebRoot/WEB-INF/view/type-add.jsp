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
<h1 align="center">添加商品类别</h1>
  <div style="margin:0 auto; position:relative; width:300px;">
	 <s:form action="type-add.action" method="post">
    	<s:textfield name="supertype.typeId" label="类别id"></s:textfield> 
    	<s:textfield name="supertype.typeName" label="类别名称"></s:textfield> 
    	<s:submit value="提交"></s:submit> 
  </s:form>
  </div>

  </body>
</html>
