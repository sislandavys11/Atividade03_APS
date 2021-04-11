package br.ufpb.dcx.aps.atividades.atv03;


import java.util.List;

public class BancoFacade {
    private Banco banco;

    public BancoFacade(String bancoNome){

        this.banco = new Banco(bancoNome);
    }
    public void cadastrarCorrentista(String cpf, String nome) throws BancoException{
        Correntista correntista01 = new Correntista(cpf,nome);
        banco.addCorrentista(correntista01);
    }
    public Conta getConta(int num){

        return banco.getConta(num);
    }

    public Conta criarContaPF(String cpf){
        Correntista c = banco.getCorrentista(cpf);
        return banco.criarConta(c);

    }
    public void depositar(double valor, int conta){
        Conta conta01 = banco.getConta(conta);
        conta01.depositar(valor);
    }
    public double sacar(double valor, int conta) throws ContaException{
        Conta conta02 = banco.getConta(conta);
        conta02.sacar(valor);
        return conta02.saldo();
    }
    public String extrato(int conta){
        Conta conta03 = banco.getConta(conta);
        return conta03.extrato();
    }
    public List<Transacao> getTransacoes(int conta){
        Conta conta04 = banco.getConta(conta);
        return conta04.getTransacoes();
    }
    public double saldo(int conta){
        Conta conta05 = banco.getConta(conta);
        return conta05.saldo();
    }
}
