package br.ufpb.dcx.aps.atividades.atv03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest{
    Correntista correntista;
    Banco banco;
    Conta conta;
    @BeforeEach
    void setUp() {
        correntista = new Correntista();
        banco = new Banco();
        conta = new Conta(correntista, 22, banco);

    }


    @Test
    void name() throws ContaException {
        conta = new Conta(correntista, 22, banco);
        conta.depositar(500.0);
        assertEquals(500.0,conta.saldo());

        conta.sacar(200.0);
        assertEquals(300.0,conta.saldo());

        assertEquals(22, conta.getNumero());





    }
}
