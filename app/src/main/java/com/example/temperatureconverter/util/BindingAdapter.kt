package com.example.temperatureconverter.util

import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.databinding.*
import com.example.temperatureconverter.R

@BindingAdapter(value = ["value"])
fun setValue(view:EditText,value:Int){
    if(view.text.toString()!=value.toString())
        view.setText(value.toString())
}

@InverseBindingAdapter(attribute = "value",event = "onValueChange")
fun getValue(view:EditText):Int {
    return view.text.toString().toIntOrNull() ?:0
}

@BindingAdapter("onValueChange")
fun setEditTextListener(view: EditText, attChange: InverseBindingListener){
    view.doOnTextChanged { _, _, _, _ ->
        attChange.onChange()
    }
}

@BindingAdapter("setColor")
fun setBackGroundColor(view:ImageView,value: Color){
    view.background =when(value){
        Color.BLUE -> ContextCompat.getDrawable(view.context, R.color.blue)
        Color.GREEN -> ContextCompat.getDrawable(view.context, R.color.green)
        Color.YELLOW -> ContextCompat.getDrawable(view.context, R.color.yellow)
        Color.ORANGE ->ContextCompat.getDrawable(view.context, R.color.orange)
        Color.RED -> ContextCompat.getDrawable(view.context, R.color.red)
    }
}