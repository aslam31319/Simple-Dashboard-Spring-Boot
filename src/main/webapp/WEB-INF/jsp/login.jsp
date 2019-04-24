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
<link rel="stylesheet" href="css/loginpage.css">
<title>Title of the document</title>
</head>

<body>



<div class="container h-100">
<div class="d-flex justify-content-center h-100">
<div class="user_card">
<div class="d-flex justify-content-center">
    <div class="brand_logo_container"><a href="home">
        <img src="images/formlogo.png" class="brand_logo" alt="Logo"></a>
    </div>
</div>
<div class="d-flex justify-content-center form_container">
    <form action="/login" method="POST" id="logform">
        <div class="input-group mb-3">
            <div class="input-group-append">
                <span class="input-group-text"><i class="fas fa-at"></i></span>
            </div>
            <input type="text" name="email" id="email" class="form-control input_user" value="" placeholder="Email id">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
        <div class="input-group mb-2">
            <div class="input-group-append">
                <span class="input-group-text"><i class="fas fa-key"></i></span>
            </div>
            <input type="password" name="password" id="password" class="form-control input_pass" value="" placeholder="password">
        </div>
        <div class="form-group">
            <div class="custom-control custom-checkbox">
                
            </div>
        </div>
    
</div>
<div class="d-flex justify-content-center mt-3 login_container">
    <input type="submit" name="button" id="loginsubmit" class="btn login_btn" id="loginsubmit" value="Login" disabled/>
</div>
</form>    
<div class="mt-4">
    
    <div class="d-flex justify-content-center links">
        <label style="color: red">${result}</label>
    </div>
    <div class="d-flex justify-content-center links">
        Don't have an account? <a href="regp" class="ml-2">Sign Up</a>
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
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary" form="forgot">Recover</button>
        </div>
      </div>
    </div>
  </div>



<!--JavaScript-->

<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="jquery/jquery-ui.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery/popper.min.js"></script>

<script src="js/loginvalidation.js"></script>

</body>

</html>