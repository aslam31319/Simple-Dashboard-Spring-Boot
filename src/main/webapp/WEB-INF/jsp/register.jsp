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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link rel="stylesheet" href="css/regpage.css">
<title>Register</title>
</head>

<body>



<div class="container h-100">
<div class="d-flex justify-content-center h-100">
<div class="user_card">
<div class="d-flex justify-content-center">
    <div class="brand_logo_container"><a href="home">
        <img src="images/formlogo.png" class="brand_logo" alt="Logo" ></a>
    </div>
</div>
<div class="d-flex justify-content-center form_container">
<form action="register" method="POST" id="regform">
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



<!--forgot password model-->

<div class="modal fade" id="forgotModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">Recover password</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form action="forgot" method="POST" id="forgot">

            <div class="input-group mb-3">
                <div class="input-group-append">
                    <span class="input-group-text"><i class="fas fa-at"></i></span>
                </div>
                <input type="text" name="recemail" id="recemail" class="form-control input_user" value="" placeholder="Email id">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary" form="forgot" value="Submit">Recover</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          
        </div>
      </div>
    </div>
  </div>


<!--JavaScript-->

<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="jquery/jquery-ui.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery/popper.min.js"></script>

<script src="js/registervalidation.js"></script>

</body>

</html>