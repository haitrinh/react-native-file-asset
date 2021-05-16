import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import FileAsset from 'react-native-file-asset';

export default function App() {
  const [result, setResult] = React.useState<string | undefined>();

  React.useEffect(() => {
    FileAsset.loadTextFile('text', 'txt')
      .then((content: string) => {
        setResult(content);
      })
      .catch((error: Error) => {
        console.log(error);
      });
  }, [setResult]);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
