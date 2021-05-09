import { NativeModules } from 'react-native';

type FileAssetType = {
  multiply(a: number, b: number): Promise<number>;
};

const { FileAsset } = NativeModules;

export default FileAsset as FileAssetType;
