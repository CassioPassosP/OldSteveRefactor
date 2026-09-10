package interfaces;

import enums.Materiais;

public interface Ferramenta {

    int Minerar(String nome, Materiais material, int durabilidade, int forca, int blocos);

    String Fabricar(Materiais material);

    int Reparar(String nome, Materiais material, int durabilidadeAtual, int quantidade);
}
