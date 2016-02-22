TiCircularSlider
===========================================


Circular slider with many customizations.
Wrapper module for EFCircularSlider.

<img src="images/demo.gif" />

### Usage

TiCircularProgress is pretty much a ProgressView replacement.

	var TiCircularSlider = require('de.marcelpociot.circularslider');

	var sliderView = TiCircularSlider.createView({
		top: 200,
		left: 50,
		height: 250,
		width: 250,
		lineWidth: 5,
		handleColor: 'red',
		filledColor: '#d7d7d7',
		unfilledColor: '#black'
	});
	sliderView.addEventListener('change',function(e)
	{
		Ti.API.info( "Value is: ", e.value );
	});
	win.add( sliderView );
	

## Options


#### lineWidth

Type: `Float`  
Default: `5`

The circle's line width.


#### minimumValue

Type: `Float`  
Default: `0.0`


#### maximumValue

Type: `Float`  
Default: `100.0`

#### handleColor

Type: `Color`  
Default: `red`

Color for the slider handle.

#### filledColor

Type: `Color`  
Default: `red`

Color for the filled (selected) area of the slider.

#### unfilledColor

Type: `Color`  
Default: `black`

Color for the unfilled (unselected) area of the slider.

#### labelFont

Type: `String`  
Default: (system-provided font-family)

Font of the inner marking labels within the circle.

#### labelColor

Type: `Color`  
Default: `Black`

Color of the inner marking labels within the circle.

#### labelDisplacement

Type: `Float`  
Default: `0`

Value with which to displace all labels along radial line from center to slider circumference.
Note: A negative value will move the label closer to the center. A positive value will move the 
label closer to the circumference

## Events

### change
Fired everytime the selection changes.

##### value
Type: `Float`   
The current selected value

### touchstart
Fired everytime the selection starts.

##### value
Type: `Float`   
The current selected value

### touchend
Fired everytime the selection stops.

##### value
Type: `Float`   
The current selected value


ABOUT THE AUTHOR
========================
I'm a web enthusiast located in Germany and in charge of http://www.titaniumcontrols.com

Follow me on twitter: @marcelpociot / @TitaniumCTRLs

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/mpociot/ticircularslider/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

