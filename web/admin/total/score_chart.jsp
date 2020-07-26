<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.uu710.util.*, java.io.*,java.nio.charset.*"%>
<%
	ScoreChartUtil util=new ScoreChartUtil();
	String filename = util.generateBarChart(session,
	new PrintWriter(out));
	String graphURL = request.getContextPath()
	+ "/DisplayChart?filename=" + filename;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩统计图</title>
</head>
<body leftmargin=10 topmargin=10>
	<img src="<%=graphURL%>" width=700 height=400 border=0>
</body>
</html>