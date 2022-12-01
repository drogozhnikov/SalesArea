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
public class PositionEntity {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

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
