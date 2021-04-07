package com.calcuate.menuapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add_menu.*

class InfoMenuActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_menu)

        val imgFoodInfo = findViewById<ImageView>(R.id.img_food_info)
        val nameFoodInfo = findViewById<TextView>(R.id.name_food_info)
        val textFoodInfo = findViewById<TextView>(R.id.text_info_food)
       // val info = findViewById<EditText>(R.id.add_info)


        val imageRef = intent.getIntExtra("imgFood",R.drawable.ic_vegetar)
        nameFoodInfo.text = intent.getStringExtra("nameFood")
        imgFoodInfo.setImageResource(imageRef)

        when (nameFoodInfo.text.toString()) {
            "Սիրակուզի" -> textFoodInfo.text = "Պանիր, սպիտակ սոուս «Մաջորիո»" +
                    "\n\n italiano 200 դր"
            "Ասորտի" -> textFoodInfo.text = "Երշիկ կիսաապխտած, սունկ, լոլիկ, պանիր, սամիթ, սպիտակ սոուս «Մաջորիո»" +
                    "\n\n italiano 280 դր"
            "Ալտոնո" -> textFoodInfo.text = "Երշիկ կիսաապխտած, խոզապուխտ, պանիր, սպիտակ սոուս «Մաջորիո»" +
                    "\n\n americano 420 դր"
            "Վենեցիա" -> textFoodInfo.text = "Սունկ, հավի կրծքամիս, պանիր, սպիտակ սոուս «Մաջորիո»" +
                    "\n\n americano 420 դր․"
            "Դիաբլո" -> textFoodInfo.text = "Խոզապուխտ, սունկ, կծու և կարմիր պղպեղ, պանիր, սպիտակ սոուս «Մաջորիո»+" +
                    "\n\n americano 420 դր․ / pizzetta 790 դր․ / italiano 300 դր․"
            "Վեգետարիական" -> textFoodInfo.text = "Սունկ, լոլիկ, եգիպտացորեն մարինացված, բուլղ. Պղպեղ, պանիր, սպիտակ սոուս «Մաջորիո»" +
                    "\n\n italiano 270 դր․ / americano 370 դր․ / pizzetta 750 դր․"
            "Պեպերոնի" -> textFoodInfo.text = "Երշիկ Պեպպերոնի, կծու և բուլղարական պղպեղ, լոլիկ, պանիր, սպիտակ սոուս «Մաջորիո»" +
                    "\n\n italiano 300 դր․ / americano 420 դր․ / pizzetta 780 դր․"
            "Նրբություն" -> textFoodInfo.text = "Խոզապուխտ, սունկ, պանիր, սպիտակ սոուս «Մաջորիո»" +
                    "\n\n italiano 270 դր․ / americano 380 դր․ / pizzetta 720 դր․"
            "Կորիդա" -> textFoodInfo.text = "Պանիր, սպիտակ սոուս «Մաջորիո»" +
                    "\n\n pizzetta 770 դր․ / americano 380 դր․ / italiano 280 դր․"
            "Եվրոպական" -> textFoodInfo.text = "Խոզի ֆիլե, խոզապուխտ, հավի կրծքամիս, երշիկ, պանիր, կարմիր պղպեղ, սպիտակ սոուս «Մաջորիո»" +
            "\n\n italiano 290 դր․ / americano 400 դր․ / pizzetta 780 դր․"

            else -> textFoodInfo.text = intent.getStringExtra(INFO)
        }

    }
}