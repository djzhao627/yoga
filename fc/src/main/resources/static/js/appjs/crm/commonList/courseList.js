
var prefix = ctx+ "/crm/course"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/listPage", // 服务器数据的加载地址
						clickToSelect : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						pagination : true, // 设置为true会在底部显示分页条
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						singleSelect : false, // 设置为true将禁止多选
						pageNumber : 1, // 如果设置了分布，首页页码
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageList: [5,10, 50, 100, 500],  //记录数可选列表
						sortStable:true,
                        sortable: true,                     //是否启用排序
                        sortOrder: "asc",                   //排序方式
                        search: false,
						showExport: false,                     //是否显示导出
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							var formData = $('#formSearch').serializeObject();
							if(!formData){
								formData = {};
							}
							formData.limit = params.limit;
							formData.offset = params.offset;
							formData.sort = this.sortName;
							formData.order = this.sortOrder;
							return formData;
						}
						
					});
}

function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function remove(id) {
	alertConfirm('确定要删除选中的记录？', 
	  function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					alertMsg(r.msg);
					reLoad();
				}else{
					alertMsg(r.msg);
				}
			}
		});
	})
}
//备用方法
function resetPwd(id) {
}

//重置输入框
function reSet(){
	cleardata("formSearch");
	reLoad();  
}

function loadCourse() {
    var rows = $('#exampleTable').bootstrapTable('getSelections');
    if (rows.length == 0) {
        alertMsg("请选择课程");
        return;
    }
    var ids = "";
    var names="";
    // 遍历所有选择的行数据，取每条数据对应的ID
    $.each(rows, function (i, row) {
        ids = ids+row['id']+",";
        names=names+row['courseName']+",";
    });
    if (ids.concat(",") && ids.charAt(ids.length - 1) == ',') {
        ids = ids.substring(0, ids.length - 1);
        names = names.substring(0, names.length - 1);
    }
    parent.loadCourse(ids, names);
    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    parent.layer.close(index);
}