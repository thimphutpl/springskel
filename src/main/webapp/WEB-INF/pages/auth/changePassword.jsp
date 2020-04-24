<%--
  Created by IntelliJ IDEA.
  User: Jigme Dorji
  Date: 24-04-2020
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<title class="title">Change Password</title>

<body class="hold-transition sidebar-mini">
<%--<div class="wrapper">--%>
<!-- Content Wrapper. Contains page content -->
<div class="">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h5>Change Password</h5>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Change Password</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="card card-info">

                <!-- /.card-header -->
                <!-- form start -->
                <form id="changePasswordForm" action="" class="form-horizontal globalForm">
                    <div class="card-body">
                        <div class="col-md-12">

                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label text-sm">User Id:</label>

                                <div class="col-md-4">
                                    <input type="text" class="form-control form-control-sm isEnable" name="userId"
                                           readonly="readonly" value="${userId}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label text-sm">Existing Password:</label>

                                <div class="col-md-4">
                                    <input type="password" class="form-control form-control-sm isEnable" name="oldPassword"
                                           id="oldPassword"
                                           maxlength="20"
                                           data-rule-required="true">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label text-sm isEnable isDisable">New
                                    Password:</label>

                                <div class="col-md-4">
                                    <input type="password" class="form-control form-control-sm readonly" id="newPassword"
                                           name="newPassword"
                                           maxlength="50" data-rule-required="true">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label text-sm isEnable">Reconfirm New
                                    Password:</label>

                                <div class="col-md-4">
                                    <input type="password" class="form-control form-control-sm isDisable" id="confirmPassword"
                                           name="confirmPassword" data-rule-required="true">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-3"></div>
                                <%--<security:authorize access="hasRole('1012-ADD')">--%>
                                <div class="col-md-2">
                                    <input type="submit" id="btnSave" value="Submit"
                                           class="btn btn-info btn-block"/>
                                </div>
                                <%--</security:authorize>--%>
                                <div class="col-md-2">
                                    <input type="reset" id="btnCancel" value="Cancel"
                                           class="btn btn-info btn-block"/>
                                </div>
                            </div>

                        </div>
                    </div>

                </form>
            </div>
        </div>
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    <%--</div>--%>
</div>
</body>
<%--<body>--%>
<%--<div class="page_title">--%>
<%--<span class="title">Bhutan Tools of Entertainment</span>--%>
<%--<span class="subtitle">Change Password</span>--%>
<%--</div>--%>
<%--<div class="col-md-3"></div>--%>
<%--<form id="changePasswordForm" action="" class="form-horizontal globalForm">--%>
<%--<div class="col-md-12">--%>
<%--<fieldset>--%>
<%--<legend>Change Password</legend>--%>
<%--<div class="form-group">--%>
<%--<label class="col-md-4 right-label required">User Id </label>--%>

<%--<div class="col-md-4">--%>
<%--<input type="text" class="form-control isEnable" name="userId"--%>
<%--readonly="readonly" value="${userId}">--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--<div class="form-group">--%>
<%--<div class="col-md-12">--%>
<%--<label class="col-md-4 right-label required">Existing Password:</label>--%>

<%--<div class="col-md-4">--%>
<%--<input type="password" class="form-control isEnable" name="oldPassword" id="oldPassword"--%>
<%--maxlength="20"--%>
<%--data-rule-required="true">--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<div class="col-md-12">--%>
<%--<label class="col-md-4 right-label required isEnable isDisable">New Password:</label>--%>

<%--<div class="col-md-4">--%>
<%--<input type="password" class="form-control readonly" id="newPassword" name="newPassword"--%>
<%--maxlength="50" data-rule-required="true">--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<div class="col-md-12">--%>
<%--<label class="col-md-4 right-label  required isEnable">Reconfirm New Password:</label>--%>

<%--<div class="col-md-4">--%>
<%--<input type="password" class="form-control isDisable" id="confirmPassword"--%>
<%--name="confirmPassword" data-rule-required="true">--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>


<%--<div class="form-group">--%>
<%--<div class="col-md-12">--%>
<%--<div class="col-md-2"></div>--%>
<%--&lt;%&ndash;<security:authorize access="hasRole('1012-ADD')">&ndash;%&gt;--%>
<%--<div class="col-md-2">--%>
<%--<input type="submit" id="btnSave" value="Submit" class="btn btn-primary btn-block"/>--%>
<%--</div>--%>
<%--&lt;%&ndash;</security:authorize>&ndash;%&gt;--%>
<%--<div class="col-md-1"></div>--%>
<%--<div class="col-md-2">--%>
<%--<input type="reset" id="btnCancel" value="Cancel" class="btn btn-primary btn-block"/>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</fieldset>--%>

<%--</div>--%>
<%--</form>--%>
<%--</body>--%>
</html>

