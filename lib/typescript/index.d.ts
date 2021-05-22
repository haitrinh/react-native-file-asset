declare type FileAssetType = {
    loadTextFile(name: string, type: string): Promise<string>;
    loadFilePath(name: string, type: string): Promise<string>;
};
declare const _default: FileAssetType;
export default _default;
