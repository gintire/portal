<%--
author  : IT0925 임진욱
since   : 2017. 7. 6.
version : 1.0
subject : 
description :
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>
    <!-- Bootstrap Core CSS -->
      <link href="../../../dist/css/bootstrap.css" rel="stylesheet">
      <!-- MetisMenu CSS -->
      <link href="../../../dist/css/metisMenu.css" rel="stylesheet">
      <!-- Timeline CSS -->
      <link href="../../../dist/css/timeline.css" rel="stylesheet">
      <!-- DataTable CSS -->
      <link href="../../../dist/css/dataTables.bootstrap.css" rel="stylesheet">
      <!-- Custom CSS -->
      <link href="../../../dist/css/sb-admin-2.css" rel="stylesheet">
      <!-- Morris Charts CSS -->
      <link href="../../../dist/css/morris.css" rel="stylesheet">
      <!-- Custom Fonts -->
      <link href="../../../dist/css/font-awesome.css" rel="stylesheet" type="text/css">
    <!-- Date Picker CSS -->
    <link href="../../../dist/css/bootstrap-datetimepicker.css" rel="stylesheet" />
    <!-- tabletools -->
    <link href="../../../dist/css/dataTables.tableTools.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="../../../../dist/css/responsive.bootstrap.css">

<script src="http://phuonghuynh.github.io/js/bower_components/jquery/dist/jquery.min.js"></script>
<style>
@import url(https://fonts.googleapis.com/css?family=Exo+2:400,900);

html {
  height: 100%;
  background: radial-gradient(circle, #fff 20%, #ccc);
  background-size: cover;
}

body {
  font-family: "Exo 2", sans-serif;
}

.generate {
    /* Remove button styles */
    border: none;
    background: transparent;
    outline: none;
    overflow: none;
  
    /* Make 'clickable' */
    cursor: pointer;
}
  
.number {
  text-shadow: 0 0 5px #bbb;
  
  /* Make it big */
  font-weight: 900;
  font-size: 250px;

  /* Center it */
  width: 50%;
  min-height: 50%;
  overflow: auto;
  margin: auto;
  position: absolute;
  top: 0; left: 0; bottom: 0; right: 0;
}

.options {
  background-color: #555;
  border-radius: 5px;
  color: #efefef;
  padding: 10px 20px;
  position: absolute;
  cursor: pointer;
  
  input, label {
    display: none;
  }
  
  &:hover input, &:hover label {
    display: inline;
  }
  
  input {
    background-color: #efefef;
    padding: 10px;
    margin: 5px 15px;
  }
}
</style>
<script>

$(document).ready(function(){
	alert("개발중입니다.\n 꼭 개발해서 대박 나겠습니다");
})
</script>
</head>

<body>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">로또 분석 시스템</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="goMorrisChart.do">전체 데이터 분석</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Analyze<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="goXChart.do">기간별 데이터 분석</a>
                                </li>
                            </ul>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="goD3Chart.do">전체 데이터 분석</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i> Lotto Expectation<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="goFlotChart.do">로또 예측</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">전체 데이터 분석</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
    <!-- /.col-lg-12 -->
         <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bullseye fa-fw"></i>번호대별 당첨 분석
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                   <h1><i class="fa fa-smile-o fa-fw"></i>번호대별 당첨 분석개발중입니다</h1>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
</div>
<!-- /#page-wrapper -->
<!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

</body>
</html>