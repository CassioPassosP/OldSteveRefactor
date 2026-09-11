package interfaces;

import enums.Materiais;

public interface FerramentaColeta extends Ferramenta {
    int Minerar(String nome, Materiais material, int durabilidade, int forca, int blocos);

    int Reparar(String nome, Materiais material, int durabilidadeAtual, int quantidade);
}
