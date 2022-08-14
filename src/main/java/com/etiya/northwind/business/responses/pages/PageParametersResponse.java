package com.etiya.northwind.business.responses.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParametersResponse {
    private int pageNumber;
    private int objectAmountInPage;
}
