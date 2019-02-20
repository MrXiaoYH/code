package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.dao.UserDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.util.Constants;
import com.zs.pms.util.MD5;
import com.zs.pms.vo.QueryUser;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("你好！");
	}

	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	@Override
	public List<TPermission> genMenu(List<TPermission> pers) {
		// TODO Auto-generated method stub
//		创建新容器
		List<TPermission> list=new ArrayList<>();
//		遍历权限列表
		for(TPermission per:pers) {
//			一级菜单
			if (per.getLev()==1) {
//				加载该一级菜单下的二级菜单
//				遍历
				for(TPermission per2:pers) {
//					二级权限的上级id等于一级权限id
					if (per2.getPid()==per.getId()) {
//						添加子权限
						per.addChlid(per2);
					}
				}
//				加到新的集合中
				list.add(per);
			}
		}
		return list;
	}

	@Override
	public List<TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub
		return dao.queryByCon(query);
	}

	@Override
	public void updateUser(TUser user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	@Override
//	该方法只要有异常就回滚事务
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUser user) throws AppException{
		// TODO Auto-generated method stub
//		模拟业务异常
		if ("admin".equals(user.getLoginname())) {
			throw new AppException(1003, "登录名不能使admin");
		}
		MD5 md5=new MD5();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
//		新增
		dao.insertUser(user);
//		返回主键
		return user.getId();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	
	@Override
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	@Override
	/**
	 * 获得分页记录
	 */
	public List<TUser> queryByPage(int page, QueryUser query) {
		// TODO Auto-generated method stub
		/*
		 * 
		 */
//		
		int start=(page-1)*Constants.PAGECONT+1;
//		
		int end=page*Constants.PAGECONT;
		
		query.setStart(start);
		query.setEnd(end);
		return dao.queryByPage(query);
	}

	@Override
	public int queryPageCount(QueryUser query) {
		// TODO Auto-generated method stub
//		
		int cont=dao.queryCount(query);
//		
		if (cont%Constants.PAGECONT==0) {
			return cont/Constants.PAGECONT;
		} else {
			return cont/Constants.PAGECONT+1;
		}
	
	}

	@Override
	public TUser queryById(int id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}

	

}
