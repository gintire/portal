<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>M빵!!!!</title>
<script>
$(document).ready(function($) {
    $(document).ready(function() {
		$('#totAmount').on("change", function() {
			  $.calc();
		});
    })
});
</script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<!-- /.row -->
   <div class="row">
       <div class="col-lg-12">
           <!-- Bar Chart -->
           <div class="panel panel-default">
               <div class="panel-heading">
                   <i class="fa fa-table fa-fw"></i> M빵!!!!
               </div>
               <!-- /.panel-heading -->
               <div class="panel-body">
                   <div class="row">
                       <div class="col-lg-12">
                           <div class="table-responsive">
                           		<input type="number" value=0 id="totAmount"/>
                           		<table id="dividedM">
	                           		<tr>
		                           		<th>누가?</th>
		                           		<th>비율?</th>
	                           			<th>얼마?</th>
	                           		</tr>
	                           		<tr>
	                           			<td>CTO님</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P0" type="text" class="form-control text-center" value="1" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M0></td>
	                           		</tr>
	                           		<tr>
	                           			<td>팀장님</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P1" type="text" class="form-control text-center" value="0" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M1></td>
	                           		</tr>
	                           		<tr>
	                           			<td>김강보수석님</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P2" type="text" class="form-control text-center" value="0" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M2></td>
	                           		</tr>
	                           		<tr>
	                           			<td>전상수부장님</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P3" type="text" class="form-control text-center" value="0" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M3></td>
	                           		</tr>
	                           		<tr>
	                           			<td>이도엽책임님</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P4" type="text" class="form-control text-center" value="0" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M4></td>
	                           		</tr>
	                           		<tr>
	                           			<td>이동민책임님</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P5" type="text" class="form-control text-center" value="0" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M5></td>
	                           		</tr>
	                           		<tr>
	                           			<td>진문원선임님</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P6" type="text" class="form-control text-center" value="0" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M6></td>
	                           		</tr>
	                           		<tr>
	                           			<td>배지현연구원</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P7" type="text" class="form-control text-center" value="0" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M7></td>
	                           		</tr>
	                           		<tr>
	                           			<td>임진욱연구원</td>
	                           			<td>
	                           				<div class="input-group number-spinner">
												<span class="input-group-btn data-dwn">
													<button class="btn btn-default btn-info" data-dir="dwn"><span class="glyphicon glyphicon-minus"></span></button>
												</span>
												<input id= "P8" type="text" class="form-control text-center" value="0" min="-10" max="40">
												<span class="input-group-btn data-up">
													<button class="btn btn-default btn-info" data-dir="up"><span class="glyphicon glyphicon-plus"></span></button>
												</span>
											</div>
	                           			</td>
	                           			<td id=M8></td>
	                           		</tr>
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
</body>
</html>