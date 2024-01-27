package org.example;

import java.math.BigInteger;

public class TransacaoBancaria extends Thread {
    private final ContaBancaria contaOrigem;
    private final ContaBancaria contaDestino;
    private final BigInteger valor;

    public TransacaoBancaria(ContaBancaria contaOrigem, ContaBancaria contaDestino, BigInteger valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    @Override
    public void run() {
        contaOrigem.transferir(contaDestino, valor);
    }
}
