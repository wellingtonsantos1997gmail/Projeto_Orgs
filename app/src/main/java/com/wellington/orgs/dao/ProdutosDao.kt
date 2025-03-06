package com.wellington.orgs.dao

import com.wellington.orgs.model.Produto

class ProdutosDao {


    fun adiciona(produto: Produto){
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}