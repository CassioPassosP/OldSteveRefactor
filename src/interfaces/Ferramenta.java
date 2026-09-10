package interfaces;

import enums.Materiais;

public interface Ferramenta {

    int Minerar(Materiais material, int durabilidade, int forca, int blocos);

    String Fabricar(Materiais material);

    int Reparar(Materiais material, int durabilidadeAtual, int quantidade);
}
