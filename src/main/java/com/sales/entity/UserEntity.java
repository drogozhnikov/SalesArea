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
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;
}
