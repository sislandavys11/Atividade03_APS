package br.ufpb.dcx.aps.atividades.atv03;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Banco {
    private Map<Integer, Conta> contas = new HashMap<Integer, Conta>();
    private int numeroContaLivre;
    private String nome;
    private Map<String, Correntista> correntistas = new HashMap<String, Correntista>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public Banco() {
        this.numeroContaLivre = 0;
        this.nome = "";
    }


    public Conta criarConta(Correntista correntista) {
        if (!this.correntistas.containsKey(correntista.getCpf())){
            throw new RuntimeException("Correntista não cadastrado no banco:Correntista{cpf='" +correntista.getCpf()+"', nome='"+correntista.getNome()+"'}");
        }
        for (Conta c: contas.values()){
            if (c.getCorrentista().equals(correntista)){
                throw new RuntimeException("Correntista já tem conta cadastrada");
            }
        }
        numeroContaLivre = geraIdCont();
        Conta conta1 = new Conta(correntista, numeroContaLivre, this);
        this.contas.put(gerarNumeroConta(), conta1);
        return conta1;
    }



    public Conta getConta(int conta) {
        //if (contas.containsKey(conta)) {
            return contas.get(conta);
       // } else {
         //   throw new RuntimeException("Conta não cadastrada. Essa conta não existe");
       // }

    }

    public Conta getConta(Correntista titular) {
        for (Conta con : this.contas.values()) {
            if (con.getCorrentista().equals(titular)) {
                return con;
            }
        }
        return null;
    }

    public void addCorrentista(Correntista correntista) throws BancoException{
        if (!Correntista.cpfValido(correntista.getCpf())){
            throw new RuntimeException("CPF invalido:" +correntista.getCpf());
        }
        if (this.correntistas.containsKey(correntista.getCpf())){
            throw new RuntimeException("Correntista ja cadastrado:Correntista{cpf='"+correntista.getCpf()+"', nome='"+correntista.getNome()+"'}");
        }
        correntistas.put(correntista.getCpf(), correntista);

    }

    public Correntista getCorrentista(String cpf) {
        if (correntistas.containsKey(cpf)) {
            return correntistas.get(cpf);
        } else {
            throw new RuntimeException("Não existe correntista com cpf:"+cpf);
        }
    }


    private int gerarNumeroConta() {
        int numero = this.numeroContaLivre;
        setNumeroContaLivre(this.contas.size()+1);
        return numero;
    }
    public void setNumeroContaLivre(int numeroContaLivre){
        this.numeroContaLivre = numeroContaLivre;
    }
    public int geraIdCont(){
        Random num = new Random();
        int numGerado = num.nextInt();
        return numGerado;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}