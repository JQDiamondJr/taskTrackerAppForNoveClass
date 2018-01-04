<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- link html to bootstrap stylesheet -->
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">
<title>Update Task</title>
</head>
<body>
	<div class="container">
		<div class="row col-lg-6 col-md-offset-2 custyle">

			<!-- this is the table that displays the info about the specific task -->
			<table class="table table-striped custab">
				<thead>
					<tr>
						<th>Task ID</th>
						<th>Task Description</th>
						<th>Status</th>
						<th>Assigned To</th>
					</tr>
				</thead>
				<tr>
					<td>${task.taskID}</td>
					<td>${task.description}</td>
					<td>${task.status}</td>
					<td>${task.assignedTo}</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="container">
		<div class="row col-lg-6 col-md-offset-2">
			<c:choose>
				<c:when test="${task.assignedTo eq 'UNASSIGNED'}">
					<a
						href="${contextPath}/updateTask/ASSIGN/${task.taskID}/${username}"
						class="btn btn-primary btn-block"> <i
						class="glyphicon glyphicon-user"></i><strong>Assign To Me</strong></a>

				</c:when>
				<c:otherwise>
					<c:if test="${task.status ne 'IN-PROGRESS'}">
						<a
							href="${contextPath}/updateTask/IN-PROGRESS/${task.taskID}/${username}"
							class="btn btn-warning btn-block"> <i
							class="glyphicon glyphicon-edit"></i> <strong>IN
								PROGRESS</strong></a>
					</c:if>
					<c:if test="${task.status ne 'COMPLETED'}">
						<a
							href="${contextPath}/updateTask/COMPLETED/${task.taskID}/${username}"
							class="btn btn-success btn-block"> <i
							class="glyphicon glyphicon-ok"></i> <strong>COMPLETED</strong></a>
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>