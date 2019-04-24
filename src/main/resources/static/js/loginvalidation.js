$(document).ready(

    
    function() {
    
        
        var emailok;
	    var passwordok;
        $("#email").keyup(function() {
        var email = $(this).val();
        if (isEmail($.trim(email))) {
            $(this).css({
                "border-color" : "black",
                "box-shadow" : "1px",
                "-webkit-box-shadow" : "none"
            });
            emailok = true;
            if (emailok && passwordok) {
                $("#loginsubmit").removeAttr("disabled");
                $("#loginsubmit").css({
                    "background-color" : "#007bff"
                });
            } else {
                $("#loginsubmit").attr("disabled", "disabled");
            }
        } else {
            $(this).css({
                "border-color" : "red",
                "box-shadow" : "2px",
                "-webkit-box-shadow" : "none"
            })
            emailok = false;
            $("#loginsubmit").attr("disabled", "disabled");
        }

    });
    $("#password").keyup(function() {
        var password = $(this).val();
        if (isPassword(password)) {
            $(this).css({
                "border-color" : "black",
                "box-shadow" : "1px",
                "-webkit-box-shadow" : "none"
            });
            passwordok = true;
            if (emailok && passwordok) {
                $("#loginsubmit").removeAttr("disabled");
                $("#loginsubmit").css({
                    "background-color" : "#007bff"
                });

            } else {
                $("#loginsubmit").attr("disabled", "disabled");
            }

        } else {
            $(this).css({
                "border-color" : "red",
                "box-shadow" : "2px",
                "-webkit-box-shadow" : "none"
            })
            passwordok = false;
            $("#loginsubmit").attr("disabled", "disabled");
        }

    });
});


function isPassword(password) {
	var pass = password;

	if (pass.length > 4) {
		return true;
	} else {
		return false
	}
}


function isEmail(email) {
	var regex = /^([a-z A-Z 0-9 \.\-_])+\@(([a-z [a-z A-Z 0-9 ]+)\.)+([a-z [a-z A-Z 0-9 ]{1,9})$/;
	if (regex.test(email)) {
		return true;
	} else {
		return false
	}
}