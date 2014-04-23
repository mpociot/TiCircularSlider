/**
  * Appcelerator Titanium Mobile
  * Copyright (c) 2009-2012 by Appcelerator, Inc. All Rights Reserved.
  * Licensed under the terms of the Apache Public License
  * Please see the LICENSE included with this distribution for details.
  *
  */

package de.marcelpociot.circularslider;

import java.util.HashMap;

import org.appcelerator.titanium.view.TiUIView;
import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.util.TiConvert;

import de.marcelpociot.circularslider.CircularSeekBar.OnSeekChangeListener;


public class View extends TiUIView 
{
	// Standard Debugging variables
	private static final String LCAT = "TiCircularSliderModule";
	
	private static final String PROPERTY_VALUE = "value";
	private static final String PROPERTY_LINE_WIDTH = "lineWidth";
	private static final String PROPERTY_COLOR_FILLED = "filledColor";
	private static final String PROPERTY_COLOR_UNFILLED = "unfilledColor";
	
	public View(TiViewProxy proxy) 
	{
		super(proxy);
		
		Log.d(LCAT, "[VIEW LIFECYCLE EVENT] view");
		
		CircularSeekBar csb = new CircularSeekBar(proxy.getActivity());
		
		csb.setSeekBarChangeListener(new OnSeekChangeListener() {

            @Override
            public void onProgressChange(CircularSeekBar view, int newProgress) {
                Log.d(LCAT, "Progress:" + view.getProgress() + "/" + view.getMaxProgress());
                notifyOfChange(view.getProgress());
            }
        });
		
		setNativeView(csb);
		
	}

		
	// The view is automatically registered as a model listener when the view
	// is realized by the view proxy. That means that the processProperties
	// method will be called during creation and that propertiesChanged and 
	// propertyChanged will be called when properties are changed on the proxy.

	@Override
	public void processProperties(KrollDict props) 
	{
		super.processProperties(props);
		
		CircularSeekBar csb = (CircularSeekBar) getNativeView();
		
		if (props.containsKey(PROPERTY_VALUE)){
			csb.setProgress(TiConvert.toInt(props.get(PROPERTY_VALUE)));
		}
		
		if (props.containsKey(PROPERTY_LINE_WIDTH)){
			csb.setBarWidth(TiConvert.toInt(props.get(PROPERTY_LINE_WIDTH)));
		}
		
		if (props.containsKey(PROPERTY_COLOR_FILLED)){
			csb.setProgressColor(TiConvert.toColor((String) props.get(PROPERTY_COLOR_FILLED)));
		}
		
		if (props.containsKey(PROPERTY_COLOR_UNFILLED)){
			csb.setRingBackgroundColor(TiConvert.toColor((String) props.get(PROPERTY_COLOR_UNFILLED)));
		}
		
		Log.d(LCAT,"[VIEW LIFECYCLE EVENT] processProperties " + props);

	}
	
	@Override
	public void propertyChanged(String key, Object oldValue, Object newValue, KrollProxy proxy)
	{
		// This method is called whenever a proxy property value is updated. Note that this 
		// method is only called if the new value is different than the current value.
		
		super.propertyChanged(key, oldValue, newValue, proxy);

		Log.d(LCAT,"[VIEW LIFECYCLE EVENT] propertyChanged: " + key + ' ' + oldValue + ' ' + newValue);
	}


	private void notifyOfChange(int newValue)
	{
		// The event listeners for a view are actually attached to the view proxy.
		// You must reference 'proxy' to get the proxy for this view.

		Log.d(LCAT,"[VIEW LIFECYCLE EVENT] notifyOfValueChange");

		if (proxy.hasListeners("change")) {
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			hm.put("value", newValue);
			proxy.fireEvent("change", hm);
		}
	}

}
