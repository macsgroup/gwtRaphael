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

import ar.com.macsgroup.graphics.gwtraphael.client.animation.AnimationFinishCallback;
import ar.com.macsgroup.graphics.gwtraphael.client.animation.OnAnimation;
import ar.com.macsgroup.graphics.gwtraphael.client.animation.Animation.Easing;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AnimatedAttribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.Attribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AttributeType;
import ar.com.macsgroup.graphics.gwtraphael.client.drag.DragHandler;
import ar.com.macsgroup.graphics.gwtraphael.client.events.RaphaelEventHandler;

/**
 * Marker interface for Raphael Elements (ie: Circle, Rect, Path, etc...)
 * Use for type safety on generic helpers (ie: Animation)
 */
public interface RaphaelElement extends RaphaelBaseElement {
	
	public <T> T getAttributeValue(AttributeType<T> type);
	
	public RaphaelElement attr(Attribute attribute);
	public RaphaelElement attr(Attribute... attributes);
	
	public RaphaelElement animate(AnimatedAttribute[] attributes, int delay);
	public RaphaelElement animate(AnimatedAttribute[] attributes, int delay, AnimationFinishCallback animationCallback);
	public RaphaelElement animate(AnimatedAttribute[] attributes, int delay, Easing easingType);
	public RaphaelElement animate(AnimatedAttribute[] attributes, int delay, Easing easingType, AnimationFinishCallback animationCallback);
	
	// TODO
//	public RaphaelElement animateWith(RaphaelBaseElement element, AnimatedAttribute[] attributes, int delay);
//	public RaphaelElement animateWith(RaphaelBaseElement element, AnimatedAttribute[] attributes, int delay, AnimationFinishCallback animationCallback);
//	public RaphaelElement animateWith(RaphaelBaseElement element, AnimatedAttribute[] attributes, int delay, Easing easingType);
//	public RaphaelElement animateWith(RaphaelBaseElement element, AnimatedAttribute[] attributes, int delay, Easing easingType, AnimationFinishCallback animationCallback);
	
	public RaphaelElement onAnimation(OnAnimation callback);
	
	public void remove();
	public void hide();
	public void show();
	public void stop();
	
	/**
	 * Rotate the specified degrees relative to the current angle
	 */
	public RaphaelElement rotate(int degress);
	public RaphaelElement rotate(int degress, boolean isAbsolute);
	
	public RaphaelElement translate(int deltaX, int deltaY);

	public RaphaelElement scale(float xTimes, float yTimes);
	public RaphaelElement scale(float xTimes, float yTimes, int centerXofTheScaling);
	public RaphaelElement scale(float xTimes, float yTimes, int centerXofTheScaling, int centerYofTheScaling);

	/**
	 * If any of these methods returns an error (like undefined),
	 * then you must be sure that the widget is attached to the DOM
	 * otherwise, it will be undefined
	 */
	public BBox getBBox();
	public int getWidth();
	public int getHeight();
	public int getX();
	public int getY();

	
	public void toFront();
	public void toBack();
	public RaphaelElement insertBefore(RaphaelBaseElement element);
	public RaphaelElement insertAfter(RaphaelBaseElement element);
	public RaphaelElement cloneRaphael();

	
	public void click(RaphaelEventHandler handler);
	public void dblclick(RaphaelEventHandler handler);
	public void mousedown(RaphaelEventHandler handler);
	public void mousemove(RaphaelEventHandler handler);
	public void mouseout(RaphaelEventHandler handler);
	public void mouseover(RaphaelEventHandler handler);
	public void mouseup(RaphaelEventHandler handler);
	public void hover(RaphaelEventHandler mouseOverHandler, RaphaelEventHandler mouseOutHandler);
	
	public void drag(DragHandler handler);
	
}
