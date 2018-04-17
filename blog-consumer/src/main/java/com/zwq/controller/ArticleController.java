package com.zwq.controller;

import com.zwq.entity.ArticleInf;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private static String ARTICLE_QUERYALLARTICLE = "http://localhost:8001/article/queryAllArticle";
    private static String ARTICLE_QUERYARTICLEBYAUTHOR = "http://localhost:8001/article/queryArticleByAuthor";
    private static String ARTICLE_QUERYARTICLEBYID = "http://localhost:8001/article/queryArticleById";
    private static String ARTICLE_SAVEARTICLE = "http://localhost:8001/article/saveArticle";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;

    @GetMapping("/queryAllArticle")
    public Object queryAllArticle(Integer page,Integer rows){
        if(page ==null){
            page = 1;
        }
        if (rows ==null){
            rows = 10;
        }
        String params = "page="+page+"&rows="+rows;
        Object result = this.restTemplate
                .exchange(ARTICLE_QUERYALLARTICLE + "?" + params, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), Object.class).getBody();
        return result;
    }
    @GetMapping("/queryArticleByAuthor")
    public Object queryArticleByAuthor(Integer page,Integer rows,String author){
        if(page ==null){
            page = 1;
        }
        if (rows ==null){
            rows = 10;
        }
        String params = "page="+page+"&rows="+rows+"&author="+author;
        Object result = this.restTemplate
                .exchange(ARTICLE_QUERYARTICLEBYAUTHOR + "?" + params, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), Object.class).getBody();
        return result;
    }
    @GetMapping("/queryArticleById/{id}")
    public Object queryArticleById(@PathVariable Integer id){

        String params = String.valueOf(id);
        Object result = this.restTemplate
                .exchange(ARTICLE_QUERYARTICLEBYID + "/" + params, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), Object.class).getBody();
        return result;
    }

    @GetMapping("/saveArticle")
    public boolean saveArticle(@RequestBody ArticleInf articleInf){
        Boolean flag = this.restTemplate
                .exchange(ARTICLE_SAVEARTICLE,HttpMethod.POST,new HttpEntity<Object>(articleInf,this.headers), Boolean.class)
                .getBody();
        return flag;
    }
}
