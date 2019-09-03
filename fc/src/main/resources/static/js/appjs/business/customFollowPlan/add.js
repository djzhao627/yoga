var prefix = ctx + "/business/customFollowPlan"
$(function () {
    var editROW = getPageValue();//列表页面传值(row)
    var customId=$("#customId").val();
    validateRule();
    loadType();
    load(customId);
});

$.validator.setDefaults({
    submitHandler: function () {
        submitData(customId);
    }
});
function load(customId) {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/listPage", // 服务器数据的加载地址
                // showRefresh : true,
                // showToggle : true,
                // showColumns : true,
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
                search: false,
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    var formData ={};
                    formData.limit = params.limit;
                    formData.offset = params.offset;
                    formData.sort = this.sortName;
                    formData.order = this.sortOrder;
                    formData.customId=customId;
                    return formData;
                }

            });
}
function submitData(customId) {
    layer.alert('customId:'+customId);
    //var formData = $('#signupForm').serializeObject();//将指定容器中的控件值，序列化为json对象
    var formData = $('#signupForm').serialize();//将指定容器中的控件值，序列化为&相连的字符串
    var url = "";
    if ($("#id").val()) {//修改时
        url = prefix + "/update";
    } else {
        url = prefix + "/save";
    }
    formData.customId=customId;
    $.ajax({
        cache: true,
        type: "POST",
        url: url,
        data: $('#signupForm').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            id: {
                required: true,
            },
            customId: {},
            talkDate: {
                maxlength: 40
            },
            recordOrPlan: {
                maxlength: 255
            },
            insertTime: {},
            insertOperator: {},
            updateTime: {},
            updateOperator: {},
        },
        messages: {
            id: {
                required: icon + "不能为空",
            },
            customId: {},
            talkDate: {
                maxlength: icon + "最大长度不超过40"
            },
            recordOrPlan: {
                maxlength: icon + "最大长度不超过255"
            },
            insertTime: {},
            insertOperator: {},
            updateTime: {},
            updateOperator: {},
        }
    })
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
                // console.log(params.selected);
                // var opt = {
                //     query: {
                //         type: params.selected,
                //     }
                // }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}