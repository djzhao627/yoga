var prefix = ctx+ "/business/fcMemberManagementBaseinfo"
$(function() {
	var editROW = getPageValue();//列表页面传值(row)
	validateRule();
    loadType();
    loadType2();
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
						name : { 
												maxlength:255
						},
						type : { 
												maxlength:3
						},
						consultants : { 
												maxlength:255
						},
						wechat : { 
												maxlength:255
						},
						phone : { 
												maxlength:255
						},
						consultingCourse : { 
												maxlength:255
						},
						accommodation : { 
												maxlength:3
						},
						advisoryDate : { 
												},
						address : { 
												maxlength:255
						},
						customerServic : { 
												maxlength:255
						},
						sfzh : { 
												maxlength:255
						},
						dataSource : { 
												maxlength:3
						},
						certificateNumber : { 
												maxlength:255
						},
						bz : { 
												maxlength:255
						},
						insertTime : { 
												},
						insertOperator : { 
												},
						updateTime : { 
												},
						updateOperator : { 
												},
					},
		messages : {
		 				id : { 
						required : icon  + "不能为空",
									},
						name : { 
												maxlength: icon  + "最大长度不超过255"
						},
						type : { 
												maxlength: icon  + "最大长度不超过3"
						},
						consultants : { 
												maxlength: icon  + "最大长度不超过255"
						},
						wechat : { 
												maxlength: icon  + "最大长度不超过255"
						},
						phone : { 
												maxlength: icon  + "最大长度不超过255"
						},
						consultingCourse : { 
												maxlength: icon  + "最大长度不超过255"
						},
						accommodation : { 
												maxlength: icon  + "最大长度不超过3"
						},
						advisoryDate : { 
												},
						address : { 
												maxlength: icon  + "最大长度不超过255"
						},
						customerServic : { 
												maxlength: icon  + "最大长度不超过255"
						},
						sfzh : { 
												maxlength: icon  + "最大长度不超过255"
						},
						dataSource : { 
												maxlength: icon  + "最大长度不超过3"
						},
						certificateNumber : { 
												maxlength: icon  + "最大长度不超过255"
						},
						bz : { 
												maxlength: icon  + "最大长度不超过255"
						},
						insertTime : { 
												},
						insertOperator : { 
												},
						updateTime : { 
												},
						updateOperator : { 
												},
					}
	})
}
function loadType(){
    var html = "";
    $.ajax({
        url : ctx+'/common/dict/list/oa_notify_type',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}
function loadType2(){
    var html = "";
    $.ajax({
        url : ctx+'/common/dict/list/yes_no',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $(".chosen-select2").append(html);
            $(".chosen-select2").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.chosen-select2').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}
var openUser = function(){
    layer.open({
        type:2,
        title:"选择人员",
        area : [ '300px', '450px' ],
        content:ctx+"/sys/user/treeView"
    })
}
var openUser2 = function(){
    layer.open({
        type:2,
        title:"选择人员",
        area : [ '300px', '450px' ],
        content:ctx+"/sys/user/treeView"
    })
}
function loadUser(userIds,userNames){
    $("#consultantsIds").val(userIds);
    $("#consultants").val(userNames);
}
