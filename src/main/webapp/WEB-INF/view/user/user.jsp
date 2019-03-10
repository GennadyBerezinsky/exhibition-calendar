<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page import="java.util.ResourceBundle" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="strings"/>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">

    <meta name="author" content="">


    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading"><fmt:message key="MENU"/></div>
      <div class="list-group list-group-flush">
        <a href="#" class="list-group-item list-group-item-action bg-light"><fmt:message key="EXHIBITIONS"/></a>
        <a href="#" class="list-group-item list-group-item-action bg-light"><fmt:message key="EXHIBITION_HALLS"/></a>
        <a href="#" class="list-group-item list-group-item-action bg-light"><fmt:message key="CATEGORYES"/></a>
        <a href="#" class="list-group-item list-group-item-action bg-light"><fmt:message key="MY_TICKETS"/></a>

      </div>
    </div>


    <!-- Page Content -->
    <div id="page-content-wrapper">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">


            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/servlet/toregistr"><fmt:message key="registration"/></a>
                    </li>

                    </li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">


        </div>
    </div>
</div>

</body>

</html>