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
package ar.com.macsgroup.graphics.gwtraphael.client.attributes;

import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AttributeType.FloatAttributeAnimated;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AttributeType.IntegerAttribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AttributeType.IntegerAttributeAnimated;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AttributeType.StringAttribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AttributeType.StringAttributeAnimated;
import ar.com.macsgroup.graphics.gwtraphael.client.core.RaphaelBaseElement;

import com.google.gwt.core.client.JavaScriptObject;

public class Attributes {
	
	/**
	 * comma or space separated values: x, y, width and height
	 */
	public static final StringAttributeAnimated CLIP_RECT 	= new StringAttributeAnimated("clip-rect"); 

	/**
	 * CSS type of the cursor
	 */
	public static final StringAttribute CURSOR = new StringAttribute("cursor"); 

	public static final IntegerAttributeAnimated CENTER_X = new IntegerAttributeAnimated("cx"); 
	public static final IntegerAttributeAnimated CENTER_Y = new IntegerAttributeAnimated("cy");


	/**
	 * <b>Colour or gradient</b>
	 * <ul>
	 *   <li>linear gradient: "&lt;angle&gt;-&lt;colour&gt;[-&lt;colour&gt;[:&lt;offset&gt;]]*-&lt;colour&gt;", example: "90-#fff-#000" – 90° gradient from white to black or "0-#fff-#f00:20-#000" – 0° gradient from white via red (at 20%) to black</li>
	 *   <li>radial gradient: "r[(&lt;fx&gt;, &lt;fy&gt;)]&lt;colour&gt;[-&lt;colour&gt;[:&lt;offset&gt;]]*-&lt;colour&gt;", example: "r#fff-#000" – gradient from white to black or "r(0.25, 0.75)#fff-#000" – gradient from white to black with focus point at 0.25, 0.75</li>
     *   <li>Focus point coordinates are in 0..1 range</li>
	 *   <li>Radial gradients can only be applied to circles and ellipses</li>
	 * </ul>
	 * 
	 */
	public static final StringAttributeAnimated FILL 	= new StringAttributeAnimated("fill"); 
	public static final FloatAttributeAnimated FILL_OPACITY = new FloatAttributeAnimated("fill-opacity"); 

	public static final StringAttribute FONT 	= new StringAttribute("font"); 
	public static final StringAttribute FONT_FAMILY 	= new StringAttribute("font-family"); 
	public static final IntegerAttributeAnimated FONT_SIZE 	= new IntegerAttributeAnimated("font-size"); 
	public static final StringAttribute FONT_WEIGHT 	= new StringAttribute("font-weight"); 

	public static final IntegerAttributeAnimated HEIGHT 	= new IntegerAttributeAnimated("height");
	
	/**
	 * URL, if specified element behaves as hyperlink
	 */
	public static final StringAttribute HREF = new StringAttribute("href");
	
	public static final FloatAttributeAnimated OPACITY  = new FloatAttributeAnimated("opacity"); 

	public static final StringAttributeAnimated PATH = new StringAttributeAnimated("path");

	public static final IntegerAttributeAnimated RADIUS = new IntegerAttributeAnimated("r"); 
	public static final IntegerAttributeAnimated ROTATION = new IntegerAttributeAnimated("rotation"); 
	
	public static final IntegerAttributeAnimated RX = new IntegerAttributeAnimated("rx"); 
	public static final IntegerAttributeAnimated RY = new IntegerAttributeAnimated("ry");
	
	/**
	 * comma or space separated values: xtimes, ytimes, cx, cy
	 */
	public static final StringAttributeAnimated SCALE = new StringAttributeAnimated("scale"); 

	/**
	 * URL
	 */
	public static final StringAttribute SRC = new StringAttribute("src"); 

	
	public static final StringAttributeAnimated STROKE = new StringAttributeAnimated("stroke"); 
	
	/**
	 *  ["", "-", ".", "-.", "-..", ". ", "- ", "--", "- .", "--.", "--.."]
	 */
	public static final StringAttribute STROKE_DASHARRAY = new StringAttribute("stroke-dasharray");
	

	/**
	 *  ["butt", "square", "round"]
	 */
	public static final StringAttribute STROKE_LINECAP = new StringAttribute("stroke-linecap");
	
	/**
	 *  ["bevel", "round", "miter"]
	 */
	public static final StringAttribute STROKE_LINEJOIN = new StringAttribute("stroke-linejoin");

	public static final IntegerAttribute STROKE_MITERLIMIT = new IntegerAttribute("stroke-miterlimit");
	public static final FloatAttributeAnimated  STROKE_OPACITY = new FloatAttributeAnimated("stroke-opacity");
	public static final IntegerAttributeAnimated STROKE_WIDTH = new IntegerAttributeAnimated("stroke-width");

	/**
	 * used with href
	 */
	public static final StringAttribute TARGET = new StringAttribute("target");

	/**
	 * ["start", "middle", "end"], default is "middle"
	 */
	public static final StringAttribute TEXT_ANCHOR = new StringAttribute("text-anchor");

	/**
	 * will create tooltip with a given text
	 */
	public static final StringAttribute TITLE = new StringAttribute("title");

	/**
	 * comma or space separated values: x and y
	 */
	public static final StringAttributeAnimated TRANSLATION = new StringAttributeAnimated("translation");
	
	public static final IntegerAttributeAnimated WIDTH = new IntegerAttributeAnimated("width");
	
	public static final IntegerAttributeAnimated X = new IntegerAttributeAnimated("x"); 
	public static final IntegerAttributeAnimated Y = new IntegerAttributeAnimated("y");
	

	
	public static <T extends RaphaelBaseElement> T attr(T element, Attribute attribute) {
		return attr(element, attribute.getName(), attribute.getValue());
	}

	public static <T extends RaphaelBaseElement> T attr(T element, Attribute... attributes) {
		
		// fresh object
		JavaScriptObject obj = JavaScriptObject.createObject();

		for (Attribute attribute : attributes) {
			setProperty(obj, attribute.getName(), attribute.getValue() );
		}
		
		return attr(element, obj);
	}
	
	private static final native void setProperty(JavaScriptObject obj, String name, String value) /*-{
		obj[name] = value;
	}-*/;
	
	private static final native <T extends RaphaelBaseElement> T attr(T element, String name, String value) /*-{
		element.attr(name, value);
		return element;
	}-*/;

	private static final native <T extends RaphaelBaseElement> T attr(T element, JavaScriptObject obj) /*-{
		element.attr(obj);
		return element;
	}-*/;
	

	/**
	 * Attribute getters
	 */
	public static final native <T extends RaphaelBaseElement> int getIntAttributeValue(T element, String attributeName)/*-{
		return element.attr(attributeName);
	}-*/;

	public static final native <T extends RaphaelBaseElement> float getFloatAttributeValue(T element, String attributeName)/*-{
		return element.attr(attributeName);
	}-*/;

	public static final native <T extends RaphaelBaseElement> String getStringAttributeValue(T element, String attributeName)/*-{
		return element.attr(attributeName) + "";
	}-*/;

	
}
