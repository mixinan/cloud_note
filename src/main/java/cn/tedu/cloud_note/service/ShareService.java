package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.util.NoteResult;

public interface ShareService {
	public NoteResult<Object> shareNote(String noteId);
}
