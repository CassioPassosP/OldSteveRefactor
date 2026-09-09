package interfaces;

public interface Ferramenta {

    String Fabricar(String material, int durabilidade, int forca);

    int Reparar(String material, int durabilidadeAtual, int quantidade);
}
