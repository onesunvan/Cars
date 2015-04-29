<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<script>
    var count = 1;
    function yHandler() {
        var wrap = document.getElementById('wrap');
        var contentHeight = wrap.offsetHeight;
        var yOffset = window.pageYOffset;
        var y = yOffset + window.innerHeight;
        if (y >= contentHeight) {
            // Ajax call to get more dynamic data goes here
            console.log(count);
            $.ajax({url: "<c:url value="/cars"/>",
                data: ("number=" + count) <c:if test="${not empty filter}"> + "&filter=" + "${filter}"</c:if> , success: 
                    function (result) {
                        $("#div1").html(result);
                        wrap.innerHTML += result;
                        count++;
                    }});
        }
    }
    window.onscroll = yHandler;
    window.onload = function () {
        var wrap = document.getElementById('wrap');
        $.ajax({url: "<c:url value="/cars"/>",
            data: ("number=" + 0) <c:if test="${not empty filter}"> + "&filter=" + "${filter}"</c:if> ,
            success: function (result) {
                console.log(0);
                console.log("query");
                $("#div1").html(result);
                wrap.innerHTML += result;
            }});
    };
</script>
<div class="row-fluid" align="center">
    <form action="<c:url value="/"/>" method="GET">
        <input type="text" name="filter" placeholder="<s:message code="welcome.searching"/>"/><br/>
        <input type="submit" class="btn btn-primary" value="<s:message code="welcome.search"/>"/>
    </form>
</div> 
<div id="wrap"></div>