var prefix = ctx+ "/crm/order"
$(function() {
	var editROW = getPageValue();//列表页面传值(row)
	validateRule();
    loadType();
    loadPaymentType();
    loadPaymentMode();
    loadSendType();
    loadScheduleCampus();
    loadConsultingCourse();
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
						sfzh : {
												},
						initialTraining : { 
												maxlength:3
						},
						paymentDate : { 
												},
						paymentType : { 
												maxlength:3
						},
						paymentMode : { 
												maxlength:3
						},
						paymentAccount : { 
												},
						book : { 
												maxlength:2
						},
						clothes : { 
												maxlength:2
						},
						scheduleDate : { 
												},
						scheduleCampus : { 
												maxlength:255
						},
						otherFees : { 
												},
						enrollmentCourse : { 
												maxlength:255
						},
						insertTime : { 
						required : true,
									},
						insertOperator : { 
												},
						updateTime : { 
						required : true,
									},
						updateOperator : { 
												},
					},
		messages : {
		 				id : { 
						required : icon  + "不能为空",
									},
						customId : { 
												},
						initialTraining : { 
												maxlength: icon  + "最大长度不超过3"
						},
						paymentDate : { 
												},
						paymentType : { 
												maxlength: icon  + "最大长度不超过3"
						},
						paymentMode : { 
												maxlength: icon  + "最大长度不超过3"
						},
						paymentAccount : { 
												},
						book : { 
												maxlength: icon  + "最大长度不超过2"
						},
						clothes : { 
												maxlength: icon  + "最大长度不超过2"
						},
						scheduleDate : { 
												},
						scheduleCampus : { 
												maxlength: icon  + "最大长度不超过255"
						},
						otherFees : { 
												},
						enrollmentCourse : { 
												maxlength: icon  + "最大长度不超过255"
						},
						insertTime : { 
						required : icon  + "不能为空",
									},
						insertOperator : { 
												},
						updateTime : { 
						required : icon  + "不能为空",
									},
						updateOperator : { 
												},
					}
	})
}

function loadType() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/yes_no',
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight: 200
            });
            //点击事件
            $('.chosen-select').on('change', function (e, params) {
                console.log(params.selected);
                var opt = {
                    query: {
                        type: params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function loadPaymentType() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/payment_type',
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select1").append(html);
            $(".chosen-select1").chosen({
                maxHeight: 200
            });
            //点击事件
            $('.chosen-select1').on('change', function (e, params) {
                console.log(params.selected);
                var opt = {
                    query: {
                        type: params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function loadPaymentMode() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/payment_mode',
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select2").append(html);
            $(".chosen-select2").chosen({
                maxHeight: 200
            });
            //点击事件
            $('.chosen-select2').on('change', function (e, params) {
                console.log(params.selected);
                var opt = {
                    query: {
                        type: params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function loadSendType() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/send_type',
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select3").append(html);
            $(".chosen-select3").chosen({
                maxHeight: 200
            });
            //点击事件
            $('.chosen-select3').on('change', function (e, params) {
                console.log(params.selected);
                var opt = {
                    query: {
                        type: params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function loadScheduleCampus() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/schedule_campus',
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select4").append(html);
            $(".chosen-select4").chosen({
                maxHeight: 200
            });
            //点击事件
            $('.chosen-select4').on('change', function (e, params) {
                console.log(params.selected);
                var opt = {
                    query: {
                        type: params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function loadConsultingCourse() {
    var html = "";
    $.ajax({
        url: ctx + '/common/dict/list/consultingCourse_type',
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select5").append(html);
            $(".chosen-select5").chosen({
                maxHeight: 200
            });
            //点击事件
            $('.chosen-select5').on('change', function (e, params) {
                console.log(params.selected);
                var opt = {
                    query: {
                        type: params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}
