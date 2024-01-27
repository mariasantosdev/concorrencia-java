import org.example.ContaBancaria;
import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class ContaBancariaTeste {

    @Test
    public void transferir__deve_fazer_a_transacao_quando_a_conta_origem_tem_saldo_suficiente() {
        ContaBancaria contaOrigem = new ContaBancaria(1, BigInteger.valueOf(1000L));
        ContaBancaria contaDestino = new ContaBancaria(2, BigInteger.valueOf(500L));

        contaOrigem.transferir(contaDestino, BigInteger.valueOf(200L));

        assertThat(contaOrigem.getSaldo()).isEqualTo(BigInteger.valueOf(800L));
        assertThat(contaDestino.getSaldo()).isEqualTo(BigInteger.valueOf(700L));
    }

    @Test
    public void transferir__nao_deve_fazer_a_transacao_quando_a_conta_nao_tem_saldo_suficiente() {
        ContaBancaria contaOrigem = new ContaBancaria(1, BigInteger.valueOf(100L));
        ContaBancaria contaDestino = new ContaBancaria(2, BigInteger.valueOf(500L));

        contaOrigem.transferir(contaDestino, BigInteger.valueOf(200L));

        assertThat(contaOrigem.getSaldo()).isEqualTo(BigInteger.valueOf(100L));
        assertThat(contaDestino.getSaldo()).isEqualTo(BigInteger.valueOf(500L));
    }

    @Test
    public void depositar__deve_depositar_valor_na_conta() {
        ContaBancaria conta = new ContaBancaria(1, BigInteger.valueOf(500L));

        conta.depositar(BigInteger.valueOf(200L));

        assertThat(conta.getSaldo()).isEqualTo(BigInteger.valueOf(700L));
    }
}
