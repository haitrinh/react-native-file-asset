# React Native File Asset
![version](https://img.shields.io/npm/v/react-native-file-asset.svg?style=flat-square)
![licence](https://img.shields.io/npm/l/react-native-file-asset.svg?style=flat-square)

A react native package to load file from android's asset and iOS's resources

## Install

`npm i react-native-file-asset`

## Usage

1. iOS: Add file to Resource folder of iOS project by Xcode
2. Android: Add file to asset folder of Android project by Android Studio
3. Import FileAsset as `import FileAsset from 'react-native-file-asset';` then use 2 apis `loadTextFile` and `loadFilePath`
4. To read content from file path, you can use the package `react-native-fs`

#### Example use with loadTextFile
```javascript
import FileAsset from 'react-native-file-asset';

FileAsset.loadTextFile('text', 'txt')
  .then((content: string) => {
    console.log(content);
  })
  .catch((error: Error) => {
    console.log('load file error', error);
  });
```
#### Example use with loadFilePath
```javascript
import FileAsset from 'react-native-file-asset';
const RNFS = require('react-native-fs');

FileAsset.loadFilePath('text', 'txt')
  .then(async (filePath: string) => {
    const content = await RNFS.readFile(filePath, 'utf8');
    console.log(content);
  })
  .catch((error: Error) => {
    console.log('load file path error', error);
  });
```
 ## License

[MIT](https://github.com/haitrinh/react-native-file-asset/blob/master/LICENSE)
