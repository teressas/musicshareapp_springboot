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
<title>Add Song</title>
</head>
<body>
	<div class="container mt-5">
	
		<a href="/dashboard">Dashboard</a>
	
		<form:form action="/songs/new" method="post" modelAttribute="newSong" class="form">
				<p>
					<form:label path="name" class="form-label">Title</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" type="text" class="form-control"/>
				</p>
				<p>
					<form:label path="artist" class="form-label">Artist</form:label>
					<form:errors path="artist" class="text-danger" />
					<form:input path="artist" class="form-control"/>
				</p>
				<p>
					<form:label path="album" class="form-label">Album</form:label>
					<form:errors path="album" class="text-danger" />
					<form:input path="album" class="form-control"/>
				</p>
				<p>
					<form:label path="rating" class="form-label">Rating</form:label>
					<form:errors path="rating" class="text-danger"/>
					<form:input path="rating" type="number" class="form-control"/>
				</p>
				<p>
					<form:label path="length" class="form-label">Length</form:label>
					<form:errors path="length" class="text-danger"/>
					<form:input path="length" type="number" class="form-control"/>
				</p>
				<button class="btn btn-primary">Submit</button>
		</form:form>
		
	</div>
</body>
</html>