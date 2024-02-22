package com.example.jpa.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

public class Pagination {
    private boolean last;

    private boolean first;

    private Integer size;

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("current_page")
    private Integer currentPage;

    @JsonProperty("current_total_elements")
    private Integer currentTotalElements;

    @JsonProperty("total_elements")
    private Long totalElements;

    private boolean empty;

    public Pagination(Page<?> page) {
        if (page == null) {
            this.last = false;
            this.first = true;
            this.size = 0;
            this.totalPages = 0;
            this.totalElements = 0L;
            this.currentPage = 0;
            this.empty = true;
            this.currentTotalElements = 0;
        } else {
            this.last = page.isLast();
            this.totalPages = page.getTotalPages();
            this.totalElements = page.getTotalElements();
            this.currentPage = page.getNumber();
            this.first = page.isFirst();
            this.size = page.getSize();
            this.empty = page.isEmpty();
            this.currentTotalElements = page.getNumberOfElements();
        }
    }


}
