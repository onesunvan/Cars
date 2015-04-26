<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="sf"%>

<security:authorize access="hasRole('ROLE_ADMIN')" var="isUser"/>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<div class="row-fluid span6 offset3" >
    <div class='row-fluid span6 offset3 login'>
        <img src="<c:url value="/carImg/${car.id}"/>" class="img-rounded myimg"/>
        <p class='CandyName'>${car.brand}</p>
        <p class='CandyName'>${car.model}</p>
        <p class='CandyName'>${car.price} $</p>
        <a href="<c:url value="/bookCar"/>">
            <s:message code="car.ordercar"/>
        </a>
    </div>
</div>
