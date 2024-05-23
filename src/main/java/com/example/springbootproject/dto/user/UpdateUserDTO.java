package com.example.springbootproject.dto.user;

import com.example.springbootproject.dto.base.UpdateBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UpdateUserDTO extends UpdateBaseDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String family;

    @NotBlank
    private String gender;

    @NotNull
    private Long birthDay;

    @NotBlank
    private String password;
}
