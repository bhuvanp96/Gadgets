         <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>



<html>
<!-- <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-hidden="true"> -->
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Register</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<c:url value="/addsupplier" var="sup"/>
<form:form action="${sup}" method="post" commandName="Supplier">
						
					
						<div class="form-group">
				
						
							<label class="col-form-label">Supplier ID</label>
							<form:input type="text" class="form-control" placeholder=" " name="Name" required="" path="SupplierId"/>
						
						</div>
						<div class="form-group">
							<label class="col-form-label">Supplier Name</label>
							<form:input type="text" class="form-control" placeholder=" " name="Email" required="" path="SupplierName"/>
						
						</div>
						<div class="form-group">
							<label class="col-form-label">Address</label>
							<form:input type="text" class="form-control" placeholder=" " name="Password" id="password1" required="" path="SupplierAddress"/>
						
						</div>
						<div class="form-group">
							<label class="col-form-label">Ph no </label>
							<form:input type="tel" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="" path="SupplierPhno"/>
					
						</div>
						
						<div class="form-group">
							<label class="col-form-label">Email Id</label>
							<form:input type="email" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="" path="SupplierEmailId"/>
						
						</div>
						<div class="form-group">
							<label class="col-form-label">Password</label>
							<form:input type="password" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="" path="SupplierPassword"/>
					
						</div>
						<div class="right-w3l">
							<input type="submit" class="form-control" value="Register">
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
<th>supplier id</th>
<th>suplier name</th>
<th>address</th>
<th>Phno</th>
<th>email id</th>
<th>Password</th>
<th>Actions</th>
</tr>
<c1:forEach items="${Suppliers}" var="sup">
<tr>
<td>${sup.getSupplierId()}</td>
<td>${sup.getSupplierName()}</td>
<td>${sup.getSupplierAddress()}</td>
<td>${sup.getSupplierPhno()}</td>
<td>${sup.getSupplierEmailId()}</td>
<td>${sup.getSupplierPassword()}</td>

<td><a href="<c:url value="/editsupplier/${sup.getSupplierId()}"/>">Edit</a>/
<a href="<c:url value="/deletesupplier/${sup.getSupplierId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>

<%@ include file="footer.jsp" %>
</html>







