package com.learn.mockito.mockitodemo.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ListTest {
	
	@Mock
	List list;
	
	@Test
	void simpleTest() {
		when(list.size()).thenReturn(3);
		assertEquals(3, list.size());
		
	}
	
	@Test
	void multipleReturn() {
		when(list.size()).thenReturn(1).thenReturn(2);
		assertEquals(1, list.size());
		assertEquals(2, list.size());
		assertEquals(2, list.size());
	}
	
	@Test
	void parameters() {
		when(list.get(0)).thenReturn("SomeString");
		assertEquals("SomeString", list.get(0));
		assertEquals(null, list.get(1));
	}
	
	void genericParameters() {
		when(list.get(Mockito.anyInt())).thenReturn("SomeString");
		assertEquals("SomeString", list.get(3));
		assertEquals("SomeString", list.get(5));
	}

}
