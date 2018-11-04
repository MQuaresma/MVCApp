package GestAcademicaApp;

import java.util.List;

/**
 * Class that abstracts the display of text to screen,
 * storing all the entries referring to a given Menu with the
 * corresponding Code
 *
 * @author MiguelQ
 * @version 1.0
 */

public class Menu {
    private List<Opcao> entries;
    private String header;

    public Menu(List<Opcao> entries, String header) {
        this.entries = entries;
        this.header = header;
    }

    public void show(){
        System.out.println("\n--------------------------------------");
        System.out.println(this.header);
        System.out.println("--------------------------------------");
        this.entries.forEach(
                op -> System.out.print(op.toString()));
        System.out.print("\tChoose an option: ");
    }
}