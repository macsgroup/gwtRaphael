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

import ar.com.macsgroup.graphics.gwtraphael.client.core.BBox;

import com.google.gwt.core.client.JavaScriptObject;

public class BBoxJS extends JavaScriptObject implements BBox {

	protected BBoxJS() {}
	
	public final native int getWidth()/*-{
		return this.width;
	}-*/;


	public final native int getHeight() /*-{
		return this.height;
	}-*/;

	public final native double getX() /*-{
		return this.x;
	}-*/;


	public final native double getY() /*-{
		return this.y;
	}-*/;

}
