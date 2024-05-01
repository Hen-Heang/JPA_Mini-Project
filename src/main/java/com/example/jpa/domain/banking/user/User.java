package com.example.jpa.domain.banking.user;



import com.example.jpa.domain.banking.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(unique = true, nullable = false)
    private String nationalCardId;

    @Column(nullable = false)
    private Integer pin;

    @Column(unique = true, nullable = false, length = 30)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    private String image;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 8)
    private String gender;

    private LocalDate dob;

    @Column(length = 100)
    private String cityOrProvince;

    @Column(length = 100)
    private String sangkatOrCommune;

    @Column(length = 100)
    private String village;

    @Column(length = 100)
    private String street;

    @Column(length = 100)
    private String position;

    @Column(length = 100)
    private String companyName;

    @Column(length = 100)
    private String mainSourceIncome;

    private BigDecimal monthlyIncomeRange;

    @Column(unique = true)
    private String oneSignalId;

    @Column(unique = true)
    private String studentIdCard;


    private Boolean isDeleted;  //manage for delete status(admin want to disable or remove an account)
    private Boolean isBlocked;  //manage block status (when is bad action happened)

    private Boolean isStudent;
    @OneToMany(mappedBy = "user")
    private List<UserAccount> userAccountList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

    private Boolean isAccountNonExpired;

    private Boolean isCredentialsNonExpired;

    private Boolean isAccountNonLocked;

    private LocalDateTime createAt;


}
