package com.example.cs_finalproject.common;

import com.example.cs_finalproject.model.Customer;
import com.example.cs_finalproject.model.Status;
import com.example.cs_finalproject.model.User;
import com.example.cs_finalproject.repository.CustomerRepository;
import com.example.cs_finalproject.repository.StatusRepository;
import com.example.cs_finalproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitialData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    public InitialData(CustomerRepository customerRepository, StatusRepository statusRepository, UserRepository userRepository) {
this.customerRepository = customerRepository;
this.statusRepository = statusRepository;
this.userRepository = userRepository;
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

User user1 = new User("Coco", "Hansen", "coco@gmail.com", "hhii");
User user2 = new User("Kate", "Champman","kach@gmail.com", "katkat");
User user3 = new User("Hana", "Moss","hana@gmail.com", "hanmo");
userRepository.save(user1);
userRepository.save(user2);
userRepository.save(user3);

    }
}
