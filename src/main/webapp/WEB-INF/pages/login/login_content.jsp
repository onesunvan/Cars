<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="sf"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<div class="row-fluid span6 offset3" >
    <div class='span6 row-fluid offset3 login'>
        <h3><s:message code="login.title"/></h3>
        <c:if test="${not empty error}">
            <div class="error"><s:message code="${error}"/></div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg"><s:message code="${msg}"/></div>
        </c:if>
        <c:url value="/j_spring_security_check" var="loginUrl"/>
        <form action="${loginUrl}" method="POST">
            <table style="margin: 0 auto;">
                <tr>
                    <td>
                        <label for="name"><s:message code="login.name"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="login.name"/></c:set>
                        <input type="text" class="form-control" id="name" placeholder="${loginNameText}" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="exampleInputPassword1"><s:message code="login.password"/></label>
                    </td>
                    <td>
                        <c:set var="passwordText"><s:message code="login.password"/></c:set>
                        <input type="password" class="form-control" id="exampleInputPassword1" 
                           name="password" placeholder="${passwordText}"/>
                    </td>
                </tr>
            </table>
            <button type="submit" class="btn btn-primary ss"><s:message code="label.login"/></button>
        </form>
        <form action="<c:url value="/registration"/>" method="GET">
            <button type="submit" class="btn btn-primary ss"><s:message code="label.registration"/></button>
        </form>
    </div>
</div>