var tree = null; // treeview对象
var treeData = null; // 记录tree的json数据
var expandedNodeId = null; // 记录被展开的节点ID
var resInputId = null; // 记录用户选中"资源"板块中input的id(父资源类型、资源类型)

$(function(){
	// ajax初始化资源tree
	$.ajax({
		url : rootPath + "/resservlettest",
		type : "get",
		dataType : "json",
		success : function(treeData) {
			tree = $("#tree").treeview({
				data : treeData,
				onNodeExpanded : nodeExpanded,
				onNodeSelected : nodeSelected
			});
		}
	});
	
	// 给"资源"板块中input绑定点击事件(父资源类型、资源类型)
	// 记录用户点击的input框id
	$("input[id*=restype]").click(function(){
		resInputId = this.id;
	});
});

// 节点被展开
function nodeExpanded(event, node){
	if(expandedNodeId){
		// TODO 将上一个展开的节点折叠起来
	}else{}
	expandedNodeId = node.id;

}
// 节点被选择
function nodeSelected(event, node){
	var nodeText = node.text;
	if(resInputId && (nodeText.indexOf(")") == -1)){
		$("#"+resInputId).val(nodeText);
	}
}

$("#tempBtn").click(installUrl);

