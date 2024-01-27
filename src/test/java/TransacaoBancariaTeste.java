import org.example.ContaBancaria;
import org.example.TransacaoBancaria;
import org.junit.Test;

import java.math.BigInteger;

public class TransacaoBancariaTeste {

    @Test
    public void deve_ocasionar_dead_lock_quando_duas_transacoes_forem_feitas_simultaneamente() {
        ContaBancaria contaA = new ContaBancaria(1, BigInteger.valueOf(1000L));
        ContaBancaria contaB = new ContaBancaria(2, BigInteger.valueOf(1000L));

        TransacaoBancaria transacaoAB = new TransacaoBancaria(contaA, contaB, BigInteger.valueOf(200L));
        TransacaoBancaria transacaoBA = new TransacaoBancaria(contaB, contaA, BigInteger.valueOf(300L));

        Thread threadAB = new Thread(() -> transacaoAB.run());
        Thread threadBA = new Thread(() -> transacaoBA.run());

        threadAB.start();
        threadBA.start();

        try {
            threadAB.join();
            threadBA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final da conta A: " + contaA.getSaldo());
        System.out.println("Saldo final da conta B: " + contaB.getSaldo());
    }
}
