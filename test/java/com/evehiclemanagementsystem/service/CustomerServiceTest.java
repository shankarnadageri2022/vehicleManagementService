package com.evehiclemanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.evehiclemanagementsystem.entity.Customer;
import com.evehiclemanagementsystem.exception.CustomerNotFoundException;
import com.evehiclemanagementsystem.repository.CustomerRepository;

@SpringBootTest
public class CustomerServiceTest {
	@InjectMocks
	private CustomerService customerService=new CustomerServiceImpl();
	@Mock
	private CustomerRepository customerRepository;

	@Test
	public void testCustomerById() {

		Customer customer = new Customer();
		customer.setCustomerName("shankar");
		customer.setCustomerAddress("Bangalore");
		customer.setCustomerEmail("shankar@gmail.com");
		customer.setCustomerId(100);
		customer.setCustomerPhone(12345678);
		customer.setCustomerUserName("shankar123");
		customer.setCustomerPassword("shankar123");

		Optional<Customer> optionalCustomer = Optional.of(customer);
		when(customerRepository.findById(100)).thenReturn(optionalCustomer);
		Customer myCustomer = customerService.getById(100);
		assertEquals("shankar", myCustomer.getCustomerName());

	}
	
	@Test
    public void testGetCustomerByIdException() {
    	when(customerRepository.findById(1000)).thenThrow(CustomerNotFoundException.class);
    	assertThrows(CustomerNotFoundException.class,()->customerService.getById(1000));
    }
	
	
}
