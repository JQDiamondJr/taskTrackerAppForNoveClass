<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">
<title>Employee Task Management Screen</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped custab">
			<thead>
				<tr>
					<th>Task ID</th>
					<th>Task Description</th>
					<th>Status</th>
					<th>Assigned To</th>
				</tr>
			</thead>
			<!-- This is where we are rendering from the array task and displaying on table with help of spring framework -->
			<c:forEach var="task" items="${taskList}">
				<tr>
					<!-- The TaskID is hyperlinked and reroutes to the update task page -->
					<td><a
						href="${contextPath}/viewTask/${task.taskID}/${username}">${task.taskID}</a></td>
					<td>${task.description}</td>
					<td>${task.status}</td>
					<td>${task.assignedTo}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>