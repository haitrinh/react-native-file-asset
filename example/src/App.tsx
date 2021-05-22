import * as React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import FileAsset from 'react-native-file-asset';
const RNFS = require('react-native-fs');

export default function App() {
  const [result, setResult] = React.useState<string | undefined>();
  const [path, setPath] = React.useState<string | undefined>();
  const [contentFromPath, setContentFromPath] = React.useState<
    string | undefined
  >();

  React.useEffect(() => {
    FileAsset.loadTextFile('text', 'txt')
      .then((content: string) => {
        setResult(content);
      })
      .catch((error: Error) => {
        console.log('load file error', error);
      });

    FileAsset.loadFilePath('text', 'txt')
      .then(async (filePath: string) => {
        setPath(filePath);
        let content = await RNFS.readFile(filePath, 'utf8');
        setContentFromPath(content);
      })
      .catch((error: Error) => {
        console.log('load file path error', error);
      });
  }, [setResult, setPath, setContentFromPath]);

  return (
    <View style={styles.container}>
      <Text>File Content: {result}</Text>
      <Text>File Path: {path}</Text>
      <Text>File Path Content: {contentFromPath}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'flex-start',
    justifyContent: 'space-around',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
