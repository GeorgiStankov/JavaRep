<%@page import="com.hackbulgaria.bugtracking.entities.Issue.IssueStatus"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hackbulgaria.bugtracking.entities.Issue"%>
<%@ page import="java.util.List"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Issues</title>

<%@ include file="head.jsp"%>
<div id="page-wrapper">
	<div class="container" style="width: 100%; padding-top: 40px;">
		<%
			List<Issue> issues = (List<Issue>) request.getAttribute("Issues");

			if (issues != null) {
				String color;
				String logo;
				for (Issue issue : issues) {
					logo = request.getContextPath() + "/resources/img/";
					if (issue.getStatus() == IssueStatus.NEW) {
						color = "red";
						logo += "bug.png";
					} else if (issue.getStatus() == IssueStatus.PROGRESSING) {
						color = "yellow";
						logo += "caterpillar.png";
					} else {
						color = "green";
						logo += "butterfly.png";
					}
		%>
		<div class="panel panel-<%=color%>">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-2" style="padding: 20px; padding-left: 30px;">
						<div class="row">
							<img src="<%=logo%>">
						</div>
						<br>
						<div class="row">
							<a class="btn btn-default"
								href="/bugtracking/issues/edit/<%=issue.getId()%>"> <i
								class="fa fa-pencil" aria-hidden="true"></i>
							</a> <a class="btn btn-default"
								href="/bugtracking/issues/delete/<%=issue.getId()%>"> <i
								class="fa fa-trash" aria-hidden="true"></i>
							</a>
						</div>
					</div>
					<div class="col-xs-3">
						<div class="row">
							<h3><%=issue.getTitle()%></h3>
							<p><%=issue.getDescription()%></p>
							<i class="fa fa-calendar-o" aria-hidden="true">
								Last update: <%=issue.getDate()%>
							</i> <br><br> <i class="fa fa-user" aria-hidden="true">
								Sumbitted by: <%=issue.getCreatorId().getName()%>
							</i>
						</div>
					</div>
					<div class="col-xs-7 text-right">
						<div class="huge"><%=issue.getStatus().toString()%></div>
						<div>
							Priority:
							<%=issue.getPriority().toString()%></div>
						<div>
							Type:
							<%=issue.getType().toString()%></div>
					</div>
				</div>
			</div>
			<%
				if (issue.getStatus() == IssueStatus.NEW) {
			%>
			<a href="/bugtracking/issues/assign/<%=issue.getId()%>">
				<div class="panel-footer">
					<span class="pull-left">Assign</span> <span class="pull-right"><i
						class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
			<%
				}
			%>
		</div>
		<%
			}
			}
		%>
	</div>
	<%@ include file="footer.jsp"%>