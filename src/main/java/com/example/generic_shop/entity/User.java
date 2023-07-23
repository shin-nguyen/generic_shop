package com.example.generic_shop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}
