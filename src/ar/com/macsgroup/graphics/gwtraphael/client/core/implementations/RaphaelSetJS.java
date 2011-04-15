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
import ar.com.macsgroup.graphics.gwtraphael.client.animation.Animation.Easing;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AnimatedAttribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.Attribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.Attributes;
import ar.com.macsgroup.graphics.gwtraphael.client.core.RaphaelElement;
import ar.com.macsgroup.graphics.gwtraphael.client.core.RaphaelSet;

import com.google.gwt.core.client.JavaScriptObject;

public final class RaphaelSetJS extends JavaScriptObject implements RaphaelSet {
	
	protected RaphaelSetJS() {}

	public RaphaelSetJS attr(Attribute attribute) {
		return Attributes.attr(this, attribute);
	}

	public RaphaelSetJS attr(Attribute... attributes) {
		return Attributes.attr(this, attributes);
	}

	public RaphaelSetJS animate(AnimatedAttribute[] attributes, int delay) {
		return Animation.animate(this, attributes, delay);
	}

	public RaphaelSetJS animate(AnimatedAttribute[] attributes, int delay, AnimationFinishCallback animationCallback) {
		return Animation.animate(this, attributes, delay, animationCallback);
	}

	public RaphaelSetJS animate(AnimatedAttribute[] attributes, int delay, Easing easingType) {
		return Animation.animate(this, attributes, delay, easingType);
	}

	public RaphaelSetJS animate(AnimatedAttribute[] attributes, int delay, Easing easingType,	AnimationFinishCallback animationCallback) {
		return Animation.animate(this, attributes, delay, easingType, animationCallback);
	}

	public final native RaphaelSet push(RaphaelElement element) /*-{
		this.push(element);
		return this;
	}-*/;
	
	
	public RaphaelSet push(RaphaelElement... elements) {
		for (RaphaelElement element : elements) {
			push(element);
		}
		return this;
	}

}
