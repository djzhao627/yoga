var prefix = ctx + "/sys/user"

function getTreeData() {
	$.ajax({
		type: "GET",
		url: ctx + "/system/sysDept/tree",
		success: function (tree) {
			loadTree(tree);

		}
	});
}

function loadTree(tree) {
	$('#jstree').jstree({
		'core': {
			'data': tree
		},
		"plugins": ["search"]
	});
	$('#jstree').jstree().open_all();
}

$('#jstree').on("changed.jstree", function (e, data) {
	if (data.selected == -1) {
		var opt = {
			query: {
				deptId: '',
			}
		}
		$('#exampleTable').bootstrapTable('refresh', opt);
	} else {
		var opt = {
			query: {
				deptId: data.selected[0],
			}
		}
		$('#exampleTable').bootstrapTable('refresh', opt);
	}
});