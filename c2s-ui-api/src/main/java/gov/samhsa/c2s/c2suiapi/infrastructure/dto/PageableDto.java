package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageableDto<T> {
    List<T> content;
    boolean last;
    private long totalElements;
    private int totalPages;
    private int size;
    int number;
    boolean first;
    private int numberOfElements;
}
