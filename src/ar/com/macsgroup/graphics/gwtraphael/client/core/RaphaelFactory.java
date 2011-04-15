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

import ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelJS;

import com.google.gwt.dom.client.Element;

public class RaphaelFactory {
	
	public static Raphael newInstance(int xPosition, int yPosition, int width, int height) {
		return RaphaelJS.newInstance(xPosition, yPosition, width, height);
	}
	
	public static Raphael newInstance(Element element, int width, int height) {
		return RaphaelJS.newInstance(element, width, height);
	}

	/**
	 * If you are using this method, keep in mind that the container element must be attached
	 * to the DOM in order to be able to find it, ie:
	 * 
	 * 		SimplePanel panel = new SimplePanel();
	 * 		panel.getElement().setId("mypanel");
	 * 
	 * 		RootPanel.get().add(panel);
	 * 
	 * 		Raphael canvas = RaphaelFactory.newInstance("mypanel", 400, 400);
	 */
	public static Raphael newInstance(String elementId, int width, int height) {
		return RaphaelJS.newInstance(elementId, width, height);
	}

}
