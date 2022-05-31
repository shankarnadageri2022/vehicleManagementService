package com.evehiclemanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.ServiceNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.evehiclemanagementsystem.entity.ServiceList;

import com.evehiclemanagementsystem.repository.ServiceListRepository;

@SpringBootTest
public class VehicleServiceTest {
	
	@InjectMocks
	private VehicleService verchileService=new VehicleServiceImpl();
	
	@Mock
	private ServiceListRepository serviceListRepository;
	
	@Test
	public void testGetAllService() {
		
		ServiceList serviceList=new ServiceList();
		serviceList.setServiceId(100);
		serviceList.setServiceName("battery replacement");
		serviceList.setPrice(2340.00);
		

		
		when(serviceListRepository.findByServiceName("battery replacement")).thenReturn(serviceList);
		
		ServiceList myServiceList = verchileService.getServiceListByName("battery replacement");
		
		assertEquals("battery replacement", myServiceList.getServiceName());
		
		
		
	}
	
//	@Test
//	public void TestGetServiceByNameWithException() {
//		
//		when(serviceListRepository.findByServiceName("battery Replacement")).thenThrow(ServiceNotFoundException.class);
//		
//		assertThrows(ServiceNotFoundException.class, ()->verchileService.getServiceListByName("battery replacement"));
//	}
	
	@Test
	public void testGetAllServiceList() {
		
		ServiceList serviceList1=new ServiceList();
		serviceList1.setServiceId(1);
		serviceList1.setServiceName("Clutch repair");
		serviceList1.setPrice(4000.0);
		
		ServiceList serviceList2=new ServiceList();
		serviceList2.setServiceId(2);
		serviceList2.setServiceName("battery Replacement");
		serviceList2.setPrice(4000.0);
		
		List<ServiceList> newServiceList=new ArrayList<>();
		newServiceList.add(serviceList1);
		newServiceList.add(serviceList2);
		
		when(serviceListRepository.findAll()).thenReturn(newServiceList);
		List<ServiceList> serviceList=verchileService.getAllService();
		
		assertEquals(2,newServiceList.size());
		
			
	}
	
	

}
