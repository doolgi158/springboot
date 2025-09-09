package com.spring.client.article.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.client.article.domain.Article;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByTitle(String title);

    List<Article> findByTitleContaining(String title);
    List<Article> findByNameContaining(String name);
    List<Article> findByContentContaining(String content);

    List<Article> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Article> findByOrderByNoDesc();

    Page<Article> findAll(Pageable pageable);

    Page<Article> findByTitleContaining(String title, Pageable pageable);
    Page<Article> findByNameContaining(String name, Pageable pageable);
    Page<Article> findByContentContaining(String content, Pageable pageable);

    Page<Article> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    @Query("SELECT a FROM Article a")
    public List<Article> articleList();

    @Query("SELECT a FROM Article a WHERE a.no = ?1")
    public Article articleDetail(Long no);

    @Query("SELECT a FROM Article a")
    public Page<Article> articleListPaging(Pageable pageable);

    @Query(value = "SELECT NO, NAME, TITLE, CONTENT, HIT, REG_DATE FROM BOOT_ARTICLE ORDER BY NO DESC", nativeQuery = true)
    public List<Article> articleAllList();
}
