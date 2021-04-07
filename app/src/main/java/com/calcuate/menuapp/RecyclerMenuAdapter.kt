package com.calcuate.menuapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerMenuAdapter(val context: Context, val menuData: MutableList<MenuData>) :
    RecyclerView.Adapter<RecyclerMenuAdapter.MenuViewHolder>() {
    lateinit var view: View
    var information:String = ""
    val listView = mutableListOf<View>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        view = LayoutInflater.from(context).inflate(R.layout.recycler_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuData.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val currentData = menuData[position]

        holder.nameFood.text = currentData.nameFood
        holder.nameCafe.text = currentData.nameCafe
        holder.imgFood.setImageResource(currentData.imgFood)

        view.setOnClickListener() {

            val intent = Intent(context, InfoMenuActivity::class.java)
            intent.putExtra("nameFood", holder.nameFood.text.toString())
            intent.putExtra(INFO,information)
            //   intent.putExtra("imgFood",holder.imgFood.id)
            context.startActivity(intent)

        }
        holder.iconLike.setOnClickListener() {                                                                // count likes
            var like = holder.countLike.text.toString().toInt()
            like++
            holder.countLike.text = like.toString()
            notifyDataSetChanged()
        }
        val currentLike = holder.countLike.text.toString().toInt()
        if (currentLike % 20 == 0 && currentLike != 0 && holder.txtLike.text.toString().toDouble() < 5.0 ) {  // count Ratings *
            var ratingsLike = holder.txtLike.text.toString().toDouble()
            ratingsLike += 0.5
            ratingsLike = (ratingsLike * 10.0) / 10.0
            holder.txtLike.text = ratingsLike.toString()
        }
        holder.imgRemove.setOnClickListener(){
            menuData.removeAt(holder.position)
            notifyDataSetChanged()
        }

        holder.imgAddCart.setOnClickListener(){
            listView.add(view)
            Toast.makeText(context,"Add  Food to Cart",Toast.LENGTH_SHORT).show()
        }

    }

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameFood: TextView
        val nameCafe: TextView
        val countLike: TextView
        val imgFood: ImageView
        val iconLike: ImageView
        val txtLike: TextView
        val imgRemove: ImageView
        val imgAddCart:ImageView
        init {
            nameFood = view.findViewById(R.id.title_name_food)
            nameCafe = view.findViewById(R.id.name_cafe)
            countLike = view.findViewById(R.id.txt_count_like)
            imgFood = view.findViewById(R.id.img_menu)
            iconLike = view.findViewById(R.id.icon_like_heart)
            txtLike = view.findViewById(R.id.txt_like)
            imgRemove = view.findViewById(R.id.icon_remove)
            imgAddCart = view.findViewById(R.id.icon_add_cart)
        }
    }

    fun addDataMenu(item:MenuData){
        menuData.add(item)
        notifyDataSetChanged()
    }
    fun info(info:String) :String{
         information = info
        return  information
    }
    fun getList() = listView

}