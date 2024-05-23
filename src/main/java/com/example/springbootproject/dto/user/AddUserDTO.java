package com.example.springbootproject.dto.user;

import com.example.springbootproject.dto.base.AddBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddUserDTO extends AddBaseDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String family;

    @Positive
    private long nationalCode;

    @NotBlank
    private String gender;

    @NotNull
    private long birthDayTimeStamp;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
