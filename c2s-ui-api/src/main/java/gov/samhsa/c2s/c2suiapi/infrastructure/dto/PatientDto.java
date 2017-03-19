package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private String address;
    @Past
    private Date birthDate;
    private String city;
    @NotBlank
    @Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*?\\.[a-zA-Z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$")
    private String email;
    private String enterpriseIdentifier;
    @NotBlank
    private String firstName;
    @NotBlank
    private String genderCode;
    @NotNull
    private Long id;
    @NotBlank
    private String lastName;
    private String medicalRecordNumber;
    private String resourceIdentifier;
    private String socialSecurityNumber;
    private String stateCode;
    private String telephone;
    private String zip;
}