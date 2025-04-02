package com.learn.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBusinessImplStubTest {

	@Test
	void findTheGreatestFromData_multipleParam_test() {
		DataServiceStub service = new DataServiceStub();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(service);
		int result = businessImpl.findTheGreatestFromData();
		assertEquals(25, result);

	}
	
	@Test
	void findTheGreatestFromData_oneparam_test() {
		DataServiceOneStub service = new DataServiceOneStub();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(service);
		int result = businessImpl.findTheGreatestFromData();
		assertEquals(35, result);
	}
}

class DataServiceStub implements DataService{

	@Override
	public int[] retriveAllData() {
		return new int[] {25, 15, 3};
	}
	
}

class DataServiceOneStub implements DataService{

	@Override
	public int[] retriveAllData() {
		return new int[] {35};
	}
	
}
