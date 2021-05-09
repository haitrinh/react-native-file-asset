#import "FileAsset.h"

#define ERROR_TAG @"Fetch content failure"

@implementation FileAsset

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(loadTextFile: (NSString *) name type: (NSString *) type resolver: (RCTPromiseResolveBlock) resolve reject: (RCTPromiseRejectBlock) reject) {
    if (name == nil || [name length] == 0) {
        reject(ERROR_TAG, @"invalid file name", nil);
        return;
    } else if (type == nil || [type length] == 0) {
        reject(ERROR_TAG, @"invalid file type", nil);
        return;
    }
    NSString *path = [[NSBundle mainBundle] pathForResource:name ofType:type];
    NSError *error = nil;
    NSString *content = [NSString stringWithContentsOfFile:path encoding:NSUTF8StringEncoding error:&error];
    if (error) {
        reject(ERROR_TAG, [error localizedDescription], nil);
    } else {
        resolve(content);
    }
}

@end
