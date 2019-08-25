var prefix = ctx + "/crm/workPlan"
$(function () {
    var editROW = getPageValue();//列表页面传值(row)
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        submitData();
    }
});

function submitData() {
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

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            id: {
                required: true,
            },
            deptId: {
                maxlength: 255
            },
            deptName: {
                maxlength: 255
            },
            startTime: {
                required: true,
            },
            endTime: {
                required: true,
            },
            personLiable: {
                maxlength: 50
            },
            helper: {
                maxlength: 50
            },
            remarks: {
                maxlength: 2000
            },
            remindType: {
                maxlength: 20
            },
        },
        messages: {
            id: {
                required: icon + "主键不能为空",
            },
            deptId: {
                maxlength: icon + "最大长度不超过255"
            },
            deptName: {
                maxlength: icon + "最大长度不超过255"
            },
            startTime: {
                required: icon + "开始时间不能为空",
            },
            endTime: {
                required: icon + "结束时间不能为空",
            },
            personLiable: {
                maxlength: icon + "最大长度不超过50"
            },
            helper: {
                maxlength: icon + "最大长度不超过50"
            },
            remarks: {
                maxlength: icon + "最大长度不超过2000"
            },
            remindType: {
                maxlength: icon + "最大长度不超过20"
            },
        }
    })
}