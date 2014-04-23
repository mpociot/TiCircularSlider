/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import "DeMarcelpociotCircularsliderViewProxy.h"
#import "TiUtils.h"

@implementation DeMarcelpociotCircularsliderViewProxy

-(void)valueChanged:(EFCircularSlider*)slider {
    NSNumber* currentValue = [NSNumber numberWithFloat:slider.currentValue];
    [self fireEvent:@"change" withObject:@{
                                           @"value":currentValue
                                           }];
}

@end
