<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Save Customers</title>
	

	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship manager</h2>
		</div>
		<div id ="container">
			<h3>Save Customer</h3>
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
				<!-- need associate this data with customer id -->
				<form:hidden path="id"/>	
				<table>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="first_name" /></td>
					</tr><tr>
						<td><label>Last name:</label></td>
						<td><form:input path="last_name" /></td>
					</tr><tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr><tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>		
				</table>
			</form:form>
			<div style="clear; both">
			
			</div>
			
			<p><a href="${pageContext.request.contextPath}/customer/list">Back to the list</a></p>
			
		</div>
	</div>
</body>
</html>