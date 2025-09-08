package com.spring.client.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.client.article.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
