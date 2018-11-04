package SomaGraficaApp;

public class SomaApp {
    public static void main(String[] args) {
        SomaModel sm = new SomaModel();
        SomaView sv = new SomaView();
        SomaController sc = new SomaController();

        sc.setModel(sm);
        sc.setView(sv);

        sc.startflow();
    }
}
