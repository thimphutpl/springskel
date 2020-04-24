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
<title class="title">Assign User Role</title>

<body>
<div class="page_title">
    <span class="title">Department of Road</span>
    <span class="subtitle">Assign User Role</span>
</div>
<div class="col-md-3"></div>
<form id="assignUserRoleForm" action="<c:url value='/assignUserRole'/> " class="form-horizontal globalForm">
    <input type="hidden" name="systemDate" id="systemDate" value="${systemDate}"/>
    <input type="hidden" name="linkedRtioOnly" id="linkedRtioOnly" value="${linkedRtioOnly}"/>
    <input type="hidden" name="linkedDealerOnly" id="linkedDealerOnly" value="${linkedDealerOnly}"/>
    <input type="hidden" name="LinkedDepotOnly" id="LinkedDepotOnly" value="${LinkedDepotOnly}"/>

    <div class="col-md-12">
        <fieldset>
            <legend>Assign User Role</legend>
            <div class="form-group">
                <div class="form-group">
                    <div class="col-md-12">
                        <label class="col-md-3 right-label">Login ID:</label>

                        <div class="col-md-5">
                            <input type="text" class="form-control isEnable" name="loginId" id="loginId" maxlength="20"
                                   data-rule-required="true" readonly>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label class="col-md-3 right-label isEnable isDisable">User Name:</label>

                        <div class="col-md-5">
                            <input type="text" class="form-control readonly" id="txtUserName" name="txtUserName"
                                   maxlength="50" readonly>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label class="col-md-3 right-label isEnable">Status:</label>

                        <div class="col-md-4">
                            <input type="text" class="form-control isDisable" id="userStatusName" name="userStatusName"
                                   readonly>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label class="col-md-3 right-label required" for="userGroupId">Screen Access Group:</label>

                        <div class="col-md-5">
                            <form:select class="form-control isDisable" path="userGroupDropdownList" id="userGroupId"
                                         name="userGroupId" data-rule-required="true">
                                <form:option value="">---Please Select---</form:option>
                                <form:options items="${userGroupDropdownList}" itemValue="value"
                                              itemLabel="text"/>
                            </form:select>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label class="col-md-3 right-label required" for="agencyId">Agency:</label>

                        <div class="col-md-5">
                            <form:select class="form-control isDisable" path="agencyDropdownList"
                                         id="agencyId" name="agencyId"
                                         data-rule-required="true">
                                <form:option value="">---Please Select---</form:option>
                                <form:options items="${agencyDropdownList}" itemValue="value"
                                              itemLabel="text"/>
                            </form:select>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-12">
                        <label class="col-md-3 right-label">Mobile No:</label>

                        <div class="col-md-4">
                            <input type="text" name="userMobileNo" id="userMobileNo"
                                   class="form-control mobileNoControl isDisable">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <label class="col-md-3 right-label">Date Assigned:</label>

                        <div class="col-md-4">
                            <input type="text" name="updatedDate" id="updatedDate"
                                   value="${assignedDate}" class="form-control datepicker isDisable" readonly>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2"></div>
                        <security:authorize access="hasRole('1004-ADD')">
                        <div class="col-md-2">
                            <input type="submit" id="btnSave" value="Save" class="btn btn-primary btn-block"/>
                        </div>
                            </security:authorize>
                        <div class="col-md-1"></div>

                        <div class="col-md-2">
                            <input type="reset" id="btnNew" value="New" class="btn btn-primary btn-block"/>
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>


        <fieldset>
            <div class="form-group">
                <div class="col-md-12 datagrid-vh-scroll" style="height: 50%;">
                    <div class="col-lg-12 datagrid" style="width:92%;">
                        <table class="table table-bordered table-striped editable-grid" id="assignUserRoleGrid">
                            <thead>
                            <tr>
                                <th scope="col" width="15%">Login Id</th>
                                <th scope="col" width="20%">User Name</th>
                                <th scope="col" width="20%">Screen Access Group</th>
                                <th scope="col" width="20%">Agency</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>
</form>
</body>
</html>

