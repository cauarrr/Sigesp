package sigesp.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import sigesp.view.*;
import sigesp.controller.*;

public class Model {
    
    private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private static HashMap<String, Usuario> professores = new HashMap<String, Usuario>(); // Usuários com Vinculo de Professor
    private static HashMap<String, Projeto> projetos = new HashMap<String, Projeto>(); // Projetos do sistema
    private static HashMap<String, SelecaoPessoas> selecoesPessoas = new HashMap<String, SelecaoPessoas>(); // Lista de processos seletivos de pessoas
    private static HashMap<String, SelecaoProjetos> selecoesProjetos = new HashMap<String, SelecaoProjetos>(); // Lista de processos seletivos de pessoas
    //private ArrayList<SelecaoProjetos> selecaoProjetos = new ArrayList<>(); // Lista de processos seletivos de projetos
    private Usuario usuarioAutt; // Usuário autenticado pelo sistema
   

    //instanceia e cadastra um novo Usuario com vinculo de Aluno no sistema, salvando-o no ArrayList
    public void cadastrarAluno(String nome, String email, String senha, String login, String tipoVinculo, String matriculaSiape) {
        
        // Converte a matricula em inteiro
        int matricula = converterParaInteiro(matriculaSiape);
        
        
        // Verifica se já existe um HashMap de Usuarios
        if(this.usuarios == null){
            this.usuarios = new HashMap<String, Usuario>(); 
        }
        System.out.println("\n\n Verificou se existe lista de usuários\n\n");
        Aluno aluno = new Aluno(matricula, tipoVinculo); 
        Usuario novoUsuario = new Usuario(nome, email, senha, login, aluno); // Cria um novo objeto Usuario
            if (!usuarios.containsKey(login)) { // Verifica se o login já não está cadastrado
                usuarios.put(login, novoUsuario); // Adiciona o usuário ao HashMap
                //notifica(); // Notifica os observadores
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Erro: O login já está em uso.");
            }
    }
    
    //instanceia e cadastra um novo Usuario com vinculo de Professor no sistema, salvando-o no ArrayList
    public void cadastrarProfessor(String nome, String email, String senha, String login, String tipoVinculo, String siape) {
        
        // Verifica se já existe um HashMap de Usuarios
        if(this.usuarios == null){
            this.usuarios = new HashMap<String, Usuario>(); 
        }
        
        Professor professor = new Professor(siape, tipoVinculo); 
        Usuario novoUsuario = new Usuario(nome, email, senha, login, professor); // Cria um novo objeto Usuario
            if (!usuarios.containsKey(login)) { // Verifica se o login já não está cadastrado
                usuarios.put(login, novoUsuario); // Adiciona o usuário ao HashMap
                professores.put(nome, novoUsuario);
                //notifica(); // Notifica os observadores
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Erro: O login já está em uso.");
            }
    }

    //autentifica o usuario (logar)
    public boolean autenticarUsuario(String login, String senha) {
        if (login == null || senha == null) {
            System.out.println("Erro: Login ou senha não podem ser nulos.");
            return false;
        }

        Usuario usuario = usuarios.get(login);
        if (usuario != null && senha.equals(usuario.getSenha())) {
            usuarioAutt = usuario;
            System.out.println("Usuário autenticado com sucesso!");
            return true;
        } else {
            System.out.println("Erro: Login ou senha incorretos.");
            return false;
        }
    }
 
    //retorna o usuario de acordo com seu id salvo no HashMap
    public Usuario getUsuario(String login) {
        if (login != null) {
            Usuario usuario = usuarios.get(login);
            return usuario;
        }
        return null;
    }
    
    //retorna o usuario autenticado (usuario logado)
    public Usuario getUsuarioAutt() {
        return usuarioAutt;
    }

    //desautentifica o usuario (deslogar)
    public void deslogarUsuario() {
        usuarioAutt = null;
        //notifica();
    }
    
