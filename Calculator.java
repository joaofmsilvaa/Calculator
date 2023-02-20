import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;  
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.image.Image;  
import javafx.beans.property.*;


/**
 * Escreva uma descrição da classe database aqui.
 * 
 * @authors (João Calado 24295 / Carlos Álvaro 24291 ) 
 * @version ( vfinal. 23/01/2023)
 * 
 */public class Calculator extends Application

{
    // Mantemos um registro da contagem e um rótulo que apresenta a contagem:
    private int count = 0;
    private Label myLabel = new Label("0");
    private TextField textfield = new TextField("");
    private TextField texfield;
    private boolean dot = false;//Controla o ponto (vírgula) dos números
    private boolean number1Negative = false;//Controla de se o primeiro número é negativo
    private float num1;
    private float num2;
    private boolean sum;
    private boolean div;
    private boolean mult;
    private boolean sub;
    private boolean percent;

    @Override
    public void start(Stage stage)
    {

        // Cria um botão ou um outro controle
        Button sevenButton = new Button("  7  ");
        Button eightButton = new Button("  8  ");
        Button nineButton = new Button("  9  ");

        Button fourButton = new Button("  4  ");
        Button fiveButton = new Button("  5  ");
        Button sixButton = new Button("  6  ");

        Button oneButton = new Button("  1  ");
        Button twoButton = new Button("  2  ");
        Button threeButton = new Button("  3  ");

        Button zeroButton = new Button("  0  ");
        Button pointButton = new Button("   .   ");

        Button cleanButton = new Button("  C  ");
        Button equalsButton = new Button("  =  ");
        Button sumButton = new Button("  +  ");
        Button subButton = new Button("   -   ");
        Button multipButton = new Button("  x  ");
        Button divButton = new Button("  ÷  ");

        //set Styles Button
        sevenButton.setId("number");
        eightButton.setId("number");
        nineButton.setId("number");

        fourButton.setId("number");
        fiveButton.setId("number");
        sixButton.setId("number");

        oneButton.setId("number");
        threeButton.setId("number");
        twoButton.setId("number");

        zeroButton.setId("number");

        pointButton.setId("char");
        cleanButton.setId("clean");
        equalsButton.setId("equals");
        sumButton.setId("char");
        subButton.setId("char");
        multipButton.setId("char");
        divButton.setId("char");

        // Cria um novo painel em grade
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        
        //Define um ação no botão usando uma referência para um método
        sevenButton.setOnAction(this::buttonClick);
        eightButton.setOnAction(this::buttonClick2);
        nineButton.setOnAction(this::buttonClick3);
        fourButton.setOnAction(this::buttonClick4);
        fiveButton.setOnAction(this::buttonClick5);
        sixButton.setOnAction(this::buttonClick6);
        oneButton.setOnAction(this::buttonClick7);
        twoButton.setOnAction(this::buttonClick8);
        threeButton.setOnAction(this::buttonClick9);
        zeroButton.setOnAction(this::buttonClick10);
        pointButton.setOnAction(this::buttonClick11);
        cleanButton.setOnAction(this::buttonClick12);
        equalsButton.setOnAction(this::equals);
        sumButton.setOnAction(this::buttonClick14);
        multipButton.setOnAction(this::buttonClick15);
        divButton.setOnAction(this::buttonClick16);
        subButton.setOnAction(this::buttonClick17);

        //forbids textfield to write from the keyboard
        textfield.setEditable(false);

        //adiona Textfield e a sua posição ao painel 
        pane.add(textfield, 1, 0, 4, 1);

        // Adiciona o botão e o rótulo ao painel
        //pane.add(myLabel, 1, 0);

        pane.add(sevenButton, 0, 1);
        pane.add(eightButton, 1, 1);
        pane.add(nineButton, 2, 1);

        pane.add(fourButton, 0, 2);
        pane.add(fiveButton, 1, 2);
        pane.add(sixButton, 2, 2);

        pane.add(oneButton, 0, 3);
        pane.add(twoButton, 1, 3);
        pane.add(threeButton, 2, 3);

        pane.add(zeroButton, 1, 4);
        pane.add(pointButton, 0, 4);

        pane.add(cleanButton, 0, 0);
        pane.add(equalsButton, 4, 4);
        pane.add(sumButton, 4, 1 );
        pane.add(multipButton, 4, 3);
        pane.add(divButton, 4, 2);
        pane.add(subButton, 2, 4);

        //Definir Style da pane
        pane.getStyleClass().add("pane");

        // O JavaFX deve ter uma 'Scene' (conteúdo da janela) dentro de um 'Stage' (janela)
        Scene scene = new Scene(pane, 225, 265);
        scene.getStylesheets().add("Styles.css");
        stage.setTitle("Calculator");
        stage.setScene(scene);

        
        // Mostra o 'Stage' (janela)
        stage.show();
    }

    private void sum (ActionEvent event)
    {
        num2 = Float.parseFloat(textfield.getText());

        textfield.setText("");

        sum = true;
        sub = false;
        div = false;
        mult = false;
        percent = false;
    }

    private void equals (ActionEvent event) 
    {
        String result;
        if(sum) 
        {
            Float sum1 = (num1) + (num2);
            result = Float.toString(sum1);
            textfield.setText("");
            String input = textfield.getText();
            textfield.setText(result);
            sum = false;
        }

        else if (sub)
        {
            Float sub1 = (num1) - (num2);
            result = Float.toString(sub1);
            textfield.setText("");
            String input = textfield.getText();
            textfield.setText(result);
            textfield.setText(result);
            sub = false;
        }

        else if (div) 
        {
            Float div1 = (num2) / (num1);
            result = Float.toString(div1);
            textfield.setText("");
            String input = textfield.getText();
            textfield.setText(result);
            div = false;
        }

        else if (mult) 
        {
            Float mult1 = (num1) * (num2);
            result = Float.toString(mult1);
            textfield.setText("");
            String input = textfield.getText();
            textfield.setText(result);
            mult = false;
        }

        else if (percent) 

        {
            Float percent1 = ((num2*num1)/ 100) ;
            result = Float.toString(percent1);
            textfield.setText("");
            String input = textfield.getText();
            textfield.setText(result);
            percent = false;
        } 
    }

    
    
    private void buttonClick(ActionEvent event)
    {
        String input = textfield.getText();
        textfield.setText(input + "7");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick2(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "8");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick3(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "9");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick4(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "4");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick5(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "5");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick6(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "6");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick7(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "1");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick8(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "2");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick9(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "3");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick10(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + "0");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick11(ActionEvent event) 
    {
        String input = textfield.getText();
        textfield.setText(input + ".");
        num1 = Float.parseFloat(textfield.getText());
    }

    private void buttonClick12(ActionEvent event) 
    {
        textfield.clear();
    }

    private void buttonClick14(ActionEvent event) 
    {
        String input = textfield.getText();
        num2 = Float.parseFloat(textfield.getText());
        textfield.setText("");
        
        sum = true;
    }

    private void buttonClick15(ActionEvent event)
    {
        String input = textfield.getText();
        num2 = Float.parseFloat(textfield.getText());
        textfield.setText("");
        
        mult = true;
    }

    private void buttonClick16(ActionEvent event) 
    {
        String input = textfield.getText();
        num2 = Float.parseFloat(textfield.getText());
        textfield.setText("");
        div=true;
    }

    private void buttonClick17(ActionEvent event) 
    {
        String input = textfield.getText();
        num2 = Float.parseFloat(textfield.getText());
        textfield.setText("");
        sub=true;
    }

}
