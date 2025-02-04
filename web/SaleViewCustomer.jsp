<%-- 
    Document   : SaleViewCustomerGood
    Created on : 09-07-2023, 21:02:32
    Author     : Zarius
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Sale Customer Detail</title>
        <link rel="icon" type="image/png" href="<%= request.getContextPath()%>/img/shop/logo1.png"/>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="<%= request.getContextPath()%>/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <style>
            .datatable-bottom, .datatable-top, .datatable-sorter, thead{
                display: none;
            }
            input{
                width: 50%;
            }
        </style>
    </head>
    <body class="sb-nav-fixed">
        <%@include file="SaleNavigation.jsp" %>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Customer Detail</h1>
                    <div class="card mb-4">
                        <form method="" action="" enctype="">
                            <c:set var="customer" value="${requestScope.customer}" />
                            <div class="card-body">
                                <input type="hidden" name="user_ID" value="${customer.getUser_ID()}" />
                                <table id="datatablesSimple">
                                    <tbody>
                                        <tr>
                                            <th>Name</th>
                                            <td><input style="background-color:#C5C5C5;" type="text" id="name" name="fullName" value="${customer.getFullName()}" readonly/><br></td>
                                        </tr>
                                        <tr>
                                            <th>Email</th>
                                            <td><input style="background-color:#C5C5C5;" type="email" id="email" name="email" value="${customer.getEmail()}" readonly/><br></td>
                                        </tr>
                                        <tr>
                                            <th>Profile Picture</th>
                                            <td><img id="previewImage" src="<%= request.getContextPath()%>/${customer.getProfile_picture()}" width="150" height="150"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Phone Number</th>
                                            <td><input style="background-color:#C5C5C5;" type="text" id="phone" name="phone" value="${customer.getPhone_Number()}" readonly/><br></td>
                                        </tr>
                                        <tr>
                                            <th>Address</th>
                                            <td><input style="background-color:#C5C5C5;" type="text" id="address" name="address" value="${customer.getAddress()}" readonly/><br></td>
                                        </tr>
                                        <tr>
                                            <th>Role</th>
                                            <td><input style="background-color:#C5C5C5;" type="text" id="role" name="role" value="${customerRole}" readonly/><br>
                                            </td>
                                        </tr>
                                </table>
                                <button type="button" id="back" name="back"><a href="customerList" style="text-decoration: none; color: black;">Back</a></button>
                            </div>
                        </form>
                    </div>
                </div>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid px-4">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Gaming Hub 2023</div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            new simpleDatatables.DataTable('#datatablesSimple', {
                paging: false // Disable pagination
            });
        });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="<%= request.getContextPath()%>/js/scripts1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
    <script src="<%= request.getContextPath()%>/js/datatables-simple-demo1.js"></script>
</body>
</html>
