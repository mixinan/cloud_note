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

		if (note == null) {
			result.setStatus(1);
			result.setMsg("未找到数据");
			return result;
		} else {
			result.setStatus(0);
			result.setMsg("加载该条笔记成功");
			result.setData(note);
			return result;
		}
	}

	public NoteResult<Note> updateNote(Note note) {
		System.out.println(note.getCn_note_title());
		int n = noteDao.updateNote(note);
		NoteResult<Note> result = new NoteResult<Note>();

		if (n == 1) {
			Note newNote = noteDao.findByNoteId(note.getCn_note_id());

			result.setStatus(0);
			result.setMsg("更新成功");
			result.setData(newNote);

			return result;
		}
		return result;
	}

	
	
	public NoteResult<Object> updateNote(String noteId, String title, String body) {
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		note.setCn_note_last_modify_time(System.currentTimeMillis());

		int rows = noteDao.updateNote(note);
		NoteResult<Object> result = new NoteResult<Object>();
		
		if (rows == 1) {
			result.setStatus(0);
			result.setMsg("更新成功");
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("保存失败");
			return result;
		}
	}

}
