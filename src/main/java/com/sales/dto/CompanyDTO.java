package com.sales.dto;

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
public class CompanyDTO {

    @NonNull
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private Date created;

    @NonNull
    private String description;

    @Override
    public boolean equals(Object inputObject) {
        if (this == inputObject) return true;
        if (inputObject == null || getClass() != inputObject.getClass()) return false;
        CompanyDTO companyDTO = (CompanyDTO) inputObject;
        return id == companyDTO.id;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        int nameValue = name == null ? 0 : name.hashCode() * 31;
        int descriptionValue = description == null ? 0 : description.hashCode() * 31;
        result = 31 * result + descriptionValue + nameValue;
        return result;
    }
}
