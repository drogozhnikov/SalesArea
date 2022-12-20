package com.sales.dto;

import com.sales.entity.CompanyEntity;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {

    @NonNull
    private long id;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String name;

    @NonNull
    private String role;

    @NonNull
    private Date created;

    @NonNull
    private Date updated;

    @NonNull
    private CompanyEntity companyEntity;

    @Override
    public boolean equals(Object inputObject) {
        if (this == inputObject) return true;
        if (inputObject == null || getClass() != inputObject.getClass()) return false;
        UserDTO userDTO = (UserDTO) inputObject;
        return id == userDTO.id;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        int nameValue = name == null ? 0 : name.hashCode() * 31;
        int userNameValue = username == null ? 0 : username.hashCode() * 31;
        int emailValue = email == null ? 0 : email.hashCode() * 31;
        result = 31 * result + userNameValue + nameValue + emailValue;
        return result;
    }
}
