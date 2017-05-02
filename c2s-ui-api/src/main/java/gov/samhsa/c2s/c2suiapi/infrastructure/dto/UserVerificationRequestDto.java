package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class UserVerificationRequestDto {

    @NotBlank
    private String emailToken;

    private String verificationCode;

    @Past
    private LocalDate birthDate;
}
