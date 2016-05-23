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
<div class="container">
    <div class="row">
        <div class="table-responsive">
            <table class="table table-hover">
            	<tbody id="myTable">
            		<tr>
            			<td><p class='CandyName'><s:message code="orders.details"/><p/></td>
            			<td>
            				<p class='CandyName'><s:message code="${order.status}"/></p>
            			</td>
            			<td>
							<c:if test="${isAdmin}">
								<c:choose>
									<c:when test="${order.status == 'NEW_ORDER'}">
										<form action="<c:url value="/orders/${order.id}"/>" method="POST">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<input type="hidden" name="_method" value="put" /> 
											<input type="hidden" name="action" value="accept" />
											<button type="submit" class="btn btn-primary ss">
												<s:message code="orders.accept" />
											</button>
										</form>
										<form action="<c:url value="/orders/${order.id}"/>" method="POST">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<input type="hidden" name="_method" value="put" /> 
											<input type="hidden" name="action" value="decline" />
											<button type="submit" class="btn btn-primary ss">
												<s:message code="orders.decline" />
											</button>
										</form>
									</c:when>
									<c:when test="${order.status == 'DECLINED'}">
										<p class='CandyName'><s:message code="orders.declined" /></p>
									</c:when>
									<c:when test="${order.status == 'RETURNED'}">
										<form action="<c:url value="/orders/${order.id}"/>" method="POST">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<input type="hidden" name="_method" value="put" /> 
											<input type="hidden" name="action" value="fine" />
											<button type="submit" class="btn btn-primary ss">
												<s:message code="orders.fine" />
											</button>
										</form>
										<form action="<c:url value="/orders/${order.id}"/>" method="POST">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<input type="hidden" name="_method" value="put" /> 
											<input type="hidden" name="action" value="close" />
											<button type="submit" class="btn btn-primary ss">
												<s:message code="orders.close" />
											</button>
										</form>
									</c:when>
									<c:when test="${order.status == 'CLOSED'}">
										<p class='CandyName'><s:message code="orders.closed" /></p>
									</c:when>
									<c:otherwise>
										<p class='CandyName'><s:message code="orders.details.waitingforuser" /></p>
									</c:otherwise>
								</c:choose>
							</c:if>
							<c:if test="${isUser }">
								<c:choose>
									<c:when test="${order.status == 'ACCEPTED'}">
										<form action="<c:url value="/orders/${order.id}"/>" method="POST">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<input type="hidden" name="_method" value="put" /> 
											<input type="hidden" name="action" value="pay" />
											<button type="submit" class="btn btn-primary ss">
												<s:message code="orders.pay" />
											</button>
										</form>
									</c:when>
									<c:when test="${order.status == 'DECLINED'}">
										<p class='CandyName'><s:message code="orders.declined" /></p>
									</c:when>
									<c:when test="${order.status == 'IN_USE'}">
										<form action="<c:url value="/orders/${order.id}"/>" method="POST">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<input type="hidden" name="_method" value="put" /> 
											<input type="hidden" name="action" value="return" />
											<button type="submit" class="btn btn-primary ss">
												<s:message code="orders.returncar" />
											</button>
										</form>
									</c:when>
									<c:when test="${order.status == 'FINED'}">
										<form action="<c:url value="/orders/${order.id}"/>" method="POST">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<input type="hidden" name="_method" value="put" /> 
											<input type="hidden" name="action" value="pay-fine" />
											<button type="submit" class="btn btn-primary ss">
												<s:message code="orders.pay" />
											</button>
										</form>
									</c:when>
									<c:when test="${order.status == 'CLOSED'}">
										<p class='CandyName'><s:message code="orders.closed" /></p>
									</c:when>
									<c:otherwise>
										<p class='CandyName'><s:message code="orders.details.waitingformanager" /></p>
									</c:otherwise>
								</c:choose>
							</c:if>
            			</td>
            		</tr>
            		<tr>
            			<td>
            				<img src="<c:url value="/cars/${car.id}/img"/>" class="img-rounded myimg"/>
            			</td>
            			<td>
            				<p class='CandyName'>${car.brand} ${car.model}</p>
            			</td>
            			<td>
            				<p class='CandyName'>${car.price} $ <s:message code="orders.perweek"/></p>
            			</td>
            		</tr>
            		<c:if test="${isAdmin}">
	            		<tr>
	            			<td>
	            				<img src="<c:url value="/users/${order.user.username}/img"/>" class="img-rounded myimg"/>
	            			</td>
	            			<td>
	            				<p class='CandyName'>${order.user.username}</p>
	            			</td>
	            			<td>
	            				<p class='CandyName'>${order.user.userInformation.firstName} ${order.user.userInformation.lastName}</p>
	            			</td>
	            		</tr>
            		</c:if>
            	</tbody>
            </table>
        </div>
    </div>
</div>