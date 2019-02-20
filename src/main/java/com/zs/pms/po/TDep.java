package com.zs.pms.po;

import java.io.Serializable;

public class TDep implements Serializable{

	/**
	 *  生成序列化标示
	 */
	private static final long serialVersionUID = 6693929339309480899L;

	/*
	 * 写属性
	 */
	private int id;
	private String name;
	private int pid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Override
	public String toString() {
		return "TDep [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}
	
	
}
