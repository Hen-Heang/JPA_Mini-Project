package com.example.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookmarks")
public class BookMark {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
