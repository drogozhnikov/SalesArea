package com.sales.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "item")
public class Item {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "created")
    private Date created;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
