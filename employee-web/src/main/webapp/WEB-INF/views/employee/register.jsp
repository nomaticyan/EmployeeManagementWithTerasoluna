<h2>Register Screen</h2>
<div id="employeeForm">
	<t:messagesPanel />

	<form:form
		action="${pageContext.request.contextPath}/employee/create"
		method="post" modelAttribute="employeeForm">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><form:input path="employeeId" /> <form:errors
						path="employeeId" cssClass="text-error" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><form:input path="employeeName" /> <form:errors
						path="employeeName" cssClass="text-error" /></td>
			</tr>
			<tr>
				<td>Birthday (mm/dd/yyyy):</td>
				<td>
					<!-- <input type="date" class="birthdate" name="birthdate"
					value="" /> --> <form:input path="birthdate" /> <form:errors
						path="birthdate" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:radiobutton path="gender" value="M" /> Male <form:radiobutton
						path="gender" value="F" /> Female <form:errors path="gender"
						cssClass="text-error" /></td>
			</tr>
			<tr>
				<td>Marital Status</td>
				<td><form:radiobutton path="maritalStatus" value="S" /> Single
					<form:radiobutton path="maritalStatus" value="M" /> Married <form:errors
						path="maritalStatus" cssClass="text-error" /></td>
			</tr>
			<tr>
				<td>Japanese Level</td>
				<td><form:select path="levelId">
						<form:option value="" />
						<form:option value="1" label="N1" />
						<form:option value="2" label="N2" />
						<form:option value="3" label="N3" />
						<form:option value="4" label="N4" />
						<form:option value="5" label="N5" />
						<form:option value="6" label="Beginner" />
					</form:select> <form:errors path="levelId" cssClass="text-error" /></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><form:select path="departmentId">
						<form:option value="" />
						<form:option value="1" label="System Development" />
						<form:option value="2" label="Infra" />
						<form:option value="3" label="HR" />
						<form:option value="4" label="Finance" />
					</form:select> <form:errors path="departmentId" cssClass="text-error" /></td>
			</tr>
			<tr>
				<td>Join Date (mm/dd/yyyy):</td>
				<td>
					<%-- <input type="date" class="joinDate" name="joinDate"
					value="<fmt:formatDate value="${joinDate}" pattern="MM-dd-yyyy" />" /> --%>
					<form:input path="joinDate" />
				</td>
			</tr>
			<tr>
				<td>Position</td>
				<td><form:select path="positionId">
						<form:option value="" />
						<form:option value="1" label="JSE" />
						<form:option value="2" label="SE" />
						<form:option value="3" label="SSE" />
						<form:option value="4" label="TL" />
						<form:option value="5" label="PL" />
						<form:option value="6" label="PM" />
						<form:option value="7" label="Junior HR" />
						<form:option value="8" label="Senior HR" />
					</form:select> <form:errors path="positionId" cssClass="text-error" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /> <form:errors path="email"
						cssClass="text-error" /></td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td><form:input path="phone" /> <form:errors path="phone"
						cssClass="text-error" /></td>
			</tr>
		</table>
		<form:button>Register</form:button>
	</form:form>
	<div id="dialog" title="Dialog box">My content</div>
</div>