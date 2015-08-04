var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
var TiCircularSlider = require('de.marcelpociot.circularslider');

var sliderView = TiCircularSlider.createView({
    height: 250,
    width: 250,
    lineWidth: 5,
    filledColor: 'blue',
    unfilledColor: 'grey'
});
sliderView.addEventListener('change',function(e)
{
    Ti.API.info( "Value is: ", e.value );
});
win.add( sliderView );
win.open();
