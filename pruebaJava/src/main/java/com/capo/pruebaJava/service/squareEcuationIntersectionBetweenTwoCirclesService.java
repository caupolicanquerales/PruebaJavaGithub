package com.capo.pruebaJava.service;

import com.capo.pruebaJava.dto.LatLng;

public interface squareEcuationIntersectionBetweenTwoCirclesService {
	
	public Double[] getSquareEcuation(LatLng locationN, LatLng locationZ);
	public double getValueC1(LatLng locationN);
	public double getValueC3(LatLng locationN, LatLng locationZ);
	public double getValueC4(LatLng locationN, LatLng locationZ);
}
