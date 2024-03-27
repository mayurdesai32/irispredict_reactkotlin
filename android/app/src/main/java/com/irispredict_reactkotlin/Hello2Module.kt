package com.irispredict_reactkotlin;


import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.irispredict_reactkotlin.ml.IrisLiteModel
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class Hello2Module(reactContext: ReactApplicationContext?) :
    ReactContextBaseJavaModule(reactContext ) {
//    private val reactContext = reactContext;
    override fun getName(): String {
        return "HelloWorld2"
    }

    @ReactMethod
    fun sayhello1(name: String, callback: Callback) {
        try {

            val message = "hello$name"
            callback.invoke(null, message)
        } catch (e: Exception) {
            callback.invoke(e.toString(), null)
        }
    }

    @ReactMethod
    fun createPromise1(promise: Promise) {
        try {
            promise.resolve("just the value")
        } catch (e: Exception) {
            promise.reject("Erorr from promise")
        }
    }

    @ReactMethod
    fun mymodel(SepalLength: String, SepalWidth: String,PetalLength: String,PetalWidth: String,promise: Promise){
try {
//    val v1: Float = 5.10f
//    val v2: Float = 5.22f
//    val v3: Float = 3.54f
//    val v4: Float = 2.22f
    val v1: Float = SepalLength.toFloat()
    val v2: Float = SepalWidth.toFloat()
    val v3: Float = PetalLength.toFloat()
    val v4: Float = PetalWidth.toFloat()



    var byteBuffer = ByteBuffer.allocateDirect(4 * 4)  //  as 4input
    byteBuffer.putFloat(v1)
    byteBuffer.putFloat(v2)
    byteBuffer.putFloat(v3)
    byteBuffer.putFloat(v4)
//    byteBuffer.putFloat(SepalLength)
//    byteBuffer.putFloat(SepalWidth)
//    byteBuffer.putFloat(PetalLength)
//    byteBuffer.putFloat(PetalWidth)

    val model = IrisLiteModel.newInstance(reactApplicationContext)

// Creates inputs for reference.
    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 4), DataType.FLOAT32)
    inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
    val outputs = model.process(inputFeature0)
    val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

    val predictedIndex = outputFeature0.indices.maxByOrNull { outputFeature0[it] } ?: -1


    val predicted: String = when (predictedIndex) {
        0 -> "Iris-setosa"
        1 -> "Iris-versicolor"
        2 -> "Iris-virginica"
        else -> "Unknown"
    }

//    opText.setText("Your Predicted model:-" + predicted)




// Releases model resources if no longer used.
    model.close()
    promise.resolve(predicted)
}catch (e: Exception) {
    // Reject the Promise if there's an error.
//    model.close()
    promise.reject("Error from model inference", e.toString())

}
    }
}
