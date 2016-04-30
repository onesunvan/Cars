<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${cars.size() gt 0}">
    <c:forEach var="i" begin="0" end="${cars.size() - 1}" step="3">
        <div class='row-fluid'>
            <c:if test="${i lt cars.size()}">
                <div class='span4 row-fluid'>
                    <div class='candy-div span10 offset2'>
                        <a href="<c:url value="/car/${cars[i].id}"/>">
                            <button>
                                <img src="<c:url value="/carImg/${cars[i].id}"/>" class="img-rounded myimg"/>
                                <p class='CandyName'>${cars[i].brand}</p>
                                <p class='CandyName'>${cars[i].model}</p>
                                <p class='CandyName'>${cars[i].price} $</p>
                            </button>
                        </a>
                    </div>
                </div>
            </c:if>
            <c:if test="${(i + 1) lt cars.size()}">
                <div class='span4 row-fluid'>
                    <div class='candy-div span10 offset1' >
                        <a href="<c:url value="/car/${cars[i + 1].id}"/>">
                            <button>
                                <img src="<c:url value="/carImg/${cars[i + 1].id}"/>" class="img-rounded myimg"/>
                                <p class='CandyName'>${cars[i + 1].brand}</p>
                                <p class='CandyName'>${cars[i + 1].model}</p>
                                <p class='CandyName'>${cars[i + 1].price} $</p>
                            </button>
                        </a>
                    </div>
                </div>
            </c:if>
            <c:if test="${(i + 2) lt cars.size()}">
                <div class='span4 row-fluid'>
                    <div class='candy-div span10' >
                        <a href="<c:url value="/car/${cars[i + 2].id}"/>">
                            <button>
                                <img src="<c:url value="/carImg/${cars[i + 2].id}"/>" class="img-rounded myimg"/>
                                <p class='CandyName'>${cars[i + 2].brand}</p>
                                <p class='CandyName'>${cars[i + 2].model}</p>
                                <p class='CandyName'>${cars[i + 2].price} $</p>
                            </button>
                        </a>
                    </div>
                </div>
            </c:if>
        </div>
    </c:forEach>
</c:if>
