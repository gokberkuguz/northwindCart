package com.etiya.northwind.businessTests;

import com.etiya.northwind.business.concretes.CustomerManager;
import com.etiya.northwind.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.mapping.ModelMapperManager;
import com.etiya.northwind.core.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerManagerTest {
    ModelMapperService modelMapperService;
    CustomerRepository mockCustomerRepository;
    CustomerManager customerManager;
    List<Customer> customers;

    @BeforeEach
    void setup(){
        modelMapperService = new ModelMapperManager(new ModelMapper());
        mockCustomerRepository = mock(CustomerRepository.class);
        customerManager = new CustomerManager(mockCustomerRepository, modelMapperService);
        customers = new ArrayList<Customer>();
    }

    @Test
    void getByIdTest_whenCustomerIdExists_shouldReturnCustomerWithThatId() {
        Customer customer = new Customer("AAAA","aa","aa","aa"
                ,new ArrayList<Order>(),new Country(),new City(),new ArrayList<Cart>());

        when(mockCustomerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));


        Executable executable = () -> this.customerManager.getById(customer.getCustomerId());

        Assertions.assertThrows(BusinessException.class,executable);
    }


}
