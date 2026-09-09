package interfaces;

import enums.Materiais;

public interface Ferramenta {

    String Fabricar(Materiais material);

    int Reparar(Materiais material, int durabilidadeAtual, int quantidade);
}
