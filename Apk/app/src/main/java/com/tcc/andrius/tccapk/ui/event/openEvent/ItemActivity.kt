package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.models.Item
import kotlinx.android.synthetic.main.activity_item.*

/**
 * Created by Andrius on 24/04/2018.
 */
class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        var item  = intent.getSerializableExtra("item") as Item
        supportActionBar?.title = item.name

        when(item.type){
            "Futsal Feminino" -> {  chave_futsal_f.visibility = View.VISIBLE  }
            "Futsal Masculino" -> {  chave_futsal_m.visibility = View.VISIBLE  }
            "Voleibol Feminino" -> {  chave_volei_f.visibility = View.VISIBLE  }
            "Voleibol Masculino" -> {  chave_volei_m.visibility = View.VISIBLE  }
            "Basquetebol Feminino" -> {  chave_basquete_f.visibility = View.VISIBLE  }
            "Basquetebol Masculino" -> {  chave_basquete_m.visibility = View.VISIBLE  }
            "Handebol Feminino" -> {  chave_handebol_f.visibility = View.VISIBLE  }
            "Handebol Masculino" -> {  chave_handebol_m.visibility = View.VISIBLE  }
            "Vôlei Praia Feminino" -> {  chave_praia_f.visibility = View.VISIBLE  }
            "Vôlei Praia Masculino" -> {  chave_praia_m.visibility = View.VISIBLE  }
            "Tênis de Mesa Feminino" -> {  chave_tenis_f.visibility = View.VISIBLE  }
            "Tênis de Mesa Masculino" -> {  chave_tenis_m.visibility = View.VISIBLE  }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}