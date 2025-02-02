package edu.temple.scopefunctionactivity

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("function output", getTestDataArray().toString())
        val doubleList = arrayListOf<Double>(5.0, 2.5, -1.4, 5.5, 6.6, 1.2)
        Log.d("function output for averageLessThanMedian()", averageLessThanMedian(doubleList).toString())

        val textView = findViewById<TextView>(R.id.textView)
        val intList = arrayListOf<Int>(4, 5, 6, 7, 8, 9)
        Log.d("function output for getView()", getView(1, textView, intList, this).toString())
        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        // eg. Log.d("function output", getTestDataArray().toString())

    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers
    private fun getTestDataArray(): List<Int> {
        val testArray = MutableList(10) { Random.nextInt() }
        return testArray.apply {
            testArray.sort()
        }
//        testArray.sort()
//        return testArray
    }

    // Return true if average value in list is greater than median value, false otherwise
    private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean {
        return listOfNumbers.average() < if (listOfNumbers.size % 2 == 0)
            (listOfNumbers.sorted()[listOfNumbers.size / 2] + listOfNumbers.sorted()[(listOfNumbers.size - 1) / 2]) / 2
        else
            listOfNumbers.sorted()[listOfNumbers.size / 2]
//        val avg = listOfNumbers.average()
//        val sortedList = listOfNumbers.sorted()
//        val median = if (sortedList.size % 2 == 0)
//            (sortedList[sortedList.size / 2] + sortedList[(sortedList.size - 1) / 2]) / 2
//        else
//            sortedList[sortedList.size / 2]
//        return avg < median
    }

    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context) : View = (recycledView as? TextView ?: TextView(context).apply{
        setPadding(5,10,10,0)
        textSize = 22f
    }).apply{text = collection[position].toString()}
//    {
//        val textView : TextView
//        return if (recycledView != null) {
//            textView = recycledView as? TextView
//        }
//        else {
//            textView = TextView(context)
//            textView.setPadding(5,10,10,0)
//            textView.textSize = 22f
//            textView.text = collection[position].toString()
//        }
//        val textView: TextView
//        if (recycledView != null) {
//            textView = recycledView as TextView
//        } else {
//            textView = TextView(context)
//            textView.setPadding(5, 10, 10, 0)
//            textView.textSize = 22f
//        }
//
//        textView.text = collection[position].toString()
//
//        return textView


    }
}