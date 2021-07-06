package com.capo.pruebaJava.service;

import java.util.List;
import java.util.Map;

import com.capo.pruebaJava.dto.LatLng;
import com.capo.pruebaJava.dto.Position;

public interface trilateracionService {
	public Position trilateracion(LatLng location1, LatLng location2, LatLng location3);
	public Map<String, Double[]> intersectionPoints(LatLng locationN, LatLng locationZ);
	public List<Double[]> getCompareCirclePosition(LatLng location,Map<String, Double[]> mapPoint);
}
