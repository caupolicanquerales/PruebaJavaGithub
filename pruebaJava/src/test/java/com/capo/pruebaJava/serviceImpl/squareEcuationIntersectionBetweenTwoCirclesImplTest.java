package com.capo.pruebaJava.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capo.pruebaJava.dto.LatLng;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {squareEcuationIntersectionBetweenTwoCirclesImpl.class})
class squareEcuationIntersectionBetweenTwoCirclesImplTest {
	
	@Autowired
	squareEcuationIntersectionBetweenTwoCirclesImpl trilateracionService;
	
	private LatLng locationN;
	private LatLng locationZ;
	private double c1=-4;
	private double c3=-8;
	private double c4=-8;
	private double c5=1.5;
	private double c6=-1;
	private double c7=2;
	private double c8=-3;
	private double c9=0.25;
	private Double[] arrayResult;
	
	@BeforeEach
	void setUp() {
		locationN=new LatLng ();
		locationZ= new LatLng();
		locationN.setDistance(2);
		locationZ.setDistance(4);
		locationN.setX(2);
		locationN.setY(2);
		locationZ.setX(-2);
		locationZ.setY(-2);
		arrayResult= new Double[]{c5,c6,c7,c8,c9};
	}
	
	@Test
	void getSquareEcuation_Test() {
		Double[] result=trilateracionService.getSquareEcuation(locationN, locationZ);
		assertArrayEquals(arrayResult, result);
	}
	
	@Test
	void checkValueC1_Test() {
		double result=trilateracionService.getValueC1(locationN);
		assertEquals(c1, result);
	}
	
	@Test
	void checkValueC3_Test() {
		double result=trilateracionService.getValueC3(locationN,locationZ);
		assertEquals(c3, result);
	}
	
	@Test
	void checkValueC4_Test() {
		double result=trilateracionService.getValueC4(locationN,locationZ);
		assertEquals(c4, result);
	}
}
