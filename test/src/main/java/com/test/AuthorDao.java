/**
 * @Title: AuthorDao.java Create on 2020年1月9日 上午10:22:02
 * @author: jiangyuanquan
 * @Description: TODO(用一句话描述该文件做什么)
 * @Package com.test
 * Copyright <a href="mailto:www.ekezhan.com">www.ekezhan.com</a> Corporation 2020
*/
	
package com.test;

import java.util.List;

/**@Description: TODO
 * @author: jiangyuanquan 
 * @version: 2020年1月9日 上午10:22:02
*/
public interface AuthorDao {

    int add(Author author);

    int update(Author author);

    int delete(Long id);

    Author findAuthor(Long id);

    List<Author> findAuthorList();
}
