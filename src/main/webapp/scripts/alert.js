//弹出“新建笔记本”对话框
function alertAddBookWindow() {
	// 加载“新建笔记本”页面
	$("#can").load("alert/alert_notebook.html");
	// 关闭 $("#can").html("");
	// 显示背景
	$(".opacity_bg").show();
	// 隐藏背景 $(".opacity_bg").hide();
}


//隐藏“新建笔记本”对话框
function closeAlertWindow() {
	$("#can").html("");
	// 隐藏背景 
	$(".opacity_bg").hide();
}