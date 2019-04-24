<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="resources/download.png">
<meta charset="UTF-8">
<!--CSS-->

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="jquery/jquery-ui.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">
<link rel="stylesheet" href="datatables/datatables.css">
<link rel="stylesheet" href="css/c3.css">

<link rel="stylesheet" href="css/mydatatables.css">
<link rel="stylesheet" href="css/home.css">
<title>Title of the document</title>
</head>

<body>



	<span id="widget">
		<nav class="navbar navbar-expand-sm navbar-dark"
			style="background-color: #ed562d;">

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><img src="images/logo.png"
						alt="" height="30px"></li>


				</ul>
				<ul class="navbar-nav ml-auto">

					<li class="dropdown nav-link"><a href="#"
						data-toggle="dropdown"><img id="downloadimg"
							src="images/download.png" height="25px" width="25px"></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li class="dropdown-item" data-toggle="modal"
								data-target="#myModal" id="pdfli"><a href="#" id="PDF">PDF</a></li>
							<div class="dropdown-divider"></div>
							<li class="dropdown-item" data-toggle="modal"
								data-target="#myModal" id="xlsxli"><a href="#" id="XLSX">XLSX</a></li>
							<div class="dropdown-divider"></div>
							<li class="dropdown-item" data-toggle="modal"
								data-target="#myModal" id="csvli"><a href="#" id="CSV">CSV</a></li>
						</ul></li>
					<li class="nav-link"><img src="images/cam.png"
						class="camimg" onclick="generateScreenshot()" height="30px"
						width="30px"></li>
					<li class="nav-link"><input type="button"
						class="btn btn-outline-light btn-sm" id="SwitchD"
						value="Show Table" /></li>
						<li class="nav-link"><a href="chpwdform"
						class="btn btn-outline-light btn-sm">Change password</a>
					<li class="nav-link"><a href="logout"
						class="btn btn-outline-light btn-sm">Logout</a>
						<form id="logoutForm" method="POST" action="logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form></li>
				</ul>

			</div>
		</nav> <!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<img src="images/user.png" height="40px" width="40px"><br>
						<h6 class="modal-title">${email}</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						What you want to do.... <input type="hidden" value=""
							id="filetype">
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<a id="downloadlink"><button type="button"
								class="btn btn-secondary" id="downloadbtn">Download</button></a>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" id="emailbtn">Send Email</button>
					</div>

				</div>
			</div>
		</div>






		<div class="container" id="containerchart">
			<div class="row">
				<div class="col">
					<div id="lineChart"></div>
				</div>
				<div class="col">
					<div id="barChart"></div>
				</div>
				<div class="w-100"></div>
				<div class="col">
					<div id="pieChart"></div>
				</div>
				<div class="col">
					<div id="donutChart"></div>
				</div>
			</div>
		</div>


		<table id="example" class="table table-striped table-bordered"
			style="width: 95%; background-color: white; display: none;"
			id="tabledata">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Office</th>
					<th>position</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Office</th>
					<th>position</th>
					<th>Salary</th>
				</tr>
			</tfoot>
		</table>


	</span>

	<script src="jquery/jquery-3.3.1.min.js"></script>
	<script src="jquery/jquery-ui.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="jquery/popper.min.js"></script>
	<script src="datatables/datatables.js"></script>
	<script src="js/d3.js"></script>
	<script src="js/c3.js"></script>
	<script src="js/html2canvas.js"></script>

	<script src="js/home.js"></script>

</body>
</html>
