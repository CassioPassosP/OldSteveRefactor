package classes.entidades;

import enums.Materiais;

public abstract class FerramentaColetaAbstrata {
    private String nome;
    private int durabilidade;
    private int forca;
    private static Materiais material;

    public FerramentaColetaAbstrata() {
    }

    public FerramentaColetaAbstrata(String nome, int durabilidade, Materiais material, int forca) {
        this.nome = nome;
        this.durabilidade = durabilidade;
        this.forca = forca;
        FerramentaColetaAbstrata.material = material;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public Materiais getMaterial() {
        return material;
    }

    public void setMaterial(Materiais material) {
        FerramentaColetaAbstrata.material = material;
    }

    @Override
    public String toString() {
        return  nome +
                "\n   durabilidade: " + durabilidade +
                "\n   forca: " + forca ;
    }
}
