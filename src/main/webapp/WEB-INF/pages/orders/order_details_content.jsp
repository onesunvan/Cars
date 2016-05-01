<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<security:authorize access="hasRole('ROLE_USER')" var="isUser" />
<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />

<c:set var="car" value="${order.car}" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/login.css"/>">
<div class="row-fluid span6 offset3">
	<div class='row-fluid span6 offset3 login'>
		<p class='CandyName'>
			<s:message code="orders.details" />
		</p>
		<%-- <img src="<c:url value="/carImg/${car.id}"/>" class="img-rounded myimg"/> --%>
		<p class='CandyName'>${car.brand}${car.model}-${car.price} $</p>
		<p class='CandyName'>${order.user.username}</p>
		<p class='CandyName'>${order.status}</p>
		<c:if test="${isAdmin}">
			<c:choose>
				<c:when test="${order.status == 'NEW'}">
					<form action="<c:url value="/orders/${order.id}"/>" method="POST">
						<input type="hidden" name="_method" value="put" /> <input
							type="hidden" name="action" value="accept" />
						<button type="submit" class="btn-link">
							<s:message code="orders.accept" />
						</button>
					</form>
					<form action="<c:url value="/orders/${order.id}"/>" method="POST">
						<input type="hidden" name="_method" value="put" /> <input
							type="hidden" name="action" value="decline" />
						<button type="submit" class="btn-link">
							<s:message code="orders.decline" />
						</button>
					</form>
				</c:when>
				<c:when test="${order.status == 'NEW'}">
				</c:when>
				<c:otherwise>
					<s:message code="orders.details.waitingforuser" />
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${isUser }">
			<c:choose>
				<c:when test="${order.status == 'NEW'}">

				</c:when>
				<c:when test="${order.status == 'NEW'}">

				</c:when>
				<c:otherwise>
					<s:message code="orders.details.waitingformanager" />
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
</div>
