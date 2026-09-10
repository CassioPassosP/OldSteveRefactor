package enums;

public enum Materiais {
    MADEIRA(50, 5),
    PEDRA(70, 8),
    FERRO(100, 12),
    OURO(31, 9);

    private final int durabilidade;
    private final int forca;

    Materiais(int durabilidade, int forca) {
        this.durabilidade = durabilidade;
        this.forca = forca;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public int getForca() {
        return forca;
    }
}