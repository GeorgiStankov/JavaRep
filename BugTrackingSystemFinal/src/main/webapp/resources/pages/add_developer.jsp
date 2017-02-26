<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Add a developer</title>

<%@ include file="head.jsp"%>
<div id="page-wrapper">
	<div class="container" style="padding: 20px;">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div>
					<form:form class="form-horizontal" method="POST"
						action="/bugtracking/developers/create" modelAttribute="developer">
						<fieldset>
							<!-- Name input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="title">Name</label>
								<div class="col-md-9">
									<input id="name" name="name" type="text"
										placeholder="A short title" class="form-control">
								</div>
							</div>

							<!-- Message body -->
							<div class="form-group">
								<label class="col-md-3 control-label" for="role">Team
									lead</label>
								<div class="col-md-9">
										<input id="role" name="role" type="text"
											placeholder="Role in team" class="form-control"/>
								</div>
							</div>

							<!-- Form actions -->
							<div class="form-group">
								<div class="col-md-12 text-right">
									<button type="submit" id="btn1" class="btn btn-primary btn-lg">Submit</button>
								</div>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>