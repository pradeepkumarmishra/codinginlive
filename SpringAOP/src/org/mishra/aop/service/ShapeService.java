package org.mishra.aop.service;

import org.mishra.aop.model.Circle;
import org.mishra.aop.model.Triangle;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;

	public Circle getCircle() {
		return circle;
	}

	@Loggable
	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
