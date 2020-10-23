package br.mil.eb.basecmp.salc.domain.enums;

public enum SecaoSolicitante {
    ALMOXARIFADO(1, "Almoxarifado"),
    APROVISIONAMENTO(2, "Aprovisionamento"),
    PELSAU(3, "PelSau"),
    PMT(4, "Pel Mnt Trnsp"),
    FISCALIZACAO(5, "Fiscalização"),
    STI(6, "Seção de Tecnologia da Informação"),
    CMP(7, "Comando Militar do Planalto"),
    CIAAP(8, "Cia Apoio"),
    CIAGD(9, "Cia Guarda"),
    CIAC(10, "Cia Comando"),
    ETGDL(11, "Estande de Tiro"),
    SALC(12, "Seção de Aquisição, Licitação e Contratos"),
    PENDENTE(13, "Em Branco"),
    CMT(14, "Cmt da Base Adm Ap / CMP");


    private int cod;
    private String descricao;

    private SecaoSolicitante(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
    public static SecaoSolicitante toEnum(Integer cod){
        if ( cod == null){
            return null;
        }
        for (SecaoSolicitante x : SecaoSolicitante.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
