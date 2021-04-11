package br.ufpb.dcx.aps.atividades.atv03;

import java.util.Calendar;
import java.util.Random;

public class Transacao {
    private int id;
    private Calendar data;
    private double valor;


    public Transacao(int id, double valor){
        this.id = id;
        this.valor = valor;

    }

    public String toString() {

        return "Transacao" +  "id=" + id + ", data=" + data + ", valor=" + valor;
    }

    public int getId() {
        if (this.id < 0){
            throw new RuntimeException("ID não pode ser menor que 0");
        }
        return id;
    }

    public double getValor() {

        return valor;
    }

    public Calendar getData(){

        return data;
    }
    public int idTransacao(){
        Random num = new Random();
        int numGerado = num.nextInt();
        return numGerado;
    }
}
