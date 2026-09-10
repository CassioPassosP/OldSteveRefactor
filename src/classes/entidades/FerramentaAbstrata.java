package classes.entidades;

import enums.Materiais;

public class FerramentaAbstrata {
    private String nome;
    private int durabilidade;
    private int forca;
    private static Materiais material;

    public FerramentaAbstrata() {
    }

    public FerramentaAbstrata(String nome, int durabilidade, Materiais material, int forca) {
        this.nome = nome;
        this.durabilidade = durabilidade;
        this.forca = forca;
        FerramentaAbstrata.material = material;
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
        FerramentaAbstrata.material = material;
    }
}
