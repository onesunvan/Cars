<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="sf"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<div class="row-fluid span6 offset3" >
    <div class='row-fluid span6 offset3 login'>
        <sf:form method="POST" commandName="user"
                 action="#"
                 enctype="multipart/form-data">
            <h3><s:message code="useredit.updatepassword"/></h3>
            <sf:errors cssClass="error" path=""/>
            <table style="margin: 0 auto;">
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
            </table>
            <input type="submit" class="btn btn-primary ss" value="<s:message code="useredit.updateuser"/>"/>
        </sf:form> 
    </div>
</div>