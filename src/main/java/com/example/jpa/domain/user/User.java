//package com.example.jpa.domain.user;
//
//import com.example.jpa.domain.bookmark.BookMark;
//import com.example.jpa.enums.Role;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
//    private Long id;
//
//    @Column(name = "user_name")
//    private String name;
//
//    @Column(name = "user_role")
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    @OneToMany(mappedBy = "user")
//    @ToString.Exclude
//    private List<BookMark> bookMarks;
//
//    @Builder
//    public User(String name, Role role){
//        this.name = name;
//        this.role = role;
//    }
//
//
//
//}
