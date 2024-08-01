/*
  Conforme o comentário do Professor na correção do diagrama de classes, modificamos o código para que Aluno e Professor não herdem mais da classe Usuario. Além disso, criamos as classes de Avaliacao, CriterioAvaliacao e Fase.

  Nosso código está disponível em:
  <https://github.com/DiegoBarrosDev/Sigesp>
 */


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        
        // Criando alguns alunos para testar
        Aluno estudante1 = new Aluno(999999, "Ciencia da Computacao",1);
        
        Aluno estudante2 = new Aluno(111111, "Ciencia da Computacao",1);
        
        //Criando Usuários
        
        Usuario user1 = new Usuario("Juquinha", "juquinha@email.com", "123456", "Juju");
        
        Usuario user2 = new Usuario("Maria", "emailmaria@email.com","ma122341","Mariazinha");

        // Vincular os alunos aos Usuários

        user1.setAluno(estudante1);
        user2.setAluno(estudante2);

        // Criando um professor, um Usuário e vinculando os dois
        Professor prof1 = new Professor();
        Usuario user3 = new Usuario("Diego", "email1@email.com","asdfg","Teacher");
        user3.setProfessor(prof1);

        // Criando um Projeto Ficticio

        Projeto projFicticio = new Projeto("Ficticio", "Projeto muito bom!", LocalDate.of(2024, 7, 12), prof1);

        Projeto projFicticio2 = new Projeto("Novo Mundo", "Vamos projetar um mundo melhor", LocalDate.of(2024, 7, 15), prof1);

        /*
        Como a classe Projetos recebe uma lista de alunos bolsistas e outra de alunos voluntarios é preciso criar as listas também. 
        */  

        List<Aluno> bolsistas = new ArrayList<>();
        bolsistas.add(estudante1);
        List<Aluno> voluntarios = new ArrayList<>();
        voluntarios.add(estudante2);

        // Vinculando as listas de alunos bolsistas e voluntarios ao projeto

        projFicticio.setBolsistas(bolsistas);
        projFicticio.setVoluntarios(voluntarios);

        // Criando as fases de um processo seletivo

        Fase faseInicial = new Fase("Fase de inscricoes", "Fase de inscricoes", LocalDate.of(2024, 07, 17), LocalDate.of(2024, 7, 27));

        Fase faseFinal = new Fase("Fase dos resultados", "Fase de publicacao dos resultados", LocalDate.of(2024, 07, 30), LocalDate.of(2024, 7, 31));

        // Criando um processo seletivo de projetos

        List<Professor> banca = new ArrayList<>();
        banca.add(prof1);

        SelecaoProjetos certame1 = new SelecaoProjetos("Qual o melhor Projeto", "Visa escolher o melhor projeto", 1, LocalDate.of(2024, 07, 17), LocalDate.of(2024, 7, 27), banca, faseInicial);

        // Inscrevendo projetos no processo seletivo

        List<Projeto> projetosInscritos = new ArrayList<>();
        projetosInscritos.add(projFicticio);
        projetosInscritos.add(projFicticio2);
        
        System.out.println(certame1.getStatus());

    }
}
