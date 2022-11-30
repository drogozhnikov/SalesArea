package com.sales.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "category")
public class Category {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_category")
    private Category parentCategory;

    @Column(name = "description")
    private String description;
}
