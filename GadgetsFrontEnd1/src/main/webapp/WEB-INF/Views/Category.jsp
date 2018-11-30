<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<html>

<!-- <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-hidden="true"> -->
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Category FORM</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					
					<c:url value="/addcategory" var="cat"/>
							<form:form action="${cat}" method="post" commandName="category"><div class="form-group">
						
							<label class="col-form-label">Category Id</label>
							<form:input type="text" class="form-control" placeholder=" " name="Name" required="" path="CategoryId"/>
			
						</div>
						<div class="form-group">
							<label class="col-form-label">Category Name</label>
							<form:input type="text" class="form-control" placeholder=" " name="Email" required="" path="CategoryName"/>
						
						</div>
						<input type="submit" value="Submit">
						<input type="reset" value="cancel">
					</form:form>
				</div>
			</div>
		</div>
	</div>
	
	

<table>
<tr>
<th>category id</th>
<th>category name</th>
<th>Actions</th>
</tr>
<c1:forEach items="${categories}" var="cat">
<tr>
<td>${cat.getCategoryId()}</td>
<td>${cat.getCategoryName()}</td>
<td><a href="<c:url value="/editcategory/${cat.getCategoryId()}"/>">Edit</a>/
<a href="<c:url value="/deletecategory/${cat.getCategoryId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>
<%@ include file="footer.jsp" %>
</html>
