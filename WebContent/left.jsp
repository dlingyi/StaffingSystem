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
function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var NavigationNodes = $.ajax({
							type : "POST",
							scriptCharset : "utf-8",
							url : "navigation?method=loadLeftNavigation",
							data : "",
							async : false
						}).responseText;
						NavigationNodes=$.parseJSON(NavigationNodes);
						
						var NavigationNode=NavigationNodes[getQueryVariable("menu")];
						
						var navigation_html = "";

						navigation_html = navigation_html
								+ "<ul class=\"nav nav-pills nav-stacked\" style=\"min-width: 100px;\">";
						
						$.each(NavigationNode, function(i, obj) {  
							navigation_html = navigation_html
							+ "<li class=\"dropdown\"><a target=\"main\" href=\""+obj.url+"\" class=\"dropdown-toggle\">"
							+ obj.name + "</a></li>"; 
						});  
						
						navigation_html = navigation_html + "</ul>";
						console.log(navigation_html);
						$("#navigation").html(navigation_html);
					});
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="navigation" class="col-xs-1 text-center"></div>

</body>
</html>