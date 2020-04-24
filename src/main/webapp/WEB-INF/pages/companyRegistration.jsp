<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 4/6/2020
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Register Company</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body class="hold-transition sidebar-mini">

<form role="form" id="companyRegistrationFormId" action="<c:url value='/companyRegistration'/>"
      method="post">
    <div class="card">
        <div class="card-body">

            <div class="form-group row">
                <label for="companyId" class="col-sm-2 col-form-label">Company Id</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" name="companyId" id="companyId">
                </div>
            </div>

            <div class="form-group row">
                <label for="companyName" class="col-sm-2 col-form-label">Company Name</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" name="companyName" id="companyName">
                </div>
            </div>

            <div class="form-group row">

                <div class="offset-sm-2 col-sm-10">
                    <button type="submit" class="btn btn-primary" id="btnSave">Submit</button>
                </div>
            </div>

            <section class="content">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Company List</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="listTableId" class="table table-bordered table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>Sl. No</th>
                                        <th>Company ID</th>
                                        <th>Company Name</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    </div>
</form>

</body>
</html>
