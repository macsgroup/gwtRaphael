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

import ar.com.macsgroup.graphics.gwtraphael.client.animation.Animation;
import ar.com.macsgroup.graphics.gwtraphael.client.animation.AnimationFinishCallback;
import ar.com.macsgroup.graphics.gwtraphael.client.animation.OnAnimation;
import ar.com.macsgroup.graphics.gwtraphael.client.animation.Animation.Easing;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AnimatedAttribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.Attribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AttributeType;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.Attributes;
import ar.com.macsgroup.graphics.gwtraphael.client.core.RaphaelBaseElement;
import ar.com.macsgroup.graphics.gwtraphael.client.core.RaphaelElement;
import ar.com.macsgroup.graphics.gwtraphael.client.drag.DragHandler;
import ar.com.macsgroup.graphics.gwtraphael.client.events.RaphaelEventHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;

public final class RaphaelElementJS extends JavaScriptObject implements RaphaelElement {
	
	protected RaphaelElementJS() {}

	@SuppressWarnings("unchecked")
	public <T> T getAttributeValue(AttributeType<T> type) {

		if ( type.isInt() ) {
			String value = Attributes.getStringAttributeValue(this, type.getName()) ;
			
			try {
				return (T) Integer.valueOf(value);
			}
			catch(Exception e) {}
			return null;
		}

		if ( type.isFloat() ) {
			String value = Attributes.getStringAttributeValue(this, type.getName()) ;
			
			try {
				return (T) Float.valueOf(value);
			}
			catch(Exception e) {}
			return null;
		}

		if ( type.isString() )
			return (T) Attributes.getStringAttributeValue(this, type.getName() );
		
		return null;
	}

	
	public RaphaelElementJS attr(Attribute attribute) {
		return Attributes.attr(this, attribute);
	}

	public RaphaelElementJS attr(Attribute... attributes) {
		return Attributes.attr(this, attributes);
	}

	public RaphaelElementJS animate(AnimatedAttribute[] attributes, int delay) {
		return Animation.animate(this, attributes, delay);
	}

	public RaphaelElementJS animate(AnimatedAttribute[] attributes, int delay, AnimationFinishCallback animationCallback) {
		return Animation.animate(this, attributes, delay, animationCallback);
	}

	public RaphaelElementJS animate(AnimatedAttribute[] attributes, int delay, Easing easingType) {
		return Animation.animate(this, attributes, delay, easingType);
	}

	public RaphaelElementJS animate(AnimatedAttribute[] attributes, int delay, Easing easingType,	AnimationFinishCallback animationCallback) {
		return Animation.animate(this, attributes, delay, easingType, animationCallback);
	}
	
	public RaphaelElement onAnimation(OnAnimation callback) {
		return Animation.onAnimation(this, callback);
	}

	
	public final native void remove() /*-{
		this.remove();
	}-*/;
	
	public final native void hide() /*-{
		this.hide();
	}-*/;

	
	public final native void show()/*-{
		this.show();
	}-*/;
	
	public final native void stop() /*-{
		this.stop();
	}-*/;

	public final native RaphaelElement rotate(int degress)/*-{
		return this.rotate(degress);
	}-*/;

	public final native RaphaelElement rotate(int degress, boolean isAbsolute)/*-{
		return this.rotate(degress, isAbsolute);
	}-*/;

	public final native RaphaelElement translate(int deltaX, int deltaY)/*-{
		return this.translate(deltaX, deltaY);
	}-*/;

	public final native RaphaelElement scale(float xTimes, float yTimes)/*-{
		return this.scale(xTimes, yTimes);
	}-*/;

	public final native RaphaelElement scale(float xTimes, float yTimes, int centerXofTheScaling)/*-{
		return this.scale(xTimes, yTimes, centerXofTheScaling);
	}-*/;

