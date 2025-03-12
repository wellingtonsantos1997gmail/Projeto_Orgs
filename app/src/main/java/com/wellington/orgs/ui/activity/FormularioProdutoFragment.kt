package com.wellington.orgs.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wellington.orgs.dao.ProdutosDao
import com.wellington.orgs.databinding.ActivityFormularioProdutoFragmentBinding
import com.wellington.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoFragment : Fragment() {

    private var _binding: ActivityFormularioProdutoFragmentBinding? = null
    private val binding: ActivityFormularioProdutoFragmentBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityFormularioProdutoFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvarFragment
        botaoSalvar.setOnClickListener {
            configuraBotaosalvar()
        }
    }


    private fun configuraBotaosalvar() {
        val dao = ProdutosDao()
        val produtoNovo = criaProduto()
        dao.adiciona(produtoNovo)

    }

    private fun criaProduto(): Produto {

        val campoNome = binding.activityFormularioProdutoNomeFragment
        val nome = campoNome.text.toString()

        val campoDescricao = binding.activityFormularioProdutoDescricaoFragment
        val descricao = campoDescricao.text.toString()

        val campoValor = binding.activityFormularioProdutoValorFragment
        val valorEmTexto = campoValor.text.toString()
        val valor =
            if (valorEmTexto.isBlank()) { // se o valor estiver em branco ou vazio sera acrescentado um zero como padrão
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

