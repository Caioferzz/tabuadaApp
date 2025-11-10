package br.senai.sp.jandira.tabuada.iu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaTabuada extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Definir o tamanho da tela
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setTitle("Tabuada");

        // Criar o root - componente de layout principal
        // Root = raiz
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #10c7ff");

        // Criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);

        // Criar o header da tela
        VBox header = new VBox();
        header.setPrefHeight(100);
        header.setStyle("-fx-background-color: white");

        // Colocar o conteúdo do header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: red; -fx-font-size: 20; -fx-font-weight: bold");
        Label subTitulo = new Label("Crie a tabuada que a sua imaginação mandar.");

        // Colocar os labels dentro do header
        header.getChildren().addAll(labelTitulo, subTitulo);

        // Criar o grid de formulário
        GridPane gridFormulario = new GridPane();
        gridFormulario.setPrefHeight(100);
        gridFormulario.setStyle("-fx-background-color: red");

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
        HBox boxbotoes = new HBox();
        boxbotoes.setPrefHeight(100);
        boxbotoes.setStyle("-fx-background-color: yellow");

        // Criar conteúdo nos botões
        Button buttonCalcular = new Button("Calcular");
        Button buttonLimpar = new Button("Limpar");
        Button buttonSair = new Button("Sair");

        // Colocar os componentes nos botões
        boxbotoes.getChildren().addAll(buttonCalcular, buttonLimpar, buttonSair);

        // Criar caixa de resultado
        VBox boxResultados = new VBox();
        boxResultados.setPrefHeight(100);
        boxResultados.setStyle("-fx-background-color: green");

        // Criar conteudo da boxResultado
        Label labelResultados = new Label("Resultados:");
        ListView listaTabuada = new ListView();

        // Adicionar componentes na boxResultado
        boxResultados.getChildren().addAll(labelResultados, listaTabuada);

        // Adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxbotoes);
        root.getChildren().add(boxResultados);

        // Colocamos a cena no palco
        stage.setScene(scene);





        stage.show();
    }
}
