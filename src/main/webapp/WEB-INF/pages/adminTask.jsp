<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Management Screen</title>
</head>
<body>
	<div class="container">

		<table class="table table-striped custab">

			<thead>
				<a href="${contextPath}/createTaskForm"
					class="btn btn-primary btn-xs pull-right"><b>+</b> Add a new
					task</a>
				<tr>
					<th>Task ID</th>
					<th>Task Description</th>
					<th>Status</th>
					<th>Assigned To</th>
					<th>Delete</th>
				</tr>
			</thead>
			<c:forEach var="task" items="${taskList}">

				<tr>
					<td><a href="${contextPath}/viewTask/${task.taskID}">${task.taskID}</a></td>
					<td>${task.description}</td>
					<td>${task.status}</td>
					<td>${task.assignedTo}</td>
					<td><a
						href="${contextPath}/deleteTask/${task.taskID}"
						class="btn btn-danger btn-block"> <i
							class="glyphicon glyphicon-trash"></i> </a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>