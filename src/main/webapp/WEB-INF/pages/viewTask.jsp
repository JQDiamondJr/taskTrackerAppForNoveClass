<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> 
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">
<div class="container">
	<div class="row col-md-6 col-md-offset-2 custyle">
		<table class="table table-striped custab">
			<thead>
				<a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b>
					Add a new task</a>
				<tr>
					<th>Task ID</th>
					<th>Task Description</th>
					<th>Assign To</th>
					<th>Status</th>

				</tr>
			</thead>
			<c:forEach var="task" items= "${taskList}">
			
		<tr>
				
				<td>${task.taskID}</td>
				<td>${task.description}</td>
				<td>${task.assignedTo}</td>
				<td>${task.status}</td>
				
				</tr>
				
			</c:forEach>
			
		</table>
	</div>
</div>