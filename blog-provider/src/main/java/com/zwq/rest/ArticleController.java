package com.zwq.rest;

import com.zwq.entity.ArticleInf;
import com.zwq.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/queryAllArticle")
    public Page<ArticleInf> queryAllArticle(Integer page,Integer rows){
        if(page ==null){
            page = 1;
        }
        if (rows ==null){
            rows = 10;
        }
        Pageable pageable = new PageRequest(page-1, rows, new Sort(Sort.Direction.DESC,"createTime"));
        return articleService.queryAllArticle(pageable);
    }
    @GetMapping("/queryArticleByAuthor")
    public Page<ArticleInf> queryArticleByAuthor(Integer page,Integer rows,String author){
        if(page ==null){
            page = 1;
        }
        if (rows ==null){
            rows = 10;
        }
        Pageable pageable = new PageRequest(page-1, rows, new Sort(Sort.Direction.DESC,"createTime"));
        return articleService.queryArticleByAuthor(author,pageable);
    }

    @GetMapping("/queryArticleById/{id}")
    public ArticleInf queryArticleById(@PathVariable Integer id){
        return articleService.queryArticleById(id);
    }

    @PostMapping(value = "/saveArticle",consumes = "application/json")
    public boolean saveArticle(@RequestBody ArticleInf articleInf){
        try {
            articleService.insertAriticle(articleInf);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
