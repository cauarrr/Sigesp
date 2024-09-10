
package sigesp.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sigesp.model.Model;
import sigesp.model.Professor;
import sigesp.model.Usuario;
import sigesp.view.LoginView;
import sigesp.view.TelaProfessorView;

public class CadastroProcessoController extends BaseController implements Initializable {
    
    private Usuario usuarioAutt;
    
    public void setModel(Model model){
        this.model = model;
        this.usuarioAutt = model.getUsuarioAutt();
        atualizarTela();
    }
    
    @FXML
    private Label titulo;
    
    @FXML
    private Label nomeLabel;
    
    @FXML
    private Label emailLabel;
    
    @FXML
    private Label matriculaLabel;
    
    @FXML
    private RadioButton opcaoPessoas;
    
    @FXML
    private RadioButton opcaoProjetos;
            
    @FXML
    private TextField nomeProcesso;
    
    @FXML
    private ComboBox membroBanca1;
    
    @FXML
    private ComboBox membroBanca2;
    
    @FXML
    private ComboBox membroBanca3;
    
    @FXML
    private TextArea descricaoProcesso;
    
    @FXML
    private TextField numVagas;
    
    @FXML
    private DatePicker dataInscricoes;
    
    @FXML
    private DatePicker dataFimInscricoes;
    
    
    @FXML
    private void cadastrar(){
        if(opcaoPessoas.isSelected()){
            cadastrarProcessoPessoas();
        } else if (opcaoProjetos.isSelected()){
            System.out.println("Implementar o método cadastrar processo seletivo de projetos");
        } else {
            String mensagem = "Indique se esse processo seletivo é de pessoas ou projetos";
            mostrarJanelaErro(mensagem);
        }
    }
    
    private void cadastrarProcessoPessoas(){
        String nome = nomeProcesso.getText();
        String descricao = descricaoProcesso.getText();
        String vagas = numVagas.getText();
        LocalDate dtInicioInscricoes = dataInscricoes.getValue();
        LocalDate dtFimInscricoes = dataFimInscricoes.getValue();
        String membro1 = (String) membroBanca1.getValue();
        String membro2 = (String) membroBanca2.getValue();
        String membro3 = (String) membroBanca3.getValue();
        Usuario professor1 = model.getProfessor(membro1);
        Usuario professor2 = model.getProfessor(membro2);
        Usuario professor3 = model.getProfessor(membro3);
        ArrayList<Usuario> banca = new ArrayList();
        banca.add(professor1);
        banca.add(professor2);
        banca.add(professor3);
        model.cadastrarSelecaoPessoas(nome, descricao, vagas, dtInicioInscricoes, dtFimInscricoes, banca);
        System.out.println("\nProcesso Seletivo Cadastrado\n");
    }
    
    @FXML
    private void carregarTelaInicial() {
        
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        TelaProfessorView.carregar(stage, model); 
    }
    
    @FXML
    private void carregarTelaLogin() {
        
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        LoginView.carregar(stage, model);
    }
    
    public void atualizarTela(){
        if (usuarioAutt != null) {
            nomeLabel.setText(usuarioAutt.getNome());
            emailLabel.setText(usuarioAutt.getEmail());
            Professor vinculo = (Professor) usuarioAutt.getVinculo();
            String matriculaText = "Siape: " + vinculo.getSiape();
            matriculaLabel.setText(matriculaText);
        }
    }
    
    @FXML
    private void limparCampos(){
        nomeProcesso.clear();
        descricaoProcesso.clear();
        numVagas.clear();
        dataInscricoes.setValue(null);
        dataFimInscricoes.setValue(null);
        membroBanca1.setValue(null);
    }
    
    public static void mostrarJanelaErro(String mensagem) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText(null); // Nenhum cabeçalho
        alerta.setContentText(mensagem); // Define a mensagem do erro
        
        alerta.showAndWait(); // Exibe a janela e aguarda a interação do usuário
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> membros = FXCollections.observableArrayList(
            
        );
        List<String> professores = model.getNomesProfessores();
        for(String nome: professores){
            membros.add(nome);
        }
        // Define os itens em cada ComboBox
        membroBanca1.setItems(membros);
        membroBanca2.setItems(membros);
        membroBanca3.setItems(membros);
        
        // Inicializações necessárias quando a tela é carregada
        ToggleGroup toggleGroup = new ToggleGroup();
        opcaoPessoas.setToggleGroup(toggleGroup);
        opcaoProjetos.setToggleGroup(toggleGroup);
    }    
    
}
