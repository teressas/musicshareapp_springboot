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
<title>Playlist Details</title>
</head>
<body>
	<div class="container mt-5">
		<a href="/dashboard">Dashboard</a>

		<div>
			<h2>Playlist Name</h2>
			<h2>${playlist.name }</h2>
		</div>
		<div>
			<h4>Songs:</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Artist</th>
						<th>Albums</th>
						<th>Ratings</th>
						<th>Length</th>
						<th>Actions</th>
				</thead>
				<tbody>

					<c:forEach var="song" items="${playlist.songs }">
						
								<tr>
								<td>${song.name }</td>
								<td>${song.artist }</td>
								<td>${song.album }</td>
								<td>${song.rating }</td>
								<td>${song.length }</td>
								<td>
									<form action="/playlists/${playlist.id }/update/${song.id }" method="post">
										<input type="hidden" name="_method" value="put" /> 
										<button class="btn btn-danger">Remove</button>
									</form>
										
								
								</td>
								</tr>
							

					</c:forEach>
				</tbody>
			</table>
		</div>




		<form action="/playlists/${playlist.id }" method="post">
			<input type="hidden" name="_method" value="put" /> <select
				name="songId" class="form-select">
				<c:forEach var="oneSong" items="${songs }">
					
						<c:if test="${oneSong.playlists.contains(playlist) == false}">
							<option value="${oneSong.id }">${oneSong.name }</option>
						</c:if>
				</c:forEach>
						
			</select>
			<button class="btn btn-primary">Add a Song</button>
		</form>

		<form action="/playlists/delete/${playlist.id }" method="post">
			<input type="hidden" name="_method" value="delete" />
			<button class="btn btn-danger">Delete</button>
		</form>
	</div>
</body>
</html>