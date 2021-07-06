package com.capo.pruebaJava.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capo.pruebaJava.dto.LatLng;
import com.capo.pruebaJava.dto.Position;
import com.capo.pruebaJava.service.intersectionBetweenTwoCirclesService;
import com.capo.pruebaJava.service.squareEcuationIntersectionBetweenTwoCirclesService;
import com.capo.pruebaJava.service.trilateracionService;
import java.util.stream.Collectors;

@Service
public class trilateracionImpl implements trilateracionService  {
	
	@Autowired
	private squareEcuationIntersectionBetweenTwoCirclesService squareEcuationIntersectionBetweenTwoCircles;
	
	@Autowired
	private intersectionBetweenTwoCirclesService intersectionBetweenTwoCircles;
	
	@Override
	public Position trilateracion(LatLng location1, LatLng location2, LatLng location3) {
		Map<String, Double[]> getPoint1and2=intersectionPoints(location1,location2);
		Map<String, Double[]> getPoint1and3=intersectionPoints(location1,location3);
		Map<String, Double[]> getPoint2and3=intersectionPoints(location2,location3);
		return null;
	}
	
	@Override
	public Map<String, Double[]> intersectionPoints(LatLng locationN, LatLng locationZ) {
		Double[] values=squareEcuationIntersectionBetweenTwoCircles.getSquareEcuation(locationN, locationZ);
		return intersectionBetweenTwoCircles.intersectionPoints(values);
	}
	
	@Override
	public List<Double[]> getCompareCirclePosition(LatLng location,Map<String, Double[]> mapPoint) {
		return mapPoint.entrySet().stream().filter(data->getCheckPoint(data.getValue()[0],data.getValue()[1],location))
				.map(Map.Entry::getValue).collect(Collectors.toList());
	}
	private  boolean getCheckPoint(double x, double y, LatLng locationN) {
		 double a=Math.sqrt(Math.abs(Math.pow(x - locationN.getX(), 2) + Math.pow(y - locationN.getY(), 2)));
		 return a<= locationN.getDistance();
	}
}
