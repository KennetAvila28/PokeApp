package com.kennet.pokeapp.data.network

import com.kennet.pokeapp.data.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonClient {
    @GET("pokemon/?limit=3000")
    suspend fun getAll():Response<PokemonResponse>
}