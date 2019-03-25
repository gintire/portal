<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.dt-center {text-align: center;}
</style>
<script>
//Plug-in to fetch page data 
jQuery.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
{
  return {
    "iStart":         oSettings._iDisplayStart,
    "iEnd":           oSettings.fnDisplayEnd(),
    "iLength":        oSettings._iDisplayLength,
    "iTotal":         oSettings.fnRecordsTotal(),
    "iFilteredTotal": oSettings.fnRecordsDisplay(),
    "iPage":          oSettings._iDisplayLength === -1 ?
      0 : Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
    "iTotalPages":    oSettings._iDisplayLength === -1 ?
      0 : Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
  };
};
$(document).ready(function($) {
    $(document).ready(function() {
          $('#dataTable').DataTable({
              responsive :  true,
              ordering : false,
              "bAutoWidth": true,
              "serverSide":true,
              "ajax":"dataTable.do",
              "processing":true,
              searching: false,
             /* ,"fnDrawCallback": function () {
                alert("Current page number: "+this.fnPagingInfo().iPage);    
              } */
             "columns":[
                 {"data":"drwNo"},
                 {"data":"drwnodate"},
                 {"data":"drwtNo"},
                 {"data":"bnusNo"},
                 {"data":"firstwinamnt"}
               ],
             "columnDefs": [{
            		    "targets" : 4,
            		    "render": $.fn.dataTable.render.number(',', '.', 2, '')
            	  }, {
                	  "className": "dt-center",
                    "targets": "_all"
                }]
          });
      });
    //Panel All data
    $.ajax({
    	  url: "allDataCount.do",
    	  context: document.body
    	}).done(function(data) {
        	console.log(data);
         $( '#allData' ).text(data);
    	});
    $.getJSON("/bestNums.do",function(json){
        var data = (json[0].num+" "+json[1].num+" "+json[2].num);
        $('#bestNums').text(data)
        $('#theBestNum').text(json[0].num)
        });
    $.getJSON("/worstNums.do",function(json){
    var data = (json[0].num+" "+json[1].num+" "+json[2].num);
    $('#worstNums').text(data)
    });
  });  
</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">로또 당첨 번호 분석</h1>
        </div>
        <!-- /.col-lg-12 -->
   </div>
   <!-- /.row -->
   <div class="row">
       <div class="col-lg-3 col-md-6">
           <div class="panel panel-primary">
               <div class="panel-heading">
                   <div class="row">
                       <div class="col-xs-3">
                           <i class="fa  fa-list-alt fa-5x"></i>
                       </div>
                       <div class="col-xs-9 text-right">
                           <div class="huge"><span id="allData"></span></div>
                           <div>All Data</div>
                       </div>
                   </div>
               </div>
           </div>
       </div>
       <div class="col-lg-3 col-md-6">
           <div class="panel panel-green">
               <div class="panel-heading">
                   <div class="row">
                       <div class="col-xs-3">
                           <i class="fa fa-thumbs-o-up fa-5x"></i>
                       </div>
                       <div class="col-xs-9 text-right">
                           <div class="huge"><span id="bestNums"></span></div>
                           <div>Good Numbers</div>
                       </div>
                   </div>
               </div>
           </div>
       </div>
       <div class="col-lg-3 col-md-6">
           <div class="panel panel-yellow">
               <div class="panel-heading">
                   <div class="row">
                       <div class="col-xs-3">
                           <i class="fa fa-thumbs-o-down fa-5x"></i>
                       </div>
                       <div class="col-xs-9 text-right">
                           <div class="huge"><span id="worstNums"></span></div>
                           <div>Bad Numbers</div>
                       </div>
                   </div>
               </div>
           </div>
       </div>
       <div class="col-lg-3 col-md-6">
           <div class="panel panel-red">
               <div class="panel-heading">
                   <div class="row">
                       <div class="col-xs-3">
                           <i class="fa fa-trophy fa-5x"></i>
                       </div>
                       <div class="col-xs-9 text-right">
                           <div class="huge"><span id="theBestNum"></span></div>
                           <div>Key Number</div>
                       </div>
                   </div>
               </div>
           </div>
       </div>
   </div>
   <!-- /.row -->
   <div class="row">
       <div class="col-lg-12">
           <!-- Bar Chart -->
           <div class="panel panel-default">
               <div class="panel-heading">
                   <i class="fa fa-table fa-fw"></i> 역대 로또 당첨 번호
               </div>
               <!-- /.panel-heading -->
               <div class="panel-body">
                   <div class="row">
                       <div class="col-lg-12">
                           <div class="table-responsive">
                               <table id="dataTable" class="table table-bordered table-hover table-striped" data-page-length='10'>
                                   <thead>
                                       <tr>
                                           <th class = "text-center">회차</th>
                                           <th class = "text-center">날짜</th>
                                           <th class = "text-center">당첨번호</th>
                                           <th class = "text-center">보너스번호</th>
                                           <th class = "text-center">상금</th>
                                       </tr>
                                   </thead>
                                   <tbody>
                                   </tbody>
                               </table>
                           </div>
                           <!-- /.table-responsive -->
                       </div>
                       <!-- /.col-lg-4 (nested) -->
                       <div class="col-lg-8">
                           <div id="morris-bar-chart"></div>
                       </div>
                       <!-- /.col-lg-8 (nested) -->
                   </div>
                   <!-- /.row -->
               </div>
               <!-- /.panel-body -->
           </div>
           <!-- /.panel -->
       </div>
       <!-- /.col-lg-4 -->
   </div>
   <!-- /.row -->
</div>
