var app = new Vue({
	el: '#app',
	data: {
		limit: 12,
		offset: 0,
		total: 0,
		file: '',
		type: '',
		rows: '',
	},
	methods: {
		getData: function () {
			$.getJSON("/common/sysFile/list", {
				limit: this.limit,
				offset: this.offset,
				type: this.type
			}, function (r) {
				app.total = r.total;
				app.rows = r.rows;
				app.page();
			});
		},
		page: function () {
			var options = {
				currentPage: app.offset / 12 + 1, //当前页
				totalPages: app.total / (12 + 1) + 1, //总页数
				numberofPages: 4, //显示的页数
				bootstrapMajorVersion: 3,
				alignment: 'center',
				size: 'large',
				shouldShowPage: true,
				itemTexts: function (type, page, current) { //修改显示文字
					switch (type) {
						case "first":
							return "首页";
						case "prev":
							return "上一页";
						case "next":
							return "下一页";
						case "last":
							return "尾页";
						case "page":
							return page;
					}
				},
				onPageClicked: function (event, originalEvent, type, page) {
					app.offset = (page - 1) * 12;
					app.getData();
				}
			};
			$('#page').bootstrapPaginator(options);
		},
		remove: function (id) {
			layer.confirm('确定要删除选中的记录？', {
				btn: ['确定', '取消']
			}, function () {
				$.ajax({
					url: "/common/sysFile/remove",
					type: "post",
					data: {
						'id': id
					},
					success: function (r) {
						if (r.code == 0) {
							layer.msg(r.msg);
							app.getData();
						} else {
							layer.msg(r.msg);
							app.getData();
						}
					}
				});
			})
		},
		changeType: function (i) {
			this.type = i;
			this.offset = 0;
			this.getData();
		}
	},
	created: function () {
		this.changeType('')
	}
});


var clipboard = new Clipboard('button.copy', {
	text: function (trigger) {
		layer.msg('文件路径已复制到粘贴板');
		return $(trigger).attr('url');
	}
});
layui.use('/lay/modules/upload', function () {
	var upload = layui.module.upload;
	//执行实例
	var uploadInst = upload.render({
		elem: '#test1', //绑定元素
		url: '/common/sysFile/upload', //上传接口
		size: 1000,
		accept: 'file',
		done: function (r) {
			layer.msg(r.msg);
			app.getData();
		},
		error: function (r) {
			layer.msg(r.msg);
		}
	});
});

function changeType(i) {
	app.type = i;
	app.offset = 0;
	app.getData();
}