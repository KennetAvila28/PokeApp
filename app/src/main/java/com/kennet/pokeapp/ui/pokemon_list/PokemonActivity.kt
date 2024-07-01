package com.kennet.pokeapp.ui.pokemon_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kennet.pokeapp.R
import com.kennet.pokeapp.core.dialog.DialogFragmentLauncher
import com.kennet.pokeapp.core.dialog.LoginSuccessDialog
import com.kennet.pokeapp.data.adapter.PokemonAdapter
import com.kennet.pokeapp.data.network.FirebaseClient
import com.kennet.pokeapp.databinding.ActivityPokemonBinding
import com.kennet.pokeapp.ui.verification.VerificationActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PokemonActivity : AppCompatActivity() {

    companion object {
        fun create(context: Context): Intent =
            Intent(context, PokemonActivity::class.java)
    }
    private lateinit var binding: ActivityPokemonBinding
    private  val  pokemonViewModel: PokemonViewModel by viewModels()
    @Inject
    lateinit var dialogLauncher: DialogFragmentLauncher
    @Inject
    lateinit var firebaseauth: FirebaseClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        val recyclerView = binding.list
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val adapter = PokemonAdapter(emptyList())
        recyclerView.adapter =adapter
        pokemonViewModel.onCreate()
        pokemonViewModel.list.observe(this) {
            adapter.updateData(it ?: emptyList())
        }
        if (firebaseauth.auth.currentUser != null){
            dialogLauncher.show(LoginSuccessDialog.create(), this)
        }
    }
}