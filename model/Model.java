package sigesp.model;

import java.util.HashMap;
import java.util.Observer;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import sigesp.view.*;
import sigesp.controller.*;

public class Model {
    
    private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private ArrayList<SelecaoPessoas> selecaoPessoas = new ArrayList<>(); // Lista de processos seletivos de pessoas
    private ArrayList<SelecaoProjetos> selecaoProjetos = new ArrayList<>(); // Lista de processos seletivos de projetos
    private Usuario usuarioAutt; // Usuário autenticado pelo sistema
    private ArrayList<Observer> observers = new ArrayList<Observer>(); // Lista de observadores interessados no modelo
   
    //adiciona um novo observer na lista de observers
    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    //exclui um observer da lista de observers
    public void removerObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    //Notifica todos os observers que ouve uma mudanca no Model
    public void notifica() {
        for (Observer o : observers) {
            o.update(); // update é a operação definida na interface Observer
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

    //instanceia e cadastra um novo usuario no sistema, salvando-o no ArrayList
    public boolean cadastrarAluno(String nome, String email, String senha, String login, String tipoVinculo, String matriculaSiape) {
        // Converte a matricula em inteiro
        int matricula = converterMatricula(matriculaSiape);
        
        // Verifica se já existe um HashMap de Usuarios
        if(this.usuarios == null){
            this.usuarios = new HashMap<String, Usuario>(); 
        }
        boolean retorno;
        System.out.println("\n\n Verificou se existe lista de usuários\n\n");
        Aluno aluno = new Aluno(matricula, tipoVinculo); 
        Usuario novoUsuario = new Usuario(nome, email, senha, login, aluno); // Cria um novo objeto Usuario
            if (!usuarios.containsKey(login)) { // Verifica se o login já não está cadastrado
                usuarios.put(login, novoUsuario); // Adiciona o usuário ao HashMap
                //notifica(); // Notifica os observadores
                retorno = true;
            } else {
                retorno = false;
            }
            return retorno;
    }
    
    public boolean cadastrarProfessor(String nome, String email, String senha, String login, String tipoVinculo, String siape) {
        // Verifica se já existe um HashMap de Usuarios
        if(this.usuarios == null){
            this.usuarios = new HashMap<String, Usuario>(); 
        }
        boolean retorno;
        Professor professor = new Professor(siape, tipoVinculo); 
        Usuario novoUsuario = new Usuario(nome, email, senha, login, professor); // Cria um novo objeto Usuario
            if (!usuarios.containsKey(login)) { // Verifica se o login já não está cadastrado
                usuarios.put(login, novoUsuario); // Adiciona o usuário ao HashMap
                //notifica(); // Notifica os observadores
                retorno = true;
            } else {
                retorno = false;
            }
        return retorno;
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

    //desautentifica o usuario (deslogar)
    public void deslogarUsuario() {
        usuarioAutt = null;
        //notifica();
    }

    //retorna o usuario autenticado (usuario logado)
    public Usuario getUsuarioAutt() {
        return usuarioAutt;
    }


    //retorna o numero de usuarios cadastrados no HashMap
    public int getTotalUsuarios() {
        return usuarios.size();
    }
    
    private boolean sohTemNumeros(String matriculaText){
        if (matriculaText.matches("\\d+")) {
        // A string contém apenas números
            return true;
        } else {
        // A string contém caracteres não numéricos
            System.out.println("A matrícula contém caracteres que não são números.");
            return false;
        }
    }

    private int converterMatricula(String matriculaText){
        if(sohTemNumeros(matriculaText)){
            int matricula = Integer.parseInt(matriculaText);
            System.out.println("A matrícula como número inteiro é: " + matricula);
            return matricula; 
        }
        return 0;
    }

     // Método para cadastrar um novo processo seletivo de pessoas
    public boolean cadastrarSelecaoPessoas(String nome, String descricao, int numVagas, LocalDate iniInscricoes, 
                                           LocalDate fimInscricoes, List<Professor> banca, Fase status, 
                                           List<Aluno> alunosInscritos, List<Aluno> aprovados) {
    if (nome == null || descricao == null || numVagas <= 0 || iniInscricoes == null || fimInscricoes == null || 
        banca == null || banca.isEmpty() || status == null) {
    return false; // Retorna false se algum parâmetro necessário for inválido
    }

    SelecaoPessoas novoProcesso = new SelecaoPessoas(nome, descricao, numVagas, iniInscricoes, fimInscricoes, banca, status);
    novoProcesso.setAlunosInscritos(alunosInscritos);
    novoProcesso.setAprovados(aprovados);
    selecaoPessoas.add(novoProcesso);
    return true; // Processo cadastrado com sucesso
    }

    // Método para cadastrar um novo processo seletivo de projetos
    public boolean cadastrarSelecaoProjetos(String nome, String descricao, int numVagas, LocalDate iniInscricoes, 
                                            LocalDate fimInscricoes, List<Professor> banca, Fase status, 
                                            List<Projeto> projetosInscritos, List<Projeto> aprovados) {
    if (nome == null || descricao == null || numVagas <= 0 || iniInscricoes == null || fimInscricoes == null || 
        banca == null || banca.isEmpty() || status == null) {
    return false; // Retorna false se algum parâmetro necessário for inválido
    }

    SelecaoProjetos novoProcesso = new SelecaoProjetos(nome, descricao, numVagas, iniInscricoes, fimInscricoes, banca, status);
    novoProcesso.setProjetosInscritos(projetosInscritos);
    novoProcesso.setAprovados(aprovados);
    selecaoProjetos.add(novoProcesso);
    return true; // Processo cadastrado com sucesso
    }

    // Método para remover um processo seletivo de pessoas
    public boolean removerSelecaoPessoas(SelecaoPessoas processo) {
    return selecaoPessoas.remove(processo);
    }

    // Método para remover um processo seletivo de projetos
    public boolean removerSelecaoProjetos(SelecaoProjetos processo) {
    return selecaoProjetos.remove(processo);
    }

   

    //***************GETERS***************
    //********PROSCESSOS_SELETIVO*********

    // Método para obter todos os processos de pessoas
    public ArrayList<SelecaoPessoas> getSelecaoPessoas() {
        return selecaoPessoas;
    }

    // Método para obter todos os processos de projetos
    public ArrayList<SelecaoProjetos> getSelecaoProjetos() {
        return selecaoProjetos;
    }


}


