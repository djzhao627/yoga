var prefix = ctx+ "/crm/employeeInfo"
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
	if($("#phonenumber").val()){//修改时
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
						phonenumber : { 
						required : true,
									maxlength:50
						},
						idcard : { 
						required : true,
									maxlength:18
						},
						nation : { 
												maxlength:255
						},
						hukoutype : { 
												maxlength:16
						},
						maritalstatus : { 
												maxlength:5
						},
						emergencycontact : { 
												maxlength:50
						},
						emergencycontactphone : { 
												maxlength:50
						},
						highestdegree : { 
												maxlength:255
						},
						graduateschool : { 
												maxlength:255
						},
						professional : { 
												maxlength:255
						},
						graduatiotime : { 
												maxlength:50
						},
						natureacademicqualifications : { 
												maxlength:255
						},
						joinworktime : { 
												maxlength:50
						},
						entercompanytime : { 
												maxlength:50
						},
						operatpost : { 
												maxlength:255
						},
						jobposition : { 
												maxlength:255
						},
						durationemptime : { 
												maxlength:50
						},
						politicallandscape : { 
												maxlength:50
						},
					},
		messages : {
		 				phonenumber : { 
						required : icon  + "手机号不能为空",
									maxlength: icon  + "最大长度不超过50"
						},
						idcard : { 
						required : icon  + "身份证号码不能为空",
									maxlength: icon  + "最大长度不超过18"
						},
						nation : { 
												maxlength: icon  + "最大长度不超过255"
						},
						hukoutype : { 
												maxlength: icon  + "最大长度不超过16"
						},
						maritalstatus : { 
												maxlength: icon  + "最大长度不超过5"
						},
						emergencycontact : { 
												maxlength: icon  + "最大长度不超过50"
						},
						emergencycontactphone : { 
												maxlength: icon  + "最大长度不超过50"
						},
						highestdegree : { 
												maxlength: icon  + "最大长度不超过255"
						},
						graduateschool : { 
												maxlength: icon  + "最大长度不超过255"
						},
						professional : { 
												maxlength: icon  + "最大长度不超过255"
						},
						graduatiotime : { 
												maxlength: icon  + "最大长度不超过50"
						},
						natureacademicqualifications : { 
												maxlength: icon  + "最大长度不超过255"
						},
						joinworktime : { 
												maxlength: icon  + "最大长度不超过50"
						},
						entercompanytime : { 
												maxlength: icon  + "最大长度不超过50"
						},
						operatpost : { 
												maxlength: icon  + "最大长度不超过255"
						},
						jobposition : { 
												maxlength: icon  + "最大长度不超过255"
						},
						durationemptime : { 
												maxlength: icon  + "最大长度不超过50"
						},
						politicallandscape : { 
												maxlength: icon  + "最大长度不超过50"
						},
					}
	})
}