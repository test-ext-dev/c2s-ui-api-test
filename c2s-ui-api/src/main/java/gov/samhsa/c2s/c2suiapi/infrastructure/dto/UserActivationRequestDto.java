package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class UserActivationRequestDto {

    @NotBlank
    private String emailToken;
    @NotBlank
    private String verificationCode;

    @Past
    private LocalDate birthDate;

    @NotBlank
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$% !\"&'()*+,-./:;<=>?\\\\\\[\\]^_`{|}~]).{8,20})")
    private String password;

    @NotBlank
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$% !\"&'()*+,-./:;<=>?\\\\\\[\\]^_`{|}~]).{8,20})")
    private String confirmPassword;

    @NotBlank
    private String username;
}
