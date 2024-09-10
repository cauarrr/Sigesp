
package sigesp.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sigesp.model.Model;
import sigesp.model.Professor;
import sigesp.model.Usuario;
import sigesp.view.LoginView;
import sigesp.view.TelaProfessorView;

public class CadastroProjetoController extends BaseController implements Initializable {
    
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
    private TextField nomeProjeto;
    
    @FXML
    private TextField coordenadorProjeto;
    
    @FXML
    private DatePicker dataInicioProjeto;
    
    @FXML
    private TextArea descricaoProjeto;
    
    
    @FXML
    private void cadastrarProjeto(){
        String nome = nomeProjeto.getText();
        String coordenador = coordenadorProjeto.getText();
        LocalDate dataInicio = dataInicioProjeto.getValue();
        String descricao = descricaoProjeto.getText();
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
