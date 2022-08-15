package com.etiya.northwind.businessTests;

import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


public class SupplierManagerTest {

    @InjectMocks
    private SupplierRepository supplierRepository;


    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void test_by_id(){

    }
}
