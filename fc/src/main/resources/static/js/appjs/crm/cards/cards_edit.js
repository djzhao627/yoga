var prefix = ctx+ "/crm/cards"
$(function() {
	var editROW = getPageValue();//列表页面传值(row)
	validateRule();
    loadType();
    loadCType();
});

$.validator.setDefaults({
	submitHandler : function() {
		sbumitData();
	}
});

function sbumitData() {
	//var formData = $('#signupForm').serializeObject();//将指定容器中的控件值，序列化为json对象
	var formData = $('#signupForm').serialize();//将指定容器中的控件值，序列化为&相连的字符串
	var url = "";
	if($("#id").val()){//修改时
		url = prefix+ "/update";
	}else{
		url = prefix+ "/save";
	}
	
	$.ajax({
		cache : true,
		type : "POST",
		url : url,
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
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
		rules : {
						id : { 
						required : true,
									},
						memberId : { 
												},
						cardType : { 
												maxlength:3
						},
						courseType : { 
												maxlength:3
						},
						startTime : { 
												maxlength:40
						},
						endTime : { 
												maxlength:40
						},
						status : { 
												maxlength:3
						},
					},
		messages : {
		 				id : { 
						required : icon  + "不能为空",
									},
						memberId : { 
												},
						cardType : { 
												maxlength: icon  + "最大长度不超过3"
						},
						courseType : { 
												maxlength: icon  + "最大长度不超过3"
						},
						startTime : { 
												maxlength: icon  + "最大长度不超过40"
						},
						endTime : { 
												maxlength: icon  + "最大长度不超过40"
						},
						status : { 
												maxlength: icon  + "最大长度不超过3"
						},
					}
	})
}
var openMember = function () {
    layer.open({
        type: 2,
        title: "选择会员",
        area: ['600px', '450px'],
        content: prefix + "/memberList"
    })
}
function loadMember(ids, names) {
    $("#memberId").val(ids);
    $("#memberName").val(names);
}
function loadType() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/card_type',
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
function loadCType() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/course_type',
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select1").append(html);
            $(".chosen-select1").chosen({
                maxHeight: 200
            });
            $(".chosen-select1").val($("#Ctype").val());
            $(".chosen-select1").trigger("chosen:updated");
            //点击事件
            $('.chosen-select1').on('change', function (e, params) {
            });
        }
    });
}