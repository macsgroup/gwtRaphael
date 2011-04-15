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
package ar.com.macsgroup.graphics.gwtraphael.client.charts.pie;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class PieChart {
    
    public static enum LegendPosition {
        SOUTH("south"), NORTH("north"), WEST("west"), EAST("east");
        
        private String raphaelString;
        
        private LegendPosition(String raphaelString) {
            this.raphaelString = raphaelString;
        }

        String getRaphaelString() {
            return this.raphaelString;
        }
        
    }
    
    protected static final int DEFAULT_WIDTH  = 320;
    protected static final int DEFAULT_HEIGHT = 100;
    
    protected static final String DEFAULT_FONT = "12px 'Fontin Sans', Fontin-Sans, sans-serif";
    
    protected int width  = DEFAULT_WIDTH;
    protected int height = DEFAULT_HEIGHT;
    protected String title;
    protected String font = DEFAULT_FONT;
    

    public PieChart() {
    }

    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getFont() {
        return font;
    }


    public void setFont(String font) {
        this.font = font;
    }

    public void drawInside(Widget widget, int[] values, LegendPosition legendPosition, String[] legends, String[] colors) {
        Integer[] newValues = new Integer[values.length];
        
        for(int i=0; i<values.length;++i)
            newValues[i] = values[i];
        
        drawInside(widget, newValues, legendPosition, legends, colors);

    }
    
    public void drawInside(Widget widget, Integer[] values, LegendPosition legendPosition, String[] legends, String[] colors) {
        
        /**
         * Converting numbers
         */
        JsArrayNumber valuesJs = (JsArrayNumber) JavaScriptObject.createArray();

        for (int value : values) {
            valuesJs.push(value);
        }
        
        /**
         * Converting legends
         */
        JsArrayString legendsJs = (JsArrayString) JavaScriptObject.createArray();

        for (String value : legends) {
            legendsJs.push(value);
        }
        
        /**
         * Converting colors
         */
        JsArrayString colorJs = (JsArrayString) JavaScriptObject.createArray();

        if ( colors!=null ) { 
            for (String value : colors) {
                colorJs.push(value);
            }
        }

        
        draw(widget.getElement(), this.width, this.height, this.font, this.title, valuesJs, legendPosition.getRaphaelString(), legendsJs, colorJs);
    }
    
    protected final native void draw(Element element, int width, int height, String font, String title, JsArrayNumber values, String legendPosition, JsArrayString legends, JsArrayString colors) /*-{
        
        var canvas = $wnd.Raphael(element, width, height);
        
        var square = canvas.rect(2, 2, width-3, height-3);
        square.attr({"stroke": "black", "stroke-width": 1});
        
        if ( font )
            canvas.g.txtattr.font = "12px arial,'Fontin Sans', Fontin-Sans, sans-serif";
        
        if ( title )
            canvas.g.text(width/2, 15, title).attr({"font-size": 15, "font-weight": "bold"});
        
        var options = {};
        
        if ( legends )
            options["legend"] = legends;
            
        if ( legendPosition )
            options["legendpos"] = legendPosition;
            
        if ( colors && colors.length>0 )
            options["colors"] = colors;
            
        
        //var pie = canvas.g.piechart(width/2, 80, 50, values, {legend: legends, legendpos: legendPosition, colors: ["red", "brown"]});
        var pie = canvas.g.piechart(width/2, 80, 50, values, options);
        
        
        pie.hover(function () {
            this.sector.stop();
            this.sector.scale(1.1, 1.1, this.cx, this.cy);
            if (this.label) {
                this.label[0].stop();
                this.label[0].scale(1.5);
                this.label[1].attr({"font-weight": 800});
            }
        }, function () {
            this.sector.animate({scale: [1, 1, this.cx, this.cy]}, 500, "bounce");
            if (this.label) {
                this.label[0].animate({scale: 1}, 500, "bounce");
                this.label[1].attr({"font-weight": 400});
            }
        });
        
    }-*/;
    
}
