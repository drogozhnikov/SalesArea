package com.sales.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "role")
    private String role;

    @NonNull
    @Column(name = "created")
    private Date created;

    @NonNull
    @Column(name = "updated")
    private Date updated;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
