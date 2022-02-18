<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="Styles/mainStyle.css">
<title>Home</title>
</head>
<body>
<div class="wrap">
	<header>
		<img alt="Pets & Plants Logo" class="img-fluid" src="Styles/img/logo3.png"/>
	</header>
	
		<form action="searchServlet" method="GET">
			<div class="search">

				<select class="form-select" aria-label="Default select example"
					name="selectedFilter">
					<option value="" disabled selected>Select what to search
						for</option>
					<option value="name">Plant Name</option>
					<option value="symptom">Symptom</option>
				</select>

				<div class="input-group">
					<input class="form-control" type="search" name="searchWord"
						placeholder="What are you looking for?" aria-label="Search">

					<button class="btn btn-warning" type="submit" name="submit" value="submit">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  						<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
					</svg>
					</button>
				</div>
			</div>
			<button class="btn btn-light" type="submit" name="reset" value="reset">Reset</button>
		</form>
		<div id="error">${error}</div>
	</div>
	<div class="wrap2">${tableResult}</div>
	<div class="footer">
		<a
			style="background-color: black; color: white; text-decoration: none; padding: 4px 6px; font-family: -apple-system, BlinkMacSystemFont,&amp; amp; amp; quot; San Francisco&amp;amp; amp; quot; , &amp; amp; amp; quot; Helvetica Neue&amp;amp; amp; quot; , Helvetica , Ubuntu, Roboto, Noto, &amp;amp; amp; quot; Segoe UI&amp;amp; amp; quot; , Arial , sans-serif; font-size: 12px; font-weight: bold; line-height: 1.2; display: inline-block; border-radius: 3px"
			href=" https://unsplash.com/@moosecarrot?utm_medium=referral&amp;utm_campaign=photographer-credit&amp;utm_content=creditBadge"
			target="_blank" rel="noopener noreferrer"
			title="Download free do whatever you want high-resolution photos from Ian Chen"><span
			style="display: inline-block; padding: 2px 3px"><svg
					xmlns="http://www.w3.org/2000/svg"
					style="height: 12px; width: auto; position: relative; vertical-align: middle; top: -2px; fill: white"
					viewBox="0 0 32 32">
				<title>unsplash-logo</title><path
						d="M10 9V0h12v9H10zm12 5h10v18H0V14h10v9h12v-9z"></path></svg></span><span
			style="display: inline-block; padding: 2px 3px">Photo: Ian
				Chen</span></a>

	</div>
</body>
</html>