package com.zwq.dao;

import com.zwq.entity.ArticleInf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by DELL on 2018/4/12.
 */
public interface ArticleInfDao extends JpaRepository<ArticleInf,Integer>{
    @Query(value = "select t from ArticleInf t where author = :author and ispublish='1' order by createTime desc",
            countQuery = "select count(t) from ArticleInf t where author = :author and ispublish='1' order by createTime desc")
    public Page<ArticleInf> findByAuthor(String author, Pageable pageable);

    public ArticleInf findByIdAndIspublish(Integer id,String ispublish);
}
