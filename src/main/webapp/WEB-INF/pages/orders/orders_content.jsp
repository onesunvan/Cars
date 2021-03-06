<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	
<security:authorize access="hasRole('ROLE_USER')" var="isUser" />
<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />

<div class="container">
    <div class="row">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                    <tr>
                    	<c:if test="${isAdmin}">
                    		<th><s:message code="orders.username"/></th>
                    	</c:if>
                        <th><s:message code="orders.carbrandandmodel"/></th>
                        <th><s:message code="orders.status"/></th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <c:forEach items="${orders}" var="order">
                        <tr style="cursor: pointer" onclick="location.href='<c:url value="/orders/${order.id}"/>';">
                            <c:if test="${isAdmin}">
                            	<td>
                            		${order.user.username}
                            	</td>
                            </c:if>
                            <td>
                                ${order.car.brand} ${order.car.model}
                            </td>
                            <td>
                                <s:message code="${order.status}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="pagination">
                <ul>
                    <c:forEach begin="1" end="${(amount / 9) + 1}" var="i">
                        <li><a href="?pageNumber=${i}">${i}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>