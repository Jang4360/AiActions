package com.aiactions.backend.subscribe.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SubscribeRequestDTO {
    @Email
    @NotBlank
    private String email;
}
