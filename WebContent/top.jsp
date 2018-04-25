<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var NavigationNodes = $.ajax({
							type : "POST",
							scriptCharset : "utf-8",
							url : "navigation?method=loadTopNavigation",
							data : "",
							async : false

						}).responseText;

						NavigationNodes = (new Function("return "
								+ NavigationNodes))();

						var navigation_html = "";

						navigation_html = navigation_html
								+ "<ul class=\"nav navbar-nav\">";
						for (var i = 0; i < NavigationNodes.length; i++) {
							navigation_html = navigation_html
									+ "<li class=\"dropdown\"><a href=\""+NavigationNodes[i].url+"\" class=\"dropdown-toggle\"data-toggle=\"dropdown\">"
									+ NavigationNodes[i].name + "</a></li>";

						}
						dhl_html = navigation_html + "</ul>";
						console.log(navigation_html);
						$("#navigation").html(navigation_html);
					});
</script>
<title>导航栏</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">部门员工管理系统</a>
		</div>
		<div id="navigation"></div>
	</div>
	</nav>
</body>
</html>
