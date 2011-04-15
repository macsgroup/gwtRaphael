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
package ar.com.macsgroup.graphics.gwtraphael.client.animation;

import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AnimatedAttribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.Attribute;
import ar.com.macsgroup.graphics.gwtraphael.client.core.RaphaelBaseElement;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * TODO:
 * 	1. add support for KeyFrames animation
 *  2. add support for Cubic Bezier and Custom Function
 *
 */
public class Animation {
	
	public enum Easing {
		EaseIn(">"),
		EaseOut("<"),
		EaseInOut("<>"),
		BackIn("backIn"),
		BackOut("backOut"),
		Bounce("bounce"),
		Elastic("elastic");
		
		/**
		 * TODO:
		 * 	Add support for Cubic Bezier and Custom function	
		 */
		
		private String text;
		
		private Easing(String text) {
			this.text = text;
		}
		
		protected String getRapahelString() {
			return this.text;
		}
		
	}
	
	private static final native <T extends RaphaelBaseElement> void doAnimation(T element, JavaScriptObject obj, int delay, String easingType, AnimationFinishCallback callbackJava) /*-{
	
		var callbackFunction = null;
	
		if ( callbackJava != null ) {
			callbackFunction = function() {
				@ar.com.macsgroup.graphics.gwtraphael.client.animation.Animation::doJavaCallback(Lar/com/macsgroup/graphics/gwtraphael/client/animation/AnimationFinishCallback;)(callbackJava);
			}
		}
	
		if ( easingType == null )
			element.animate(obj, delay, callbackFunction);
		else
			element.animate(obj, delay, easingType, callbackFunction);
	}-*/;

	public final static void doJavaCallback(AnimationFinishCallback callback) {
		callback.onAnimationFinish();
	}
	
	public final static void doJavaCallback(OnAnimation callback) {
		callback.execute();
	}

//	public static <T extends RaphaelBaseElement> T animate(T element, Attribute[] attributes, int delay) {
//		return animate(element, attributes, delay, null, null);
//	}
	
	public static <T extends RaphaelBaseElement> T animate(T element, AnimatedAttribute[] attributes, int delay) {
		return animate(element, attributes, delay, null, null);
	}

	public static <T extends RaphaelBaseElement> T animate(T element, AnimatedAttribute[] attributes, int delay, AnimationFinishCallback callback) {
		return animate(element, attributes, delay, null, callback);
	}

	public static <T extends RaphaelBaseElement> T animate(T element, AnimatedAttribute[] attributes, int delay, Easing easingType) {
		return animate(element, attributes, delay, easingType, null);
	}
	
	private static final native void setProperty(JavaScriptObject obj, String name, String value) /*-{
		obj[name] = value;
	}-*/;

	public static <T extends RaphaelBaseElement> T animate(T element, AnimatedAttribute[] attributes, int delay, Easing easingType, AnimationFinishCallback callback) {
		// fresh object
		JavaScriptObject objAttributes = JavaScriptObject.createObject();

		for (Attribute attribute : attributes) {
			setProperty(objAttributes, attribute.getName(), attribute.getValue() );
		}

		String easingTypeString = easingType!=null ? easingType.getRapahelString() : null;

		doAnimation(element, objAttributes, delay, easingTypeString, callback);

		return element;
	}

	public static final native <T extends RaphaelBaseElement> T onAnimation(T element, OnAnimation callback)/*-{
		element.onAnimation(
			function() {
				@ar.com.macsgroup.graphics.gwtraphael.client.animation.Animation::doJavaCallback(Lar/com/macsgroup/graphics/gwtraphael/client/animation/OnAnimation;)(callbackJava);
			}
		);
	}-*/;
 

}
