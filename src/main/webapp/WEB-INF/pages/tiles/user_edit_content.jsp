<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="sf"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<div class="row-fluid span6 offset3" >
    <div class='row-fluid span6 offset3 login'>
        <sf:form method="POST" commandName="user"
                 action="#">
            <h3><s:message code="useredit.title"/></h3>
            <sf:errors cssClass="error" path=""/>
            <table align="center">
                <tr>
                    <td>
                        <label for="first_name"><s:message code="registration.first_name"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="registration.first_name"/></c:set>
                        <sf:input path="firstName"
                                  class="form-control" id="first_name" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="last_name"><s:message code="registration.last_name"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="registration.last_name"/></c:set>
                        <sf:input path="lastName"
                                  class="form-control" id="last_name" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="lastName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="oldpasswordF"><s:message code="edituser.oldpassword"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="edituser.oldpassword"/></c:set>
                        <sf:password path="oldPassword"
                                     class="form-control" id="oldpasswordF" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="oldPassword"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="passwordF"><s:message code="login.password"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="login.password"/></c:set>
                        <sf:password path="password"
                                     class="form-control" id="passwordF" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="password"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="cpasswordF"><s:message code="registration.confirmpassword"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="registration.confirmpassword"/></c:set>
                        <sf:password path="confirmPassword"
                                     class="form-control" id="cpasswordF" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="confirmPassword"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="emailF"><s:message code="registration.email"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="registration.email"/></c:set>
                        <sf:input path="email"
                                  class="form-control" id="emailF" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="email"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="passportF"><s:message code="registration.passport"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="registration.passport"/></c:set>
                        <sf:input path="passport"
                                  class="form-control" id="passportF" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="passport"/>
                    </td>
                </tr>
            </table>
            <input type="submit" class="btn btn-primary ss" value="<s:message code="useredit.updateuser"/>"/>
        </sf:form> 
    </div>
</div>