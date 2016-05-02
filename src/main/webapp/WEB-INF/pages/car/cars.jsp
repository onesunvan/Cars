<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	
<security:authorize access="hasRole('ROLE_USER')" var="isUser" />
<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />

<div class="row-fluid" align="center">
    <form action="<c:url value="/"/>" method="GET">
        <input type="text" name="filter" placeholder="<s:message code="welcome.searching"/>"/><br/>
        <input type="submit" class="btn btn-primary" value="<s:message code="welcome.search"/>"/>
    </form>
</div> 

<div class="container">
    <div class="row">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                    <tr>
                    	<th><s:message code="cars.image"/></th>
                        <th><s:message code="cars.brand"/></th>
                        <th><s:message code="cars.model"/></th>
                        <th><s:message code="cars.price"/></th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <c:forEach items="${cars}" var="car">
                        <tr style="cursor: pointer" onclick="location.href='<c:url value="/cars/${car.id}"/>';">
                            <td>
                                <img src="<c:url value="/cars/${car.id}/img"/>" class="img-rounded smallimg"/>
                            </td>
                            <td>
                                <c:out value="${car.brand}"/>
                            </td>
                            <td>
                                <c:out value="${car.model}"/>
                            </td>
                            <td>
                                <c:out value="${car.price}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="pagination">
                <ul>
                    <c:forEach begin="1" end="${(amount / 9) + 1}" var="i">
                        <li><a href="?number=${i}">${i}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>