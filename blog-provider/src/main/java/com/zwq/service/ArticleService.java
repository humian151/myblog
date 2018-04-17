package com.zwq.service;

import com.zwq.dao.ArticleInfDao;
import com.zwq.entity.ArticleInf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by DELL on 2018/4/12.
 */
public interface ArticleService {
    public Page<ArticleInf> queryAllArticle(Pageable pageable);

    public ArticleInf queryArticleById(Integer id);

    public Page<ArticleInf> queryArticleByAuthor(String author, Pageable pageable);

    public ArticleInf insertAriticle(ArticleInf articleInf);
}
