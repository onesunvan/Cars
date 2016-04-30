<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<div class="container">
    <div class="row">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th><s:message code="orders.carbrandandmodel"/></th>
                        <th><s:message code="orders.status"/></th>
                        <th><s:message code="orders.message"/></th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>
                                ${order.car.brand} ${order.car.model}
                            </td>
                            <td>
                                <s:message code="${order.status}"/>
                            </td>
                            <td>
                                <c:if test="${not empty order.message}">${order.message}</c:if>
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