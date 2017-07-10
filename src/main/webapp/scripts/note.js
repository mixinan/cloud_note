function createNoteLi(noteId,noteTitle){
	var str = "";
	
	str+='<li class="online">';
	str+='<a>';
	str+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	str+=noteTitle;
	str+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	str+='</a>';
	str+='<div class="note_menu" tabindex="-1">';
	str+='<dl>';
	str+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	str+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	str+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	str+='</dl>';
	str+='</div></li>';
	
	$li=$(str);
	
	$li.data("noteId",noteId);
	
	$("#note_ul").append($li);
}