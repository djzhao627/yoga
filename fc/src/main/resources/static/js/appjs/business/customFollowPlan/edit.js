var prefix = ctx + "/business/customFollowPlan"
$(function () {
    var editROW = getPageValue();//列表页面传值(row)
    validateRule();
    loadType();
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