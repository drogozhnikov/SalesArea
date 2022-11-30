package com.sales.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "position")
public class Position {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @NonNull
    @Column(name = "created")
    private Date created;

    @NonNull
    @Column(name = "amount")
    private double amount;

    @NonNull
    @Column(name = "min_amount")
    private double minAmount;
}
