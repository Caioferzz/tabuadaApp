package br.senai.sp.jandira.tabuada.iu;

import br.senai.sp.jandira.tabuada.model.TabuadaApp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Optional;

public class TelaTabuada extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Definir o tamanho da tela
        // stage.setWidth(500);
        // stage.setHeight(500);
        stage.setTitle("Tabuada");
        stage.setResizable(false);

        // Criar o root - componente de layout principal
        // Root = raiz
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #10c7ff");

        // Criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);

        // Criar o header da tela
        VBox header = new VBox();
        // header.setPrefHeight(100);
        // header.setStyle("-fx-background-color: #ff0000");

        // Colocar o conteúdo do header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setPadding(new Insets(8, 8, 0, 8));
        labelTitulo.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 20; -fx-font-weight: bold");
        Label labelSubTitulo = new Label("Crie a tabuada que a sua imaginação mandar.");
        labelSubTitulo.setPadding(new Insets(0, 8, 8, 8));

        // Colocar os labels dentro do header
        header.getChildren().addAll(labelTitulo, labelSubTitulo);

        // Criar o grid de formulário
        GridPane gridFormulario = new GridPane();
        gridFormulario.setVgap(10);
        gridFormulario.setHgap(10);
        gridFormulario.setPadding(new Insets(16, 8, 16, 8));
        // gridFormulario.setPrefHeight(100);
        // gridFormulario.setStyle("-fx-background-color: #6c4f4f");

        // Criar conteúdo do gridFormulário
        Label labelMultiplicando = new Label("Multiplicando: ");
        TextField textFieldMultiplicando = new TextField();
        Label labelMenorMultiplicador = new Label("Menor Multiplicador: ");
        TextField textFieldMenorMultiplicador = new TextField();
        Label labelMaiorMultiplicador = new Label("Maior Multiplicador: ");
        TextField textFieldMaiorMultiplicador = new TextField();

        // Colocar os componentes no grid
        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldMultiplicando, 1, 0);
        gridFormulario.add(labelMenorMultiplicador, 0, 1);
        gridFormulario.add(textFieldMenorMultiplicador, 1, 1);
        gridFormulario.add(labelMaiorMultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiorMultiplicador, 1, 2);


        // Criar caixa dos botões
        Pane paneButtons = new Pane();

        HBox boxbotoes = new HBox();
        boxbotoes.setPadding(new Insets(8));
        boxbotoes.setSpacing(10);
        paneButtons.getChildren().add(boxbotoes);


        // Criar conteúdo nos botões
        Button buttonCalcular = new Button("Calcular");
        Button buttonLimpar = new Button("Limpar");
        Button buttonSair = new Button("Sair");

        // Colocar os componentes nos botões
        boxbotoes.getChildren().addAll(buttonCalcular, buttonLimpar, buttonSair);

        // Criar caixa de resultado
        VBox boxResultados = new VBox();
        boxResultados.setPrefHeight(300);
        // boxResultados.setStyle("-fx-background-color: green");

        // Criar conteudo da boxResultado
        Label labelResultados = new Label("Resultados:");
        labelResultados.setPadding(new Insets(8, 8, 8, 8));
        labelResultados.setStyle("-fx-text-fill: blue; -fx-font-size: 20");
        ListView listaTabuada = new ListView();
        listaTabuada.setPadding(new Insets(8));
        //listaTabuada.setPrefHeight(100);

        // Adicionar componentes na boxResultado
        boxResultados.getChildren().addAll(labelResultados, listaTabuada);

        // Adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(paneButtons);
        root.getChildren().add(boxResultados);

        // Colocamos a cena no palco
        stage.setScene(scene);

        stage.show();

        buttonCalcular.setOnAction(e -> {
            TabuadaApp tabuada = new TabuadaApp();

            tabuada.multiplicando =
                    Integer.parseInt(textFieldMultiplicando.getText());

            tabuada.multiplicadorInicial =
                    Integer.parseInt(textFieldMenorMultiplicador.getText());

            tabuada.multiplicadorFinal =
                    Integer.parseInt(textFieldMaiorMultiplicador.getText());

            String[] resultado = tabuada.calcularDados();
            listaTabuada.getItems().addAll(resultado);

            // gravar dados da tabuada em arquivo
            Path arquivo = Path.of("C:\\Users\\25203662\\DS1T-javafx\\Tabuada\\dados_tabuada.csv");

            String dados = textFieldMultiplicando.getText() + ";" + textFieldMenorMultiplicador.getText() + ";" + textFieldMaiorMultiplicador.getText() + ";" + LocalDateTime.now() + "\n";

            try {

                Files.writeString(arquivo, dados, StandardOpenOption.APPEND);
            } catch (IOException erro){
                System.out.println(erro.getMessage());
            }
        });
        buttonLimpar.setOnAction(e -> {
            textFieldMaiorMultiplicador.clear();
            textFieldMenorMultiplicador.clear();
            textFieldMultiplicando.clear();
            listaTabuada.getItems().clear();
            textFieldMultiplicando.requestFocus();
        });
        buttonSair.setOnAction(e -> {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Sair do programa?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> resposta = alerta.showAndWait();

            if (resposta.get() == ButtonType.YES) {
                stage.close();
            }

        });
    }
}
