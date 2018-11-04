package GestAcademicaApp;

import java.util.*;
import java.util.stream.Collectors;

public class GestAcademicaModelMap implements InterfGestAcademicaModel {
    private Map<String,Aluno> fichas;

    public GestAcademicaModelMap() {
        this.fichas = new TreeMap<>();
    }

    public GestAcademicaModelMap(Map<String,Aluno> alunos) {
        this.fichas = alunos;
    }

    // Student operation mode
    public void insereAluno(Aluno al){
        this.fichas.put(al.getNro(), al);
    }

    public boolean existeAluno(String codAluno){
        return this.fichas.containsKey(codAluno);
    }

    public Aluno getAluno(String codAluno){
        return this.fichas.getOrDefault(codAluno, null);
    }

    public void removeAluno(String codAluno){
        this.fichas.remove(codAluno);
    }

    public int numDeAlunos(){
        return this.fichas.size();
    }

    public Aluno[] toArrayAlunos(){
        return this.fichas
                .values()
                .stream()
                .map(Aluno::clone)
                .toArray(size -> new Aluno[size]);
    }

    public List<Aluno> toListAlunos(){
        return new ArrayList<>(this.fichas.values());
    }

    // Course operation mode
    public List<Aluno> alunosDoCurso(String curso){
        return this.fichas
                .values()
                .stream()
                .filter(a -> a.getDegree().equals(curso))
                .collect(Collectors.toList());
    }

    public Aluno[] toArrayCurso(String curso){
        return this.alunosDoCurso(curso)
                .toArray(size -> new Aluno[size]);
    }

    public Set<String> cursos(){
        return this.fichas
                .values()
                .stream()
                .map(Aluno::getDegree)
                .collect(Collectors.toSet());
    }

    public boolean existeCurso(String codCurso){
        return this.cursos()
                .contains(codCurso);
    }

    public int numAlunosDoCurso(String curso){
        return (int)this.fichas
                .values()
                .stream()
                .filter(a -> a.getDegree().equals(curso))
                .count();
    }
}
