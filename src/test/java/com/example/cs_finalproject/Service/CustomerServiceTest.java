package com.example.cs_finalproject.Service;

import com.example.cs_finalproject.model.Customer;
import com.example.cs_finalproject.model.Status;
import com.example.cs_finalproject.repository.CustomerRepository;
import com.example.cs_finalproject.repository.StatusRepository;
import com.example.cs_finalproject.service.CustomerService;
import com.example.cs_finalproject.service.StatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private StatusService statusService;

    @Mock
    private StatusRepository statusRepository;

    private Integer id;
    private Customer customer;

    private Integer statusId;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository, statusService);
        Status statusId1 = new Status("VIP");
        customer = new Customer("Suzu", "Hirose", "Rosenborgade,80", "suzuH@gmail.com", statusId1);
    }

    @Test
    void getAllCustomer() {
        customerService.getAllCustomer();
        Mockito.verify(customerRepository).findAll();
    }

    @Test
    void getCustomerById() {
        customerService.getCustomerById(id);
        Mockito.verify(customerRepository).findById(id);
    }

    @Test
    void createCustomer() {
        customerService.createCustomer(customer, statusId);
        ArgumentCaptor<Customer> CustomerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        Mockito.verify(customerRepository).save(CustomerArgumentCaptor.capture());
        Customer capturedCustomer = CustomerArgumentCaptor.getValue();
        assertThat(capturedCustomer).isEqualTo(customer);
    }

    @Test
    void deleteCustomerById() {
        customerService.deleteCustomer(id);
        Mockito.verify(customerRepository).deleteById(id);
    }

    @Test
    void updateCustomer() {
        //given precondition or setup
        customer.setFirstName("Helen");
        customer.setEmail("hee@gmail.com");

        Mockito.when(customerRepository.findById(id)).thenReturn(Optional.ofNullable(customer));
        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
        //action or the behaviour that we are going to test
        Customer updateCustomer = customerService.updateCustomer(id, customer);

        //verify the output
        assertThat(updateCustomer.getFirstName()).isEqualTo("Helen");
        assertThat(updateCustomer.getEmail()).isEqualTo("hee@gmail.com");
    }

}

