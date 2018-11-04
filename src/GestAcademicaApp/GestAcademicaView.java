package GestAcademicaApp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GestAcademicaView {
    private Menus menusGestAcademica;

    public GestAcademicaView() {
        this.menusGestAcademica = initView();
    }

    // Creates view based on text menus
    public static Menus initView() {
        Menus menusSIGCA = new Menus();
        Opcao op1, op2, op3, op4;

        // Layout definition
        // Main Menu creation
        op1 = new Opcao("Student Management ....... ", "S");
        op2 = new Opcao("Course Management ........ ", "C");
        op3 = new Opcao("Exit Application >>>>>>>>> ", "E");
        List<Opcao> linhas = Arrays.asList(op1, op2, op3);

        Menu menuPrincipal = new Menu(linhas,"    Main Menu");
        menusSIGCA.addMenu(0, menuPrincipal);

        // Student Management Menu creation
        op1 = new Opcao("Insert Student ....... ", "I");
        op2 = new Opcao("Remove Student ....... ", "R");
        op3 = new Opcao("Consult Student ...... ", "C");
        op4 = new Opcao("Main Menu >>>>>>>>>>>> ", "M");
        linhas = Arrays.asList(op1, op2, op3, op4);

        Menu menuAlunos = new Menu(linhas, "   Student Management");
        menusSIGCA.addMenu(1, menuAlunos);

        // Course Management Menu creation
        op1 = new Opcao("Course List ................ ", "L");
        op2 = new Opcao("Total Enrollments .......... ", "E");
        op3 = new Opcao("Students/Course No. Table .. ", "T");
        op4 = new Opcao("Main Menu >>>>>>>>>>>>>>>>>> ", "M");
        linhas = Arrays.asList(op1, op2, op3, op4);

        Menu menuCursos = new Menu(linhas, "   Gestão Cursos");
        menusSIGCA.addMenu(2, menuCursos);

        return menusSIGCA;
    }

    // Helper methods
    public Menu getMenu(int index){
        return this.menusGestAcademica.getMenu(index);
    }

    // Display list of students/courses
    public void displayList(String list_type, Collection<String> elements){
        System.out.println("Fetching " + list_type + "...");
        System.out.println("\nHere is the list of " + list_type + ":\n");
        elements.forEach(System.out::println);
        System.out.println();
    }

    public void displaySingleValue(String value_type, int value) {
        System.out.println("Fetching " + value_type + "...\n");
        System.out.println(value_type + ":" + value + "\n");
    }
}
