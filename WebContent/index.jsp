<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="web_test.*" %>
<%@ page  import="java.net.URL" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    hello World!
   <%
   GetFileUrl gfu = new GetFileUrl();
   URL url=gfu.getFileUrl("crazybucket","test.mp3");
   %>
   <%=url %> 
</body>
</html>
