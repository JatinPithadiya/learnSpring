package com.learn.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

	@Mock
	private DataService service;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;
	
	@Test
	void findTheGreatestFromData_multipleParam_test() {
		
		when(service.retriveAllData()).thenReturn(new  int[]{25, 15, 10});
		assertEquals(25, businessImpl.findTheGreatestFromData());

	}
	
	@Test
	void findTheGreatestFromData_oneParam_test() {
		
		when(service.retriveAllData()).thenReturn(new int[] {35});
		assertEquals(35, businessImpl.findTheGreatestFromData());
	}
}

