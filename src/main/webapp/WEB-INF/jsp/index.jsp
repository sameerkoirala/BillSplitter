<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="css/bootstrap-reboot.min.css" rel="stylesheet">

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Bill Splitter <sup>V1</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="index.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <%--        <!-- Heading -->--%>
        <%--        <div class="sidebar-heading">--%>
        <%--            Interface--%>
        <%--        </div>--%>

        <%--        <!-- Nav Item - Pages Collapse Menu -->--%>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">--%>
        <%--                <i class="fas fa-fw fa-cog"></i>--%>
        <%--                <span>Components</span>--%>
        <%--            </a>--%>
        <%--            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">--%>
        <%--                <div class="bg-white py-2 collapse-inner rounded">--%>
        <%--                    <h6 class="collapse-header">Custom Components:</h6>--%>
        <%--                    <a class="collapse-item" href="buttons.html">Buttons</a>--%>
        <%--                    <a class="collapse-item" href="cards.html">Cards</a>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </li>--%>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Group List</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Group List:</h6>
                    <c:if test="${!empty(groupName)}">
                        <c:forEach var="gname" items="${groupName}">
                    <a class="collapse-item" href="/groupDetails?groupName=${gname}">${gname}</a>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Addons
        </div>

        <form id="logoutForm" method="POST" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
               aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-folder"></i>
                <span>Pages</span>
            </a>
            <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Login Screens:</h6>
                    <a class="collapse-item" href="login.html">Login</a>
                    <a class="collapse-item" href="" data-toggle="modal" data-target="#modalcreateGroupForm">Create
                        Group</a>
                    <a class="collapse-item" href="" data-toggle="modal" data-target="#modaladdMemberForm">Add
                        member</a>
                    <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
                    <div class="collapse-divider"></div>
                    <h6 class="collapse-header">Other Pages:</h6>
                    <a class="collapse-item" href="404.html">404 Page</a>
                    <a class="collapse-item" href="blank.html">Blank Page</a>
                </div>
            </div>
        </li>


        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="charts.html">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Charts</span></a>
        </li>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href="tables.html">
                <i class="fas fa-fw fa-table"></i>
                <span>Tables</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <ul class="navbar-nav ml-auto">
                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small"><em>${name}</em</span>
                            <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
<%--                            <a class="dropdown-item" href="#">--%>
<%--                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>--%>
<%--                                Settings--%>
<%--                            </a>--%>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>
                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <div class="modal fade" id="modaladdMemberForm" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <form method="post" action="/addmember">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold">Add Member</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body mx-3">
                                    <div class="md-form mb-5">
                                        <i class="fas fa-user prefix grey-text"></i>
                                        <input type="text" name="name" id="orangeForm-name"
                                               class="form-control validate"/>
                                        <label data-error="wrong" data-success="right" for="orangeForm-name">Your
                                            name</label>
                                    </div>
                                    <div class="md-form mb-5">
                                        <i class="fas fa-envelope prefix grey-text"></i>
                                        <input name="number" type="text" id="orangeForm-email"
                                               class="form-control validate"/>
                                        <label data-error="wrong" data-success="right" for="orangeForm-email">Phone
                                            Number</label>
                                    </div>

                                </div>
                                <div class="modal-footer d-flex justify-content-center">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <button class="btn btn-primary">ADD</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal fade" id="modalcreateGroupForm" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <form method="post" action="/createGroup">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold">Create Group</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body mx-3">
                                    <div class="md-form mb-4">
                                        <input type="text" name="gName" class="form-control validate"
                                               placeholder="Enter Group Name"/>
                                    </div>
                                    <div class="md-form mb-7">
                                        <div class="table-responsive">
                                            <table class="table " id="dynamic_field">
                                                <tr>
                                                    <td><input type="text" name="name0" placeholder="Enter member's Phone Number"
                                                               class="form-control name_list"/></td>
                                                    <td>
                                                        <button type="button" name="add" id="add" class="btn btn-success"> + Add</button>
                                                    </td>
                                                </tr>
                                            </table>

                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer d-flex justify-content-center">
                                    <input type = "hidden" name="profileName" value="${name}"/>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <button class="btn btn-primary">Create Group</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <c:choose>
                        <c:when test="${!empty(gName)}">
                            <h1 class="h3 mb-0 text-gray-800">Dashboard for ${gName} group </h1>
                        </c:when>
                        <c:otherwise>
                            <h1 class="h3 mb-0 text-gray-800">Dashboard for selecting or creating  a group  </h1>
                        </c:otherwise>
                    </c:choose>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                </div>
