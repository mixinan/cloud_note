package test.dao;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import test.TestCase;

public class TestNoteDao extends TestCase{
	
	@Test
	public void testDao(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		List<Map> list = dao.findByBookId("6d763ac9-dca3-42d7-a2a7-a08053095c08");
		for (Map note:list) {
			System.out.println("id£º"+note.get("cn_note_id")+"\ntitle£º"+note.get("cn_note_title"));
		}
	}
	
	@Test
	public void loadNoteByNoteId(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		Note note = dao.findByNoteId("054449b4-93d4-4f97-91cb-e0043fc4497f");
		System.out.println(note.getCn_note_title());
		System.out.println(note.getCn_note_body());
		System.out.println(note.getCn_note_create_time());
	}
}
