package GestAcademicaApp;

import java.lang.System;
import java.util.HashMap;

/**
 * Application used to showcase the benefits of interface-driven development.
 * The application provides a student/course management system via a simple
 * text interface and follows the MVC model.
 *
 * The Model can be either of type GestAcademicaModel or GestAcademicaModelMap
 * which vary in terms of the underlying Collection (List vs Map)
 *
 * @author MiguelQ
 * @version 1.0
 */
public class GestAcademicaApp {

    public static void main(String[] args) {
        InterfGestAcademicaModel modelMap = createData();
        GestAcademicaView view = new GestAcademicaView();

        GestAcademicaController controller = new GestAcademicaController();
        controller.setModel(modelMap);
        controller.setView(view);

        controller.startFlow();

        System.out.println("Fim da Aplicação >> "
                + java.time.LocalDateTime.now());

        System.exit(0);
    }

    //Method that returns an object of type InterfGestAcademicaModel
    private static InterfGestAcademicaModel createData() {
        HashMap<String, Aluno> fichas = new HashMap<>();
        fichas.put("212", new Aluno("212", "Rui Mota", 21, "LEI", 13.7));
        fichas.put("120", new Aluno("120", "Paulo Rio", 22, "LEM", 12.7));
        fichas.put("200", new Aluno("200", "Maria Joao", 22, "LCC", 12.5));
        fichas.put("323", new Aluno("323", "Carlos Ferreira", 21, "LEI", 16));
        return new GestAcademicaModelMap(fichas);
    }
}