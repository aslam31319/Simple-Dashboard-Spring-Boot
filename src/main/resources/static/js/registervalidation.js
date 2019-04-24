$(document).ready(
		function() {
			$("#loginsubmit").attr("disabled");
			$( function() {
			    $( "#DOB" ).datepicker({
			      showOn: "both",
			      changeMonth: true,
			      changeYear: true,
			      buttonImage: "https://img.icons8.com/ios/50/000000/planner.png",
			      buttonImageHeight:"10px",
			      buttonImageOnly: true,
			      dateFormat: 'dd-mm-yy',
			      buttonText: "Select date",
			      maxDate: "-18Y",
			      minDate:"-80Y",
			      yearRange: "1947:2010" 
			    });
			    
			  } );
			
			var emailok;
			var passwordok;
			var firstnameok;
			var secondnameok;
			var genderok = true;
			var phoneok;
			var countryok;
			var stateok;
			var cityok;
			var dobok=true;
			$("#passwordreg")
					.keyup(
							function() {

								var password = $(this).val();
								if (isPassword(password)) {
									$(this).css({
										"border-color" : "green",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									passwordok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}

								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									passwordok = false;
									$("#btnreg").attr("disabled", "disabled");
								}
							});

			$("#firstName")
					.keyup(
							function() {

								var password = $(this).val();
								if (isPassword(password)) {
									$(this).css({
										"border-color" : "green",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									firstnameok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}

								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									firstnameok = false;
									$("#btnreg").attr("disabled", "disabled");
								}
							});

			$("#lastName")
					.keyup(
							function() {

								var password = $(this).val();
								if (isPassword(password)) {
									$(this).css({
										"border-color" : "green",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									secondnameok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}

								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									secondnameok = false;
									$("#btnreg").attr("disabled", "disabled");
								}
							});

			$("#phone").keypress(
					function(e) {
						if (e.which != 8 && e.which != 0
								&& (e.which < 48 || e.which > 57)) {
							// display error message

							return false;
						} else {
							var phone = $(this).val();
							if (isPhone(phone)) {
								$(this).css({
									"border-color" : "green",
									"border-width":"1px"
									
								})
								phoneok = true;
								if (passwordok && emailok && firstnameok
										&& secondnameok && genderok && phoneok
										&& countryok && stateok && cityok
										&& dobok) {
									$("#btnreg").removeAttr("disabled");
									$("#btnreg").css({
										"background-color" : "#007bff"
									});
								} else {
									$("#btnreg").attr("disabled", "disabled");
								}

							} else {
								$(this).css({
									"border-style": "solid",	
									"border-color" : "red",
									"border-width":"1px"
									
																		
								})
								phoneok = false;
								$("#btnreg").attr("disabled", "disabled");
							}
						}
					});
			/*$("#DOB")
					.keyup(
							function() {

								var dob = $(this).val();
								if (isPassword(dob)) {
									$(this).css({
										"border-color" : "green",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									dobok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}

								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									dobok = false;
									$("#btnreg").attr("disabled", "disabled");
								}
							});*/

			$("#emailreg")
					.keyup(
							function() {
								var email = $(this).val();
								if (isEmail($.trim(email))) {
									$(this).css({
										"border-color" : "green",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									emailok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}
								} else {
									$(this).css({
										"border-color" : "red",
										"box-shadow" : "1px",
										"-webkit-box-shadow" : "none"
									})
									emailok = false;
									$("#btnreg").attr("disabled", "disabled");
								}

							});

			
			
			$("#emailforg").keyup(function() {
				var email = $(this).val();
				if (isEmail($.trim(email))) {
					$(this).css({
						"border-color" : "green",
						"box-shadow" : "1px",
						"-webkit-box-shadow" : "none"
					});
					emailok = true;
					if (emailok) {
						$("#forgotsubmit").removeAttr("disabled");
						$("#forgotsubmit").css({
							"background-color" : "#007bff"
						});
					} else {
						$("#forgotsubmit").attr("disabled", "disabled");
					}
				} else {
					$(this).css({
						"border-color" : "red",
						"box-shadow" : "1px",
						"-webkit-box-shadow" : "none"
					})
					emailok = false;
					$("#forgotsubmit").attr("disabled", "disabled");
				}

			});
			
			
			$("#email").keyup(function() {
				var email = $(this).val();
				if (isEmail($.trim(email))) {
					$(this).css({
						"border-color" : "green",
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
						"box-shadow" : "1px",
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
						"border-color" : "green",
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
						"box-shadow" : "1px",
						"-webkit-box-shadow" : "none"
					})
					passwordok = false;
					$("#loginsubmit").attr("disabled", "disabled");
				}

			});
			// Adding Country Using ajax call
			$.ajax({
				url : "api/place",
				type : "GET",
				success : function(data) {
					$.each(data, function(index, value1) {
						$('#country').append($('<option>', {
							value : value1,
							text : value1
						}));
					});
				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert(xhr.status);
					alert(thrownError);
				}

			});

			// Adding State to option
			$("#country")
					.change(
							function() {

								$('#state').empty().append($('<option>', {
									value : 'Nil',
									text : '--State--'
								}));
								$("#state").removeAttr("disabled");
								
								$('#city').empty().append($('<option>', {
									value : 'Nil',
									text : '--City--'
								}));
								$("#city").attr("disabled", "disabled");
								var ur = "api/place/" + $("#country").val();
								$.ajax({
									url : ur,
									type : "GET",
									success : function(data) {
										$.each(data, function(index, value1) {
											$('#state').append($('<option>', {
												value : value1,
												text : value1
											}));
										});
									}

								});
								if ($(this).val() == "Nil") {
									$("#btnreg").attr("disabled", "disabled");
									countryok = false;
								} else {
									countryok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}
								}

							});

			// Adding City to option
			$("#state")
					.change(
							function() {

								$('#city').empty().append($('<option>', {
									value : 'Nil',
									text : '--City--'
								}));
								$("#city").removeAttr("disabled");

								$.ajax({
									url : "api/place/" + $("#country").val() + "/"
											+ $("#state").val(),
									type : "GET",
									success : function(data) {
										$.each(data, function(index, value1) {
											$('#city').append($('<option>', {
												value : value1,
												text : value1
											}));
										});
									}

								});
								if ($(this).val() == "Nil") {
									$("#btnreg").attr("disabled", "disabled");
									stateok = false;

								} else {

									stateok = true;
									if (passwordok && emailok && firstnameok
											&& secondnameok && genderok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}
								}
							});

			$("#login").click(function() {
				
				$("#raw1").hide();
				$("#forgotPass").hide();
				$("#rew1").show();
				$("#lognavli").addClass("active");
				$("#regnavli").removeClass("active");
			});
			$("#register").click(function() {
				
				$("#rew1").hide();
				$("#forgotPass").hide();
				$("#raw1").show();
				$("#regnavli").addClass("active");
				$("#lognavli").removeClass("active");
			});
			$("#forgot").click(function() {
				$("#raw1").hide();
				$("#rew1").hide();
				$("#forgotPass").show();
				$("#regnavli").addClass("active");
				$("#lognavli").removeClass("active");
			});

			$("#city")
					.change(
							function() {
								if ($(this).val() == "Nil") {
									$("#btnreg").attr("disabled", "disabled");
									cityok = false;
								} else {
									cityok = true;

									if (passwordok && emailok && firstnameok
											&& genderok && secondnameok
											&& phoneok && countryok && stateok
											&& cityok && dobok) {
										$("#btnreg").removeAttr("disabled");
										$("#btnreg").css({
											"background-color" : "#007bff"
										});
									} else {
										$("#btnreg").attr("disabled",
												"disabled");
									}
								}
							});
		});

function ok(st) {
	if (st == 1) {

	} else {

	}

}
function isPassword(password) {
	var pass = password;

	if (pass.length > 4) {
		return true;
	} else {
		return false
	}
}

function isPhone(phone) {
	var regex = /^([0-9]){9}$/;
	if (regex.test(phone)) {
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
