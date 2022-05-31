package com.evehiclemanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.evehiclemanagementsystem.entity.Enquiry;
import com.evehiclemanagementsystem.repository.EnquiryRepository;

@SpringBootTest
public class EnquiryServiceTest {
	
	@InjectMocks
	private EnquiryService enquiryService = new EnquiryServiceImpl();
	
	@Mock
	private EnquiryRepository enquiryRepository;
	
	@Test
	public void testGetEnquiryById() {
		
		Enquiry enquiry = new Enquiry();
		enquiry.setEnquiryId(100);
		enquiry.setQuery("how to book");
		enquiry.setResponse("visit our website https://vehicleservice.com");
		enquiry.setStatus("pending");
		
		Optional<Enquiry> optionalEnquiry = Optional.of(enquiry);
		
		when(enquiryRepository.findById(100)).thenReturn(optionalEnquiry);
		
		Enquiry myEnquiry = enquiryService.getById(100);
		
		assertEquals("how to book",myEnquiry.getQuery());
		
	
	
	
	
	}

}
