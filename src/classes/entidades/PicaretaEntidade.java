package classes.entidades;

import enums.Materiais;

import java.util.ArrayList;
import java.util.List;

public class PicaretaEntidade extends FerramentaColetaAbstrata {
    private int blocos;

    public PicaretaEntidade() {
    }

    public PicaretaEntidade(String nome, int durabilidade, Materiais materiais, int blocos, int forca) {
        super(nome, durabilidade, materiais, forca);
        this.blocos = blocos;
    }

    public int getBlocos() {
        return blocos;
    }

    public void setBlocos(int blocos) {
        this.blocos = blocos;
    }
}
