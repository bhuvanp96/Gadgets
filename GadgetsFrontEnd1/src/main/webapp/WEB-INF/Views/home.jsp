<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TechGadgets</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
       <c1:if test="${pageContext.request.userPrincipal.name!=null}">
        <security:authorize access="hasRole('ROLE_ADMIN')">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin <span class="caret"></span></a>
        <ul class="dropdown-menu">
        
       
          <li><a href='<c:url value="/Category"/>'>Category</a></li>
          <li><a href='<c:url value="/Product"/>'>Product</a></li>
          <li><a href='<c:url value="/Supplier"/>'>Supplier</a></li>
          </ul></li>
          </security:authorize>
          </c1:if>
<c1:if test="${pageContext.request.userPrincipal.name!=null}">
<li><a href="<c:url value="/logout"/>">Logout</a></li>
</c1:if>

      
<li><a href='<c:url value="/User"/>'>Sign-up</a></li>

<c1:if test="${pageContext.request.userPrincipal.name==null}">
<li><a href='<c:url value="/Login"/>'>Login</a></li>
</c1:if>
     
      <c1:if test="${pageContext.request.userPrincipal.name!=null}">
      Welcome!!!
      ${pageContext.request.userPrincipal.name}
      </c1:if>

  </div>
</nav>
  
<div class="container">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu for the "Page 1" button in the navigation bar.</p>
</div>

</body>
</html>
