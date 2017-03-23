package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageableDto<T> {
    List<T> content;
    boolean first;
    boolean last;
    int number;
    private int numberOfElements;
    private int size;
    private long totalElements;
    private int totalPages;
}
