package com.sales.dto;

import com.sales.entity.CompanyEntity;
import com.sales.entity.ItemEntity;
import com.sales.entity.UserEntity;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PositionDTO {

    @NonNull
    private long id;

    @NonNull
    private ItemEntity itemEntity;

    @NonNull
    private CompanyEntity companyEntity;

    @NonNull
    private UserEntity createdBy;

    @NonNull
    private Date created;

    @NonNull
    private double amount;

    @NonNull
    private double minAmount;

    @Override
    public boolean equals(Object inputObject) {
        if (this == inputObject) return true;
        if (inputObject == null || getClass() != inputObject.getClass()) return false;
        PositionDTO positionDTO = (PositionDTO) inputObject;
        return id == positionDTO.id;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        int companyValue = companyEntity.hashCode() * 31;
        int userValue = createdBy.hashCode() * 31;
        result = 31 * result + userValue + companyValue;
        return result;
    }
}
