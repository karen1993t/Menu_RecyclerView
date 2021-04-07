package com.calcuate.menuapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class AddMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)

        val addNameCafe = findViewById<EditText>(R.id.add_name_cafe)
        val addNameFood = findViewById<EditText>(R.id.add_name_food)
        val addInfoFood = findViewById<EditText>(R.id.add_info)
        val addImgFood = findViewById<ImageView>(R.id.add_img_food)
        val btnAdd = findViewById<Button>(R.id.btn_add)



        btnAdd.setOnClickListener(){
            if (addNameCafe.text.isNotEmpty() && addInfoFood.text.isNotEmpty()
                && addNameFood.text.isNotEmpty()){
                intent.putExtra(NAME_CAFE, addNameCafe.text.toString())
                intent.putExtra(NAME_FOOD, addNameFood.text.toString())
                intent.putExtra(INFO, addInfoFood.text.toString())
                setResult(Activity.RESULT_OK,intent)
                Toast.makeText(this,"Add new menu",Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this,"Pleas edited full texts...",Toast.LENGTH_SHORT).show()
            }
        }
    }
}