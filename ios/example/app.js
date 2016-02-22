var win = Ti.UI.createWindow({
	backgroundColor:'white'
});

var TiCircularSlider = require('de.marcelpociot.circularslider');
var sliderView = TiCircularSlider.createView({
	top: 200,
	left: 50,
	height: 250,
	width: 250,
	lineWidth: 15,
	handleColor: 'red',
	filledColor: '#d7d7d7',
	unfilledColor: '#black'
});

sliderView.addEventListener('change',function(e) {
    Ti.API.warn("change");
	sliderValue.text = Math.round( e.value );
});

sliderView.addEventListener('touchstart',function(e) {
    Ti.API.warn("touchstart");
	sliderValue.text = Math.round( e.value );
});

sliderView.addEventListener('touchend',function(e) {
    Ti.API.warn("touchend");
	sliderValue.text = Math.round( e.value );
});

win.add( sliderView );

win.addEventListener("open", function() {
    sliderView.setValue(50);
});

var sliderValue = Ti.UI.createLabel({
	top: 40,
	layout: 'horizontal',
});
win.add( sliderValue );

win.open();
