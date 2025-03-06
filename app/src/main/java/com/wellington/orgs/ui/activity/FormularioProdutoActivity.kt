package com.wellington.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wellington.orgs.R
import com.wellington.orgs.dao.ProdutosDao
import com.wellington.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        formularioProduto()

    }

    private fun formularioProduto() {
        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        botaoSalvar.setOnClickListener {

            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()

            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()

            val campoValor = findViewById<EditText>(R.id.valor)
            val valorEmTexto = campoValor.text.toString()
            val valor =
                if (valorEmTexto.isBlank()) { // se o valor estiver em branco ou vazio sera acrescentado um zero como padrão
                    BigDecimal.ZERO
                } else {
                    BigDecimal(valorEmTexto)
                }

            val produtonovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )


            Log.i("FormularioProduto", "onCreate $produtonovo")
            val dao = ProdutosDao()
            dao.adiciona(produtonovo)
            Log.i("FormularioProduto", "onCreate ${dao.buscaTodos()}")

            finish()
        }

    }
}