/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import "DeMarcelpociotCircularsliderView.h"

@implementation DeMarcelpociotCircularsliderView

-(EFCircularSlider*)sliderView
{
    if( sliderView == nil )
    {
        NSLog(@"INITIALIZING VIEW %@",[self frame]);
        sliderView = [[EFCircularSlider alloc] initWithFrame:[self frame]];
        [self addSubview:sliderView];
    }
    return sliderView;
}

-(void)frameSizeChanged:(CGRect)frame bounds:(CGRect)bounds
{
    NSLog(@"[VIEW LIFECYCLE EVENT] frameSizeChanged");

    if (sliderView != nil) {
        
        // You must call the special method 'setView:positionRect' against
        // the TiUtils helper class. This method will correctly layout your
        // child view within the correct layout boundaries of the new bounds
        // of your view.
        [TiUtils setView:sliderView positionRect:bounds];
        EFCircularSlider *oldSlider = sliderView;
        [sliderView removeFromSuperview];
        sliderView = [[EFCircularSlider alloc] initWithFrame:bounds];
        [self addSubview:sliderView];
        [sliderView setMinimumValue:oldSlider.minimumValue];
        [sliderView setMaximumValue:oldSlider.maximumValue];
        [sliderView setLineWidth:oldSlider.lineWidth];
        [sliderView setHandleColor:oldSlider.handleColor];
        [sliderView setUnfilledColor:oldSlider.unfilledColor];
        [sliderView setFilledColor:oldSlider.filledColor];

        [sliderView setLabelFont:oldSlider.labelFont];
        [sliderView setLabelColor:oldSlider.labelColor];
        [sliderView setLabelDisplacement:oldSlider.labelDisplacement];
        
        // Event: "change"
        [sliderView addTarget:self.proxy action:@selector(valueChanged:) forControlEvents:UIControlEventValueChanged];
        
        // Event: "touchstart"
        [sliderView addTarget:self.proxy action:@selector(touchStarted:) forControlEvents:UIControlEventTouchDragEnter];
        
        // Event: "touchend"
        [sliderView addTarget:self.proxy action:@selector(touchEnded:) forControlEvents:UIControlEventTouchDragExit];
    }
}

-(void)setMinimumValue_:(id)minimum
{
    [[self sliderView] setMinimumValue:[TiUtils floatValue:minimum def:0.0f]];
}

-(void)setMaximumValue_:(id)maximum
{
    [[self sliderView] setMaximumValue:[TiUtils floatValue:maximum def:100.0f]];
}

-(void)setValue_:(id)value
{
    [[self sliderView] setCurrentValue:[TiUtils floatValue:value def:0.0f]];
}

-(void)setLineWidth_:(id)value
{
    [[self sliderView] setLineWidth:[TiUtils floatValue:value def:0.0f]];
}

-(void)setHandleColor_:(id)value
{
    [[self sliderView] setHandleColor:[TiUtils colorValue:value].color];
}

-(void)setUnfilledColor_:(id)value
{
    [[self sliderView] setUnfilledColor:[TiUtils colorValue:value].color];
}

-(void)setFilledColor_:(id)value
{
    [[self sliderView] setFilledColor:[TiUtils colorValue:value].color];
}

-(void)setInnerMarkingLabels_:(NSArray *)value
{
    [[self sliderView] setInnerMarkingLabels:value];
}

-(void)setLabelFont_:(id)value
{
    [[self sliderView] setLabelFont:[TiUtils fontValue:value].font];
}

-(void)setLabelColor_:(id)value
{
    [[self sliderView] setLabelColor:[TiUtils colorValue:value].color];
}

-(void)setLabelDisplacement_:(id)value
{
    [[self sliderView] setLabelDisplacement:[TiUtils floatValue:value]];
}

MAKE_SYSTEM_PROP(BIG_CIRCLE, CircularSliderHandleTypeBigCircle);
MAKE_SYSTEM_PROP(SEMI_TRANSPARENT_WHITE_CIRCLE, CircularSliderHandleTypeSemiTransparentWhiteCircle);
MAKE_SYSTEM_PROP(SEMI_TRANSPARENT_BLACK_CIRCLE, CircularSliderHandleTypeSemiTransparentBlackCircle);
MAKE_SYSTEM_PROP(DOUBLE_CIRCLE_OPEN_CENTER, CircularSliderHandleTypeDoubleCircleWithOpenCenter);
MAKE_SYSTEM_PROP(DOUBLE_CIRCLE_CLOSED_CENTER, CircularSliderHandleTypeDoubleCircleWithClosedCenter);

-(void)setHandleType_:(id)value
{
    NSLog(@"Handle Type: %@",value);
    [[self sliderView] setHandleType:value];
}


@end
