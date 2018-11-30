<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <html>
<head>
<title>Cart </title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid black;
}


.button {
    border: none;
    color: Black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    margin: 4px 2px;
    cursor: pointer;
}
.button1 {font-size: 16px;
          padding: 12px 28px;}

.center {
    margin: auto;
    width: 50%;
    padding: 15px;
}

</style>



<body>

<h1>CART ITEMS</h1>

<table>
  <tr>
  <td><h2>Product Image</h2></td>
    <td><h2>Product ID</h2></td>
    <td><h2>Name</h2></td>
    <td><h2>Price</h2></td>
    <td><h2></h2></td>
    <td><h2></h2></td>       
  </tr>
  <c1:forEach items="${cartItem}" var="prod">
  <tr>
      <td><a href="#" class="at-in"><img src="<c:url value="/resources/images/${prod.getProduct().getProductId()}.jpg"/>" class="img-responsive" alt=""></a>
     
        <td>${prod.getProduct().getProductName()}</td>
       
     
      <td>&#x20b9;${prod.getProduct().getProductPrice()}</td>
      <div class="clearfix"> </div></td>
      <td class="check"><input type="text"  pattern="^[0-9]" ></td>    
<%--       <td>${prod.getProduct().getSubCategory().getSubcatName()}</td> --%>
     <td><a href="<c:url value="/Remove/${prod.getCartitem_Id()}"/>">remove</a>
     <a href="<c:url value="/Buy/${prod.getProduct().getProductId()}/${prod.getCartitem_Id()}"/>">/buy</td>
      </tr>
       </c1:forEach> 
 
</table>
<div class="center">
<button class="button button1">Buy All</button>
 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
<button class="button button1">Remove ALL</button>
</div>


</body>

</html>