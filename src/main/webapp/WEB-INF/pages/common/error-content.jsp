<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="sf"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<div class="row-fluid span6 offset3" >
    <div class='span6 row-fluid offset3 login'>
        <span class="error">
            <c:choose>
                <c:when test="${not empty code}">
                    <s:message  code="${code}"/>
                </c:when>
                <c:otherwise>
                    ${message}
                </c:otherwise>
            </c:choose>
        </span>
    </div>
</div>
<!-- 
${exception_message}
-->