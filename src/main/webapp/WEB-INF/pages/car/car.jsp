<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="sf"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<security:authorize access="hasRole('ROLE_USER')" var="isUser"/>
<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin"/>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<div class="row-fluid span6 offset3" >
    <div class='row-fluid span6 offset3 login'>
        <img src="<c:url value="/cars/${car.id}/img"/>" class="img-rounded myimg"/>
        <p class='CandyName'>${car.brand}</p>
        <p class='CandyName'>${car.model}</p>
        <p class='CandyName'>${car.price} $</p>
        <c:if test="${not isAdmin}">
            <form action="<c:url value="/orders"/>" method="POST">
            	<input type="hidden" name="carId" value="${car.id}"/>
            	<button type="submit" class="btn-link"><s:message code="car.ordercar"/></button>
            </form>
        </c:if>
        <c:if test="${isAdmin}">
            <c:choose>
                <c:when test="${car.ifExists}">
                	<form action="<c:url value="/cars/${car.id}"/>" method="POST">
						<input type="hidden" name="_method" value="put" /> 
						<input type="hidden" name="action" value="disable" />
						<button type="submit" class="btn-link">
							<s:message code="car.deletecar" />
						</button>
					</form>
                </c:when>
                <c:otherwise>
                	<form action="<c:url value="/cars/${car.id}"/>" method="POST">
						<input type="hidden" name="_method" value="put" /> 
						<input type="hidden" name="action" value="restore" />
						<button type="submit" class="btn-link">
							<s:message code="car.restorecar" />
						</button>
					</form>
                </c:otherwise>
            </c:choose>
        </c:if>
    </div>
</div>
