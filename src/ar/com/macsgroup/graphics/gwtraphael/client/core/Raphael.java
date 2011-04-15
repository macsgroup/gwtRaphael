/*
 * Copyright 2011 MacsGroup  (support@macsgroup.com.ar)
 *
 * This file is part of GWTRaphael.
 *
 * GWTRaphael is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GWTRaphael.  If not, see <http://www.gnu.org/licenses/>.
 */
package ar.com.macsgroup.graphics.gwtraphael.client.core;


public interface Raphael {
	
	public RaphaelElement circle(int x, int y, int radius);
	
	public RaphaelElement ellipse(int x, int y, int horizontalRadius, int verticalRadius);
	
	public RaphaelElement rect(int x, int y, int width, int height); 
	public RaphaelElement rect(int x, int y, int width, int height, int radiusForCorners); 

	public RaphaelElement image(String imageSrc, int x, int y, int width, int height);
	
	public RaphaelSet set();
	
	public RaphaelElement text(int x, int y, String message);

	public RaphaelElement path(String path);

	public RaphaelElement clear();

	public RaphaelElement setSize(int width, int height);

	public float angle(int x1, int y1, int x2, int y2); 
	public float angle(int x1, int y1, int x2, int y2, int x3, int y3);
	
	/**
	 * Converts degrees to radians.
	 */
	public float rad(float degrees);
	
	/**
	 * Converts radians to degrees.
	 */
	public float deg(float radians);

	
	/**
	 * TODOs:
	 * 	1. implement "node" (http://raphaeljs.com/reference.html#node)
	 */
	

}
