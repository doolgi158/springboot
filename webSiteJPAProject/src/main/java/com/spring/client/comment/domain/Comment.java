package com.spring.client.comment.domain;

import com.spring.client.article.domain.Article;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boot_comment")
@SequenceGenerator(name = "comment_generator",
    sequenceName = "boot_comment_seq",
    initialValue = 1,
    allocationSize = 1)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    private Long id;

    @Column
    private String nickname;

    @Column
    private String body;

    @CreationTimestamp
    @ColumnDefault(value = "sysdate")
    private LocalDateTime cdate;

    @ManyToOne  // Comment 엔티티와 Article 엔티티를 다대일 관계로 설정
    @JoinColumn(name="no")  // 외래키 생성, Article 엔티티의 기본키(no)와 매핑
    private Article article;    // 해당 댓글의 부모 게시
}
