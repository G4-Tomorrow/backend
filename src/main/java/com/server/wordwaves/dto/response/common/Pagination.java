package com.server.wordwaves.dto.response.common;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pagination {
    int pageNumber;
    int pageSize;
    int totalPages;
    long totalElements;
}