<c:choose>
    <c:when test="${!empty(nameLists)}">
                <!-- Content Row -->
                <div class="row">

                  <!-- Earnings (Monthly) Card Example -->
                    <div class="col-xl-12 col-md-12 mb-12">
                        <div class="card border-left-primary shadow h-100 py-2">
                            <div class="card-body">

                                <%--<div class="row no-gutters align-items-center ">--%>
                                <form:form type="Post" action="/billDetails" modelAttribute="newBillingDetails">
                                    <div class="form-inline form-group">

                                        <div class="form-group col-md-3 ">
                                            <label class="form-label col-md-4 " for="description"> Description: </label>
                                            <form:input type="text" id="description" path="description" class="form-control col-md-8 " placeholder="Description"/>
                                        </div>

                                        <div class="form-group col-md-3 ">
                                            <label class="form-label col-md-4 " for="description"> Date: </label>
                                            <form:input type="date" id="date" path="date" class="form-control col-md-8 " placeholder="Date"/>
                                        </div>
                                        <div class="col-md-3 form-group">
                                            <label class="form-label col-md-4 " for="amount"> Amount: </label>
                                            <form:input type="number" step="0.01" path="amount" id="amount" class="form-control col-md-6 " placeholder="Amount"/>
                                        </div>

                                        <div class="form-group col-md-3">

                                            <label for="paidPerson" class="form-label col-md-4"> Paid By: </label>

                                            <form:select path="paidBy" class="form-control col-md-6" id="paidPerson">
                                                <c:choose>
                                                <c:when test = "${!empty(nameLists)}">
                                                <c:forEach var="names" items="${nameLists}">
                                                    <option>${names}</option>
                                                </c:forEach>
                                                </c:when>
                                                    <c:otherwise><option>No Person</option></c:otherwise>
                                                </c:choose>

                                            </form:select>

                                        </div>
                                    </div>

                                <table class="table col-md-12" >
                                    <tr>
                                        <td class="col-md-1">Split On:</td>

                                    <td class="col-md-10">
                                        <form:checkboxes element="span class='checkbox col-md-3'"  path="splitedOn" class="form-check-input" items="${nameLists}" id="inlineCheckbox1"/>
                                    </td>
                                    </tr>
                                </table>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                                    <div class="d-inline">
                                       <form:button class="btn btn-outline-primary" type="submit">Add</form:button>
                                    </div>
                                    <div class="d-inline">
                                        <button type="button" class ="btn btn-outline-primary" onclick="location.href='/calculate'">Settlement</button>
                                    </div>
                                    <div class="d-inline">
                                        <button type="reset" class ="btn btn-outline-primary">Reset</button>
                                    </div>
                                    <form:input path="groupName" type="hidden" value="${gName}"/>

<%--                                    <c:set var="id" value="0"/>--%>
<%--                                    <c:if test="${!empty(billingDetailsList)}">--%>
<%--                                        <c:set var="id" value="${fn:length(billingDetailsList)}"/>--%>
<%--                                    </c:if>--%>
<%--                                    <form:input path="transId" type="hidden" value="${id}"/>--%>

                                </form:form>


                            </div>
                        </div>
                    </div>
                </div>
    </c:when>
    <c:otherwise>
                <div class="row">

                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-12 col-md-12 mb-12">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <c:if test="${!empty(groupName)}">
                                <c:forEach var="gname" items="${groupName}">
                                   <h3> <a class="collapse-item" href="/groupDetails?groupName=${gname}">${gname}</a> </h3>
                                </c:forEach>
                            </c:if>
                            <a class="collapse-item" href="" data-toggle="modal" data-target="#modalcreateGroupForm">Create
                                Group</a>
                        </div>
                    </div>
                </div>
                </div>
                            </c:otherwise>
</c:choose>
                <c:if test="${!empty(billingDetailsList)}">
                    <div class="row" style="margin-top: 20px">
                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-12 col-md-12 mb-12">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <table class="table">
                                        <thead>
                                        <th>Date</th>
                                        <th>Paid By</th>
                                        <th>Description</th>
                                        <th>Paid Amount</th>
                                        <th>Split Amount</th>
                                        <th>Split On</th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items = "${billingDetailsList}" var = "billLists">
                                            <tr>
                                                <td>${billLists.date}</td>
                                                <td>${billLists.paidBy}</td>
                                                <td>${billLists.description}</td>
                                                <td>${billLists.amount}</td>
                                                <td>${billLists.spittedAmount}</td>
                                              <td>  <c:forEach items = "${billLists.splitedOn}" var="nList">
                                                   <spam> ${nList}</spam>,
                                                </c:forEach></td>
                                                <td><button class="btn btn-block btn-danger" onclick="location.href='/remove?id=${billLists.transId}'">Remove</button></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>

                <c:if test="${!empty(data)}">
                    <div class="row" style="margin-top: 20px">
                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-12 col-md-12 mb-12">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <h3>Final Settlement</h3>
                                    <table class="table tab-content">
                                        <tr>
                                        <c:forEach items = "${data}" var = "dataLists">
                                           <td>
                                            <c:forEach items = "${dataLists.value}" var="valueList">
                                                <p>${valueList.name} pays <span>${dataLists.key}</span> = <span>${valueList.amount}</span> </p>
                                            </c:forEach></td>
                                        </c:forEach>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2019</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Are you sure wanna Logout? </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" onclick="document.forms['logoutForm'].submit()">Logout</a>
            </div>
        </div>
    </div>
</div>


<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>


<script type="text/javascript">

    $(document).ready(function () {
        var i = 1;
        $('#add').click(function () {
            i++;
            $('#dynamic_field').append('<tr id="row' + i + '"><td><input type="text" name="name' + i + '" placeholder="Enter Member Name" class="form-control name_list" /></td><td><button type="button" name="remove" id="' + i + '" class="btn btn-danger btn_remove"> X Remove</button></td></tr>');
        });
        $(document).on('click', '.btn_remove', function () {
            var button_id = $(this).attr("id");
            $('#row' + button_id + '').remove();
        });

    });


</script>

</body>

</html>
