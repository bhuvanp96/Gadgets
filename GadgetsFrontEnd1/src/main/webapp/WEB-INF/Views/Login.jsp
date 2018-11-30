<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<fieldset>
<legend><B><h1> Login Form </h1></B></legend>

<c:url value="/j_spring_security_check" var="login"/>
    <form:form action="${login}" method="post">
     User Name:
  &nbsp<input type="text"  name="j_username" >
  
  <br><br>
  
  Password :
  &nbsp&nbsp&nbsp<input type="text" name="j_password">
  <br><br><br>

  <input type="submit" value="LOGIN">
  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="reset" value="CANCEL">




</form:form>




</fieldset>
<%@ include file="footer.jsp" %>
</html>
