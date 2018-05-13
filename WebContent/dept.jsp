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
        	
        	//查询部门显示字段，组建表格
        	var deptField = $.ajax({
                type : "POST",
                scriptCharset : "utf-8",
                url : "dept?method=findDeptField",
                data : "",
                async : false
            }).responseText;
        	var tableHtml = "<table class=\"table table-bordered\">";
            tableHtml = tableHtml + "<caption></caption><tbody>";
                    deptField=$.parseJSON(deptField);
                    console.log(deptField);
                    $.each(deptField, function(i, obj) {
                    	console.log(obj);
                    	tableHtml = tableHtml
                    	+ "<tr><td class=\"col-xs-3\">"+obj.chinese_name+"</td><td class=\"col-xs-9\"><div class=\"input-group\"><input id=\""+obj.colname+"\" type=\"text\" class=\"form-control\"  placeholder=\"\" value=\"\"></div></td></tr>";
					}); 
            tableHtml = tableHtml + "</tbody></table>";
            console.log(tableHtml);
            $("#DeptContent").html(tableHtml);
        	
        	
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
                
                var dept ={"TreeNodeId":treeNode.id,"TreeNodeName":treeNode.name};
                
                var deptInfo = $.ajax({
                    type : "POST",
                    dataType:"json",
                    scriptCharset : "utf-8",
                    url : "dept?method=findDeptInfo",
                    data : dept,
                    async : false
                }).responseText;
                deptInfo=$.parseJSON(deptInfo);
                console.log(deptInfo);
                $.each(deptInfo, function(i, obj) {
                	console.log(obj.value);
                	var a="#"+obj.field;
                	$(a).val(obj.value);;
                }); 
            };

            //Ajax调用处理
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
    <script type="text/javascript">
        function addDept() {
            if ($("#TreeNodeId").val() != "") {
                $("#TreeNodeId").val("");
                $("#TreeNodeName").val("");
                $(':input', '#form1').not(':button, :submit, :reset, :hidden').val('').removeAttr('checked').removeAttr('selected');
                console.log("清空数据");
                var newUrl = "dept?method=addDpte";
                $("#form1").attr('action', newUrl);
            } else {
                console.log("提交数据");
                $("#form1").submit();
            }

        }
        function updateDept(){
            var newUrl="depa?method=updateDept";
            $("#form1").attr('action',newUrl);
            //$("#form1").submit();
        }
        function deleteDept(){
            var newUrl="depa?method=deleteDept";
            $("#form1").attr('action',newUrl);
           // $("#form1").submit();
        }
    </script>
</head>
<body>
<div class="col-xs-2">
    <input type="hidden" id="TreeNodeId" name="TreeNodeId"
           class="form-control" /> <input type="hidden" id="TreeNodeName"
                                          name="TreeNodeName" class="form-control" />
    <ul id="tree" class="ztree" style="width: 260px; overflow: auto;"></ul>
</div>
<form id="form1" class="bs-example bs-example-form" action="depart?method=addDpte" method="post">
    <div class="col-xs-10">
        <div class="btn-group pull-right" role="group">
            <button type="button" class="btn btn-default" onclick="addDept();">新增</button>
            <button type="button" class="btn btn-default" onclick="updateDept();">修改</button>
            <button type="button" class="btn btn-default" onclick="deleteDept();">删除</button>
        </div>
        <div id="DeptContent"></div>
    </div>
</form>
</body>
</html>
