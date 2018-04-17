package com.zwq.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class HomeController {
    private static String ARTICLE_QUERYALLARTICLE = "http://localhost:8001/article/queryAllArticle";
    private static String ARTICLE_QUERYARTICLEBYAUTHOR = "http://localhost:8001/article/queryArticleByAuthor";
    private static String ARTICLE_QUERYARTICLEBYID = "http://localhost:8001/article/queryArticleById";
    private static String ARTICLE_SAVEARTICLE = "http://localhost:8001/article/saveArticle";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;

    @GetMapping("/home")
    public ModelAndView home(ModelAndView mv){
        mv.setViewName("/home");
        return mv;
    }
    @GetMapping("/index")
    public ModelAndView index(ModelAndView mv,Integer page,Integer rows){
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
        mv.addObject("result",result);
        mv.setViewName("/index");
        return mv;
    }
    @GetMapping("/article/{id}")
    public ModelAndView article(ModelAndView mv,@PathVariable Integer id){

        String params = String.valueOf(id);
        Object result = this.restTemplate
                .exchange(ARTICLE_QUERYARTICLEBYID + "/" + params, HttpMethod.GET,
                        new HttpEntity<Object>(this.headers), Object.class).getBody();
        mv.addObject("result",result);
        mv.setViewName("/article");
        return mv;
    }
}
