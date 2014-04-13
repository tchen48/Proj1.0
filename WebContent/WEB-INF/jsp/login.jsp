<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Management System</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="resources/css/loginstyle.css" />
<script src="resources/js/jquery-1.11.0.js"></script>

</head>
<body>
	<div class="container">
		<div class="row-fluid">
			<div id="content">
				<h1>Project Management System</h1>
				<h3>Group 17 <br/>
					Shihuan Shao&nbsp;&nbsp;&nbsp;&nbsp;Tuyue Chen&nbsp;&nbsp;&nbsp;&nbsp;Yongming Zhang</h3>
				<form:form method="post" action="home.html" commandName="user">
					<div id="logindiv" class="span6 offset3">
						<div id="alertdiv">
							${ErrorMsg}						
						</div>
						<form:input id="input1" class="span12" placeholder="UserID" type="text" value="" path="userId" required="true" />
						<form:input id="input2" class="span12" placeholder="Password" type="password" path="password" required="true" />
						<div id="btndiv" class="span6 offset3">
							<input type="submit" class="btn btn-large btn-success btn-block" value="Log In"/>
						</div>
					</div>
				</form:form>
				<script language="JavaScript">
					var content = $("#alertdiv").html();
					var val = content.trim().length;
					if(val == 0){
					}
					else{
						$("#alertdiv").empty();
						var newalert = document.createElement("div");
						newalert.className = "alert alert-error";
						newalert.innerHTML = content;
						$("#alertdiv").append(newalert);
					}
				</script>
			</div>
		</div>
	</div>
</body>
</html>