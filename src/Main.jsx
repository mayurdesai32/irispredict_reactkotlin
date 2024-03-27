import { View, Text,TextInput ,Button, NativeModules,} from 'react-native'
import React, { useState } from 'react'
const {HelloWorld2} = NativeModules;
const Main = () => {
    const [SepalLength, setSepalLength] = useState(null);
      const [SepalWidth, setSepalWidth] = useState(null);
        const [PetalLength, setPetalLength] = useState(null);
          const [PetalWidth, setPetalWidth] = useState(null);
            const [Species, setSpecies] = useState(null);
    const clickHandler=async()=>{
      try {

if (SepalLength && SepalWidth && PetalLength && PetalWidth) {
    try {
        const output = await HelloWorld2.mymodel(SepalLength, SepalWidth,PetalLength,PetalWidth);
        console.log(output);
        setSpecies(output);
    } catch (error) {
        console.log(error)
    }
     
 }else{
    console.log("cccccc")
}

       
      } catch (error) {
        console.error(error);
      }
    };
  return (
    <View>
      <TextInput placeholder="Sepal Length in Cm "   
            onChangeText={(e)=>setSepalLength(e)} keyboardType="numeric"/>


            <TextInput placeholder="Enter Sepal Widthin Cm"  keyboardType="numeric"  
             onChangeText={(e)=>setSepalWidth(e) }/>


      <TextInput placeholder="Enter Petal Length in Cm" keyboardType="numeric"
      onChangeText={(e)=>setPetalLength(e)}
      />
        <TextInput placeholder="Enter Petal Width in Cm" keyboardType="numeric"
         onChangeText={(e)=>setPetalWidth(e)}/>
        
            <Button title="Predict Flower" onPress={clickHandler}/>
              <Text>Model Predicted :-{Species} Flower</Text>
    </View>
  )
}

export default Main