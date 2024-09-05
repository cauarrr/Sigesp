package poo.model;

import java.util.HashMap;
import java.util.ArrayList;
import Sigesp.view.*;
import Sigesp.controller

public class Model {
    private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private Usuario usuarioAutt; // Usuário autenticado pelo sistema
    private ArrayList<Observer> observers = new ArrayList<Observer>(); // Lista de observadores interessados no modelo

    /*
     * Método utilizado para notificar todos os observadores contidos no ArrayList que o modelo mudou
     */
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

    //adiciona um novo usuario no HashMap
    public void setUsuario(Usuario usuario) {
        if (usuario != null && usuario.getLogin() != null) {
            usuarios.put(usuario.getLogin(), usuario);
            notifica();
        }
    }

    //instanceia e cadastra um novo usuario no sistema, salvando-o no ArrayList
    public void cadastrarUsuario(String nome, String email, String senha, String login) {
        if (nome != null && email != null && senha != null && login != null) {
            Usuario novoUsuario = new Usuario(nome, email, senha, login); // Cria um novo objeto Usuario
            if (!usuarios.containsKey(login)) { // Verifica se o login já não está cadastrado
                usuarios.put(login, novoUsuario); // Adiciona o usuário ao HashMap
                notifica(); // Notifica os observadores
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Erro: O login já está em uso.");
            }
        } else {
            System.out.println("Erro: Todos os campos devem ser preenchidos.");
        }
    }

    //autentifica o usuario (logar)
    public Usuario autenticarUsuario(String login, String senha) {
        Usuario usuario;
        if (login != null && senha != null) {
            usuario = usuarios.get(login);
            if (usuario != null) {
                if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
                    usuarioAutt = usuario;
                }
            }
        }
        return usuarioAutt;
    }

    //desautentifica o usuario (deslogar)
    public void deslogarUsuario() {
        usuarioAutt = null;
        notifica();
    }

    //retorna o usuario autenticado (usuario logado)
    public Usuario getUsuarioAutt() {
        return usuarioAutt;
    }

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

    //retorna o numero de usuarios cadastrados no HashMap
    public int getTotalUsuarios() {
        return usuarios.size();
    }
}
