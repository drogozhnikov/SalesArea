package com.sales.dto;

import com.sales.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ItemDTO {


    @NonNull
    private long id;

    @NonNull
    private String name;

    private String description;

    @NonNull
    private Date created;

    @NonNull
    private CategoryEntity categoryEntity;

    @Override
    public boolean equals(Object inputObject) {
        if (this == inputObject) return true;
        if (inputObject == null || getClass() != inputObject.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) inputObject;
        return id == itemDTO.id;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        int nameValue = name == null ? 0 : name.hashCode() * 31;
        result = 31 * result + nameValue;
        return result;
    }

}
