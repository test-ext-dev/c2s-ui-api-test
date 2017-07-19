package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

import java.util.Date;


@Data
public class UserProfileSelfServiceEditDto {
    private UmsAddressDto homeAddress;

    private String homeEmail;

    private String homePhone;

    private String lastUpdatedBy;
}