    // Método para retornar o nome de todos os professores no ArrayList
    public List<String> getNomesProfessores() {
        List<String> nomesProfessores = new ArrayList<>();
        for (String nome : professores.keySet()) {
            nomesProfessores.add(nome);
        }
        return nomesProfessores;
    }
    
    //Método para retornar um Usuario com Vinculo de Professor pelo seu nome
    public Usuario getProfessor(String nome) {
        return professores.get(nome);
    }
    
    public boolean cadastrarProjeto(String nome, String descricao, String coordenador, LocalDate dataInicio) {
       
        if (nome == null || descricao == null || dataInicio == null || coordenador == null) {
            return false; // Retorna false se algum parâmetro necessário for inválido
        }
        
        Usuario coordenador1 = getProfessor(coordenador);
        
        Projeto novoProjeto = new Projeto(nome, descricao, coordenador1, dataInicio);
        projetos.put(nome, novoProjeto);
        System.out.println("Projeto Cadastrado");
        return true; // Projeto cadastrado com sucesso
    }
    
    // Método para cadastrar um novo processo seletivo de pessoas
    public boolean cadastrarSelecaoPessoas(String nome, String descricao, String vagas, LocalDate iniInscricoes, 
                                           LocalDate fimInscricoes, ArrayList<Usuario> banca) {
        int numVagas = converterParaInteiro(vagas);
        if (nome == null || descricao == null || numVagas <= 0 || iniInscricoes == null || fimInscricoes == null) {
            return false; // Retorna false se algum parâmetro necessário for inválido
        }
        
        LocalDate dataDeHoje = LocalDate.now();
        Fase status = new Fase("Previsto", "O processo seletivo iniciará em breve.", dataDeHoje, iniInscricoes);
        SelecaoPessoas novoProcesso = new SelecaoPessoas(nome, descricao, numVagas, iniInscricoes, fimInscricoes, banca, status);
        
        selecoesPessoas.put(nome, novoProcesso);
        return true; // Processo cadastrado com sucesso
    }
    
    public boolean cadastrarSelecaoProjetos(String nome, String descricao, String vagas, LocalDate iniInscricoes, 
                                           LocalDate fimInscricoes, ArrayList<Usuario> banca) {
        int numVagas = converterParaInteiro(vagas);
        if (nome == null || descricao == null || numVagas <= 0 || iniInscricoes == null || fimInscricoes == null) {
            return false; // Retorna false se algum parâmetro necessário for inválido
        }
        
        LocalDate dataDeHoje = LocalDate.now();
        Fase status = new Fase("Previsto", "O processo seletivo iniciará em breve.", dataDeHoje, iniInscricoes);
        SelecaoProjetos novoProcesso = new SelecaoProjetos(nome, descricao, numVagas, iniInscricoes, fimInscricoes, banca, status);
        
        selecoesProjetos.put(nome, novoProcesso);
        return true; // Processo cadastrado com sucesso
    }
    
    public List<String> getNomesProcessos() {
        ArrayList<String> nomesProcessos = new ArrayList<>();
        for (String nome : selecoesPessoas.keySet()) {
            nomesProcessos.add(nome);
        }
        for (String nome : selecoesProjetos.keySet()) {
            nomesProcessos.add(nome);
        }
        return nomesProcessos;
    }

    //retorna o numero de usuarios cadastrados no HashMap
    public int getTotalUsuarios() {
        return usuarios.size();
    }
    
    public int getTotalProfessores() {
        return professores.size();
    }
    
    private boolean sohTemNumeros(String texto){
        if (texto.matches("\\d+")) {
        // A string contém apenas números
            return true;
        } else {
        // A string contém caracteres não numéricos
            System.out.println("O texto contém caracteres que não são números.");
            return false;
}
    }
    private int converterParaInteiro(String texto){
        if(sohTemNumeros(texto)){
            int inteiro = Integer.parseInt(texto);
            
            return inteiro; 
        }
        System.out.println("\nErro ao converter o texto em inteiro\n");
        return 0;
    }

    
}


