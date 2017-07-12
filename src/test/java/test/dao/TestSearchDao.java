package test.dao;

import java.util.List;

import org.junit.Test;

import cn.tedu.cloud_note.dao.ShareDao;
import cn.tedu.cloud_note.entity.Share;
import test.TestCase;

public class TestSearchDao extends TestCase{
	ShareDao dao = super.getContext().getBean("shareDao", ShareDao.class);
	
	@Test
	public void test(){
		List<Share> list = dao.searchLikeNotes("a");
		System.out.println(list);
	}
}
