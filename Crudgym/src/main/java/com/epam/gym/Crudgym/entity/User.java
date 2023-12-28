package com.epam.gym.Crudgym.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String firstname;

    @Getter
    @Setter
    @Column(nullable = false)
    private String lastname;

    @Getter
    @Setter
    @Column(nullable = true)
    private String username;

    @Getter
    @Setter
    @Column(nullable = true)
    private String password;

    @Getter
    @Setter
    @Column(nullable = false)
    private Boolean IsActive;

}
