package test.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;
import test.TestCase;

public class TestNoteService extends TestCase{
	private NoteService noteService;
	
	@Before
	public void init(){
		noteService = super.getContext().getBean("noteService", NoteService.class);
	}
	
	@Test
	public void test(){
		NoteResult<List<Map>> result =  
				noteService.loadBookNotes("6d763ac9-dca3-42d7-a2a7-a08053095c08");
		
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		
		for (Map note : result.getData()) {
			System.out.println(note.get("cn_note_title"));
		}
		
	}
}
