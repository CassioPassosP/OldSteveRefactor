package interfaces;

import enums.Materiais;

public interface Ferramenta {

    String Fabricar(Materiais material, int durabilidade, int forca);

    int Reparar(Materiais material, int durabilidadeAtual, int quantidade);
}
