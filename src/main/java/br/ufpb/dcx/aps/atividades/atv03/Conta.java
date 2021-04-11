package br.ufpb.dcx.aps.atividades.atv03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Conta {
    private Correntista correntista;
    private int numero;
    private List<Transacao> transacao = new LinkedList<Transacao>();
    private Banco banco;
    private List<String > movimentacao = new ArrayList<>();


    public Conta(Correntista correntista, int numero, Banco banco) {
        this.correntista = correntista;
        this.numero = numero;
        this.banco = banco;
    }
    public Conta(){
        this.numero = 0;
    }

    public int idTransacao(){
        Random num = new Random();
        int numGerado = num.nextInt();
        return numGerado;
    }

    public Transacao depositar(double valor) {
        if (valor > 0) {
            Transacao tr = new Transacao(idTransacao(), valor);
            transacao.add(tr);
            this.movimentacao.add("CRÉDITO\tR$ " +(int) valor + ",00");
            return tr;
        } else {
            throw new RuntimeException("Não é possível realizar depósito de valor negativo");

        }
    }

    public Transacao sacar(double valor) throws ContaException {
        if (valor <= this.saldo() && valor > 0){
            Transacao transacao1 = new Transacao(idTransacao(), - valor);
            transacao.add(transacao1);
            this.movimentacao.add("DÉBITO\t-R$ " +(int) valor + ",00");
            return transacao1;
        }else {
            throw new ContaException("Saldo insuficiente. Saldo:"+saldo()+" - valor do saque:"+valor);
        }


    }

    public double saldo(){
        double s = 0.0;
        for (Transacao t : transacao){
            s+= t.getValor();
        }
        return s;
    }

    public String extrato(){
        String ext = "";
        ext += ">> " +banco.getNome()+ "\n";
        ext += ">> Correntista: \n";
        ext += " CPF: " + correntista.getCpf() + "\n";
        ext += " " + correntista.getNome() + "\n";
        ext += "> EXTRATO\n";
        ext += "------------------------------------\n";
        for (String a: this.movimentacao) ext += a+ "\n";
        ext += "------------------------------------\n";
        ext += "SALDO:\tR$ " + (int) this.saldo() + ",00";
        return ext;

    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public List<Transacao> getTransacoes() {
        return transacao;
    }

    public int getNumero() {
        return numero;
    }
}
