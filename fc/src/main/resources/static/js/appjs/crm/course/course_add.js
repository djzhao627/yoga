var prefix = ctx+ "/crm/course"
$(function() {
	var editROW = getPageValue();//列表页面传值(row)
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		sbumitData();
	}
});
$().ready(function() {
    $('.summernote').summernote({
        height:'220px',
        lang : 'zh-CN'
    });
    validateRule();
});
function sbumitData() {
	//var formData = $('#signupForm').serializeObject();//将指定容器中的控件值，序列化为json对象
	var formData = $('#signupForm').serialize();//将指定容器中的控件值，序列化为&相连的字符串
    var courseDetail=$("#courseDetail").val();
    formData.courseDetail=courseDetail;
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
		data : formData,// 你的formid
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
						deptId : { 
												maxlength:255
						},
						courseName : { 
												maxlength:255
						},
						price : { 
												},
						courseDetail : { 
												maxlength:255
						},
					},
		messages : {
		 				id : { 
						required : icon  + "不能为空",
									},
						deptId : { 
												maxlength: icon  + "最大长度不超过255"
						},
						courseName : { 
												maxlength: icon  + "最大长度不超过255"
						},
						price : { 
												},
						courseDetail : { 
												maxlength: icon  + "最大长度不超过255"
						},
					}
	})
}