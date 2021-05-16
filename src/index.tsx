import { NativeModules } from 'react-native';

type FileAssetType = {
  loadTextFile(name: string, type: string): Promise<string>;
  loadFilePath(name: string, type: string): Promise<string>;
};

const { FileAsset } = NativeModules;

export default FileAsset as FileAssetType;
