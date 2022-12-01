package com.sales.dto;

import com.sales.entity.CategoryEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryDTO {

    @NonNull
    private long id;

    @NonNull
    private String name;

    private CategoryEntity parentCategoryEntity;

    private String description;

    @Override
    public boolean equals(Object inputObject) {
        if (this == inputObject) return true;
        if (inputObject == null || getClass() != inputObject.getClass()) return false;
        CategoryDTO categoryDTO = (CategoryDTO) inputObject;
        return id == categoryDTO.id;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        int nameValue = name == null ? 0 : name.hashCode() * 31;
        result = 31 * result + nameValue;
        return result;
    }

}
