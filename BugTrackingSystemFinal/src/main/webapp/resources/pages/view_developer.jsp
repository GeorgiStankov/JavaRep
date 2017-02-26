<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>View dev</title>
<link href="../css/custom.css" rel="stylesheet" />

<%@ include file="head.jsp"%>
<div id="page-wrapper">
	<div class="container" style="padding: 20px;">
		<div class="row">
			<div class="col-sm-2 col-md-2">
				<img src="<c:url value="/resources/img/profile.png"/>" alt=""
					class="img-rounded img-responsive" />
			</div>
			<div class="col-sm-4 col-md-4">
				<blockquote>
					<h2>${dev.name } 
					 <a class="btn btn-default"
								href="/bugtracking/developers/edit/${dev.id}"> <i
								class="fa fa-pencil" aria-hidden="true"></i>
							</a>
							<a class="btn btn-default"
								href="/bugtracking/developers/delete/${dev.id}"> <i
								class="fa fa-trash" aria-hidden="true"></i>
							</a></h2> 
					<small><cite title="Source Title">Sofia, Bulgaria <i
							class="glyphicon glyphicon-map-marker"></i>
					</cite></small>
				</blockquote>
				<span class="label label-primary">${dev.role }</span> 
				<br> <br>
				<i class="fa fa-calendar" aria-hidden="true"></i>
					${dev.date}
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>