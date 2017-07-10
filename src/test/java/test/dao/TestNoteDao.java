package test.dao;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.tedu.cloud_note.dao.NoteDao;
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
}
