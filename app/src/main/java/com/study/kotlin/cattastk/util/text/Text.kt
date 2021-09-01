package com.study.kotlin.cattastk.util.text

object Text {

    fun getSummedUpText(text: String):String {

        if(text.length > 50){
            return "${text.subSequence(0, 50)}..."
        }else{
            return text;
        }

    }
}