package com.calcuate.menuapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable
const val REQUEST_CODE_ACTIVITY = 1
const val NAME_CAFE = "name cafe"
const val NAME_FOOD = "name food"
const val INFO = "info"
class MainActivity : AppCompatActivity() {
    lateinit var menuAdapter : RecyclerMenuAdapter
     var info:String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerMenu = findViewById<RecyclerView>(R.id.recycler_menu)
        val imgAdd = findViewById<ImageView>(R.id.add_data)
        val showCard  = findViewById<ImageView>(R.id.show_cart)


        val listMenu =
            mutableListOf<MenuData>(MenuData("Սիրակուզի","Տաշիր Պիցցա",R.drawable.ic_siracuzi),
            MenuData("Ասորտի","Տաշիր Պիցցա",R.drawable.ic_assorti),
            MenuData("Ալտոնո","Տաշիր Պիցցա",R.drawable.ic_altono),
            MenuData("Վենեցիա","Տաշիր Պիցցա",R.drawable.ic_venecia),
            MenuData("Դիաբլո","Տաշիր Պիցցա",R.drawable.ic_diablo),
            MenuData("Վեգետարիական","Տաշիր Պիցցա",R.drawable.ic_venecia),
            MenuData("Պեպերոնի","Տաշիր Պիցցա",R.drawable.ic_pepperoni),
            MenuData("Նրբություն","Տաշիր Պիցցա",R.drawable.ic_nrbutyun),
            MenuData("Կորիդա","Տաշիր Պիցցա",R.drawable.ic_korida),
            MenuData("Եվրոպական","Տաշիր Պիցցա",R.drawable.ic_evropakan))

        menuAdapter = RecyclerMenuAdapter(this,listMenu)
        recyclerMenu.adapter = menuAdapter
        recyclerMenu.layoutManager = LinearLayoutManager(this)

        imgAdd.setOnClickListener(){
            val intent = Intent(this,AddMenuActivity::class.java)
            startActivityForResult(intent,REQUEST_CODE_ACTIVITY)
        }

        showCard.setOnClickListener(){
           
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ACTIVITY) {
            if (Activity.RESULT_OK == resultCode){
                val nameCafe:String? = data?.getStringExtra(NAME_CAFE)
                val nameFood:String? = data?.getStringExtra(NAME_FOOD)
                 info = data?.getStringExtra(INFO)
                menuAdapter.addDataMenu(MenuData(nameFood.toString(),nameCafe.toString(),R.drawable.ic_vegetar))
                menuAdapter.info(info.toString())

            }
        }
    }


}