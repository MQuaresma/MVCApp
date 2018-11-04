package GestAcademicaApp;

public class Opcao {
    private String entry;
    private String code;

    public Opcao(String entry, String cd){
        this.entry = entry;
        this.code = cd;
    }

    @Override
    public String toString() {
        return entry + "\t" + code + "\n";
    }
}