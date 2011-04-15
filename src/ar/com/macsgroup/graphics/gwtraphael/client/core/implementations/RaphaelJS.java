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
package ar.com.macsgroup.graphics.gwtraphael.client.core.implementations;

import ar.com.macsgroup.graphics.gwtraphael.client.core.Raphael;
import ar.com.macsgroup.graphics.gwtraphael.client.core.RaphaelElement;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public final class RaphaelJS extends JavaScriptObject implements Raphael {

	protected RaphaelJS() {};
	
	public static final native RaphaelJS newInstance(int xPosition, int yPosition, int width, int height) /*-{
		return $wnd.Raphael(xPosition, yPosition, width, height);
	}-*/;
	
	public static final native RaphaelJS newInstance(Element element, int width, int height) /*-{
		return $wnd.Raphael(element, width, height);
	}-*/;
	
	/**
	 * If you are using this method, keep in mind that the container element must be attached
	 * to the DOM in order to be able to find it, ie:
	 * 
	 * 		SimplePanel panel = new SimplePanel();
	 * 		panel.getElement().setId("mypanel");
	 * 
	 * 		RootPanel.get().add(panel);
	 * 
	 * 		Raphael canvas = RaphaelJS.newInstance("mypanel", 400, 400);
	 */
	public static final native RaphaelJS newInstance(String elementId, int width, int height) /*-{
		return $wnd.Raphael(elementId, width, height);
	}-*/;


	public final native RaphaelElementJS circle(int x, int y, int radius) /*-{
		return this.circle(x, y, radius);
	}-*/;
	
	public final native RaphaelElementJS ellipse(int x, int y, int horizontalRadius, int verticalRadius) /*-{
		return this.ellipse(x, y, horizontalRadius, verticalRadius);
	}-*/;

	public final native RaphaelElementJS rect(int x, int y, int width, int height) /*-{
		return this.rect(x, y, width, height);
	}-*/;

	public final native RaphaelElementJS rect(int x, int y, int width, int height, int radiusForCorners) /*-{
		return this.rect(x, y, width, height, radiusForCorners);
	}-*/;

	
	public final native RaphaelElementJS image(String imageSrc, int x, int y, int width, int height) /*-{
		return this.image(imageSrc, x, y, width, height);
	}-*/;


	public final native RaphaelSetJS set() /*-{
		return this.set();
	}-*/;
	
	public final native  RaphaelElement text(int x, int y, String message)/*-{
		return this.text(x, y, message);
	}-*/;

	public final native RaphaelElement path(String path)/*-{
		return this.path(path);
	}-*/;

	public final native RaphaelElement clear()/*-{
		return this.clear();
	}-*/;

	public final native RaphaelElement setSize(int width, int height)/*-{
		return this.setSize(width, height);
	}-*/;


	public final native float angle(int x1, int y1, int x2, int y2) /*-{
		return this.angle(x1, y1, x2, y2);
	}-*/;


	public final native float angle(int x1, int y1, int x2, int y2, int x3, int y3) /*-{
		return this.angle(x1, y1, x2, y2, x3, y3);
	}-*/;


	public final native float rad(float degrees)/*-{
		return this.rad(degrees);
	}-*/;
 

	public final native float deg(float radians)/*-{
		return this.deg(radians);
	}-*/;
 
}
