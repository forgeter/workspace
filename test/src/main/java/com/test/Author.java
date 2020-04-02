/**
 * @Title: Author.java Create on 2020年1月9日 上午10:20:41
 * @author: jiangyuanquan
 * @Description: TODO(用一句话描述该文件做什么)
 * @Package com.test
 * Copyright <a href="mailto:www.ekezhan.com">www.ekezhan.com</a> Corporation 2020
*/
	
package com.test;

/**@Description: TODO
 * @author: jiangyuanquan 
 * @version: 2020年1月9日 上午10:20:41
*/
public class Author {

    private Long id;
    private String realName;
    private String nickName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
    
}
