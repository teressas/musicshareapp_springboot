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
<title>Song Details</title>
</head>
<body>
	<div class="container mt-5">
		<a href="/dashboard">Dashboard</a>

		<div class="form-group row">
			<label for="name" class="col-sm-2 col-form-label">Title</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="name" value="${song.name }">
			</div>
			<div class="form-group row">
				<label for="artist" class="col-sm-2 col-form-label">Artist</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="artist" value="${song.artist }">
				</div>
			</div>
			<div class="form-group row">
				<label for="artist" class="col-sm-2 col-form-label">Album</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="artist" value="${song.album }">
				</div>
			</div>
			<div class="form-group row">
				<label for="artist" class="col-sm-2 col-form-label">Length</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="artist" value="${song.length }">
				</div>
			</div>
			<div class="form-group row">
				<label for="rating" class="col-sm-2 col-form-label">Rating (1-10)</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="rating" value="${song.rating }">
				</div>
			</div>
		</div>

		<form action="/songs/delete/${song.id }" method="post">
			<input type="hidden" name="_method" value="delete" />
			<button class="btn btn-danger">Delete</button>
		</form>


	</div>
</body>
</html>