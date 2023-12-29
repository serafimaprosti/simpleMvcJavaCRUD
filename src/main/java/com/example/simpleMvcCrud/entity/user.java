package com.example.simpleMvcCrud.entity;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    @NotBlank(message = "cant be empty")
    @Size(min = 2, message = "min size 2 symbols")
    private String userName;

    @Column(name = "user_surname")
    @NotBlank(message = "cant be empty")
    @Size(min = 2, message = "min size 2 symbols")
    private String userSurname;

    @Column(name = "user_age")
    @Min(value = 12, message = "write correct age")
    private int userAge;

    @Column(name = "user_email")
    @Email(message = "write correct email")
    private String userEmail;

}
