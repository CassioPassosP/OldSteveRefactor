package classes.entidades;

import enums.Materiais;
import interfaces.Ferramenta;

public class PicaretaEntidade extends FerramentaAbstrata {
    private int blocos;

    public PicaretaEntidade() {
    }

    public PicaretaEntidade(String nome, int durabilidade, Materiais materiais, int blocos) {
        super(nome, durabilidade, materiais);
        this.blocos = blocos;
    }
}
