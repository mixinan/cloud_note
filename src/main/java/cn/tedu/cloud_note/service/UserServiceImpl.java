package cn.tedu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("userService")  //扫描的Spring容器
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	public NoteResult<User> checkLogin(String name, String password) {
		//接收结果数据
		NoteResult<User> result = new NoteResult<User>();
		User user = userDao.findByName(name);
		
		//检测用户名
		if (user==null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		
		//检测密码(md5加密)
		String md5Password = NoteUtil.md5(password);
		if (!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		
		//用户名和密码都正确
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		
		return result;
	}

}
