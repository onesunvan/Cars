<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<security:authorize access="hasRole('ROLE_USER')" var="isUser"/>

<c:choose>
    <c:when test="${isUser}">
        <li><a href="<c:url value="/editUser"/>"><security:authentication property="principal.username" /></a></li>
        <li> 
            <a href="<c:url value="/j_spring_security_logout" />" >
                <s:message code="login.menu.logout"/>
            </a>
        </li>
    </c:when>
    <c:otherwise>
        <li><a href="<c:url value="/login"/>">
                <s:message code="login.menu.login"/>
            </a>
        </li>
        <li><a href="<c:url value="/registration"/>">
                <s:message code="login.menu.registration"/>
            </a>
        </li>
    </c:otherwise>
</c:choose>