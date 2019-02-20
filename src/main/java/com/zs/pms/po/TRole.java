package com.zs.pms.po;

import java.io.Serializable;

public class TRole implements Serializable{

	/**
	 *  生成序列化标示
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 写属性
	 */
	private int id;
	private String rname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	@Override
	public String toString() {
		return "TRole [id=" + id + ", rname=" + rname + "]";
	}
	
	
}
