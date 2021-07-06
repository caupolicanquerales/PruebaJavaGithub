package com.capo.pruebaJava.service;

import java.util.Map;

public interface intersectionBetweenTwoCirclesService {
	public double checkDiscriminante(double a, double b, double c);
	public double quadraticEquation(double a, double b, double discriminante, int sing);
	public double getSecant(double c5, double c6, double valueX);
	public Map<String, Double[]> intersectionPoints(Double[] arrayResult);
}
