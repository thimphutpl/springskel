<%@ page import="java.util.ResourceBundle" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>
<%
    ResourceBundle resource = ResourceBundle.getBundle("env");
    String environment = resource.getString("ENVIRONMENT");
    pageContext.setAttribute("env", environment);
%>
<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="get" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
        </li>
    </ul>

    <!-- right navbar links -->
    <ul class="navbar-nav ml-auto">
        <li class="nav-item d-none d-sm-inline-block">
            <div class="nav-link">
                <label>Welcome::</label>
                <i class="fa fa-user-md fa-fw"></i>
                <label> ${currentUser.txtUserName} (${currentUser.loginId})</label>
            </div>
            <%--<a href="index3.html" class="nav-link">Home</a>--%>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
            <a class="nav-link" href="<c:url value="/changePassword"/> "><i
                    class="fa fa-key fa-fw"></i> Change Password</a>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
            <a class="nav-link" href="javascript:$('#logoutForm').submit();" ><i
                    class="fa fa-power-off"></i> Logout</a>
        </li>
    </ul>

</nav>