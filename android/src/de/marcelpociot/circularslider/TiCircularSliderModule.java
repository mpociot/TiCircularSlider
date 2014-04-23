package de.marcelpociot.circularslider;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;

@Kroll.module(name="TiCircularSlider", id="de.marcelpociot.circularslider")
public class TiCircularSliderModule extends KrollModule
{
	private static final String TAG = "TiCircularSliderModule";

	public TiCircularSliderModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(TAG, "inside onAppCreate");
		// put module init code that needs to run when the application is created
	}


}

