package com.example.jpa.domain.post;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titele",length = 50, nullable = false)
    private String title;

    @Column(name = "des", length = 500, nullable = false)
    private String description;

    @Builder()
    public Post(String title, String description){
        this.title = title;
        this.description=description;
    }

}
