<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div class="row-fluid span4 offset4 welcome" >
    <s:message code="admin.hello"/>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome : ${pageContext.request.userPrincipal.name} 
            | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>  
    </c:if>
</div>
