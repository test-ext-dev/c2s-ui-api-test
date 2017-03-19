package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

@Data
public class PlsFlattenedSmallProviderDto {
    private String entityTypeCode;
    private String entityTypeDisplayName;
    private String enumerationDate;
    private String firstLinePracticeLocationAddress;
    private String firstName;
    private String genderCode;
    private String lastName;
    private String lastUpdateDate;
    private String middleName;
    private String npi;
    private String organizationName;
    private String practiceLocationAddressCityName;
    private String practiceLocationAddressCountryCode;
    private String practiceLocationAddressFaxNumber;
    private String practiceLocationAddressPostalCode;
    private String practiceLocationAddressStateName;
    private String practiceLocationAddressTelephoneNumber;
    private String secondLinePracticeLocationAddress;
}
