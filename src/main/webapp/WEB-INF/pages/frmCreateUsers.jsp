<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Creation</title>
</head>
<body class="hold-transition sidebar-mini">
<%--<div class="wrapper">--%>
<!-- Content Wrapper. Contains page content -->
<div class="">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h4>User Creation</h4>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">User Creation</li>
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
                <form id="createUsersForm" action="<c:url value='/createUser'/> " class="form-horizontal globalForm">

                    <div class="card-body">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label text-sm">Login ID:</label>

                            <div class="col-3">
                                <input type="text" name="loginId" id="loginId" class="form-control form-control-sm"
                                       required="true">
                            </div>
                            <label class="col-sm-2 col-form-label text-sm">User Name:</label>

                            <div class="col-3">
                                <input type="text" name="txtUserName" id="txtUserName"
                                       class="form-control form-control-sm"  required="true">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label text-sm">Password:</label>

                            <div class="col-3">
                                <input type="text" name="txtPassword" id="txtPassword"
                                       class="form-control form-control-sm"  required="true">
                            </div>
                            <label class="col-sm-2 col-form-label text-sm">Confirmed Password:</label>

                            <div class="col-3">
                                <input type="text" name="txtConfirmPassword" id="txtConfirmPassword"
                                       class="form-control form-control-sm"  required="true">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label text-sm">Creation Date:</label>

                            <div class="col-3">
                                <input type="text" value="${createdDate}" readonly="readonly" name="createdDate"
                                       id="createdDate" class="form-control form-control-sm"  required="true">
                            </div>
                            <label class="col-sm-2 col-form-label text-sm">User Roles:</label>

                            <div class="col-3">
                                <form:select   required="true" class="form-control form-control-sm" tabindex="1" path="userRoleList"
                                             id="roleTypeId"
                                             name="roleTypeId">
                                    <form:option value="">---Please Select---</form:option>
                                    <form:options items="${userRoleList}" itemValue="valueInteger"
                                                  itemLabel="text"/>
                                </form:select>
                            </div>

                        </div>
                        <div class="form-group row">
                            <div class="col-2"></div>
                            <div class="col-1">
                                <input type="reset" class="btn btn-info " value="New" id="btnNew">
                            </div>
                            <div class="col-1">
                                <input type="submit" class="btn btn-info " value="Save" id="btnSave">

                            </div>
                            <div class="col-1 float-md-right">
                                <input type="button" disabled class="btn btn-danger " value="Delete"
                                       id="btnDelete">
                            </div>
                        </div>
                        <div class="card">
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="createdUserGrid" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">Login Id</th>
                                        <th class="text-muted">User Name</th>
                                        <th class="text-muted">Date Created</th>
                                        <th class="text-muted">Role</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
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
</html>




