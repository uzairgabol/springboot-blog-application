package com.uzairgabol.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min=4, message = "name must be at least 4 characters.")
    private String name;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min=3, max=10, message = "Password should be at least 3 character and under 10 characters.")
    private String password;

    private String about;
}
