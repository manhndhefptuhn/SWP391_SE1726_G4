<%-- 
    Document   : AdminUserList
    Created on : Jun 9, 2023, 10:59:06 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="generator" content="Hugo 0.101.0">
  <title>Admin UserList</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/dashboard/">



  <!-- Bootstrap core CSS -->
  <link href="<%= request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/css/dashboard.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style3.css">



  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>


  <!-- Custom styles for this template -->
  <link href="<%= request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#"></a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <ul class="navbar-nav px-3" >
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="#">Admin</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">
              <div>
                <img src="https://bootdey.com/img/Content/avatar/avatar7.png" width="100px" id="profile-pic"alt="User">
                <h1>Admin</h1>
              </div>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="home"></span>
              Dashboard <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="AdminUserList.jsp">
              <span data-feather="file"></span>
              User List
            </a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="AdminSettingList.jsp">
              <span data-feather="settings"></span>
              Setting List
            </a>
          </li>


        </ul>

      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      <h2>User List</h2>
      <div class="search_bar">
        <input type="email" id="email" name="email" type="text" id="text" name="text" type="tel" id="phone" name="phone" placeholder="Enter email, name, phone">
        <select name="roles" id="roles">
          <option value="All Roles">All Roles</option>
          <option value="Admin">Admin</option>
          <option value="Sales">Sales</option>
          <option value="Customer">Customer</option>
          <option value="Support">Support</option>
        </select>
        <select name="status" id="status">
          <option value="All Status">All Status</option>
          <option value="active">Active</option>
          <option value="inactive">Inactive</option>
        </select>
        <button type="button" id="search" name="search">Search</button>
        <button type="button" id="add" name="add"><a href="AdminAddUser.html" style="color: white">Add new user</a></button>
      </div>

      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
          <tr>
            <th>ID</th>
            <th>Customer Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Role</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>1,001</td>
            <td>random</td>
            <td>data</td>
            <td>placeholder</td>
            <td>text</td>
            <td>1000</td>
            <td><a href="AdminUserDetail.html">Edit</a></td>

          </tr>
          <tr>
            <td>1,002</td>
            <td>placeholder</td>
            <td>irrelevant</td>
            <td>visual</td>
            <td>layout</td>
            <td>1000</td>
            <td><a href="AdminUserDetail.html">Edit</a></td>

          </tr>
          <tr>
            <td>1,003</td>
            <td>data</td>
            <td>rich</td>
            <td>dashboard</td>
            <td>tabular</td>
            <td>1000</td>
            <td><a href="AdminUserDetail.html">Edit</a></td>
          </tr>
          <tr>
            <td>1,003</td>
            <td>information</td>
            <td>placeholder</td>
            <td>illustrative</td>
            <td>data</td>
            <td>1000</td>
            <td><a href="AdminUserDetail.html">Edit</a></td>
          </tr>
          <tr>
            <td>1,004</td>
            <td>text</td>
            <td>random</td>
            <td>layout</td>
            <td>dashboard</td>
            <td>1000</td>
            <td><a href="AdminUserDetail.html">Edit</a></td>
          </tr>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="<%= request.getContextPath()%>/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="<%= request.getContextPath()%>/assets/dist/js/bootstrap.bundle.min.js"></script>


<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
<script src="<%= request.getContextPath()%>/js/dashboard.js"></script>
</body>
</html>


