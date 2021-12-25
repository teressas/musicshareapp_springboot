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
<title>Music Playlist</title>
</head>
<body>

	<div class="container mt-5">

		<div class="col-sm-4">

			<a href="/">Home</a>
		</div>
		<div class="row">
			<h1>Daily Hits</h1>


			<div class="col-sm-4">

				<a href="/playlist/new">Add New Playlist</a>
			</div>
			<div class="col-sm-4">
				<a href="/songs/new">Add New Song</a>
			</div>
			<div class="col-sm-4">
				<a href="/songs/topsongs">Top Songs</a>
			</div>
			<div class="col-sm-4">
				<form action="/search" method="post">
					<input type="search" name="artist" />
					<button class="btn btn-primary">Search</button>
				</form>
			</div>




			<div>
				<h3>Songs</h3>

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Artist</th>
							<th>Albums</th>
							<th>Ratings</th>
							<th>Length</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="song" items="${songs }">
							<tr>
								<td><a href="/songs/${song.id}">${song.name }</a></td>
								<td>${song.artist }</td>
								<td>${song.album }</td>
								<td>${song.rating }</td>
								<td>${song.length }</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

				<h3>My Playlists</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th colspan="2">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="playlist" items="${playlists }">
							<tr>
								<td><a href="/playlists/${playlist.id}">${playlist.name }</a></td>
								<td><a href="/playlists/edit/${playlist.id }"
									class="btn btn-success">Edit</a></td>
								<td>
									<form action="/playlists/delete/${playlist.id }" method="post">
										<input type="hidden" name="_method" value="delete" />
										<button class="btn btn-danger">Delete</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>