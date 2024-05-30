package com.example.springbootproject.dto.user;

import com.example.springbootproject.dto.base.ViewBaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ViewUserDTO extends ViewBaseDTO {
    private String name;
    private String family;
    private long nationalCode;
    private String gender;
    private long birthDay;
    private String username;
}
