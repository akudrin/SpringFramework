package com.amigoscode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class SpringBoot3AmigoscodeApplication {
    private final CustomerRepository customerRepository;

    public SpringBoot3AmigoscodeApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private static final Logger logger
            = LoggerFactory.getLogger(SpringBoot3AmigoscodeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3AmigoscodeApplication.class, args);
        logger.info("Example log from {}", SpringBoot3AmigoscodeApplication.class.getSimpleName());

    }

    @GetMapping("/greetings")
    public GreetResponse greet(){
        return new GreetResponse("Hello", List.of("Java","GO","Python"), new Person("Nick"));
    }

    record Person(String name){}
    record GreetResponse(String greet, List<String> favProgLanguages, Person person){}
    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    record NewCustomerRequest(String name, String email,Integer age){}
    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
    Customer customer = new Customer();
    customer.setName(request.name);
    customer.setEmail(request.email);
    customer.setAge(request.age);
    customerRepository.save(customer);
    }
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    public record CustomerUpdateRequest(String name, String email, Integer age) { }

    @PutMapping("{customerId}")
    public void deleteCustomer(
            @PathVariable("customerId") Integer customerId,
            @RequestBody CustomerUpdateRequest updateRequest) {
        Customer customer = customerRepository.getReferenceById(customerId);
        boolean changes = false;

        if (updateRequest.name() != null && !updateRequest.name().equals(customer.getName())) {
            customer.setName(updateRequest.name());
            changes = true;
        }

        if (updateRequest.age() != null && !updateRequest.age().equals(customer.getAge())) {
            customer.setAge(updateRequest.age());
            changes = true;
        }

        if (updateRequest.email() != null && !updateRequest.email().equals(customer.getEmail())) {
            /*
            if (customerRepository.(updateRequest.email())) {
                throw new DuplicateResourceException(
                        "email already taken"
                );
            }

             */
            customer.setEmail(updateRequest.email());
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("no data changes found");
        }

        customerRepository.save(customer);
    }
/*
 public boolean processCustomersByEmail (String email){
     Slice<Customer> slice = customerRepository.findAllByEmail(email,
             PageRequest.of(0,10));
     List<Customer> customersInBatch= slice.getContent();
     customersInBatch.forEach();
 }
*/
}
