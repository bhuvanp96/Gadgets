<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<html>



<!--  <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-hidden="true">  -->
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Register</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<c:url value="/addproduct" var="prod"/>
                        <form:form action="${prod}" method="post" commandName="Product" enctype="Multipart/form-data">
						
					
						<div class="form-group">
						
						
							<label class="col-form-label">Product ID</label>
							<form:input type="text" class="form-control" placeholder=" " name="Name" required="" path="ProductId"/>
						
						</div>
						<div class="form-group">
							<label class="col-form-label">Product Name</label>
							<form:input type="text" class="form-control" placeholder=" " name="Email" required="" path="ProductName"/>
						
						</div>
						<div class="form-group">
							<label class="col-form-label">Price</label>
							<form:input type="text" class="form-control" placeholder=" " name="Password" id="password1" required="" path="ProductPrice"/>
					
						</div>
						<div class="form-group">
							<label class="col-form-label">Quantity</label>
							<form:input type="text" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="" path="ProductQuantity"/>
						
						</div>
						
						
						<div class="form-group">
							<label class="col-form-label">Description</label>
							<form:input type="text" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="" path="ProductDescription"/>
						
						</div>
						
						<div class="form-group">
							<label class="col-form-label">Upload Prod Image</label>
							<form:input type="file" class="form-control" placeholder=" " value="Upload file" path="pimg"/>
						
						</div>
						
						
						<div class="right-w3l">
							<input type="submit" class="form-control" value="Submit">
						</div>
						
							</form:form>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	







<table>
<tr>
<th>product image</th>
<th>product id</th>
<th>procut name</th>
<th>price</th>
<th>quantity</th>
<th>description</th>
<th>Actions</th>
</tr>
<c1:forEach items="${Products}" var="prod">
<tr>
<td><img src="${img}/${prod.getProductId()}.jpg" width="250" height="250" ></td>
<td>${prod.getProductId()}</td>
<td>${prod.getProductName()}</td>
<td>${prod.getProductPrice()}</td>
<td>${prod.getProductQuantity()}</td>
<td>${prod.getProductDescription()}</td>

<td><a href="<c:url value="/editproduct/${prod.getProductId()}"/>">Edit</a>/
<a href="<c:url value="/deleteproduct/${prod.getProductId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>
</html>





<%@ include file="footer.jsp" %>

</html>
