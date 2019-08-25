var prefix = ctx+ "/business/memberBaseInfo"
$(function() {
	load();
    loadType();
});

function load() {
	$('#dataTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/listPage", // 服务器数据的加载地址
						// showRefresh : true,
						// showToggle : true,
						// showColumns : true,
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
						showColumns : true, // 是否显示内容下拉框（选择显示的列）
						showRefresh:true,
                        showToggle: true,
                        search: false,
						showExport: true,                     //是否显示导出
						exportDataType: "all",              //basic', 'all', 'selected'.
                        exportTypes:['excel'],
                        exportOptions:{
                            ignoreColumn: [0],  //忽略某一列的索引
                            fileName: '报表',  //文件名称设置
                            worksheetName: 'sheet1',  //表格工作区名称
                            tableName: '报表'
                            //excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],
                            //onMsoNumberFormat: DoOnMsoNumberFormat
                        },
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
						},
                        columns : [
                            {
                                checkbox : true
                            },
                            {
                                visible :false,
                                field : 'id',
                                title : '编号'
                            },

                            {
                                field : 'name',
                                title : '客户名称'
                            },
                            {
                                field : 'type',
                                title : '客户类型'
                            },
                            {
                                field : 'consultants',
                                title : '所属顾问'
                            },
                            {
                                field : 'wechat',
                                title : '微信号'
                            },
                            {
                                field : 'phone',
                                title : '联系电话'
                            },
                            {
                                field : 'consultingCourse',
                                title : '咨询课程',
                                formatter : function(value, row, index){
                                    if(value==0){
                                        return '零基础班';
                                    }else if(value==1){
                                        return '空中瑜伽';
                                    }else if(value==2){
                                        return '舞韵瑜伽';
                                    }
                                }
                            },
                            {
                                field : 'accommodation',
                                title : '是否住宿',
                                formatter : function(value, row, index){
                                    if(value==0){
                                        return '否';
                                    }else if(value==1){
                                        return '是';
                                    }
                                }
                            },
                            {
                                field : 'advisoryDate',
                                title : '咨询日期'
                            },
                            {
                                field : 'address',
                                title : '所在省市'
                            },
                            {
                                field : 'customerServic',
                                title : '所属客服'
                            },
                            {
                                field : 'sfzh',
                                title : '身份证号码'
                            },
                            {
                                field : 'dataSource',
                                title : '数据来源',
                                formatter : function(value, row, index){
                                    if(value==0){
                                        return '商务通';
                                    }else if(value==1){
                                        return '微信群';
                                    }else if(value==2){
                                        return '400呼入';
                                    }
                                }
                            },
                            {
                                field : 'bz',
                                title : '备注'
                            },
                            {
                                field : 'plan',
                                title : '沟通计划',
                                align : 'center',
                                formatter: function(value,row,index){
                                    return '<a href="#" onclick="openCustom(\''+row.id+'\')">'+"详情"+'</a>';
                                }
                            },
                            {
                                title : '操作',
                                field : 'operation',
								width:40,
                                align : 'center',
                                formatter : function(value, row, index) {
                                    var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                        + row.id
                                        + '\')"><i class="fa fa-edit"></i></a> ';
                                    var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                        + row.id
                                        + '\')"><i class="fa fa-remove"></i></a> ';
                                    var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                        + row.id
                                        + '\')"><i class="fa fa-key"></i></a> ';
                                    return e + d;
                                }
                            } ]
					});
}


function reLoad() {
	$('#dataTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	/*var row = $('#dataTable').bootstrapTable('getData')[index];*/
	if(!id){
		alertMsg("请选择一条记录!");
		return;
	}
	// setPageValue(JSON.stringify(row));
	
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
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
function batchRemove() {
	var rows = $('#dataTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		alertMsg("请选择要删除的数据");
		return;
	}
	alertConfirm("确认要删除选中的'" + rows.length + "'条数据吗?",
	  function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					alertMsg(r.msg);
					reLoad();
				} else {
					alertMsg(r.msg);
				}
			}
		});
	});
}

//重置输入框
function reSet(){
	cleardata("formSearch");
	reLoad();  
}

var openCustom = function (id) {
    layer.open({
        type: 2,
        title: "沟通计划",
        area: ['800px', '500px'],
        scrollbar: true,
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        content: ctx + "/business/customFollowPlan/customerList/"+id
    });
}
function loadType() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/custom_type',
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight: 200
            });
            $(".chosen-select").val($("#Ttype").val());
            $(".chosen-select").trigger("chosen:updated");
            //点击事件
            $('.chosen-select').on('change', function (e, params) {
            });
        }
    });
}