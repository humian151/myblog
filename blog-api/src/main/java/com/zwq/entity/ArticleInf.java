package com.zwq.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by DELL on 2018/4/12.
 */
@Entity
public class ArticleInf implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modiTime;
    private String title;
    private String author;
    private String ispublish;
    private String link;

    @OneToMany(fetch = FetchType.EAGER,targetEntity = ArticlelistInf.class,cascade =      //单项一对多配置
            {
                    CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE
            })
    @Fetch(FetchMode.SELECT)
    @JoinColumns(value={@JoinColumn(name="articleId",referencedColumnName="id")})   //对应关系 Pid = id
    private Set<ArticlelistInf> articlelistInfList;

    @OneToMany(fetch = FetchType.EAGER,targetEntity = AuthorInf.class,cascade =      //单项一对多配置
            {
                    CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE
            })
    @Fetch(FetchMode.SELECT)
    @JoinColumns(value={@JoinColumn(name="author",referencedColumnName="author")})   //对应关系 Pid = id
    private Set<AuthorInf> authorInfs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModiTime() {
        return modiTime;
    }

    public void setModiTime(Date modiTime) {
        this.modiTime = modiTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIspublish() {
        return ispublish;
    }

    public void setIspublish(String ispublish) {
        this.ispublish = ispublish;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<ArticlelistInf> getArticlelistInfList() {
        return articlelistInfList;
    }

    public void setArticlelistInfList(Set<ArticlelistInf> articlelistInfList) {
        this.articlelistInfList = articlelistInfList;
    }

    public Set<AuthorInf> getAuthorInfs() {
        return authorInfs;
    }

    public void setAuthorInfs(Set<AuthorInf> authorInfs) {
        this.authorInfs = authorInfs;
    }
}
