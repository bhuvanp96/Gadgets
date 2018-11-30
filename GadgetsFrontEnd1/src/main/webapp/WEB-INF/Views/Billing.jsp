<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    font-family: Arial;
    color: white;
}

.split {
    height: 100%;
    width: 50%;
    position: fixed;
    z-index: 1;
    top: 0;
    overflow-x: hidden;
    padding-top: 20px;
}

.left {
    left: 0;
    background-color: black;
}

.right {
    right: 0;
    background-color: black;
}

.centered {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
}

.centered img {
    width: 150px;
    border-radius: 50%;
}
</style>
</head>
<body>

<div class="span11">

	<div class="col-md-12  col-sm-12  col-xs-8 "
	style="background: #fff; padding: 30px;">

	<div class="col-md-6 col-sm-6 col-xs-12">
		<h3 class="text-center">Billing Address</h3>

		<hr>
			<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" path="user.UserEmailId" name="email" class="form-control input-sm"					
				placeholder="Emailid" disabled="true"/> 
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="number" name="mono" path="user.UserPhno" disabled="true"
			class="form-control input-sm" placeholder="Mobile no"/>
			</div>
		</div>
		

		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="form-group">
				<form:input class="form-control" path="billing.BillingAddress" disabled="true"
					placeholder="House name and number"/>                                                
                                            
			</div>
		</div>

				<input class="coupon_question" type="checkbox" name="coupon_question"
			value="1"> <span class="item-text">Check Shipping
			address</span>
	</div>


	<div class="col-md-6 shipping col-sm-6 col-xs-12">
		<h3 class="text-center">shipping Address</h3>

		<hr>
	<c:url value="/orderConfirm" var="a"/>
		<form:form action="${a}" method="post" commandName="shippingAddress">
		
	
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name"
					class="form-control input-sm" placeholder="First Name" path="address"/>
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="last_name" id="last_name"
					class="form-control input-sm" placeholder="Last Name" path="city"/>
			</div>
		</div>

		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name"
					class="form-control input-sm" placeholder="Email id" path="state"/>
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="Mobile_no" 
					class="form-control input-sm" placeholder="Mobile no" path="country"/>
			</div>
		</div>

		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="form-group">
				<form:input type="text" class="form-control" path="pincode"/>                                                
                                           
			</div>
		</div>

		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text"
					class="form-control input-sm" placeholder="country" path="phone"/>
			</div>
		</div>
		
	</div>
	<div class="col-md-12">
		<input type="submit" class="btn btn-primary pull-right" value="Continue">
	</div>
   </form:form>
</div>
</div></div>
     
</body>
</html>