
package sigesp.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sigesp.model.Aluno;
import sigesp.model.Model;
import sigesp.model.Professor;
import sigesp.model.Usuario;
import sigesp.view.AcompanharCandidaturaView;
import sigesp.view.LoginView;
import sigesp.view.TelaAlunoView;
import sigesp.view.TelaProfessorView;

public class InscricaoController extends BaseController implements Initializable {
    
    Usuario usuario;
    
    public void setModel(Model model){
        this.model = model;
        this.usuario = model.getUsuarioAutt();
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
    private ComboBox processosCombo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> processosDisponiveis = FXCollections.observableArrayList();
        List<String> processos = model.getNomesProcessos();
        for(String nome: processos){
            processosDisponiveis.add(nome);
        }
        // Define os itens em cada ComboBox
        processosCombo.setItems(processosDisponiveis);
        
    }    

    @FXML
    private void carregarTelaInicial() {
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        if(usuario.getVinculo() instanceof Aluno){
            TelaAlunoView.carregar(stage, model);
        } else{
            TelaProfessorView.carregar(stage, model);
        }
    }
    @FXML
    private void carregarTelaLogin() {
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        LoginView.carregar(stage, model);
    }
    
    @FXML
    public void atualizarTela(){
        if (usuario != null) {
            nomeLabel.setText(usuario.getNome());
            emailLabel.setText(usuario.getEmail());
            
            if(usuario.getVinculo() instanceof Aluno){
                Aluno vinculo = (Aluno) usuario.getVinculo();
                String matriculaText = "Maricula: " + vinculo.getMatricula();
                matriculaLabel.setText(matriculaText);
            }else{
                Professor vinculo = (Professor) usuario.getVinculo();
                String matriculaText = "Siape: " + vinculo.getSiape();
                matriculaLabel.setText(matriculaText);
            }    
        }
    }
    
}
