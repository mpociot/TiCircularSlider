# TiCircularSlider

## About
TiCircularSlider is a native module for Titanium for iOS and Android. It uses [EFCircularSlider](https://github.com/eliotfowler/EFCircularSlider) on iOS and [CircularSeekBar](https://github.com/RaghavSood/AndroidCircularSeekBar) on Android. Within this module they share the same API.

## Quick Start

### Installation [![gitTio](http://gitt.io/badge.png)](http://gitt.io/component/de.marcelpociot.circularslider)
Download the latest distribution ZIP-file and consult the [Titanium Documentation](http://docs.appcelerator.com/titanium/latest/#!/guide/Using_a_Module) on how install it, or simply use the [gitTio CLI](http://gitt.io/cli):

`$ gittio install de.marcelpociot.circularslider`

### Usage
```javascript
var TiCircularSlider = require('de.marcelpociot.circularslider');

var sliderView = TiCircularSlider.createView({
	height: 250,
	width: 250,
	lineWidth: 5,
	filledColor: 'blue',
	unfilledColor: 'grey'
});
sliderView.addEventListener('change',function(e){
	Ti.API.info( "Value is: ", e.value );
});
win.add( sliderView );
```

### [iOS](ios)
Author: Marcel Pociot ([mpociot](https://github.com/mpociot/))

### [Android](android)
Author: Manuel Lehner ([manumaticx](https://github.com/manumaticx/))

## License: MIT

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/mpociot/ticircularslider/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
