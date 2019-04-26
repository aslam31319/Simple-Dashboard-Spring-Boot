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
<link rel="stylesheet" href="css/main.css">
<title>Admin page</title>
</head>

<body>


    <nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #ed562d;">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><img src="resources/logo.png"
					alt="" height="30px" ></li>


			</ul>
			<ul class="navbar-nav ml-auto">

				<li class="nav-item " ><a class="nav-link" href="admin/removeUser" id="register">Remove User</a></li>
				<li class="nav-item " ><a class="nav-link" href="logout" id="register">Logout</a></li>

			</ul>

		</div>
	</nav>


<div class="container h-100">
<div class="d-flex justify-content-center h-100">
<div class="user_card">
<div class="d-flex justify-content-center">
    <div class="brand_logo_container"><a href="home">
        <img src="resources/formlogo.png" class="brand_logo" alt="Logo" ></a>
    </div>
</div>
<div class="d-flex justify-content-center form_container">
<form action="admin/addAdmin" method="POST" id="regform">
    <div class="input-group mb-2">
        <div class="input-group-append">
            <span class="input-group-text"><i class="fas fa-user"></i></span>
        </div>
        <input type="text" name="firstName"
        id="firstName" class="form-control input_user" value="" placeholder="firstname">
        <div class="input-group-append">
                <span class="input-group-text"><i class="fas fa-user"></i></span>
            </div>
            <input type="text" name="lastName" id="lastName" 
            class="form-control input_user" value="" placeholder="lastname">
    </div>
    
        <div class="input-group mb-2">
                <div class="input-group-append">
                    <span class="input-group-text"><i class="fas fa-phone"></i></span>
                </div>
                <input type="text" name="phone" id="phone" 
                class="form-control input_user" value="" placeholder="Phone" maxlength="10">
                <div class="input-group-append">
                        <span class="input-group-text"><i class="fas fa-at"></i></span>
                    </div>
                    <input type="text" name="email" id="emailreg" class="form-control input_user"  value="" placeholder="Email">
            </div>
            <div class="input-group mb-2">
                    <div class="input-group-append">
                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                    </div>
                    <input type="password" name="password" id="passwordreg" 
                    class="form-control input_pass" value="" placeholder="password">
                </div>
            <div class="input-group mb-2">
                    <div class="input-group-append" style="
                    height: 38px;">
                        <span class="input-group-text"><i class="fas fa-calendar-day"></i></span>
                    </div>
                    <input type="text" name="DOB" class="form-control input_user" id="DOB" readonly placeholder="Date of birth">
                    
                    <div class="form-group btn-group btn-group-toggle" style="padding: 5px;margin-bottom: 0px;"
        data-toggle="buttons">

        <label class="btn btn-dark active gender4 btn-sm"> <input
            type="radio" name="gender" value="Male" id="gender1"
            autocomplete="off" checked> Male
        </label> <label class="btn btn-dark gender4 btn-sm"> <input
            type="radio" name="gender" value="Female" id="gender2"
            autocomplete="off"> Female
        </label>
    
    </div>
                </div>
            <div class="input-group mb-2">
                    <div class="input-group-append">
                        <span class="input-group-text"><i class="fas fa-globe"></i></span>
                    </div>
                    <select id="country" name="country" class="form-control input_user" value="" ><option value="Nill">--Country--</option>

                    </select>
                    <div class="input-group-append">
                            <span class="input-group-text"><i class="fas fa-flag"></i></span>
                        </div>
                        <select id="state" name="state" class="form-control input_user" value=""  disabled="disabled"><option value="Nill">--State--</option>

                        </select>
                </div>
                
                <div class="input-group mb-2">
                        <div class="input-group-append">
                            <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                        </div>
                        <select id="city" name="city" class="form-control input_pass" value="" disabled="disabled"><option value="Nill">--City--</option>

                        </select>
                    </div>       
        
        
</form>    
</div>
<div class="d-flex justify-content-center mt-3 login_container">
    <button type="submit" name="btnreg" id="btnreg" class="btn login_btn " form="regform" disabled>Sign Up</button>
</div>

<div class="mt-4">
        <div class="d-flex justify-content-center links">
                <label style="color: red">${result }</label>
            </div>
    <div class="d-flex justify-content-center links">
        Already a member ? <a href="logp" class="ml-2">Login</a>
    </div>
    <div class="d-flex justify-content-center links">
        <a href="#" data-toggle="modal" data-target="#forgotModalCenter">Forgot your password?</a>
    </div>
</div>
</div>
</div>
</div>
    
    



<!--JavaScript-->

<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="jquery/jquery-ui.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery/popper.min.js"></script>

</body>

</html>