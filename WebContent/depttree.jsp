<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head runat="server">
<meta charset="UTF-8">
<title></title>

<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="zTree_v3/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript" src="zTree_v3/js/jquery.ztree.core.js"></script>
<!-- 生成部门树 -->
<script type="text/javascript">
	$(document).ready(
			function() {

				var setting = {
					view : {
						dblClickExpand : false,
						showLine : true,
						selectedMulti : false
					},
					data : {
						simpleData : {
							enable : true,
							idKey : "id",
							pIdKey : "pId",
							rootPId : ""
						}
					},
					callback : {
						onClick : zTreeOnClick
					}
				};
				function zTreeOnClick(event, treeId, treeNode) {

					$("#inp").val(
							"id=" + treeNode.id + ", name=" + treeNode.name
									+ ",pId=" + treeNode.pId);
				}
				;

				var zNodes = "";
				$(document).ready(function() {
					var t = $("#tree");
					//Ajax调用处理
					zNodes = $.ajax({
						type : "POST",
						scriptCharset : "utf-8",
						url : "depttree?method=loadTree",
						data : "",
						async : false

					}).responseText;
					zNodes = (new Function("return " + zNodes))();
					console.log(zNodes);
					t = $.fn.zTree.init(t, setting, zNodes);
				});
			})//end document.ready
</script>

</head>
<body>

	<form id="form1" runat="server">
		<div style="float: left; background: red;">
			<input type="text" id="inp" name='inp' style="width: 300px" />
			<ul id="tree" class="ztree" style="width: 260px; overflow: auto;"></ul>
		</div>
		<div style="float: float; background: green;">hjgftf</div>
	</form>
</body>
</html>
