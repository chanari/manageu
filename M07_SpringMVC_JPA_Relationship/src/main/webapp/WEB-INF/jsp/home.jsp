<%-- 
    Document   : home
    Created on : Mar 30, 2018, 8:25:41 PM
    Author     : AnhLe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    </head>
    <body>
        <div class="container">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <h1>Show List User</h1>
            </div> 
            <c:if test="${message!=null && message!=''}">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="alert alert-danger">
                        ${message}
                    </div>
                </div>
            </c:if>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <form action="search" method="post" class="form-inline">
                    <div class="form-group">
                        <input name="searchText" placeholder="type an email" type="text" class="form-control" />
                        <input type="submit" value="search" />
                    </div>
                </form>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-12" style="padding-bottom: 5px; padding-top: 5px">
                <button class="btn-default" onclick="location.href = '${pageContext.request.contextPath}/add-new'">Add New User</button>
            </div> 
            <div class="col-xs-12 col-sm-12 col-md-12">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Detail</th>
                            <th>Birth Date</th>
                            <th>Gender</th>
                            <th>Country</th>
                            <th>Smoking</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="u" items="${lstUser}">
                            <tr>
                                <td>${u.userDetail.firstname}</td>
                                <td>${u.userDetail.lastname}</td>
                                <td>${u.email}</td>
                                <td>${u.password}</td>
                                <td>${u.userDetail.detail}</td>
                                <td>${u.userDetail.birthDate}</td>
                                <td>${u.userDetail.gender}</td>
                                <td>${u.country.name}</td>
                                <td>${u.userDetail.nonSmoking}</td>
                                <td>
                                    <button class="btn-warning" onclick="location.href = '${pageContext.request.contextPath}/edit/${u.id}'">Edit</button>
                                    <button class="btn-danger" onclick="location.href = '${pageContext.request.contextPath}/delete/${u.id}'">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
