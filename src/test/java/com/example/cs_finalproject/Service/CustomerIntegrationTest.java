package com.example.cs_finalproject.Service;
import com.example.cs_finalproject.model.Customer;
import com.example.cs_finalproject.model.Status;
import com.example.cs_finalproject.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerIntegrationTest {

    @LocalServerPort
    private int port;

    private String baseUrl;

    private static RestTemplate restTemplate;//is used for testing endpoint

    @Autowired
    private CustomerRepository customerRepository;


    @BeforeAll
    public static void init()  {
        restTemplate = new RestTemplate(); //initialize restTemplate
    }

    @BeforeEach
    public void beforeSetUP() {
        baseUrl ="http://localhost:" +":" +port+"/customer?statusId=1";
    }

    @AfterEach
    public void afterSetup() {
        customerRepository.deleteAll();//(clean up after running each test)
    }

    @Test
    void shouldCreateCustomerTest() {
        Status status1 = new Status();
        status1.setStatusName("VIP");

        Customer customer1 = new Customer();
        customer1.setFirstName("Pink");
        customer1.setLastName("Hansen");
        customer1.setAddress("Robert Jacobsens 60");
        customer1.setEmail("han@gmail.com");
        customer1.setStatus(status1);

        try {
        Customer newCustomer = restTemplate.postForObject(baseUrl, customer1, Customer.class);
        assertNotNull(newCustomer);
        assertThat(newCustomer.getId()).isNotNull();
            assertNotNull(newCustomer);
            assertThat(newCustomer.getId()).isNotNull();
            assertThat(newCustomer.getFirstName()).isEqualTo("Pink");
            assertThat(newCustomer.getLastName()).isEqualTo("Hansen");
            assertThat(newCustomer.getAddress()).isEqualTo("Robert Jacobsens 60");
            assertThat(newCustomer.getEmail()).isEqualTo("han@gmail.com");
            assertThat(newCustomer.getStatus()).isEqualTo(status1);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

}

