package com.wellington.orgs.model

import java.math.BigDecimal
 /*Lista de produto*/
data class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal ) {

}
