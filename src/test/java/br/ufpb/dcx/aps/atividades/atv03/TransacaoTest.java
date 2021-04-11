package br.ufpb.dcx.aps.atividades.atv03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoTest {
    Transacao transacao;
    Transacao transacao1;
    @BeforeEach
    void setUp() {
        transacao = new Transacao(121, 70);
        transacao1 = new Transacao(-123, 100);

    }


    @Test
    void testTransacao() {
        assertEquals(70.0, transacao.getValor());

         Exception exception = assertThrows(RuntimeException.class, () ->
                transacao1.getId());
        assertEquals("ID não pode ser menor que 0", exception.getMessage());



    }

}
