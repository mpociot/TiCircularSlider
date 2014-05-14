package de.marcelpociot.circularslider;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

@Kroll.proxy(creatableInModule = TiCircularSliderModule.class)
public class ViewProxy extends TiViewProxy {
	private static final String LCAT = "TiCircularSliderModule";

	de.marcelpociot.circularslider.View view;

	public ViewProxy() {
		super();

		Log.d(LCAT, "[VIEWPROXY LIFECYCLE EVENT] init");
	}

	@Override
	public TiUIView createView(Activity activity) {
		// This method is called when the view needs to be created. This is
		// a required method for a TiViewProxy subclass.

		view = new View(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;

		return view;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options) {
		// This method is called from handleCreationArgs if there is at least
		// argument specified for the proxy creation call and the first argument
		// is a KrollDict object.

		Log.d(LCAT, "VIEWPROXY LIFECYCLE EVENT] handleCreationDict " + options);

		// Calling the superclass method ensures that the properties specified
		// in the dictionary are properly set on the proxy object.
		super.handleCreationDict(options);
	}

	public void handleCreationArgs(KrollModule createdInModule, Object[] args) {
		// This method is one of the initializers for the proxy class. The
		// arguments
		// for the create call are passed as an array of objects. If your proxy
		// simply needs to handle a single KrollDict argument, use
		// handleCreationDict.
		// The superclass method calls the handleCreationDict if the first
		// argument
		// to the create method is a dictionary object.

		Log.d(LCAT, "VIEWPROXY LIFECYCLE EVENT] handleCreationArgs ");

		for (int i = 0; i < args.length; i++) {
			Log.d(LCAT, "VIEWPROXY LIFECYCLE EVENT] args[" + i + "] " + args[i]);
		}

		super.handleCreationArgs(createdInModule, args);
	}

}
