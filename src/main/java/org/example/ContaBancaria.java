package org.example;

import java.math.BigInteger;

public class ContaBancaria {
    private BigInteger saldo;
    private final int numeroConta;

    public ContaBancaria(int numeroConta, BigInteger saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public synchronized void transferir(ContaBancaria destino, BigInteger valor) {
        if (saldo.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
            destino.depositar(valor);
            System.out.println("Transferência de " + valor + " da conta " + numeroConta + " para a conta " + destino.getNumeroConta());
        } else {
            System.out.println("Saldo insuficiente na conta " + numeroConta);
        }
    }

    public synchronized void depositar(BigInteger valor) {
        saldo = saldo.add(valor);
    }
}
