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
import ar.com.macsgroup.graphics.gwtraphael.client.animation.Animation.Easing;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.AnimatedAttribute;
import ar.com.macsgroup.graphics.gwtraphael.client.attributes.Attribute;

/**
 * Marker interface for Raphael Sets
 */
public interface RaphaelSet extends RaphaelBaseElement {
	
	public RaphaelSet attr(Attribute attribute);
	public RaphaelSet attr(Attribute... attributes);
	
	public RaphaelSet animate(AnimatedAttribute[] attributes, int delay);
	public RaphaelSet animate(AnimatedAttribute[] attributes, int delay, AnimationFinishCallback animationCallback);
	public RaphaelSet animate(AnimatedAttribute[] attributes, int delay, Easing easingType);
	public RaphaelSet animate(AnimatedAttribute[] attributes, int delay, Easing easingType, AnimationFinishCallback animationCallback);

	public RaphaelSet push(RaphaelElement element);
	public RaphaelSet push(RaphaelElement... element);

	
}
