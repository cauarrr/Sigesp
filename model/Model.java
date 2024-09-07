package poo.model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Model {
    private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private ArrayList<ProcessoSeletivo> processosSeletivos = new ArrayList<ProcessoSeletivo>(); // Lista de processos seletivos
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

    // Retorna o usuário de acordo com seu login salvo no HashMap
    public Usuario getUsuario(String login) {
        if (login != null) {
            Usuario usuario = usuarios.get(login);
            return usuario;
        }
        return null;
    }

    // Adiciona um novo usuário no HashMap
    public void setUsuario(Usuario usuario) {
        if (usuario != null) {
            String login = usuario.getLogin();
            if (login != null) {
                usuarios.put(login, usuario);
                notifica();
            }
        }
    }

    // Instancia e cadastra um novo usuário no sistema, salvando-o no HashMap
    public void cadastrarUsuario(String nome, String email, String senha, String login) {
        if (nome != null && email != null && senha != null && login != null) {
            Usuario novoUsuario = new Usuario(nome, email, senha, login); // Cria um novo objeto Usuario
            if (!usuarios.containsKey(login)) { // Verifica se o login já não está cadastrado
                usuarios.put(login, novoUsuario); // Adiciona o usuário ao HashMap
                notifica(); // Notifica os observadores
                // Mensagem de sucesso removida, para simplificação
            } else {
                // Mensagem de erro removida, para simplificação
            }
        } else {
            // Mensagem de erro removida, para simplificação
        }
    }

    // Autentica o usuário (logar)
    public Usuario autenticarUsuario(String login, String senha) {
        Usuario usuario = null;
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

    // Desautentica o usuário (deslogar)
    public void deslogarUsuario() {
        usuarioAutt = null;
        notifica();
    }

    // Retorna o usuário autenticado (usuário logado)
    public Usuario getUsuarioAutt() {
        return usuarioAutt;
    }

    // Adiciona um novo observer na lista de observers
    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    // Exclui um observer da lista de observers
    public void removerObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    // Retorna o número de usuários cadastrados no HashMap
    public int getTotalUsuarios() {
        return usuarios.size();
    }

    // Adiciona um novo processo seletivo ao ArrayList
    public void adicionarProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
        if (processoSeletivo != null) {
            processosSeletivos.add(processoSeletivo);
            notifica();
        }
    }

    // Remove um processo seletivo do ArrayList
    public void removerProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
        if (processoSeletivo != null) {
            processosSeletivos.remove(processoSeletivo);
            notifica();
        }
    }



    //***************GETERS***************
    //********PROSCESSO_SELETIVO**********

    // Retorna o nome do processo seletivo de acordo com o nome fornecido
    public String getNomeProcessoSeletivo(String nome) {
        for (ProcessoSeletivo ps : processosSeletivos) {
            if (ps.getNome().equals(nome)) {
                return ps.getNome();
            }
        }
        return null;
    }
    // Retorna a descrição do processo seletivo de acordo com o nome fornecido
    public String getDescricaoProcessoSeletivo(String nome) {
        for (ProcessoSeletivo ps : processosSeletivos) {
            if (ps.getNome().equals(nome)) {
                return ps.getDescricao();
            }
        }
        return null;
    }
    // Retorna o número de vagas do processo seletivo de acordo com o nome fornecido
    public int getNumVagasProcessoSeletivo(String nome) {
        for (ProcessoSeletivo ps : processosSeletivos) {
            if (ps.getNome().equals(nome)) {
                return ps.getNumVagas();
            }
        }
        return -1; // Retorna um valor inválido se não encontrar
    }
    // Retorna o número de inscritos do processo seletivo de acordo com o nome fornecido
    public int getNumInscritosProcessoSeletivo(String nome) {
        for (ProcessoSeletivo ps : processosSeletivos) {
            if (ps.getNome().equals(nome)) {
                return ps.getNumInscritos();
            }
        }
        return -1; // Retorna um valor inválido se não encontrar
    }
    // Retorna o número de aprovados do processo seletivo de acordo com o nome fornecido
    public int getNumAprovadosProcessoSeletivo(String nome) {
        for (ProcessoSeletivo ps : processosSeletivos) {
            if (ps.getNome().equals(nome)) {
                return ps.getNumAprovados();
            }
        }
        return -1; // Retorna um valor inválido se não encontrar
    }
    // Retorna o status do processo seletivo de acordo com o nome fornecido
    public Fase getStatusProcessoSeletivo(String nome) {
        for (ProcessoSeletivo ps : processosSeletivos) {
            if (ps.getNome().equals(nome)) {
                return ps.getStatus();
            }
        }
        return null;
    }
    // Retorna a avaliação do processo seletivo de acordo com o nome fornecido
    public Avaliacao getAvaliacaoProcessoSeletivo(String nome) {
        for (ProcessoSeletivo ps : processosSeletivos) {
            if (ps.getNome().equals(nome)) {
                return ps.getAvaliacao();
            }
        }
        return null;
    }
    //***************GETERS***************
    //***************USUARIO**************
    
    // Retorna o nome do usuário de acordo com o login fornecido
    public String getNomeUsuario(String login) {
        Usuario usuario = getUsuario(login);
        if (usuario != null) {
            return usuario.getNome();
        }
        return null;
    }
    // Retorna o email do usuário de acordo com o login fornecido
    public String getEmailUsuario(String login) {
        Usuario usuario = getUsuario(login);
        if (usuario != null) {
            return usuario.getEmail();
        }
        return null;
    }
    // Retorna o login do usuário de acordo com o login fornecido
    public String getLoginUsuario(String login) {
        Usuario usuario = getUsuario(login);
        if (usuario != null) {
            return usuario.getLogin();
        }
        return null;
    }
}
