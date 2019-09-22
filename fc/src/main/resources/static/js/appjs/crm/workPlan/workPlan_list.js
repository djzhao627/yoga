var prefix = ctx + "/crm/workPlan"

$(function () {
    getTreeData();
    var deptId = '';
    initTable(deptId);
    $('#locale').change(initTable);
})


var $table = $('#exampleTable')
var $remove = $('#remove')
var selections = []

function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id
    })
}

function responseHandler(res) {
    $.each(res.rows, function (i, row) {
        row.state = $.inArray(row.id, selections) !== -1
    })
    return res
}

function uploadFile() {
    var fordata = new FormData();
    fordata.append('id', "5");
    fordata.append('file', $('#taskAnnex')[0].files[0]);
    $.ajax({
        url: '/crm/workPlan/uploadFile',
        type: 'post',
        processData: false,
        contentType: false,
        data: fordata,
        success: function (data) {
            layer.msg("保存成功！");
        },
        error : function (data) {
            layer.msg("保存失败！");
        }
    })
}
function detailFormatter(index, row) {

    return '<label class="col-sm-3 control-label">任务附件：</label>' +
        ' <div><input id="taskAnnex" name="file" value="'+ row.taskAnnex +'" class="form-control" type="file">' +
        ' <button class="layui-btn" onclick="uploadFile()">保存</button></div>';

    /*var params = {
        workPlanId: row.id
    };
    var html = [];
    var str = "<div>";
    $.ajax({
        url: ctx + "/crm/workPlanFollowUp/listPage",
        method: 'post',                      //请求方式（*）
//            contentType: 'application/json; charset=utf-8',
        dataType: "json",
        async: false,
        data: params,
        beforeSend: function () {
            close = layer.load(2);
        },
        success: function (data) {
            layer.close(close);
            var rowData = data.rows;

            for (var i = 0; i < rowData.length; i++) {
                str += "<tr class='detail-view'>";
                str += "<td style='width: 50px' align='center' id=''></td>";
                str += "<td style='width: 50px' align='center'>" + (i + 1) + "</td>";
                str += "<td class='colStyle' align='center'>" + rowData[i].followUp + "</td>";
                str += "<td class='colStyle' align='center'>" + rowData[i].followUp + "</td>";
                str += "</tr>";
            }

        }
    })
    return str + "</div>";*/
}

function operateFormatter(value, row, index) {
    return [
        '<a class="like" href="javascript:void(0)" title="Like">',
        '<i class="fa fa-heart"></i>',
        '</a>  ',
        '<a class="remove" href="javascript:void(0)" title="Remove">',
        '<i class="fa fa-trash"></i>',
        '</a>'
    ].join('')
}

window.operateEvents = {
    'click .like': function (e, value, row, index) {
        alert('You click like action, row: ' + JSON.stringify(row))
    },
    'click .remove': function (e, value, row, index) {
        $table.bootstrapTable('remove', {
            field: 'id',
            values: [row.id]
        })
    }
}

function totalTextFormatter(data) {
    return 'Total'
}

function totalNameFormatter(data) {
    return data.length
}

function totalPriceFormatter(data) {
    var field = this.field
    return '$' + data.map(function (row) {
        return +row[field].substring(1)
    }).reduce(function (sum, i) {
        return sum + i
    }, 0)
}

function formatTableUnit(value, row, index) {
    return {
        css: {
            "white-space": 'nowrap',
            "text-overflow": 'ellipsis',
            "overflow": 'hidden'
        }
    }
}

function initTable(deptId) {
    $table.bootstrapTable('destroy').bootstrapTable({

        method: 'get', // 服务器数据的请求方式 get or post
        url: prefix + "/listPage", // 服务器数据的加载地址
        clickToSelect: true,
        iconSize: 'outline',
        toolbar: '#exampleToolbar',
        pagination: true, // 设置为true会在底部显示分页条
        striped: true, // 设置为true会有隔行变色效果
        dataType: "json", // 服务器返回的数据类型
        pagination: true, // 设置为true会在底部显示分页条
        singleSelect: false, // 设置为true将禁止多选
        pageNumber: 1, // 如果设置了分布，首页页码
        pageSize: 10, // 如果设置了分页，每页数据条数
        pageList: [5, 10, 50, 100, 500],  //记录数可选列表
        sortStable: true,
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        showColumns: true, // 是否显示内容下拉框（选择显示的列）
        showRefresh: true,
        showToggle: true,
        search: false,
        showExport: true,                     //是否显示导出
        exportDataType: "all",              //basic', 'all', 'selected'.
        exportTypes: ['excel'],
        height: $(window).height() - 160,
        rowHeight: "35px",
        exportOptions: {
            ignoreColumn: [0],  //忽略某一列的索引
            fileName: '报表',  //文件名称设置
            worksheetName: 'sheet1',  //表格工作区名称
            tableName: '报表'
            //excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],
            //onMsoNumberFormat: DoOnMsoNumberFormat
        },
        sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams: function (params) {
            var formData = $('#formSearch').serializeObject();
            if (!formData) {
                formData = {};
            }
            formData.limit = params.limit;
            formData.offset = params.offset;
            formData.sort = this.sortName;
            formData.order = this.sortOrder;
            formData.deptId = deptId;
            return formData;
        },
        columns: [
            {
                checkbox: true,
                height: "35px"
            }, {
                field: 'id',
                visible: false,
            }, {
                field: 'deptId',
                visible: false,
            }, {
                field: 'deptName',
                title: '部门名称',
                width: 60,
                height: "35px"
            }, {
                field: 'content',
                title: '交办事项',
                width: 80,
                cellStyle: formatTableUnit,
                formatter: function (value, row, index) {

                    var span = document.createElement('div');
                    span.setAttribute('title', value);
                    span.innerHTML = value.toString().substring(0, 20);
                    return span.outerHTML;
                }
            }, {
                field: 'startTime',
                title: '开始时间',
                width: 60
            }, {
                field: 'endTime',
                title: '结束时间',
                width: 60
            }, {
                field: 'personLiableName',
                title: '责任人',
                width: 60
            }, {
                field: 'helperName',
                title: '协助人',
                width: 60
            }, {
                field: 'state',
                title: '状态',
                width: 60
            }, {
                field: 'operate',
                title: '操作',
                width: 100,
                align: 'center',
                formatter: function (value, row, index) {
                    var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                        + row.id
                        + '\')"><i class="fa fa-edit"></i></a> ';
                    var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                        + row.id
                        + '\')"><i class="fa fa-remove"></i></a> ';
                    return '<span>' + e + d + '</span>';
                }
            }
        ],
        rowStyle: function (row, index) {
            return row.height = "35px";
        }
    })
    $table.on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table',
        function () {
            $remove.prop('disabled', !$table.bootstrapTable('getSelections').length)

            // save your data, here just save the current page
            selections = getIdSelections()
            // push or splice the selections if you want to save all data selections
        })
    $table.on('all.bs.table', function (e, name, args) {
        console.log(name, args)
    })
    $remove.click(function () {
        var ids = getIdSelections()
        $table.bootstrapTable('remove', {
            field: 'id',
            values: ids
        })
        $remove.prop('disabled', true)
    })
}


