package com.wellington.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.wellington.orgs.R
import com.wellington.orgs.dao.ProdutosDao
import com.wellington.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configuraRecyclerView()
        floatingActionButton()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())

    }

    private fun configuraRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produtos_recyclerView) // busca a referência do layout
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun floatingActionButton() {

        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_produtos_floatingActionButton)
        fab.setOnClickListener {
           acessaFormularioProdutoActivity()
        }
    }

    private fun acessaFormularioProdutoActivity(){
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

}