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

import ar.com.macsgroup.graphics.gwtraphael.client.animation.SupportsAnimation;

public abstract class AttributeType<T> {
	
	public static class StringAttribute extends AttributeType<String> {
		public StringAttribute(String name) {
			super(name);
		}

		@Override
		public String getString(String value) {
			return value;
		}
		
		@Override
		public boolean isString() {
			return true;
		}
	}
	
	public static class IntegerAttribute extends AttributeType<Integer> {
		public IntegerAttribute(String name) {
			super(name);
		}

		@Override
		public String getString(Integer value) {
			return value.toString();
		}
		
		@Override
		public boolean isInt() {
			return true;
		}
	}
	
	public static class FloatAttribute extends AttributeType<Float> {
		public FloatAttribute(String name) {
			super(name);
		}

		@Override
		public String getString(Float value) {
			return value.toString();
		}
		
		@Override
		public boolean isFloat() {
			return true;
		}
	}
	
	public static class StringAttributeAnimated extends StringAttribute implements SupportsAnimation {
		public StringAttributeAnimated(String name) {
			super(name);
		}
		
		@Override
		public AnimatedAttribute set(String value) {
			return new AnimatedAttribute(this, value);
		}
	}

	public static class IntegerAttributeAnimated extends IntegerAttribute implements SupportsAnimation {
		public IntegerAttributeAnimated(String name) {
			super(name);
		}
		
		@Override
		public AnimatedAttribute set(Integer value) {
			return new AnimatedAttribute(this, value);
		}
		
	}
	
	public static class FloatAttributeAnimated extends FloatAttribute implements SupportsAnimation {
		public FloatAttributeAnimated(String name) {
			super(name);
		}
		
		@Override
		public AnimatedAttribute set(Float value) {
			return new AnimatedAttribute(this, value);
		}
	}
	
	private String name;
	
	public AttributeType(String name) {
		this.name   = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract String getString(T value);
	
	public Attribute set(T value) {
		return new Attribute(this, value);
	}
	
	public boolean isInt() {
		return false;
	}

	public boolean isString() {
		return false;
	}

	public boolean isFloat() {
		return false;
	}

	
}
