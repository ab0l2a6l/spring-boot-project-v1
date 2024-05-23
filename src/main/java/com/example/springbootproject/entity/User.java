package com.example.springbootproject.entity;

import com.example.springbootproject.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@MappedSuperclass
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String family;

    @Column(unique = true, nullable = false)
    private long nationalCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date birthDay;

    @Column(unique = true, updatable = false, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}
