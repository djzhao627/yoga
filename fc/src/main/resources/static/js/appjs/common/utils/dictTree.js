var prefix = ctx + "/common/dict"

function getTreeData() {
	$.ajax({
		type: "POST",
		url: prefix + "/dictTree",
		success: function (tree) {
			loadTree(tree);
		}
	});
}

function loadTree(tree) {
	$('#dictTree').jstree({
		'core': {
			'data': tree
		},
		"plugins": ["search"]
	});
	$('#dictTree').jstree().open_all();
}

$('#dictTree').on("changed.jstree", function (e, data) {
	if (data.selected == -1) {
		var opt = {
			query: {
				type: '',
			}
		}
		$('#exampleTable').bootstrapTable('refresh', opt);
	} else {
		var opt = {
			query: {
				type: data.selected[0],
			}
		}
		$('#exampleTable').bootstrapTable('refresh', opt);
	}
});