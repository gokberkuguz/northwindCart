package com.etiya.northwind.business.responses.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResultResponse<T> {
    List<T> response;
    int totalPage;
    long totalElements;
    int pageNumber;

}
