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
sliderView.addEventListener('change',function(e)
{
	sliderValue.text = Math.round( e.value );
});
win.add( sliderView );

var sliderValue = Ti.UI.createLabel({
	top: 40,
	layout: 'horizontal',
});
win.add( sliderValue );

win.open();