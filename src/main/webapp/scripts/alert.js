//弹出“新建笔记”对话框
function alertAddNoteWindow() {
	// 判断是否有笔记本被选中
	var $li = $("#book_ul a.checked").parent();
	if ($li.length == 0) {
		alert("请选择笔记本");
	} else {
		// 加载“新建笔记”页面
		$("#can").load("alert/alert_note.html");
		// 显示背景
		$(".opacity_bg").show();
	}

}





// 弹出“新建笔记本”对话框
function alertAddBookWindow() {
	// 加载“新建笔记本”页面
	$("#can").load("alert/alert_notebook.html");
	// 显示背景
	$(".opacity_bg").show();
}

// 隐藏“新建笔记本”对话框
function closeAlertWindow() {
	$("#can").html("");
	// 隐藏背景
	$(".opacity_bg").hide();
}





// 新建笔记本
function addBook() {
	console.log(this);
	// 获取参数
	// 输入内容：笔记本名称 #input_notebook
	var name = $("#input_notebook").val().trim();
	// 通过cookie获取userId
	var userId = getCookie("userId");
	alert("name:" + name + " ,userId:" + userId);

	if (name != "") {

		$.ajax({
			url : path + "/book/add.do",
			type : "post",
			data : {
				"userId" : userId,
				"bookName" : name
			},
			dataType : "json",
			success : function(result) {
				// 提示创建结果
				alert(result.msg);

				if (result.status == 0) {
					var book = result.data;
					var bookId = book.cn_notebook_id;
					var bookName = book.cn_notebook_name;
					
					// 更新笔记本列表
					createBookLi(bookId, bookName);
				}
			},
			error : function() {
				alert("新建笔记本失败");
			}
		});
	}else{
		alert("笔记本名字不能为空");
	}
}