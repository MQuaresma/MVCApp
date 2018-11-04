package GestAcademicaApp;

import java.util.List;
import java.util.Set;

/**
 * Interface que garante a implementação de uma API partilhada
 * por todos os Models independentemente da estrutura subjacente
 * usada por cada um (e.g.: Map, List, Set, ...)
 *
 * @author MiguelQ
 * @version 1.0
 */
public interface InterfGestAcademicaModel {

    public void insereAluno(Aluno al);
    public boolean existeAluno(String codAluno);
    public Aluno getAluno(String codAluno);
    public void removeAluno(String codAluno);
    public int numDeAlunos();
    public Aluno[] toArrayAlunos();
    public List<Aluno> toListAlunos();
    public List<Aluno> alunosDoCurso(String curso);
    public Aluno[] toArrayCurso(String curso);
    public Set<String> cursos();
    public boolean existeCurso(String codCurso);
    public int numAlunosDoCurso(String curso);

}
