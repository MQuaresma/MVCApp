package GestAcademicaApp;

public class Aluno {
    private String nro;
    private String name;
    private String degree;
    private int age;
    private double avg;

    public Aluno() {
        this.nro = new String();
        this.name = new String();
        this.degree = new String();
        this.age = 0;
        this.avg = 0.f;
    }

    public Aluno(String nro, String name, int age, String degree, double avg) {
        this.nro = nro;
        this.name = name;
        this.degree = degree;
        this.age = age;
        this.avg = avg;
    }

    public Aluno(Aluno oldAluno){
        this.nro = oldAluno.getNro();
        this.name = oldAluno.getName();
        this.degree = oldAluno.getDegree();
        this.age = oldAluno.getAge();
        this.avg = oldAluno.getAvg();
    }

    //getters
    public String getNro() {
        return nro;
    }

    public String getName() {
        return name;
    }

    public String getDegree() {
        return degree;
    }

    public int getAge() {
        return age;
    }

    public String getAgeS(){
        return Integer.toString(age);
    }

    public double getAvg() {
        return avg;
    }

    public String getAvgS(){
        return Double.toString(avg);
    }

    //setters
    public void setNro(String nro) {
        this.nro = nro;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student\n" +
                "ID: " + nro + "\n" +
                "Name: " + name + "\n" +
                "Degree: " + degree + "\n" +
                "Age" + age + "\n" +
                "Grade avg=" + avg + "\n";
    }

    public Aluno clone(){
        return new Aluno(this);
    }

}
