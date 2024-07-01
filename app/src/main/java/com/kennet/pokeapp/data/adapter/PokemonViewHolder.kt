package com.kennet.pokeapp.data.adapter


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.kennet.pokeapp.R
import com.kennet.pokeapp.data.model.Pokemon

class PokemonViewHolder(view: View, ) : ViewHolder(view) {

    val name = view.findViewById<TextView>(R.id.tvName)
    val image = view.findViewById<ImageView>(R.id.ivImage)
    fun render(pokemon: Pokemon, position:Int) {
        name.text = pokemon.name
        Glide.with(image.context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position+1}.png").into(image)
    }

}