	public final native RaphaelElement scale(float xTimes, float yTimes, int centerXofTheScaling, int centerYofTheScaling)/*-{
		return this.scale(xTimes, yTimes, centerXofTheScaling, centerYofTheScaling);
	}-*/;

	public final native BBoxJS getBBox()/*-{
		return this.getBBox();
	}-*/;
	
	public final native int getWidth()/*-{
		return this.getBBox().width;
	}-*/;
	
	public final native int getHeight()/*-{
		return this.getBBox().height;
	}-*/;
	
	public final native int getX()/*-{
		return this.getBBox().x;
	}-*/;
	
	public final native int getY()/*-{
		return this.getBBox().y;
	}-*/;
	

	public final native void toFront()/*-{
		this.toFront();
	}-*/;

	public final native void toBack()/*-{
		this.toBack();
	}-*/;

	public final native RaphaelElement insertBefore(RaphaelBaseElement element)/*-{
		return this.insertBefore(element);
	}-*/;

	public final native RaphaelElement insertAfter(RaphaelBaseElement element) /*-{
		return this.insertAfter(element);
	}-*/;

	public final native RaphaelElement cloneRaphael() /*-{
		return this.clone();
	}-*/;
	

	private final static void doClickCall(RaphaelElementJS element, RaphaelEventHandler handler, NativeEvent event) {
		handler.execute(event);
	}

	

	public final native void click(RaphaelEventHandler handler) /*-{
		this.click(
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, handler, event);
			}
		);
	}-*/;


	public final native void dblclick(RaphaelEventHandler handler) /*-{
		this.dblclick(
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, handler, event);
			}
		);
	}-*/;

	
	public final native void mousedown(RaphaelEventHandler handler) /*-{
		this.mousedown(
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, handler, event);
			}
		);
	}-*/;

	
	public final native void mousemove(RaphaelEventHandler handler) /*-{
		this.mousemove(
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, handler, event);
			}
		);
	}-*/;

	public final native void mouseout(RaphaelEventHandler handler) /*-{
		this.mouseout(
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, handler, event);
			}
		);
	}-*/;

	public final native void mouseover(RaphaelEventHandler handler) /*-{
		this.mouseover(
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, handler, event);
			}
		);
	}-*/;

	public final native void mouseup(RaphaelEventHandler handler) /*-{
		this.mouseup(
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, handler, event);
			}
		);
	}-*/;

	public final native void hover(RaphaelEventHandler mouseOverHandler, RaphaelEventHandler mouseOutHandler) /*-{
		this.hover(
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, mouseOverHandler, event);
			},
			function(event) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doClickCall(Lar/com/macsgroup/graphics/gwtraphael/client/core/implementations/RaphaelElementJS;Lar/com/macsgroup/graphics/gwtraphael/client/events/RaphaelEventHandler;Lcom/google/gwt/dom/client/NativeEvent;)(this, mouseOutHandler, event);
			}
		);
	}-*/;

	/**
	 * Drag
	 */
	private final static void doDragStart(DragHandler handler) {
		handler.onStart();
	}
	private final static void doDragEnd(DragHandler handler) {
		handler.onEnd();
	}
	private final static void doDragMove(DragHandler handler, int deltaX, int deltaY) {
		handler.onMove(deltaX, deltaY);
	}

	
	public final native void drag(DragHandler handler) /*-{
		
		this.drag(
			function(dx, dy) {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doDragMove(Lar/com/macsgroup/graphics/gwtraphael/client/drag/DragHandler;II)(handler, dx, dy);
			},
			function() {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doDragStart(Lar/com/macsgroup/graphics/gwtraphael/client/drag/DragHandler;)(handler);
			},
			function() {
				@ar.com.macsgroup.graphics.gwtraphael.client.core.implementations.RaphaelElementJS::doDragEnd(Lar/com/macsgroup/graphics/gwtraphael/client/drag/DragHandler;)(handler);
			}
		);

	}-*/;
 

}
