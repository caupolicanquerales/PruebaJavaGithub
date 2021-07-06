package com.capo.pruebaJava.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.capo.pruebaJava.service.intersectionBetweenTwoCirclesService;

@Service
public class intersectionBetweenTwoCirclesImpl implements intersectionBetweenTwoCirclesService{
	
	
	@Override
	public Map<String, Double[]> intersectionPoints(Double[] values) {
		Map<String, Double[]> intersetionPoints= new HashMap<>();
		if (values[2] != 0) {
			double discriminante = checkDiscriminante(values[2], values[3], values[4]);
			double valueX1 = quadraticEquation(values[2], values[3], discriminante, 1);
			double valueX2 = quadraticEquation(values[2], values[3], discriminante, -1);
			double valueY1 = getSecant(values[0], values[1], valueX1);
			double valueY2 = getSecant(values[0], values[1], valueX2);
			intersetionPoints.put("point1",new Double[] {valueX1,valueY1});
			intersetionPoints.put("point2",new Double[] {valueX2,valueY2} );
		}
		return intersetionPoints;
	}
	
	@Override
	public double checkDiscriminante(double a, double b, double c) {
		double var = Math.pow(b, 2) - (4 * a * c);
		if (var >= 0) {
			return var;
		}
		return 0;
	}

	@Override
	public double quadraticEquation(double a, double b, double discriminante, int sing) {
		return (-b + sing * (Math.sqrt(discriminante))) / (2 * a);
	}
	
	@Override
	public double getSecant(double c5, double c6, double valueX) {
		return (c6 * valueX) + c5;
	}

}
