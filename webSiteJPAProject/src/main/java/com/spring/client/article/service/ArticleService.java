package com.spring.client.article.service;

import com.spring.client.article.domain.Article;
import com.spring.client.board.domain.Board;

import java.util.List;

public interface ArticleService {
    public List<Article> articleList(Article article);
    public void articleInsert(Article article);
    public Article articleDetail(Article article);
    public Article updateForm(Article article);
    public void articleUpdate(Article article);
    public void articleDelete(Article article);
    public Article articleHitUpdate(Article article);
    public Article getArticle(Long no);
}
