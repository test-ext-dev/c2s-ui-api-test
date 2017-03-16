package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

@Data
public class ValueSetCategoryDto {

    /**
     * The code.
     */
    private String code;
    /**
     * The description.
     */
    private String description;
    /**
     * The display name.
     */
    private String displayName;
    /**
     * The displayOrder.
     */
    private int displayOrder;
    /**
     * The isFederal.
     */
    private boolean isFederal;
}