package com.etiya.northwind.business.responses.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParameterResponseSorting extends PageParametersResponse{
    private String fieldName;
    private boolean isAsc;
}
