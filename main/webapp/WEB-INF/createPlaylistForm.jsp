<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>New Playlist</title>
</head>
<body>
	<div class="container mt-5">
	
		<a href="/dashboard">Dashboard</a>
	
		<form:form action="/playlist/new" method="post" modelAttribute="newPlaylist" class="form">
				<div class="form-group row">
       				<div class="col-xs-2">
						<form:label path="name" class="form-label">Title</form:label>
						<form:errors path="name" class="text-danger"/>
						<form:input path="name" type="text" class="form-control"/>
					</div>
				</div>
				
				<button class="btn btn-primary">Submit</button>
		</form:form>
		
	</div>
</body>
</html>