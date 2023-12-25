package com.example.cs_finalproject.common;

import com.example.cs_finalproject.model.Customer;
import com.example.cs_finalproject.model.Status;
import com.example.cs_finalproject.repository.CustomerRepository;
import com.example.cs_finalproject.repository.RoleRepository;
import com.example.cs_finalproject.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitialData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final StatusRepository statusRepository;
//    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public InitialData(CustomerRepository customerRepository, StatusRepository statusRepository, RoleRepository roleRepository) {
this.customerRepository = customerRepository;
this.statusRepository = statusRepository;
this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

Status status1 = new Status("VIP");
Status status2 = new Status("semi-VIP");
statusRepository.save(status1);
statusRepository.save(status2);


Customer customer1 = new Customer("Alice", "Jensen", "Rosenbogate, 80", "hi@gmail.com ", status1);
Customer customer2 = new Customer("Bill", "Joe", "RobertJacobsensVej, 10", "jo@gmail.com ", status2);
Customer customer3 = new Customer("Mike", "Hall", "ArneJacobsensVej, 35",  "mimi@gmail.com ", status1);
customerRepository.save(customer1);
customerRepository.save(customer2);
customerRepository.save(customer3);

//Role role1 = new Role ("General");
//Role role2 = new Role("Admin");
//roleRepository.save(role1);
//roleRepository.save(role2);
//
//User user1 = new User( "Hansen", "coco@gmail.com", "hhii", role1);
//User user2 = new User( "Champman","kach@gmail.com", "katkat", role2);
//User user3 = new User( "Moss","hana@gmail.com", "hanmo", role1);
//userRepository.save(user1);
//userRepository.save(user2);
//userRepository.save(user3);

    }
}
