/**
 * @Title: AuthorDaoJdbcTemplateImpl.java Create on 2020年1月9日 上午10:22:38
 * @author: jiangyuanquan
 * @Description: TODO(用一句话描述该文件做什么)
 * @Package com.test
 * Copyright <a href="mailto:www.ekezhan.com">www.ekezhan.com</a> Corporation 2020
*/
	
package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**@Description: TODO
 * @author: jiangyuanquan 
 * @version: 2020年1月9日 上午10:22:38
*/
@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao{
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Override
    public int add(Author author) {
        String sql = "insert into t_author(id,real_name,nick_name) " +
                "values(:id,:realName,:nickName)";
        Map<String, Object> param = new HashMap<>();
        param.put("id",author.getId());
        param.put("realName", author.getRealName());
        param.put("nickName", author.getNickName());
        
        return (int) jdbcTemplate.update(sql, param);
    }

    @Override
    public int update(Author author) {  
        return 0;
    }

    @Override
    public int delete(Long id) {    
        return 0;
    }

    @Override
    public Author findAuthor(Long id) {
        return null;
    }

    @Override
    public List<Author> findAuthorList() {  
          return null;
    }
}
