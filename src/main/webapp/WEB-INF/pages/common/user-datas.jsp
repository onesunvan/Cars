<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<security:authorize access="hasRole('ROLE_USER')" var="isUser"/>


<c:choose>
    <c:when test="${isUser}">
        <table>
            <tr>
                <td>
                    <img src="<c:url value="/avatarImg"/>" style="width:200px; height:200px;" width="200" height="200"/>
                </td>
            </tr>
            <tr>
                <td>
                    ${userDTO.firstName}
                </td>
            </tr>
            <tr>
                <td>
                    ${userDTO.lastName}
                </td>
            </tr>
            <tr>
                <td>
                    ${userDTO.email}
                </td>
            </tr>
            <tr>
                <td>
                    ${userDTO.phoneNumber}
                </td>
            </tr>
            <tr>
                <td>
                    <a href="<c:url value="/editUser"/>">
                        <button class="btn btn-primary"><s:message code="useredit.title"/></button>
                    </a>
                </td>
            </tr>

        </table>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/login"/>">
            <s:message code="popuplogin.access"/> 
        </a>
    </c:otherwise>
</c:choose>