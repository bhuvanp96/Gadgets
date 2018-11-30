<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <html>
<head>
<title>Order Confirmation</title>
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
<div class="center">
<h1>Order Confirmation</h1>
</div>
<div class="center">
<table>
  <tr>
  <td><h2>Product ID</h2></td>
    <td><h2>Product Name</h2></td>
    <td><h2>Price</h2></td>
    
    <td><h2></h2></td>       
  </tr>
 <c1:if test="${prot!=null}">
      <tr>
        <td style="border: 1px solid black"><img src="<c:url value='/resources/images/${prot.getProductId()}.jpg'/>" width="150px" height="200px"></td>
        <td style="border: 1px solid black">${prot.getProductName()}</td>
<%--         <td>${prot.getDes()}</td>  --%>
<%--         <td style="border: 1px solid black">${prot.getCategory().getCategoryName()}</td> --%>
<%--         <td style="border: 1px solid black">${prot.getSupplier().getSupplierName()}</td> --%>
        <td style="border: 1px solid black">${prot.getProductPrice()}</td>
       </tr> 
      </c1:if>
    <c1:if test="${prot==null}">
     <c1:forEach items="${cartItems}" var="c1">
      <tr>
        <td style="border: 1px solid black"><img src="<c:url value='/resources/images/${c1.getProduct().getProductId()}.jpg'/>"></td>
        <td style="border: 1px solid black">${c1.getProduct().getProductName()}</td>
<%--         <td>${c1.getproduct.getDes()}</td> --%>
        <td style="border: 1px solid black">${c1.getProduct().getCategory().getCategoryName()}</td>
        <td style="border: 1px solid black">${c1.getProduct().getSupplier().getSupplierNam()}</td>
        <td style="border: 1px solid black">${c1.getProduct().getProductPrice()}</td>
      </tr>
      </c1:forEach>
      </c1:if>
  
</table>
<br><br>
</div>
<br><br>
<div class="center">
<table>
  <td>
    <td><h2>Billing ID</h2></td>
    <td><h2>Billing Name</h2></td>
    <td><h2>Address</h2></td>
	<td><h2>Ph no</h2></td>
	</td>
	<tr style="align:center">
<th align="center" >${billing.getBillingId()}</th>
<th align="center"> ${billing.getBillingName()}</th>
<th align="center">${billing.getBillingAddress()}</th>
<th align="center">${billing.getBillingPhno()}</th>
</tr>
<%--     <c1:if test="${prot==null}"> --%>
<%--      <c1:forEach items="${cartItems}" var="c1"> --%>
<!--       <tr> -->
<!--         <td style="border: 1px solid black"><img src=""></td> -->
<%--         <td style="border: 1px solid black">${c1.getProduct().getProductName()}</td> --%>
<%-- <%--         <td>${c1.getproduct.getDes()}</td> --%> 
<%--         <td style="border: 1px solid black">${c1.getProduct().getCategory().getCategoryName()}</td> --%>
<%--         <td style="border: 1px solid black">${c1.getProduct().getSupplier().geSupplierName()}</td> --%>
<%--         <td style="border: 1px solid black">${c1.getProduct().getProductPrice()}</td> --%>
<!--       </tr> -->
<%--       </c1:forEach> --%>
<%--       </c1:if> --%>
	</table>
	<br><br>
	</div>
	<br><br>
	<div class="center">
	<table>
  <tr>
  <td><h2>Shipping ID</h2></td>
    <td><h2>Shipping Name</h2></td>
    <td><h2>Shipping Address</h2></td>
    <td><h2>Shipping Phone</h2></td>
    
    </tr>
	<tr style="align:center">
<th align="center" >${shippingAddress.getShipId()}</th>
<th align="center"> ${shippingAddress.getUser().getUserName()}</th>
<th align="center">${shippingAddress.getAddress()}</th>
<th align="center">${shippingAddress.getPhone()}</th>
</tr>
	</table>
	 <br><br>
</div>
<br><br><br><br>
<div class="center">
<button class="button button1">
<a href="<c:url value="/payment"/>">Pay</a></button>
 
</div>


</body>

</html>