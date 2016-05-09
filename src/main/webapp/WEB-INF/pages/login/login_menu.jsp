<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<script type="text/javascript" src="<c:url value="/resources/js/popup-login.js"/>">
</script>
<script type="text/javascript" src="<c:url value="/resources/js/post-form.js"/>">
</script>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/popup-login.css"/>"/>

<security:authorize access="hasRole('ROLE_USER')" var="isUser"/>
<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin"/>


<c:choose>
    <c:when test="${isUser}">
        <li><a href="javascript:PopUpShow()"><security:authentication property="principal.username" /></a></li>
        <li>
			<a href="javascript:post('<c:url value="/j_spring_security_logout"/>', {${_csrf.parameterName}: '${_csrf.token}'})" >
                <s:message code="login.menu.logout"/>
            </a>
        </li>
        <li>
            <a href="<c:url value="/orders"/>">
                <s:message code="login.showmyorders"/>
            </a>
        </li>
        <div class="b-popup" id="popup1">
            <div class="b-popup-content" id="popup-content-id">
<!--                Text in Popup
                <a href="javascript:PopUpHide()">Hide popup</a>-->
            </div>
        </div>	
    </c:when>
    <c:when test="${isAdmin}">
        <li class="brand"><security:authentication property="principal.username" /></li>
        <li> 
            <a href="javascript:post('<c:url value="/j_spring_security_logout"/>', {${_csrf.parameterName}: '${_csrf.token}'})" >
                <s:message code="login.menu.logout"/>
            </a>
        </li>
        <li>
            <a href="<c:url value="/addContent"/>">
                <s:message code="login.menu.add_content"/>
            </a>
        </li>
        <li>
            <a href="<c:url value="/orders?pageNumber=1"/>">
                <s:message code="login.showorders"/>
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
