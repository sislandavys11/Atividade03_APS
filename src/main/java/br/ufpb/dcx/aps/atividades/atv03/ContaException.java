package br.ufpb.dcx.aps.atividades.atv03;

public class ContaException extends Exception{
    private static final long serialVersionUID = 1L;

    public ContaException(String ContaErro){

        super(ContaErro);
    }
}
