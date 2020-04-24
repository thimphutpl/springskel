<%--
  Created by IntelliJ IDEA.
  User: Jigme Dorji
  Date: 24-04-2020
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<title class="title">User Access Permission</title>

<body class="hold-transition sidebar-mini">
<%--<div class="wrapper">--%>
<!-- Content Wrapper. Contains page content -->
<div class="">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h5>User Access Permission</h5>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">User Access Permission</li>
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
                <form id="userAccessPermissionForm" action="<c:url value='/userAccessPermission'/> "
                      class="form-horizontal globalForm">

                    <div class="card-body">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label ">User Roles:</label>

                            <div class="col-5">
                                <form:select class="form-control form-control-sm" tabindex="1" path="userRoleList"
                                             id="roleTypeId"
                                             name="userRoleTypeId">
                                    <form:option value="">---Please Select---</form:option>
                                    <form:options items="${userRoleList}" itemValue="valueInteger"
                                                  itemLabel="text"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="card">
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="userAccessPermissionGrid" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">Screen Id</th>
                                        <th class="text-muted">Screen Name</th>
                                        <th class="text-muted">View Access</th>
                                        <th class="text-muted">Edit Access</th>
                                        <th class="text-muted">Delete Access</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                        <div class="form-group row">
                            <div class="col-4"></div>
                            <div class="col-6">
                                <input type="submit" class="btn btn-info col-3" value="Save" id="btnSave">

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

