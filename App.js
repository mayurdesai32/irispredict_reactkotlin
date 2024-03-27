/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useState, useEffect} from 'react';

import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  NativeModules,
} from 'react-native';
import Main from './src/Main';

const {HelloWorld2} = NativeModules;

const App = () => {
  const [text1, setText] = useState('my name');

  // useEffect(() => {
  //   HelloWorld2.sayhello1('sam', (err, message) => {
  //     if (err) {
  //       return console.log(err);
  //     } else {
  //       setText(message);
  //     }
  //   });
  //   const fetchData = async () => {
  //     try {
  //       const message1 = await HelloWorld2.mymodel();
  //       console.log(message1);
  //     } catch (error) {
  //       console.error(error);
  //     }
  //   };
  //   fetchData();
  // }, []); // Empty dependency array to run effect only once on mount

  return (
    <SafeAreaView>
      <Main />
      {/* <ScrollView>
        <View>
          <Text>"{text1}"</Text>
        </View>
      </ScrollView> */}
    </SafeAreaView>
  );
};

export default App;
