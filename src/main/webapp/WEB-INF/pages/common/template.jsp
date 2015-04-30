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
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-responsive.css"/>"/>
        <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">-->
        <script src="<c:url value="/resources/js/jquery-2.0.2.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>" ></script>
        <script type="text/javascript">
            var appUrl = "<c:url value="/"/>";
        </script>
    </head>
    <body>
        <header>
            <!--<h1 class='shop-name'><s:message code="welcome.carshow"/></h1>-->
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
        <c:if test="${not empty successMessage}">
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#myModal").modal('show');
                });
            </script>
            <div id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><s:message code="welcome.message"/></h4>
                        </div>
                        <div class="modal-body">
                            <p><s:message code="${successMessage}"/></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal"><s:message code="welcome.close"/></button>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </body>
</html>
