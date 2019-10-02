var prefix = ctx+ "/crm/curriculum"
$(function() {
	var editROW = getPageValue();//列表页面传值(row)
	validateRule();
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
		// data : $('#signupForm').serialize(),// 你的formid
		data:formData,
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
						courseId : { 
												},
						memberId : { 
												},
						classroomId : { 
												},
						startDate : { 
												maxlength:255
						},
						endDate : { 
												maxlength:255
						},
						startTime : { 
												maxlength:40
						},
						endTime : { 
												maxlength:40
						},
						minNum : { 
												},
						maxMun : { 
												},
						status : { 
												maxlength:255
						},
					},
		messages : {
		 				id : { 
						required : icon  + "不能为空",
									},
						courseId : { 
												},
						memberId : { 
												},
						classroomId : { 
												},
						startDate : { 
												maxlength: icon  + "最大长度不超过255"
						},
						endDate : { 
												maxlength: icon  + "最大长度不超过255"
						},
						startTime : { 
												maxlength: icon  + "最大长度不超过40"
						},
						endTime : { 
												maxlength: icon  + "最大长度不超过40"
						},
						minNum : { 
												},
						maxMun : { 
												},
						status : { 
												maxlength: icon  + "最大长度不超过255"
						},
					}
	})
}

var openTrain = function () {
    layer.open({
        type: 2,
        title: "选择人员",
        area: ['300px', '450px'],
        content: ctx + "/sys/user/train"
    })
}

function loadTrain(userIds, userNames) {
    $("#trainId").val(userIds);
    $("#memberId").val(userNames);
}


var openRoom = function () {
    layer.open({
        type: 2,
        title: "选择教室",
        area: ['300px', '450px'],
        content: ctx + "/sys/user/room"
    })
}

function loadRoom(userIds, userNames) {
    $("#roomId").val(userIds);
    $("#classroomId").val(userNames);
}
