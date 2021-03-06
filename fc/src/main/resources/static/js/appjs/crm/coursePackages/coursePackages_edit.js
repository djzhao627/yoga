var prefix = ctx+ "/crm/coursePackages"
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
						deptId : { 
												},
						packageName : { 
												maxlength:255
						},
						subtitle : { 
												maxlength:255
						},
						courseIds : { 
												maxlength:255
						},
						goodsIds : { 
												maxlength:255
						},
						totalPrice : { 
												},
					},
		messages : {
		 				id : { 
						required : icon  + "不能为空",
									},
						deptId : { 
												},
						packageName : { 
												maxlength: icon  + "最大长度不超过255"
						},
						subtitle : { 
												maxlength: icon  + "最大长度不超过255"
						},
						courseIds : { 
												maxlength: icon  + "最大长度不超过255"
						},
						goodsIds : { 
												maxlength: icon  + "最大长度不超过255"
						},
						totalPrice : { 
												},
					}
	})
}
var openCourse = function () {
    layer.open({
        type: 2,
        title: "选择课程",
        area: ['600px', '450px'],
        content: prefix + "/courseList"
    })
}
function loadCourse(ids, names) {
    $("#courseIds").val(ids);
    $("#courseNames").val(names);
}
var openGoods = function () {
    layer.open({
        type: 2,
        title: "选择商品",
        area: ['600px', '450px'],
        content: prefix + "/goodsList"
    })
}
function loadGoods(ids, names) {
    $("#goodsIds").val(ids);
    $("#goodsNames").val(names);
}