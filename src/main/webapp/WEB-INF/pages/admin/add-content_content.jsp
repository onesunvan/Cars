<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="sf"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<div class="row-fluid span6 offset3" >
    <div class='span8 row-fluid offset2 login'>
        <sf:form method="POST" commandName="car"
                 action="#"
                 enctype="multipart/form-data">
            <h3><s:message code="label.car"/></h3>
            <sf:errors cssClass="error" path=""/>
            <table align="center">
                <tr>
                    <td>
                        <label for="brandF"><s:message code="addcontent.brand"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="addcontent.brand"/></c:set>
                        <sf:input path="brand"
                                  class="form-control" id="brandF" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="brand"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="modelF"><s:message code="addcontent.model"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="addcontent.model"/></c:set>
                        <sf:input path="model"
                                  class="form-control" id="modelF" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="model"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="priceF"><s:message code="addcontent.price"/></label>
                    </td>
                    <td>
                        <c:set var="loginNameText"><s:message code="addcontent.price"/></c:set>
                        <sf:input path="price"
                                  class="form-control" id="priceF" placeholder="${loginNameText}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <sf:errors cssClass="error" path="price"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:message code="addcontent.image"/>
                    </td>
                    <td>
                        <input type="file" name="uploadFile" class=" btn-mini"/>
                    </td>
                </tr>
                <c:if test="${not empty imageErrors}">
                    <tr>
                        <td colspan="2">
                            <c:forEach items="${imageErrors}" var="error">
                                <div class="error"><s:message code="${error}"/></div>
                            </c:forEach>
                        </td>
                    </tr>
                </c:if>
            </table>
            <input type="submit" class="btn btn-primary ss" value="<s:message code="addcontent.button"/>"/>
        </sf:form>
    </div>
</div>
