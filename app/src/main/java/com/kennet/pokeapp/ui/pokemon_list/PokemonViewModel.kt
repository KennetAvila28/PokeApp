package com.kennet.pokeapp.ui.pokemon_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kennet.pokeapp.data.model.Pokemon
import com.kennet.pokeapp.domain.GetAllPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val useCase: GetAllPokemonsUseCase): ViewModel(){
    val list = MutableLiveData<List<Pokemon>?>()

    fun onCreate(){
        viewModelScope.launch {
            val result = useCase()
            if (!result.isNullOrEmpty())
            {
                list.postValue(result)
            }
            print(result)
        }
    }
}