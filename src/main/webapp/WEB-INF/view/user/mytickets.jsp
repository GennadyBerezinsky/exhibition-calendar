<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2019
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page import="java.util.ResourceBundle" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="strings"/>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">

    <meta name="author" content="">


    <title>My Tickets</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
        <div class="sidebar-heading"><fmt:message key="page.all.menu"/></div>
        <div class="list-group list-group-flush">
            <a href="${pageContext.request.contextPath}/servlet/gotoselect" class="list-group-item list-group-item-action bg-light"><fmt:message key="EXHIBITIONS"/></a>
            <a href="${pageContext.request.contextPath}/servlet/gotomytickets" class="list-group-item list-group-item-action bg-light"><fmt:message key="MY_TICKETS"/></a>

        </div>
    </div>


    <!-- Page Content -->
    <div id="page-content-wrapper">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">


            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/servlet/logout"><fmt:message key="LOG_OUT"/></a>
                    </li>

                    </li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">


            <c:if test="${fn:length(dto) eq 0}">
                <div class="alert alert-danger">
                    <strong>Error!</strong> <fmt:message key="ERROR_SEARCH"/>
                </div>
            </c:if>

            <c:if test="${fn:length(dto) gt 0}">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th><fmt:message key="table.ticket.id"/> </th>
                        <th><fmt:message key="TABLE_HALL"/> </th>
                        <th><fmt:message key="TABLE_CAT"/> </th>
                        <th><fmt:message key="TABLE_NAME_EXHIBITION"/> </th>
                        <th><fmt:message key="TABLE_PRICE"/> </th>
                        <th><fmt:message key="TABLE_DATE"/> </th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${dto}" varStatus="status">
                        <tr>
                            <th>${i.ticket.idTicket}</th>
                            <th>${i.exhibition.hallName}</th>
                            <th>${i.exhibition.catName}</th>
                            <th>${i.exhibition.name}</th>
                            <th>${i.exhibition.price}</th>
                            <th>${i.exhibition.date}</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <form action="${pageContext.request.contextPath}/servlet/topage">
                    <ul class="pagination">
                        <c:forEach var="i" begin="1" end="${pages}">
                            <li>
                                <input type="submit" name="pagenum" value="${i}">
                            </li>
                        </c:forEach>
                    </ul>
                </form>

            </c:if>



        </div>
    </div>
</div>

</body>

</html>
