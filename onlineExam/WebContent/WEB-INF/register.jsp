<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Registration Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>

$(document).ready(function(){
        var selected = $(".registerForm option:selected").val();
        if(selected=='Company'){
		 $("#name").text("Company Owner Name");
		$("#companyOrCollegeName").text("Company Name");
		 }
		 else
		 {
		  $("#name").text("Student Name");
		 $("#companyOrCollegeName").text("College Name ");
		 }
    });


$(document).ready(function(){
    $("select.registerForm").change(function(){
        var selected = $(".registerForm option:selected").val();
		   if(selected=='Company'){
		 $("#name").text("Company Owner Name");
		$("#companyOrCollegeName").text("Company Name");
		 }
		 else
		 {
		  $("#name").text("Student Name");
		 $("#companyOrCollegeName").text("College Name ");
		 }
    });
});
</script>
<style type="text/css">
#form{

  min-height: 600px;
  padding: 5px 40px 40px 40px;
}

.registration{
   font-size: 45px;
   font-family: Agency FB;
   font-weight: 500;
   border-bottom-style: ridge;
}

.text{
height: 43px;
}
.selectClass{
width:80px;
}
label {
	font-size: 18px;
	
}
.btn-primary{
border-radius: 0px;
padding: 10px;
width: 48%;
}
.btn-danger{
border-radius: 0px;
padding: 10px;
width: 48%;
}

</style>
</head>
<body>

<div class="container">
<div class="row">
<div class="col-md-6 col-md-offset-3" id="form">
     <center><b class="registration">ONLINE EXAM</b>
</center>
<form>
<div class="form-group ">
<label>Register As : </label>
<select class="from-control registerForm" name="registerType">
<option>Company</option>
<option>Student</option>
</select>
</div>
<div class="form-group">
<label id="companyOrCollegeName"></label>
<input type="text" name="name" class="form-control text" placeholder="enter name" >
</div>
<div class="form-group">
<label id="name"></label>
<input type="text" name="name" class="form-control text" placeholder="enter user name " >
</div>
<div class="form-group">
<label>Email</label>
<input type="email" name="email" class="form-control text" placeholder="enter email id" >
</div>
<div class="form-group">
<label>Password</label>
<input type="password" name="pass" class="form-control text" placeholder="enter password" >
</div>
<div class="form-group">
<label>Confirm Password</label>
<input type="password" name="pass" class="form-control text" placeholder="enter confirm password" >
</div>
<div class="form-group">
<label>Address</label>
<textarea class="form-control" rows="6" placeholder="enter full address"></textarea>
</div>
<div class="form-group">
<input type="submit" class="btn btn-primary" value="submit"></div>
<div class="form-group">
<input type="reset" class="btn btn-danger" value="reset"></div>

</form>
</div>
</div>
</div>
</body>
</html>