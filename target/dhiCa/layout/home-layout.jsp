<%--
  Created by IntelliJ IDEA.
  User: bikash.rai
  Date: 04-May-16
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login ::spms</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="<c:url value='/resources/images/prpduct_logo.png'/>" rel="icon">
    <link type="text/css" rel="stylesheet"
          href="<c:url value='/resources/css/datepicker.min.css' />"/>
    <link type="text/css" rel="stylesheet"
          href="<c:url value='/resources/css/login.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />"/>
</head>
<body>
<sitemesh:write property="body"/>
</body>
<script type="text/javascript"
        src="<c:url value='/resources/jQuery/jquery.min.js' />"></script>
<script type="text/javascript"
        src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
<script type="text/javascript"
        src="<c:url value='/resources/js/lib/datepicker.min.js' />"></script>
</html>
