package GestAcademicaApp;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestAcademicaController {
    private InterfGestAcademicaModel model;
    private GestAcademicaView viewTxt;
    private Input in;

    // métodos de instância
    public void setModel(InterfGestAcademicaModel alunos) {
        this.model = alunos;
    }

    public void setView(GestAcademicaView txtMenus) {
        this.viewTxt = txtMenus;
    }

    //--  Auxiliary methods that invoke the model API
    //--  for student managment operations
    private void studentFlow() {
        Menu menu = viewTxt.getMenu(1);
        String option;

        do {
            menu.show();
            option = Input.lerString();
            option.toUpperCase();
            switch(option){
                case "I":
                    System.out.println("Inserting student...");
                    this.insertStudent();
                    break;
                case "R":
                    this.removeStudent();
                    break;
                case "C":
                    List<String> alunos_string_format = this.model.toListAlunos()
                            .stream()
                            .map(Aluno::toString)
                            .collect(Collectors.toList());
                    this.viewTxt.displayList("Students", alunos_string_format);
                    break;
                case "M":
                    System.out.println("Exiting to main menu...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while(!option.equals("M"));
    }

    private void insertStudent() {
        Aluno al = new Aluno();
        System.out.println("    New Student");
        System.out.print("Student no.:");
        al.setNro(Input.lerString());
        System.out.print("Name:");
        al.setName(Input.lerString());
        System.out.print("Degree:");
        al.setDegree(Input.lerString());
        System.out.print("Age:");
        al.setAge(Input.lerInt());
        System.out.print("Grade Avg:");
        al.setAvg(Input.lerDouble());
        this.model.insereAluno(al);
    }

    private void removeStudent() {
        System.out.print("Student No.: ");
        String student_no = Input.lerString();
        this.model.removeAluno(student_no);
    }

    //--  Auxiliary methods that invoke the model API
    //--  for course managment operations
    private void courseFlow() {
        Menu menu = viewTxt.getMenu(2);
        String option;

        do {
            menu.show();
            option = Input.lerString();
            option.toUpperCase();
            switch(option){
                case "L":
                    this.viewTxt.displayList("Courses", this.model.cursos());
                    break;
                case "E":
                    this.viewTxt.displaySingleValue("no. of students", this.model.numDeAlunos());
                    break;
                case "T":
                    this.students_per_course();
                    break;
                case "M":
                    System.out.println("Exiting to main menu...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while(!option.equals("M"));
    }

    private void students_per_course(){
        Map<String, Long> student_count_per_course = this.model.toListAlunos()
                .stream()
                .collect(
                        Collectors.groupingBy(Aluno::getDegree,
                                Collectors.mapping(Aluno::getNro, Collectors.counting())));

        List<String> students_per_course = student_count_per_course
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + " " + entry.getValue().toString())
                .collect(Collectors.toList());
        this.viewTxt.displayList("Students per Course",  students_per_course);
    }

    // Invoked by the main method to begin execution
    public void startFlow () {
        // Program flow start
        Menu menu = viewTxt.getMenu(0);
        String option;
        do {
            menu.show();
            option = Input.lerString();
            option = option.toUpperCase();
            switch(option) {
                case "S" :
                    studentFlow();
                    break;
                case "C" :
                    courseFlow();
                    break;
                case "E": break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
        while(!option.equals("E"));
    }
}
