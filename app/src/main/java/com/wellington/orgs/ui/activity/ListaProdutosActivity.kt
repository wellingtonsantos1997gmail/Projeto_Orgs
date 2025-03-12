package com.wellington.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wellington.orgs.R
import com.wellington.orgs.dao.ProdutosDao
import com.wellington.orgs.databinding.ActivityListaProdutosBinding
import com.wellington.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val adapter by lazy {
        ListaProdutosAdapter(this, dao.buscaTodos())
    }

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    private val dao = ProdutosDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView?.adapter = adapter

        configuraRecyclerView()
        floatingActionButton()
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())

    }

    private fun configuraRecyclerView(){
        val recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = adapter
    }

    private fun floatingActionButton() {

        val fab = binding.activityListaProdutosFloatingActionButton

        fab?.setOnClickListener {
           acessaFormularioProdutoActivity()
        }
    }

    private fun acessaFormularioProdutoActivity(){
        val intent = Intent(this, FormularioProdutoFragment::class.java)
        startActivity(intent)
    }

}