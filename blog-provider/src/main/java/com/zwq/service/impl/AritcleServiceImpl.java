package com.zwq.service.impl;

import com.zwq.dao.ArticleInfDao;
import com.zwq.entity.ArticleInf;
import com.zwq.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DELL on 2018/4/12.
 */
@Service
public class AritcleServiceImpl implements ArticleService{
    @Autowired
    ArticleInfDao articleInfDao;
    @Override
    public Page<ArticleInf> queryAllArticle(Pageable pageable) {
        ArticleInf articleInf = new ArticleInf();
        articleInf.setIspublish("1");
        Example<ArticleInf> example = Example.of(articleInf);
        return articleInfDao.findAll(example,pageable);
    }

    @Override
    public ArticleInf queryArticleById(Integer id) {
        return articleInfDao.findByIdAndIspublish(id,"1");
    }

    @Override
    public Page<ArticleInf> queryArticleByAuthor(String author,Pageable pageable) {
        return articleInfDao.findByAuthor(author,pageable);
    }

    @Transactional
    @Override
    public ArticleInf insertAriticle(ArticleInf articleInf) {
        return articleInfDao.save(articleInf);
    }
}
