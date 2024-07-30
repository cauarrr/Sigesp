
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        
        // Criando alguns alunos para testar
        Aluno estudante1 = new Aluno("Antonio", "email@email.com","ma122345","Toin");
        Aluno estudante2 = new Aluno("Maria", "emailmaria@email.com","ma122341","Mariazinha");

        // Criando um professor
        Professor professor1 = new Professor("Diego", "email1@email.com","asdfg","Teacher");

        Projeto ProjFicticio = new Projeto("Ficticio", "Projeto muito bom!", LocalDate.of(2024, 7, 12), professor1);


        /*
        Como a classe Projetos recebe uma lista de alunos bolsistas e outra de alunos voluntarios é preciso criar as listas também.

        
        */  
        List<Aluno> bolsistas = new ArrayList<>();
        bolsistas.add(estudante1);
        List<Aluno> voluntarios = new ArrayList<>();
        voluntarios.add(estudante2);

        ProjFicticio.setBolsistas(bolsistas);
        ProjFicticio.setVoluntarios(voluntarios);
        
        System.out.println(ProjFicticio);

        
    }
}
