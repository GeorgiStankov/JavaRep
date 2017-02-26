<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>DBUG</title>


<script>
	//Does the button thing
	function addMessage() {
		var msg = document.getElementById("btn-input").value;
		document.getElementById("whiteboard").append("<p>" + msg + "</p>");
	}
</script>

<%@ include file="head.jsp"%>
 <% int commentsCount = (Integer)session.getAttribute("commentsCount"); %>
		<% int activeCount = (Integer)session.getAttribute("activeCount"); %>
		<% int inProcessCount = (Integer)session.getAttribute("progressingCount"); %>
		<% int resolvedCount = (Integer)session.getAttribute("resolvedCount"); %> 

<%-- <!-- Mocking these for now -->
<%
	int commentsCount = 12;
%>
<%
	int activeCount = 13;
%>
<%
	int inProcessCount = 66;
%>
<%
	int resolvedCount = 136; --%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Dashboard</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<img src="<c:url value="resources/img/comment.png"/> ">
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge"><%=commentsCount%></div>
							<div>New comments</div>
						</div>
					</div>
				</div>
				<a href="#">
					<div class="panel-footer">
						<span class="pull-left">View</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-red">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<img src="<c:url value="resources/img/bug.png"/> ">
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge"><%=activeCount%></div>
							<div>Bugs active</div>
						</div>
					</div>
				</div>
				<a href="<c:url value="/issues/active"/> ">
					<div class="panel-footer">
						<span class="pull-left">View</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-yellow">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<img src="<c:url value="resources/img/caterpillar.png"/> ">
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge"><%=inProcessCount%></div>
							<div>In process</div>
						</div>
					</div>
				</div>
				<a href="<c:url value="/issues/assigned"/> ">
					<div class="panel-footer">
						<span class="pull-left">View</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-green">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<img src="<c:url value="resources/img/butterfly.png"/> ">
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge"><%=resolvedCount%></div>
							<div>Resolved</div>
						</div>
					</div>
				</div>
				<a href="<c:url value="/issues/resolved"/>">
					<div class="panel-footer">
						<span class="pull-left">View</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-8">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-newspaper-o"></i> Whiteboard
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body" id="whiteboard">
					<c:if test="${not empty messages }">
						<tbody>
							<c:forEach var="msg" items="${messages}">

								<ul class="chat">
									<li class="left clearfix"><span class="chat-img pull-left">
											<img src="http://placehold.it/50/55C1E7/fff"
											alt="User Avatar" class="img-circle" />
									</span>
										<div class="chat-body clearfix">
											<div class="header">
												<strong class="primary-font">${msg.title }</strong> <small
													class="pull-right text-muted"> <i
													class="fa fa-clock-o fa-fw"></i>
													 ${msg.getFormattedTimestamp() }
												</small>
											</div>
											<p>${msg.message }</p>
										</div></li>
								</ul>
							</c:forEach>

						</tbody>
					</c:if>

					<!-- /.panel-body -->
					<div class="panel-footer">
						<div class="input-group">
							<input id="btn-input" type="text" class="form-control input-sm"
								placeholder="Type your message here..." /> <span
								class="input-group-btn">
								<button class="btn btn-warning btn-sm" id="btn-chat">
									Send</button>
							</span>
						</div>
					</div>
					<!-- /.panel-footer -->
				</div>
				<!-- /.panel-body -->
			</div>

		</div>
		<!-- /.col-lg-8 -->
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-bell fa-fw"></i> Notifications Panel
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="list-group">
						<a href="#" class="list-group-item"> <i
							class="fa fa-comment fa-fw"></i> New Comment <span
							class="pull-right text-muted small"><em>4 minutes ago</em>
						</span>
						</a> <a href="#" class="list-group-item"> <i
							class="fa fa-twitter fa-fw"></i> 3 New Followers <span
							class="pull-right text-muted small"><em>12 minutes
									ago</em> </span>
						</a> <a href="#" class="list-group-item"> <i
							class="fa fa-envelope fa-fw"></i> Message Sent <span
							class="pull-right text-muted small"><em>27 minutes
									ago</em> </span>
						</a> <a href="#" class="list-group-item"> <i
							class="fa fa-tasks fa-fw"></i> New Task <span
							class="pull-right text-muted small"><em>43 minutes
									ago</em> </span>
						</a> <a href="#" class="list-group-item"> <i
							class="fa fa-upload fa-fw"></i> Server Rebooted <span
							class="pull-right text-muted small"><em>11:32 AM</em> </span>
						</a> <a href="#" class="list-group-item"> <i
							class="fa fa-bolt fa-fw"></i> Server Crashed! <span
							class="pull-right text-muted small"><em>11:13 AM</em> </span>
						</a> <a href="#" class="list-group-item"> <i
							class="fa fa-warning fa-fw"></i> Server Not Responding <span
							class="pull-right text-muted small"><em>10:57 AM</em> </span>
						</a> <a href="#" class="list-group-item"> <i
							class="fa fa-shopping-cart fa-fw"></i> New Order Placed <span
							class="pull-right text-muted small"><em>9:49 AM</em> </span>
						</a> <a href="#" class="list-group-item"> <i
							class="fa fa-money fa-fw"></i> Payment Received <span
							class="pull-right text-muted small"><em>Yesterday</em> </span>
						</a>
					</div>
					<!-- /.list-group -->
					<a href="#" class="btn btn-default btn-block">View All Alerts</a>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
			<!--  <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Donut Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                                <a href="#" class="btn btn-default btn-block">View Details</a>
                            </div>
                            /.panel-body
                        </div> -->
			<!-- /.panel -->
			<!-- <div class="chat-panel panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Chat
					<div class="btn-group pull-right">
						<button type="button"
							class="btn btn-default btn-xs dropdown-toggle"
							data-toggle="dropdown">
							<i class="fa fa-chevron-down"></i>
						</button>
						<ul class="dropdown-menu slidedown">
							<li><a href="#"> <i class="fa fa-refresh fa-fw"></i>
									Refresh
							</a></li>
							<li><a href="#"> <i class="fa fa-check-circle fa-fw"></i>
									Available
							</a></li>
							<li><a href="#"> <i class="fa fa-times fa-fw"></i> Busy
							</a></li>
							<li><a href="#"> <i class="fa fa-clock-o fa-fw"></i>
									Away
							</a></li>
							<li class="divider"></li>
							<li><a href="#"> <i class="fa fa-sign-out fa-fw"></i>
									Sign Out
							</a></li>
						</ul>
					</div>
				</div>
				/.panel-heading

				/.panel-body
				<div class="panel-footer">
					<div class="input-group">
						<input id="btn-input" type="text" class="form-control input-sm"
							placeholder="Type your message here..." /> <span
							class="input-group-btn">
							<button class="btn btn-warning btn-sm" id="btn-chat" onclick="addMessage()">
								Send</button>
						</span>
					</div>
				</div>
				/.panel-footer
			</div> -->
			<!-- /.panel .chat-panel -->
		</div>
		<!-- /.col-lg-4 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="footer.jsp"%>