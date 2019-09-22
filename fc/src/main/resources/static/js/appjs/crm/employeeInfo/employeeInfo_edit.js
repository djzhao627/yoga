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
	if($("#phoneNumber").val()){//修改时
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
						phoneNumber : { 
						required : true,
									maxlength:50
						},
						idCard : { 
						required : true,
									maxlength:18
						},
						nation : { 
												maxlength:255
						},
						huKouType : { 
												maxlength:16
						},
						maritalStatus : { 
												maxlength:5
						},
						emergencyContact : { 
												maxlength:50
						},
						emergencyContactPhone : { 
												maxlength:50
						},
						highestDegree : { 
												maxlength:255
						},
						graduateSchool : { 
												maxlength:255
						},
						professional : { 
												maxlength:255
						},
						graduationTime : { 
												maxlength:50
						},
						natureAcademicQualifications : { 
												maxlength:255
						},
						joinWorkTime : { 
												maxlength:50
						},
						enterCompanyTime : { 
												maxlength:50
						},
						workPost : { 
												maxlength:255
						},
						jobPosition : { 
												maxlength:255
						},
						durationEmpTime : { 
												maxlength:50
						},
						politicalLandscape : { 
												maxlength:50
						},
					},
		messages : {
		 				phoneNumber : { 
						required : icon  + "手机号不能为空",
									maxlength: icon  + "最大长度不超过50"
						},
						idCard : { 
						required : icon  + "身份证号码不能为空",
									maxlength: icon  + "最大长度不超过18"
						},
						nation : { 
												maxlength: icon  + "最大长度不超过255"
						},
						huKouType : { 
												maxlength: icon  + "最大长度不超过16"
						},
						maritalStatus : { 
												maxlength: icon  + "最大长度不超过5"
						},
						emergencyContact : { 
												maxlength: icon  + "最大长度不超过50"
						},
						emergencyContactPhone : { 
												maxlength: icon  + "最大长度不超过50"
						},
						highestDegree : { 
												maxlength: icon  + "最大长度不超过255"
						},
						graduateSchool : { 
												maxlength: icon  + "最大长度不超过255"
						},
						professional : { 
												maxlength: icon  + "最大长度不超过255"
						},
						graduationTime : { 
												maxlength: icon  + "最大长度不超过50"
						},
						natureAcademicQualifications : { 
												maxlength: icon  + "最大长度不超过255"
						},
						joinWorkTime : { 
												maxlength: icon  + "最大长度不超过50"
						},
						enterCompanyTime : { 
												maxlength: icon  + "最大长度不超过50"
						},
						workPost : { 
												maxlength: icon  + "最大长度不超过255"
						},
						jobPosition : { 
												maxlength: icon  + "最大长度不超过255"
						},
						durationEmpTime : { 
												maxlength: icon  + "最大长度不超过50"
						},
						politicalLandscape : { 
												maxlength: icon  + "最大长度不超过50"
						},
					}
	})
}