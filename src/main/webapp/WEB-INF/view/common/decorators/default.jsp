<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

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
    
      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
      
    <!-- jQuery v2.1.4 -->
      <script src="../../../../dist/js/jquery.js"></script>
      <!-- Bootstrap Core JavaScript -->
      <script src="../../../../dist/js/bootstrap.js"></script>
      <!-- Custom Theme JavaScript -->
      <!-- DatePicker JavaScript -->
    <script src="../../../../dist/js/moment-ko.js"></script>
    <script src="../../../../dist/js/transition.js"></script>
    <script src="../../../../dist/js/collapse.js"></script>
    <script src="../../../../dist/js/bootstrap-datetimepicker.js"></script>
    <!-- DataTables JavaScript -->
        <!-- tabletools -->
      <script src="../../../../dist/js/jquery.dataTables.js"></script>
      <script src="../../../../dist/js/dataTables.bootstrap.js"></script>
      <script src="../../../../dist/js/dataTables.responsive.js"></script>
    <script src="../../../../dist/js/responsive.bootstrap.js"></script>
    <!-- tabletools -->
    <script src="../../../../dist/js/dataTables.tableTools.js"></script>    
    <script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src=" //cdn.datatables.net/plug-ins/1.10.15/dataRender/datetime.js"></script>
   

</head>



<jsp:include page="/WEB-INF/view/common/include/Top.jsp" />

<decorator:body />

<jsp:include page="/WEB-INF/view/common/include/Footer.jsp" />
