package classes;

import enums.Materiais;

public class FerramentaAbstrata {
    private String name;
    private int durability;
    private static Materiais materials;

    public FerramentaAbstrata(String name, int durability, Materiais materials) {
        this.name = name;
        this.durability = durability;
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

    public static Materiais getMaterials() {
        return materials;
    }

    public void setMaterials(Materiais materials) {
        FerramentaAbstrata.materials = materials;
    }
}
