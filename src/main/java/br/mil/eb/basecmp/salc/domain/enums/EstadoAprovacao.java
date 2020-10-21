package br.mil.eb.basecmp.salc.domain.enums;

public enum EstadoAprovacao {
    APROVADO(1, "Aprovado"),
    REPROVADO(2, "Reprovado"),
    PENDENTE(3, "Pendente");

    private int cod;
    private String descricao;

    private EstadoAprovacao(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
    public static EstadoAprovacao toEnum(Integer cod){
        if ( cod == null){
            return null;
        }
        for (EstadoAprovacao x : EstadoAprovacao.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
