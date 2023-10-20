package one.digitalinovation.laboojava.entidade.constantes;

public enum Materias {
    M2(2),
    M5(5),
    M10(10);
    

    private double fator;

    private Materias(double fator) {
        this.fator = fator/10;
    }

    public double getFator() {
        return fator;
    }

    
}
