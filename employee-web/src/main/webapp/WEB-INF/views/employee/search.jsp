
<h2>Search Screen</h2>
<form:form action="${pageContext.request.contextPath}/employee/register">
	<button type="submit">Register</button>
</form:form>

<%-- <div id="todoList">
	<ul>
		<!-- (3) -->
		<c:forEach items="${employees}" var="employee">
			<li>
                            ${f:h(employee.employeeName)}
		</li>
		</c:forEach>
	</ul>
</div> --%>
<table>
	<tr>
		<th>Employee Id</th>
		<th>Name</th>
		<th>Join Date</th>
		<th>Department</th>
		<th>Position</th>
		<th>Email</th>
		<th>Ph No.</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${employees}" var="employee" varStatus="status">
		<tr>
			<td>${employee.employeeId}</td>
			<td>${employee.employeeName}</td>
			<td><fmt:formatDate value="${employee.joinDate}"
						pattern="MM/dd/yyyy" /></td>
			<td>${employee.departmentName}</td>
			<td>${employee.positionName}</td>
			<td>${employee.email}</td>
			<td>${employee.phone}</td>
			<td>............</td>
		</tr>
	</c:forEach>
</table>