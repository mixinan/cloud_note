//加载笔记本的笔记
function loadBookNotes() {
	// 设置选中效果
	$("#book_ul a").removeClass("checked"); // 去除所有选中效果
	$(this).find("a").addClass("checked"); // 设置点击后的li效果

	// 获取参数
	var bookId = $(this).data("bookId");
	// alert(bookId);
	// 发送ajax请求
	$.ajax({
		url : path + "/note/loadnotes.do",
		type : "post",
		data : {
			"bookId" : bookId
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				// 清空列表
				$("#note_ul").empty();

				var maps = result.data;
				for (var i = 0; i < maps.length; i++) {
					var map = maps[i];
					var noteId = map.cn_note_id;
					var noteTitle = map.cn_note_title;
					createNoteLi(noteId, noteTitle);
				}
			}
		},
		error : function() {
			alert("获取笔记失败");
		}
	});
}

function createNoteLi(noteId, noteTitle) {
	var str = "";

	str += '<li class="online">';
	str += '<a>';
	str += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	str += noteTitle;
	str += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	str += '</a>';
	str += '<div class="note_menu" tabindex="-1">';
	str += '<dl>';
	str += '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	str += '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	str += '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	str += '</dl>';
	str += '</div></li>';

	$li = $(str);

	$li.data("noteId", noteId);

	$("#note_ul").append($li);
}