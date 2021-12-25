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
<title>Top Ten Songs</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<h2>Top Ten Songs</h2>
			<a href="/dashboard">Dashboard</a>
			<c:forEach var="song" items="${songs}">
				<ul>
					<li>${song.rating }- ${song.name } - ${song.artist}</li>
				</ul>
			</c:forEach>
		</div>
	</div>
</body>
</html>