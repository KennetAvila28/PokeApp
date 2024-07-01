package com.kennet.pokeapp.data.network

import com.kennet.pokeapp.data.model.PokemonResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(private val api: PokemonService){
    suspend fun getAll(): PokemonResponse?{
        return api.getAllPokemons()
    }
}