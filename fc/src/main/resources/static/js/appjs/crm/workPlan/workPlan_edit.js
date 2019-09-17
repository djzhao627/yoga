var prefix = ctx + "/crm/workPlan"
$(function () {
    var editROW = getPageValue();//列表页面传值(row)
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        sbumitData();
    }
});

function sbumitData() {
    //var formData = $('#signupForm').serializeObject();//将指定容器中的控件值，序列化为json对象
    var formData = $('#signupForm').serialize();//将指定容器中的控件值，序列化为&相连的字符串
    var url = "";
    if ($("#id").val()) {//修改时
        url = prefix + "/update";
    } else {
        url = prefix + "/save";
    }

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

var openPersonLiableName = function () {
    layer.open({
        type: 2,
        title: "选择人员",
        area: ['300px', '450px'],
        content: prefix + "/personLiable"
    })
}

function loadPersonLiable(userIds, userNames) {
    $("#personLiableId").val(userIds);
    $("#personLiableName").val(userNames);
}

var openHelperName = function () {
    layer.open({
        type: 2,
        title: "选择人员",
        area: ['300px', '450px'],
        content: prefix + "/helper"
    })
}

function loadHelper(userIds, userNames) {
    $("#helperId").val(userIds);
    $("#helperName").val(userNames);
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            id: {
                required: true,
                maxlength: 10
            },
            content: {
                required: true,
                maxlength: 1000
            },
            deptId: {
                required: true,
                maxlength: 100
            },
            deptName: {
                required: true,
                maxlength: 100
            },
            startTime: {
                required: true,
                maxlength: 23
            },
            endTime: {
                required: true,
                maxlength: 23
            },
            schedule: {
                maxlength: 255
            },
            personLiableId: {
                required: true,
                maxlength: 100
            },
            helperId: {
                maxlength: 100
            },
            remarks: {
                maxlength: 1000
            },
            remindType: {
                maxlength: 2
            },
            state: {
                required: true,
                maxlength: 2
            },
            level: {
                maxlength: 2
            },
            taskAnnex: {
                maxlength: 500
            },
            taskAnnexPath: {
                maxlength: 500
            },
            executeAnnex: {
                maxlength: 500
            },
            executeAnnexPath: {
                maxlength: 500
            },
        },
        messages: {

            id: {
                required: icon + "不能为空",
                maxlength: icon + "最大长度不超过10"
            },
            content: {
                required: icon + "交办事项不能为空",
                maxlength: icon + "最大长度不超过1000"
            },
            deptId: {
                required: icon + "部门Id不能为空",
                maxlength: icon + "最大长度不超过100"
            },
            deptName: {
                required: icon + "部门名称不能为空",
                maxlength: icon + "最大长度不超过100"
            },
            startTime: {
                required: icon + "开始时间不能为空",
                maxlength: icon + "最大长度不超过23"
            },
            endTime: {
                required: icon + "结束时间不能为空",
                maxlength: icon + "最大长度不超过23"
            },
            schedule: {
                maxlength: icon + "最大长度不超过255"
            },
            personLiableId: {
                required: icon + "责任人不能为空",
                maxlength: icon + "最大长度不超过100"
            },
            personLiableName: {
                required: icon + "责任人不能为空",
                maxlength: icon + "最大长度不超过100"
            },
            helperId: {
                maxlength: icon + "最大长度不超过100"
            },
            helperName: {
                maxlength: icon + "最大长度不超过100"
            },
            remarks: {
                maxlength: icon + "最大长度不超过1000"
            },
            remindType: {
                maxlength: icon + "最大长度不超过2"
            },
            state: {
                required: icon + "状态：0：草稿，1：发布，2：删除不能为空",
                maxlength: icon + "最大长度不超过2"
            },
            level: {
                maxlength: icon + "最大长度不超过2"
            },
            taskAnnex: {
                maxlength: icon + "最大长度不超过500"
            },
            taskAnnexPath: {
                maxlength: icon + "最大长度不超过500"
            },
            executeAnnex: {
                maxlength: icon + "最大长度不超过500"
            },
            executeAnnexPath: {
                maxlength: icon + "最大长度不超过500"
            },
        }
    })
}