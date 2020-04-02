/**
 * @Title: AuthorMapper.java Create on 2020年1月9日 上午10:27:44
 * @author: jiangyuanquan
 * @Description: TODO(用一句话描述该文件做什么)
 * @Package com.test
 * Copyright <a href="mailto:www.ekezhan.com">www.ekezhan.com</a> Corporation 2020
*/
	
package com.test;

import org.apache.ibatis.annotations.Mapper;

/**@Description: TODO
 * @author: jiangyuanquan 
 * @version: 2020年1月9日 上午10:27:44
*/
@Mapper
public interface AuthorMapper  {

    public Long insertAuthor(Author author);

    public void updateAuthor(Author author);

    public Author queryById(Long id);
    
}
