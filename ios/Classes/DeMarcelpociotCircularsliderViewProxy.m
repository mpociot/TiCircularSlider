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
    if ([self _hasListeners:@"change"]) {
        [self fireEvent:@"change" withObject:@{
            @"value": NUMFLOAT([slider currentValue])
        }];
    }
}

-(void)touchStarted:(EFCircularSlider*)slider {
    if ([self _hasListeners:@"touchstart"]) {
        [self fireEvent:@"touchstart" withObject:@{
            @"value": NUMFLOAT([slider currentValue])
        }];
    }
}

-(void)touchEnded:(EFCircularSlider*)slider {
    if ([self _hasListeners:@"touchend"]) {
        [self fireEvent:@"touchend" withObject:@{
            @"value": NUMFLOAT([slider currentValue])
        }];
    }
}

@end