/*格式化"操作"按钮列*/
function operateFormatter(value, row, index) {
    /**var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
     + row.id
     + '\' , '+ index +')"><i class="fa fa-edit"></i></a> ';
     var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
     + row.id
     + '\')"><i class="fa fa-remove"></i></a> ';
     var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
     + row.id
     + '\')"><i class="fa fa-key"></i></a> ';*/
    var e = "";
    if (s_edit_h != "hidden") {
        e = createTableEditHtml();
    }
    var d = "";
    if (s_remove_h != "hidden") {
        d = createTableDelHtml();
    }
    return e + d;
}

//操作列事件
var operateEvent = {
    'click .check': function (e, value, row, index) {
        edit(row, 'check');
    },
    'click .edit': function (e, value, row, index) {
        edit(row, 'edit');
    },
    'click .remove': function (e, value, row, index) {
        remove(row.id);
    }
};

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function addWorkPlan() {

    var selected = $('#jstree').jstree(true).get_selected(true)[0];
    if (!selected) {
        alertMsg("请选择部门!");
        return;
    }
    var deptId = selected.id;
    var deptName = selected.text;
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add/' + deptId + "/" + deptName // iframe的url
    });
}

function edit(id) {
    /*var row = $('#exampleTable').bootstrapTable('getData')[index];*/
    if (!id) {
        alertMsg("请选择一条记录!");
        return;
    }
    setPageValue(JSON.stringify(id));

    layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
}

function remove(id) {
    alertConfirm('确定要删除选中的记录？',
        function () {
            $.ajax({
                url: prefix + "/remove",
                type: "post",
                data: {
                    'id': id
                },
                success: function (r) {
                    if (r.code == 0) {
                        alertMsg(r.msg);
                        reLoad();
                    } else {
                        alertMsg(r.msg);
                    }
                }
            });
        })
}

/**
 * 发布
 * @param id
 */
function batchPublic() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        alertMsg("请选择要发布的数据");
        return;
    }
    alertConfirm("确认要发布选中的'" + rows.length + "'条数据吗?",
        function () {
            var ids = new Array();
            // 遍历所有选择的行数据，取每条数据对应的ID
            $.each(rows, function (i, row) {
                ids[i] = row['id'];
            });
            $.ajax({
                type: 'POST',
                data: {
                    "ids": ids
                },
                url: prefix + '/batchPublic',
                success: function (r) {
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

/**
 * 作废
 * @param id
 */
function batchScrapped() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        alertMsg("请选择要作废的数据");
        return;
    }
    alertConfirm("确认要作废选中的'" + rows.length + "'条数据吗?",
        function () {
            var ids = new Array();
            // 遍历所有选择的行数据，取每条数据对应的ID
            $.each(rows, function (i, row) {
                ids[i] = row['id'];
            });
            $.ajax({
                type: 'POST',
                data: {
                    "ids": ids
                },
                url: prefix + '/batchScrapped',
                success: function (r) {
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

//备用方法
function resetPwd(id) {
}

function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        alertMsg("请选择要删除的数据");
        return;
    }
    alertConfirm("确认要删除选中的'" + rows.length + "'条数据吗?",
        function () {
            var ids = new Array();
            // 遍历所有选择的行数据，取每条数据对应的ID
            $.each(rows, function (i, row) {
                ids[i] = row['id'];
            });
            $.ajax({
                type: 'POST',
                data: {
                    "ids": ids
                },
                url: prefix + '/batchRemove',
                success: function (r) {
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
function reSet() {
    cleardata("formSearch");
    reLoad();
}