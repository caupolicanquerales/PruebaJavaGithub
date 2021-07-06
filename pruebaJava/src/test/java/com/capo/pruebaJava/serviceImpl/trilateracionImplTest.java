package com.capo.pruebaJava.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capo.pruebaJava.dto.LatLng;
import com.capo.pruebaJava.dto.Position;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {trilateracionImpl.class})
class trilateracionImplTest {
	
	private LatLng location1;
	private LatLng location2;
	private LatLng location3;
	private Map<String,Double[]> intersectionPoints;
	private Double[] point;
	
	@Autowired
	private trilateracionImpl trilateracion; 
	
	@MockBean
	private squareEcuationIntersectionBetweenTwoCirclesImpl squareEcuationIntersectionBetweenTwoCircles;
	
	@MockBean
	private intersectionBetweenTwoCirclesImpl intersectionBetweenTwoCircles;
	
	@BeforeEach
	void setUp() {
		location1=new LatLng();
		location2=new LatLng();
		location3=new LatLng();
		location3.setDistance(3);
		location3.setX(2);
		location3.setY(2);
		intersectionPoints= new HashMap<>();
		intersectionPoints.put("point1",new Double[]{(double)0,(double)4});
		intersectionPoints.put("point2",new Double[]{(double)-4,(double)0});
		point=new Double[]{(double)0,(double)4};
	}
	
	@Test
	void trilateracion_Test() {
		when(squareEcuationIntersectionBetweenTwoCircles.getSquareEcuation(any(LatLng.class),any(LatLng.class))).thenReturn(new Double[] {}).thenReturn(new Double[] {}).thenReturn(new Double[] {});
		when(intersectionBetweenTwoCircles.intersectionPoints(any(Double[].class))).thenReturn(new HashMap<String, Double[]>()).thenReturn(new HashMap<String, Double[]>()).thenReturn(new HashMap<String, Double[]>());
		Position result=trilateracion.trilateracion(location1,location2,location3);
		assertNull(result);
	}
	
	@Test
	void intersectionPointsBetweenCircles() {
		when(squareEcuationIntersectionBetweenTwoCircles.getSquareEcuation(any(LatLng.class),any(LatLng.class))).thenReturn(new Double[] {});
		when(intersectionBetweenTwoCircles.intersectionPoints(any(Double[].class))).thenReturn(new HashMap<String, Double[]>());
		Map<String,Double[]> result=trilateracion.intersectionPoints(location1,location2);
		assertNotNull(result);
	}
	
	@Test
	void getCompareCirclePosition_Test() {
		List<Double[]> result=trilateracion.getCompareCirclePosition(location3,intersectionPoints);
		assertArrayEquals(point,result.get(0));
	}
}
