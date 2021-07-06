package com.capo.pruebaJava.serviceImpl;

import org.springframework.stereotype.Service;

import com.capo.pruebaJava.dto.LatLng;
import com.capo.pruebaJava.service.squareEcuationIntersectionBetweenTwoCirclesService;

@Service
public class squareEcuationIntersectionBetweenTwoCirclesImpl implements squareEcuationIntersectionBetweenTwoCirclesService {

	@Override
	public Double[] getSquareEcuation(LatLng locationN, LatLng locationZ) {
		double c1 =getValueC1(locationN);
		double c2 =getValueC1(locationZ);
		double c3 =getValueC3(locationN,locationZ);
		double c4 =getValueC4(locationN,locationZ);
		double c5 = (c1 - c2) / c4;
		double c6 = -c3 / c4;
		double c7 = 1 + Math.pow(c6, 2);
		double c8 = (2 * c6) * c5 - (2 * locationN.getX()) - (2 * locationN.getY() * c6);
		double c9 = Math.pow(c5, 2) - ((2 * locationN.getY()) * c5) - c1;
		return new Double[] {c5,c6,c7,c8,c9};
	}
	
	@Override
	public double getValueC1(LatLng location) {
		return Math.pow(location.getDistance(), 2) - Math.pow(location.getX(), 2)
				- Math.pow(location.getY(), 2);
	}
	
	@Override
	public double getValueC3(LatLng locationN, LatLng locationZ) {
		return  (2 * locationZ.getX()) - (2 * locationN.getX());
	}
	
	@Override
	public double getValueC4(LatLng locationN, LatLng locationZ) {
		return (2 * locationZ.getY()) - (2 * locationN.getY());
	}
	
}
