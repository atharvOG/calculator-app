package com.example.myclaculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)

    }

    fun onDigit(view: View) {
        tvInput?.append((view as Button).text) // Jo bhi view hoga uska text format mae dispaly krva rahe hn hm yaha by saying
        // view as button.text means every view here is a button and we are here acessing the text of every button by the help of .text
        lastNumeric = true
        lastDot = false

        var sen = "Denis is a Coder"
        if (sen.contains("Denis")) {//.Contains("") => This function will check if sen string contains whatever written between "".

        }
    }

    fun onClear(view: View) { // This function will assgin an empty string to the TextView whenever the clr button is pressed
        // for more elaborated explanation check main activity xml code of clr button.
        tvInput?.text = ""
    }

    fun onDec(view: View) { // This function will get implemented when you'll press decimal
        if (lastNumeric && !lastDot) {
            tvInput?.append((view as Button).text)
            lastNumeric = false
            lastDot = true

        }
    }

    fun onOperator(view: View) {
        tvInput?.text?.let {

            if (lastNumeric && !isoperationAdded(it.toString())) { // it.toString()=> Checking if the alst thing enetered by the user is an operator or not operator means +-/*
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false

            }
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue =
                tvInput?.text.toString()// Converting the view(view itself is a char sequence type of data type) into string type fata type
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = ""
                    tvValue = tvValue.substring(1)
                    // substring(1) => it will cut anything before index one in the string
                    // example STRING = ATHARV : substring(1) => THARV

                }
                if (tvValue.contains("-")) {
                    val splitValue =
                        tvValue.split("-") // split() => Split function will split the string into two parts
                    // it takes input a string from where the string have to get split like here we want to split the string from the "-" sign.
                    var one = splitValue[0]
                    var two = splitValue[1]

                    // Adding back the prefix back which we removed earlier in the previous functiom
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    // displaying result
                    var result =
                        one.toDouble() - two.toDouble() // Converting the string into double to perform mathematical operation
                    tvInput?.text =
                        result.toString() // again converting it to string after performing a mathematical operation to display it as a text
                } else if (tvValue.contains("+")) {
                    val splitValue =
                        tvValue.split("+") // split() => Split function will split the string into two parts
                    // it takes input a string from where the string have to get split like here we want to split the string from the "-" sign.
                    var one = splitValue[0]
                    var two = splitValue[1]

                    // Adding back the prefix back which we removed earlier in the previous functiom
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    // displaying result
                    var result =
                        one.toDouble() + two.toDouble() // Converting the string into double to perform mathematical operation
                    tvInput?.text =
                        result.toString() // again converting it to string after performing a mathematical operation to display it as a text

                } else if (tvValue.contains("*")) {
                    val splitValue =
                        tvValue.split("*") // split() => Split function will split the string into two parts
                    // it takes input a string from where the string have to get split like here we want to split the string from the "-" sign.
                    var one = splitValue[0]
                    var two = splitValue[1]

                    // Adding back the prefix back which we removed earlier in the previous functiom
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    // displaying result
                    var result =
                        one.toDouble() * two.toDouble() // Converting the string into double to perform mathematical operation
                    tvInput?.text =
                        result.toString() // again converting it to string after performing a mathematical operation to display it as a text
                } else if (tvValue.contains("/")) {
                    val splitValue =
                        tvValue.split("/") // split() => Split function will split the string into two parts
                    // it takes input a string from where the string have to get split like here we want to split the string from the "-" sign.
                    var one = splitValue[0]
                    var two = splitValue[1]

                    // Adding back the prefix back which we removed earlier in the previous functiom
                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    // displaying result
                    var result =
                        one.toDouble() / two.toDouble() // Converting the string into double to perform mathematical operation
                    tvInput?.text =
                        result.toString() // again converting it to string after performing a mathematical operation to display it as a text
                }
            }
                catch(e:ArithmeticException) {
                    e.printStackTrace()
                }
            }
        }

        private fun isoperationAdded(valu: String): Boolean {

            return if (valu.startsWith("-")) {
                false
            } //basically by doing this we are neglecting the - button
            else {
                valu.contains("/") || valu.contains("*") || valu.contains("+") || valu.contains("-")
            }

        }
    }

