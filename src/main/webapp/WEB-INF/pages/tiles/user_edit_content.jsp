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
            <s:bind path="user">
                <c:forEach items="${status.errorMessages}" var="error">
                    <div class="error"><s:message code="${error}"/></div>
                </c:forEach>
            </s:bind>
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
                        <s:bind path="user.firstName">
                            <c:forEach items="${status.errorMessages}" var="error">
                                <div class="error"><s:message code="${error}"/></div>
                            </c:forEach>
                        </s:bind>
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
                        <s:bind path="user.lastName">
                            <c:forEach items="${status.errorMessages}" var="error">
                                <div class="error"><s:message code="${error}"/></div>
                            </c:forEach>
                        </s:bind>
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
                        <s:bind path="user.oldPassword">
                            <c:forEach items="${status.errorMessages}" var="error">
                                <div class="error"><s:message code="${error}"/></div>
                            </c:forEach>
                        </s:bind>
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
                        <s:bind path="user.password">
                            <c:forEach items="${status.errorMessages}" var="error">
                                <div class="error"><s:message code="${error}"/></div>
                            </c:forEach>
                        </s:bind>
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
                        <s:bind path="user.confirmPassword">
                            <c:forEach items="${status.errorMessages}" var="error">
                                <div class="error"><s:message code="${error}"/></div>
                            </c:forEach>
                        </s:bind>
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
                        <s:bind path="user.email">
                            <c:forEach items="${status.errorMessages}" var="error">
                                <div class="error"><s:message code="${error}"/></div>
                            </c:forEach>
                        </s:bind>
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
                        <s:bind path="user.passport">
                            <c:forEach items="${status.errorMessages}" var="error">
                                <div class="error"><s:message code="${error}"/></div>
                            </c:forEach>
                        </s:bind>
                    </td>
                </tr>
            </table>

            <%--            <div class="form-group">
                            <label for="name"><s:message code="login.name"/></label>
                            <c:set var="loginNameText"><s:message code="login.name"/></c:set>
                            <sf:input path="username"
                                      class="form-control" id="name" placeholder="${loginNameText}"/>
                            <s:bind path="user.username">
                                <c:forEach items="${status.errorMessages}" var="error">
                                    <div class="error"><s:message code="${error}"/></div>
                                </c:forEach>
                            </s:bind>
                        </div>
            <div class="form-group">
                <label for="oldPassword"><s:message code="edituser.oldpassword"/></label>
                <c:set var="loginNameText"><s:message code="edituser.oldpassword"/></c:set>
                <sf:password path="oldPassword"
                             class="form-control" id="oldPassword" placeholder="${loginNameText}"/>
                <s:bind path="user.oldPassword">
                    <c:forEach items="${status.errorMessages}" var="error">
                        <div class="error"><s:message code="${error}"/></div>
                    </c:forEach>
                </s:bind>
            </div>
            <div class="form-group">
                <label for="passwordF"><s:message code="login.password"/></label>
                <c:set var="loginNameText"><s:message code="login.password"/></c:set>
                <sf:password path="password"
                             class="form-control" id="passwordF" placeholder="${loginNameText}"/>
                <s:bind path="user.password">
                    <c:forEach items="${status.errorMessages}" var="error">
                        <div class="error"><s:message code="${error}"/></div>
                    </c:forEach>
                </s:bind>
            <%--<c:set var="error">
                <sf:errors delimiter="" path="password"/>
            </c:set>
            <c:if test="${not empty error}">
                <div class="error"><s:message code="${error}"/></div>
            </c:if>
        </div>
        <div class="form-group">
            <label for="cpasswordF"><s:message code="registration.confirmpassword"/></label>
            <c:set var="loginNameText"><s:message code="registration.confirmpassword"/></c:set>
            <sf:password path="confirmPassword"
                         class="form-control" id="cpasswordF" placeholder="${loginNameText}"/>
            <s:bind path="user.confirmPassword">
                <c:forEach items="${status.errorMessages}" var="error">
                    <div class="error"><s:message code="${error}"/></div>
                </c:forEach>
            </s:bind>
        </div>
        <div class="form-group">
            <label for="emailF"><s:message code="registration.email"/></label>
            <c:set var="loginNameText"><s:message code="registration.email"/></c:set>
            <sf:input path="email"
                      class="form-control" id="emailF" placeholder="${loginNameText}"/>
            <s:bind path="user.email">
                <c:forEach items="${status.errorMessages}" var="error">
                    <div class="error"><s:message code="${error}"/></div>
                </c:forEach>
            </s:bind>
        </div>
        <div class="form-group">
            <label for="passportF"><s:message code="registration.passport"/></label>
            <c:set var="loginNameText"><s:message code="registration.passport"/></c:set>
            <sf:input path="passport"
                      class="form-control" id="passportF" placeholder="${loginNameText}"/>
            <s:bind path="user.passport">
                <c:forEach items="${status.errorMessages}" var="error">
                    <div class="error"><s:message code="${error}"/></div>
                </c:forEach>
            </s:bind>
        </div>--%>
            <input type="submit" class="btn btn-primary ss" value="<s:message code="useredit.updateuser"/>"/>
        </sf:form> 
    </div>
</div>