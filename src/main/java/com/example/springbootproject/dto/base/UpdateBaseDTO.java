package com.example.springbootproject.dto.base;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBaseDTO {

    @NotNull
    private Long id;
}
