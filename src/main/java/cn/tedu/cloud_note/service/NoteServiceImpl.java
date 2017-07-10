package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	
	@Resource
	private NoteDao noteDao;

	public NoteResult<List<Map>> loadBookNotes(String bookId) {
		List<Map> list = noteDao.findByBookId(bookId);
		
		NoteResult<List<Map>> result = new NoteResult<List<Map>>();
		result.setStatus(0);
		result.setMsg("笔记加载成功");
		result.setData(list);
		
		return result;
	}

	public NoteResult<Note> loadNote(String noteId) {
		Note note = noteDao.findByNoteId(noteId);
		
		NoteResult<Note> result = new NoteResult<Note>();
		result.setStatus(0);
		result.setMsg("加载该条笔记成功");
		result.setData(note);
		
		return result;
	}


}
