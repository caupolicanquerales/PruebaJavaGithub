package com.capo.pruebaJava.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {intersectionBetweenTwoCirclesImpl.class})
class intersectionBetweenTwoCirclesImplTest {
	
	private double a;
	private double b;
	private double c;
	private double discriminante;
	private int sing;
	private double c5=1.5;
	private double c6=-1;
	private double c7=2;
	private double c8=-3;
	private double c9=0.25;
	private Double[] arrayResult;
	private double valueX=-1;
	private double valueY=2.5;
	
	@Autowired
	intersectionBetweenTwoCirclesImpl intersectionBetweenTwoCircles;
	
	@BeforeEach
	void setUp() {
		a=1;
		b=4;
		c=3;
		discriminante=4;
		sing=1;
		arrayResult= new Double[]{c5,c6,c7,c8,c9};
	}
	
	@Test
	void intersectionPoints_Test() {
		Map<String,Double[]> result=intersectionBetweenTwoCircles.intersectionPoints(arrayResult);
		assertNotNull(result);
	}
	
	@Test
	void checkDiscriminante_Test() {
		double result=intersectionBetweenTwoCircles.checkDiscriminante(a,b,c);
		assertEquals(discriminante, result,0);
	}
	
	@Test
	void quadraticEquation_Test() {
		double result=intersectionBetweenTwoCircles.quadraticEquation(a,b,discriminante,sing);
		assertEquals(valueX, result,0);
	}
	
	@Test
	void getSecant_Test() {
		double result=intersectionBetweenTwoCircles.getSecant(arrayResult[0],arrayResult[1],valueX);
		assertEquals(valueY, result,0);
	}
}
