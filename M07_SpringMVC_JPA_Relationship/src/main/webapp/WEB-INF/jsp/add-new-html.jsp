<%-- 
    Document   : add-new-html
    Created on : Apr 4, 2018, 6:30:57 PM
    Author     : AnhLe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <h1>Add new user</h1>
            </div> 
            <c:if test="${message!=null && message!=''}">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="alert alert-danger">
                        ${message}
                    </div>
                </div>
            </c:if>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <f:form action="${pageContext.request.contextPath}/${action}" method="post" modelAttribute="user">

                    <input type="text" hidden name="id" value="${user.id}">
                    <c:if test="${action=='editUser'}">
                        <input type="text" hidden name="userDetail.id" value="${user.userDetail.id}">
                    </c:if>
                    <div class="form-group">
                        <label>First Name:</label>
                        <input type="text" class="form-control" name="userDetail.firstname" value="${user.userDetail.firstname}">
                    </div>
                    <div class="form-group">
                        <label>Last Name:</label>
                        <input type="text" class="form-control" name="userDetail.lastname" value="${user.userDetail.lastname}">
                    </div>
                    <div class="form-group">
                        <label>Email:</label>
                        <input type="email" class="form-control" name="email" value="${user.email}">
                    </div>
                    <div class="form-group">
                        <label>Password:</label>
                        <input type="password" class="form-control" name="password" value="${user.password}">
                    </div>
                    <div class="form-group">
                        <label>Detail:</label>
                        <textarea class="form-control" rows="5" name="userDetail.detail">${user.userDetail.detail}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Birth Date:</label>
                        <input type="text" class="form-control" value="${user.userDetail.birthDate}" placeholder="yyyy-MM-dd" name="userDetail.birthDate">
                    </div>
                    <div class="form-group">
                        <label>Gender: </label>
                        <c:forEach var="gender" items="${genders}">
                            <c:if test="${user.userDetail.gender == gender}">
                                <label class="radio-inline">
                                    <input type="radio" name="userDetail.gender" checked value="${gender}">${gender}
                                </label>
                            </c:if>
                            <c:if test="${user.userDetail.gender != gender}">
                                <label class="radio-inline">
                                    <input type="radio" name="userDetail.gender" value="${gender}">${gender}
                                </label>
                            </c:if>
                        </c:forEach>
                    </div>
                    <div class="form-group">
                        <label>Country: </label>
                        <select name="country.id">
                            <c:forEach var="country" items="${countries}">
                                <c:if test="${user.country.id == country.id}">
                                    <option value="${country.id}" selected>${country.name}</option>
                                </c:if>
                                <c:if test="${user.country.id != country.id}">
                                    <option value="${country.id}">${country.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Smoking: </label>
                        <c:if test="${user.userDetail.nonSmoking}">
                            <input type="checkbox" name="userDetail.nonSmoking" checked/>
                        </c:if>
                        <c:if test="${!user.userDetail.nonSmoking}">
                            <input type="checkbox" name="userDetail.nonSmoking"/>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Register"/>
                    </div>
                </f:form>
            </div>
        </div>
    </body>
</html>
