<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set var="title">
            <t:getAsString name="title"/>
        </c:set>
        <title><s:message code="${title}"/></title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/test.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"/>
        <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>" ></script>
    </head>
    <body>
        <header>
            <h1 class='shop-name'><s:message code="welcome.carshow"/></h1>
        </header>
        <div class="navbar">
            <nav class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li><a class="brand" href="<c:url value="/"/>"><s:message code="welcome.carshow"/></a></li>
                        <li class="divider-vertical"></li>
                            <t:insertAttribute name="menu"/>
                        <li class="divider-vertical"></li>
                            <t:insertAttribute name="login" ignore="true"/>
                    </ul>
                </div>
            </nav>
        </div>
        <div>
            <div class='row-fluid'>
                <t:insertAttribute name="content"/>
            </div>
        </div>
    </body>
</html>
