package com.sales.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "created")
    private Date created;

    @NonNull
    @Column(name = "description")
    private String description;
}
