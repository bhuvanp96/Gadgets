<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<fieldset>
<legend><I><h1> REGISTRATION FORM </h1></I></legend>

<c:url value="/adduser" var="cat"/>
<form:form action="${cat}" method="post" commandName="user">  
    USER ID :  </label>
    &nbsp &nbsp &nbsp&nbsp&nbsp  <form:input type="text" name="UserId" Placeholder=" 101 " path="UserId"/>
    
<br>
<br>

    Name : </label>
    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <form:input type="text" name="User" Placeholder=" 101 " path="UserName"/>
    
  
<br>
<br>  

    Email-ID: </label>
    &nbsp &nbsp&nbsp&nbsp &nbsp&nbsp <form:input type="Email" name="UserId" Placeholder=" 101 " path="UserEmailId"/>
    

<br>
<br>  

    Phone No: </label>
    &nbsp &nbsp&nbsp&nbsp &nbsp <form:input type="Number" name="UserId" Placeholder="101" path="UserPhno"/>
    
<br>
<br>  

    Address: </label>
    &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp <form:input type="text" name="UserId" Placeholder="101" path="UserAddress"/>
    
  
<br>
<br>

    Password : </label>
    &nbsp&nbsp &nbsp &nbsp&nbsp <form:input type="password" id="name" name="Password" path="UserPassword"/>

<br>
<br>
<br>

 <input type="submit" value="REGISTER">
   &nbsp &nbsp &nbsp &nbsp &nbsp<input type="reset" value="CANCEL">

</form:form>

</fieldset>
<%@ include file="footer.jsp" %>
</html>

