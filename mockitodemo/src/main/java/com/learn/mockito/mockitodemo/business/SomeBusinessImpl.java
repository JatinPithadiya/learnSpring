package com.learn.mockito.mockitodemo.business;

public class SomeBusinessImpl {
	
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}



	public int findTheGreatestFromData() {
		
		int[] data = dataService.retriveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value:data) {
			if(value>greatestValue) {
				greatestValue = value;
			}
		}
		return greatestValue;
	}
	

}

interface DataService{
	int[] retriveAllData();
}