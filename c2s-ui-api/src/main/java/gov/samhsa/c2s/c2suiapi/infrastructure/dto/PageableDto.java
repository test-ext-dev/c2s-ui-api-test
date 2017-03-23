package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageableDto<T> {
    List<T> content;
    private int totalPages;
    private long totalElements;
    boolean last;
    private int size;
    int number;
    private int numberOfElements;
    boolean first;
}
