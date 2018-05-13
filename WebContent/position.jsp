<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title></title>
    <script
            src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="zTree_v3/css/zTreeStyle/zTreeStyle.css"
          type="text/css">
    <script type="text/javascript" src="zTree_v3/js/jquery.ztree.core.js"></script>
    <link rel="stylesheet"
          href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- 生成部门树 -->
    <script type="text/javascript">
        $(document).ready( function() {
        	
        	//查询岗位显示字段，组建表格
        	var positionField = $.ajax({
                type : "POST",
                scriptCharset : "utf-8",
                url : "position?method=findPositionField",
                data : "",
                async : false
            }).responseText;
        	var tableHtml = "<table class=\"table table-bordered\">";
        	tableHtml = tableHtml + "<caption></caption><thead><tr>";
        	positionField=$.parseJSON(positionField);
            console.log(positionField);
            $.each(positionField, function(i, obj) {
            	console.log(obj);
            	tableHtml = tableHtml
            	+ "<th>"+obj.chinese_name+"</th>";
			}); 
            tableHtml = tableHtml+"<th>操作</th>";
            tableHtml = tableHtml + "</tr></thead><tbody></tbody></table>";
            console.log(tableHtml);
            $("#positionContent").html(tableHtml);
        	
            var setting = {
                view : {
                    dblClickExpand : false,
                    showLine : false,
                    selectedMulti : false,
                    showIcon : false
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
                $("#TreeNodeId").val(treeNode.id);
                $("#TreeNodeName").val(treeNode.name);
                
                var position ={"TreeNodeId":treeNode.id,"TreeNodeName":treeNode.name};
                
                var positionInfo = $.ajax({
                    type : "POST",
                    dataType:"json",
                    scriptCharset : "utf-8",
                    url : "position?method=findPositionInfo",
                    data : position,
                    async : false
                }).responseText;
                positionInfo=$.parseJSON(positionInfo);
                
                var tbodyhtml="<tr>";
                $.each(positionInfo, function(i, obj) {
                	//<div class=\"input-group\"><input id=\""+obj.colname+"\" type=\"text\" class=\"form-control\"  placeholder=\"\" value=\"\"></div>
                	tbodyhtml=tbodyhtml+"<td><div class=\"input-group\"><input id=\""+obj.field+"\" type=\"text\" readonly=\"true\" class=\"form-control\"  placeholder=\"\" value=\""+obj.value+"\"></div></td>";
                }); 
                tbodyhtml=tbodyhtml+"<td>按钮</td></tr>";
                $("#positionContent tbody").html(tbodyhtml);
            };

            //得到部门信息
            var zNodes = $.ajax({
                type : "POST",
                scriptCharset : "utf-8",
                url : "depttree?method=loadTree",
                data : "",
                async : false
            }).responseText;
            //转换为json
            zNodes = (new Function("return " + zNodes))();
            tree = $.fn.zTree.init($("#tree"), setting, zNodes);

        })//end document.ready
    </script>
</head>
<body>
<div class="col-xs-2">
    <input type="hidden" id="TreeNodeId" name="TreeNodeId" class="form-control" />
    <input type="hidden" id="TreeNodeName" name="TreeNodeName" class="form-control" />
    <ul id="tree" class="ztree" style="width: 260px; overflow: auto;"></ul>
</div>
    <div class="col-xs-10">
        <div id="positionContent"></div>
    </div>
</body>
</html>
