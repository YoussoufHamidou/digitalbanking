package org.sid.ebanckingbackend;

import org.sid.ebanckingbackend.entities.BankAccount;
import org.sid.ebanckingbackend.entities.CurrentAccount;
import org.sid.ebanckingbackend.entities.Customer;
import org.sid.ebanckingbackend.enums.AccountStatus;
import org.sid.ebanckingbackend.repositories.AccountOperationRepository;
import org.sid.ebanckingbackend.repositories.BankAccountRepository;
import org.sid.ebanckingbackend.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class EbanckingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbanckingBackendApplication.class, args);
	}

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository){
       return args -> {
           Stream.of("Hassan","Yassine","Aicha").forEach(name -> {
              Customer customer=new Customer();
              customer.setName (name);
              customer.setEmail(name+"@gmail.com");
              customerRepository.save(customer);
            });
           customerRepository.findAll().forEach(cust->{
               CurrentAccount currentAccount= new CurrentAccount();
               currentAccount.setBalance(Math.random()*9000);
               currentAccount.setCreatedAt(new Date());
               currentAccount.setStatus(AccountStatus.CREATED);
               currentAccount.setCustomer(cust);
               currentAccount.setOverDraft(9000);
               bankAccountRepository.save(currentAccount);
           });
       };
    }
}
