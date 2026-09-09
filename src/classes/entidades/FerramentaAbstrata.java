package classes.entidades;

import enums.Materiais;

public class FerramentaAbstrata {
    private String name;
    private int durability;
    private int forca;
    private static Materiais materials;

    public FerramentaAbstrata() {
    }

    public FerramentaAbstrata(String name, int durability, Materiais materials, int forca) {
        this.name = name;
        this.durability = durability;
        this.forca = forca;
        FerramentaAbstrata.materials = materials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public static Materiais getMaterials() {
        return materials;
    }

    public void setMaterials(Materiais materials) {
        FerramentaAbstrata.materials = materials;
    }
}
