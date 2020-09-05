/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Jocelyn
 */
public class Menu{
    
        CheckBox C1,C2,C3,C4,C5;
        Button SubmitBtn,exitBtn;
        String CustomerFeedback;
        TextArea descriptionTA;
        GridPane G1,G2;
        BorderPane B1,B2;
        //Order CheckBox
        CheckBox F1, F2, F3, F4, F5, F6, F7, F8, F9, F10;
        //Button TotalPrice
        Button TotalBTN;
        //Quantity TextField
        TextField T1, T2, T3, T4, T5, T6, T7, T8, T9, T10;
        //Customize Combo Box
        ComboBox SelectCB1, SelectCB2, SelectCB3, SelectCB4, SelectCB5, SelectCB6, SelectCB7, SelectCB8, SelectCB9, SelectCB10;
        //Option for ComboBox
        String [] SelectOption={"original","spicy","cheese","meal"};
        ObservableList<String> OptionList = FXCollections.observableArrayList(SelectOption);
        //Quantity
        int Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10;
        //Quantity String
        String sT1, sT2, sT3, sT4, sT5, sT6, sT7, sT8, sT9, sT10;
        //Food Price
        int FP1, FP2, FP3, FP4, FP5, FP6, FP7, FP8, FP9, FP10;
        //Food Name
        String FN1, FN2, FN3, FN4, FN5, FN6, FN7, FN8, FN9, FN10;
        //Single Itme
        double Income1, Income2, Income3, Income4, Income5, Income6, Income7, Income8, Income9, Income10;
        //Tax1 = SST Tax2 = Service Tax
        double Tax1,Tax2;
        //Total Income before add tax
        double Total;
        //Total Price(Print at the Receipt)
        double Price;
        //ComboBox Option Price
        int Ori = 5;
        int Spi = 10;
        int Che = 15;
        int Meal = 20;
        
        
    public void start(Receipt r) {
        Stage primaryStage = new Stage();
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:ANTIQUEWHITE");
        G1 = new GridPane();
        B1 = new BorderPane();
        G1.setHgap(10);
        G1.setVgap(5);
        B1.setTop(new Label("PizzaHut Menu"));
        B1.setPadding(new Insets(0, 0, 0, 100));
        pane.getChildren().add(B1);
        
        G1.add(new Label(), 0, 0);
        G1.add(new Label("1. Aloha Chicken PizzaHut"), 0, 1);
        G1.add(new Label("2. BBQ Chicken PizzaHut"), 0, 2);
        G1.add(new Label("3. Classic Chicken PizzaHut"), 0, 3);
        G1.add(new Label("4. Seafood Delight PizzuHut"), 0, 4);
        G1.add(new Label("5. Heat Mania PizzuHut"), 0, 5);
        G1.add(new Label("6. Flaming Tuna PizzuHut"), 0, 6);
        G1.add(new Label("7. Tuna Extreme PizzuHut"), 0, 7);
        G1.add(new Label("8. Prawn Passion PizzuHut"), 0, 8);
        G1.add(new Label("9. Meatasaurus PizzuHut"), 0, 9);
        G1.add(new Label("10. Peperoni PizzuHut"), 0, 10);

        G1.add(new Label("RM20"), 1, 1);
        G1.add(new Label("RM25"), 1, 2);
        G1.add(new Label("RM30"), 1, 3);
        G1.add(new Label("RM25"), 1, 4);
        G1.add(new Label("RM20"), 1, 5);
        G1.add(new Label("RM20"), 1, 6);
        G1.add(new Label("RM25"), 1, 7);
        G1.add(new Label("RM25"), 1, 8);
        G1.add(new Label("RM30"), 1, 9);
        G1.add(new Label("RM25"), 1, 10);

        G1.add(F1 = new CheckBox(), 2, 1);
        G1.add(F2 = new CheckBox(), 2, 2);
        G1.add(F3 = new CheckBox(), 2, 3);
        G1.add(F4 = new CheckBox(), 2, 4);
        G1.add(F5 = new CheckBox(), 2, 5);
        G1.add(F6 = new CheckBox(), 2, 6);
        G1.add(F7 = new CheckBox(), 2, 7);
        G1.add(F8 = new CheckBox(), 2, 8);
        G1.add(F9 = new CheckBox(), 2, 9);
        G1.add(F10 = new CheckBox(), 2, 10);

        G1.add(TotalBTN = new Button("Total"), 2, 12);
        TotalBTN.setTextFill(Color.DARKSALMON);
        TotalBTN.setFont(Font.font("Agency FB",FontWeight.EXTRA_BOLD,15));
        Label L1 = new Label("Ordering List:");
        Label L2 = new Label();
        L1.setPadding(new Insets(25,0,0,450));
        L2.setPadding(new Insets(45,0,0,450));
        pane.getChildren().addAll(L1,L2);
        
        G1.setHgap(10);
        G1.setVgap(5);
        pane.getChildren().addAll(G1);
        
        
        F1.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T1 = new TextField(), 3, 1);
            T1.setPrefWidth(40.0);
            SelectCB1 = new ComboBox(OptionList);
            G1.add(SelectCB1,4,1);
        });
        
        F2.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T2 = new TextField(), 3, 2);
            T2.setPrefWidth(40.0);
            SelectCB2 = new ComboBox(OptionList);
            G1.add(SelectCB2,4,2);
        });
        
        F3.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T3 = new TextField(), 3, 3);
            T3.setPrefWidth(40.0);
            SelectCB3 = new ComboBox(OptionList);
            G1.add(SelectCB3,4,3);
        });
        
        F4.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T4 = new TextField(), 3, 4);
            T4.setPrefWidth(40.0);
            SelectCB4 = new ComboBox(OptionList);
            G1.add(SelectCB4,4,4);
        });
        
        F5.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T5 = new TextField(), 3, 5);
            T5.setPrefWidth(40.0);
            SelectCB5 = new ComboBox(OptionList);
            G1.add(SelectCB5,4,5);
        });
        
        F6.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T6 = new TextField(), 3, 6);
            T6.setPrefWidth(40.0);
            SelectCB6 = new ComboBox(OptionList);
            G1.add(SelectCB6,4,6);
        });
        
        F7.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T7 = new TextField(), 3, 7);
            T7.setPrefWidth(40.0);
            SelectCB7 = new ComboBox(OptionList);
            G1.add(SelectCB7,4,7);
        });
        
        F8.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T8 = new TextField(), 3, 8);
            T8.setPrefWidth(40.0);
            SelectCB8 = new ComboBox(OptionList);
            G1.add(SelectCB8,4,8);
        });
        
        F9.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T9 = new TextField(), 3, 9);
            T9.setPrefWidth(40.0);
            SelectCB9 = new ComboBox(OptionList);
            G1.add(SelectCB9,4,9);
        });
        
        F10.setOnAction(e -> {
            L2.setText(getResult());
            G1.add(T10 = new TextField(), 3, 10);
            T10.setPrefWidth(40.0);
            SelectCB10 = new ComboBox(OptionList);
            G1.add(SelectCB10,4,10);
        });
        
        
        TotalBTN.setOnAction(e -> {
            try{
               JOptionPane.showMessageDialog(null, r.toString()+ "\nFood: \n" + getFood()+ "\nTotal:      RM "+ 
                    getPrice(), "Receipt", JOptionPane.INFORMATION_MESSAGE);
               int dialogboxBTN = JOptionPane.OK_OPTION;
                    if(dialogboxBTN == JOptionPane.OK_OPTION){
                        feedback();
                    }
            }catch(NumberFormatException Z){
                JOptionPane.showMessageDialog(null,"Waiting Enter the Quantity");
            }catch(NullPointerException Z){
                JOptionPane.showMessageDialog(null, "Waiting Enter the Flavour");
            }
        });
        
        Scene scene = new Scene(pane, 600, 420);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }
    
     public String getFood() {
        String msg = "";
        if (F1.isSelected()) {
            try{
                FN1 = "Aloha McChicken          RM20\n";
                String q1Str = T1.getText();
                Q1 = Integer.parseInt(q1Str);
                msg = msg + FN1 + "(" + SelectCB1.getValue() + ")"+ "     ----- " + Q1  + "\n";
            }catch(NullPointerException Z){
                JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
            
            
        }
        if (F2.isSelected()) {
            try{
                FN2 = "BBQ Chicken              RM25\n";
                String q2Str = T2.getText();
                Q2 = Integer.parseInt(q2Str);
                msg = msg + FN2 +  "(" + SelectCB2.getValue() + ")"+ "     ----- " + Q2  + "\n";
            }catch(NullPointerException Z){
                JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
        }
        if (F3.isSelected()) {
            try{
                FN3 = "Classic Chicken          RM30\n";
                String q3Str = T3.getText();
                Q3 = Integer.parseInt(q3Str);
                msg = msg + FN3 + "(" + SelectCB3.getValue() + ")"+  "     ----- " + Q3  + "\n";
            }catch(NullPointerException Z){
                JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
            
        }
        if (F4.isSelected()) {
            try{
                FN4 = "Seafood Delight          RM25\n";
                String q4Str = T4.getText();
                Q4 = Integer.parseInt(q4Str);
                msg = msg + FN4 + "(" + SelectCB4.getValue() + ")"+  "     ----- " + Q4  + "\n";
             }catch(NullPointerException Z){
                JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            
            }
            
        }
        if (F5.isSelected()) {
            try{
                FN5 = "Heat Mania               RM20\n";
                String q5Str = T5.getText();
                Q5 = Integer.parseInt(q5Str);
                msg = msg + FN5 + "(" + SelectCB5.getValue() + ")"+  "     ----- " + Q5  + "\n";
            }catch(NullPointerException Z){
                 JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
            
        }
        if (F6.isSelected()) {
            try{
                FN6 = "Flaming Tuna             RM20\n";
                String q6Str = T6.getText();
                Q6 = Integer.parseInt(q6Str);
               msg = msg + FN6 + "(" + SelectCB6.getValue() + ")"+  "     ----- " + Q6  + "\n";
            }catch(NullPointerException Z){
                JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
            
        }
        if (F7.isSelected()) {
            try{
                FN7 = "Tuna Extreme             RM25\n";
                String q7Str = T7.getText();
                Q7 = Integer.parseInt(q7Str);
                msg = msg + FN7 + "(" + SelectCB7.getValue() + ")"+  "     ----- " + Q7  + "\n";
            }catch(NullPointerException Z){
                JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
            
        }
        if (F8.isSelected()) {
            try{
                FN8 = "Prawn Passion            RM25\n";
                String q8Str = T8.getText();
                Q8 = Integer.parseInt(q8Str);
                msg = msg + FN8 + "(" + SelectCB8.getValue() + ")"+  "     ----- " + Q8  + "\n";
            }catch(NullPointerException Z){
                JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
            
        }
        if (F9.isSelected()) {
            try{
                FN9 = "Meatasaurus              RM30\n";
                String q9Str = T9.getText();
                Q9 = Integer.parseInt(q9Str);
                msg = msg + FN9 + "(" + SelectCB9.getValue() + ")"+  "     ----- " + Q9  + "\n";
            }catch(NullPointerException Z){
                 JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
            
        }
        if (F10.isSelected()) {
            try{
                FN10 = "Peperoni                RM25\n";
                String q10Str = T10.getText();
                Q10 = Integer.parseInt(q10Str);
                msg = msg + FN10 + "(" + SelectCB10.getValue() + ")"+  "     ----- " + Q10  + "\n";
            }catch(NullPointerException Z){
                 JOptionPane.showMessageDialog(null,"Must be Select the Combo Box");
            }
            
        }
        return msg;
    }
        
        public double getPrice(){
            
            if(F1.isSelected()){
                try{
                String a1 = (String) SelectCB1.getValue();
                FP1 = 20;
                sT1 = T1.getText();
                Q1 = Integer.parseInt(sT1);               
                switch(a1){
                    case "original":    Income1 = FP1 + Ori;break;
                    case "spicy":       Income1 = FP1 + Spi;break;
                    case "cheese":      Income1 = FP1 + Che;break;
                    case "meal":        Income1 = FP1 + Meal;break;
                    }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
                }
            
            if(F2.isSelected()){
                try{
                String a2 = (String) SelectCB2.getValue();
                FP2 = 25;
                sT2 = T2.getText();
                Q2 = Integer.parseInt(sT2);
                switch(a2){
                    case "original":    Income2 = FP2 + Ori; break;
                    case "spicy":       Income2 = FP2 + Spi; break;
                    case "cheese":      Income2 = FP2 + Che; break;
                    case "meal":        Income2 = FP2 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            if(F3.isSelected()){
                try{
                String a3 = (String) SelectCB3.getValue();
                FP3 = 30;
                sT3 = T3.getText();
                Q3 = Integer.parseInt(sT3);
                switch(a3){
                    case "original":    Income3 = FP3 + Ori; break;
                    case "spicy":       Income3 = FP3 + Spi; break;
                    case "cheese":      Income3 = FP3 + Che; break;
                    case "meal":        Income3 = FP3 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            if(F4.isSelected()){
                try{
                String a4 = (String) SelectCB4.getValue();
                FP4 = 25;
                sT4 = T4.getText();
                Q4 = Integer.parseInt(sT4);
                switch(a4){
                    case "original":    Income4 = FP4 + Ori; break;
                    case "spicy":       Income4 = FP4 + Spi; break;
                    case "cheese":      Income4 = FP4 + Che; break;
                    case "meal":        Income4 = FP4 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            if(F5.isSelected()){
                try{
                String a5 = (String) SelectCB5.getValue();
                FP5 = 20;
                sT5 = T5.getText();
                Q5 = Integer.parseInt(sT5);
                switch(a5){
                    case "original":    Income5 = FP5 + Ori; break;
                    case "spicy":       Income5 = FP5 + Spi; break;
                    case "cheese":      Income5 = FP5 + Che; break;
                    case "meal":        Income5 = FP5 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            if(F6.isSelected()){
                try{
                String a6 = (String) SelectCB6.getValue();
                FP6 = 20;
                sT6 = T6.getText();
                Q6 = Integer.parseInt(sT6);
                switch(a6){
                    case "original":    Income6 = FP6 + Ori; break;
                    case "spicy":       Income6 = FP6 + Spi; break;
                    case "cheese":      Income6 = FP6 + Che; break;
                    case "meal":        Income6 = FP6 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            if(F7.isSelected()){
                try{
                String a7 = (String) SelectCB7.getValue();
                FP7 = 25;
                sT7 = T7.getText();
                Q7 = Integer.parseInt(sT7);
                switch(a7){
                    case "original":    Income7 = FP7 + Ori; break;
                    case "spicy":       Income7 = FP7 + Spi; break;
                    case "cheese":      Income7 = FP7 + Che; break;
                    case "meal":        Income7 = FP7 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            if(F8.isSelected()){
                try{
                String a8 = (String) SelectCB8.getValue();
                FP8 = 25;
                sT8 = T8.getText();
                Q8 = Integer.parseInt(sT8);
                switch(a8){
                    case "original":    Income8 = FP8 + Ori; break;
                    case "spicy":       Income8 = FP8 + Spi; break;
                    case "cheese":      Income8 = FP8 + Che; break;
                    case "meal":        Income8 = FP8 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            if(F9.isSelected()){
                try{
                String a9 = (String) SelectCB9.getValue();
                FP9 = 30;
                sT9 = T9.getText();
                Q9 = Integer.parseInt(sT9);
                switch(a9){
                    case "original":   Income9 = FP9 + Ori; break;
                    case "spicy":      Income9 = FP9 + Spi; break;
                    case "cheese":     Income9 = FP9 + Che; break;
                    case "meal":       Income9 = FP9 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            if(F10.isSelected()){
                try{
                String a10 = (String) SelectCB10.getValue();
                FP10 = 25;
                sT10 = T10.getText();
                Q10 = Integer.parseInt(sT10);
                switch(a10){
                    case "original":    Income10 = FP10 + Ori; break;
                    case "spicy":       Income10 = FP10 + Spi; break;
                    case "cheese":      Income10 = FP10 + Che; break;
                    case "meal":        Income10 = FP10 + Meal;break;
                }
                }catch(NumberFormatException Z){
                    JOptionPane.showMessageDialog(null,"Must be Enter the Quantity");
                }
            }
            
            Price = (Income1*Q1)+(Income2*Q2)+(Income3*Q3)+(Income4*Q4)+(Income5*Q5)+(Income6*Q6)
                    +(Income7*Q7)+(Income8*Q8)+(Income9*Q9)+(Income10*Q10);
            
            return Price; 
        }
        
        public String getResult() {
        String msg = "";
        if (F1.isSelected()) {
            msg += "\nAloha McChicken";
        }
        if (F2.isSelected()) {
            msg += "\nBBQ Chicken";
        }
        if (F3.isSelected()) {
            msg += "\nClassic Chicken";
        }
        if (F4.isSelected()) {
            msg += "\nSeafood Delight";
        }
        if (F5.isSelected()) {
            msg += "\nHeat Mania";
        }
        if (F6.isSelected()) {
            msg += "\nFlaming Tuna";
        }
        if (F7.isSelected()) {
            msg += "\nTuna Extreme";
        }
        if (F8.isSelected()) {
            msg += "\nPrawn Passion";
        }
        if (F9.isSelected()) {
            msg += "\nMeatasaurus";
        }
        if (F10.isSelected()) {
            msg += "\nPeperoni";
        }
        return msg;
    }
       public void feedback(){
            Stage primaryStage = new Stage();
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color:ANTIQUEWHITE");
            GridPane G2 = new GridPane();
            G2.add(new Label("Customer Feedback"), 1, 3);
            G2.add(new Label(),1,4);
            G2.add(C1 = new CheckBox("Very Good"), 1, 5);
            G2.add(C2 = new CheckBox("Good"), 1, 6);
            G2.add(C3 = new CheckBox("Normal"), 1, 7);
            G2.add(C4 = new CheckBox("Poor"), 1, 8);
            G2.add(C5 = new CheckBox("Worst"), 1, 9);
            G2.add(new Label(),1,10);
            G2.add(descriptionTA = new TextArea("Write some text here"),1,11);
            G2.add(SubmitBtn = new Button("Submit"),1,12);
            G2.add(exitBtn = new Button("Exit"),2,12);
            SubmitBtn.setTextFill(Color.DARKSALMON);
            SubmitBtn.setFont(Font.font("Agency FB",FontWeight.EXTRA_BOLD,15));
            exitBtn.setTextFill(Color.DARKSALMON);
            exitBtn.setFont(Font.font("Agency FB",FontWeight.EXTRA_BOLD,15));
            descriptionTA.setPrefColumnCount(20);
            descriptionTA.setPrefRowCount(5);
            G2.setHgap(10);
            G2.setVgap(5);
            
            pane.getChildren().addAll(G2);
            
            exitBtn.setOnAction(e->{
                int dialogBtn=JOptionPane.YES_OPTION;
                dialogBtn=JOptionPane.showConfirmDialog(null,"Do you want to exit?","exit",dialogBtn);
                if(dialogBtn==JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"Thank You,Welcome Again");
                    System.exit(0);
                }else if(dialogBtn==JOptionPane.NO_OPTION){
                    int dialogBtn1 = JOptionPane.YES_NO_CANCEL_OPTION;
                }
            });
            
            C1.setOnAction(e->{
                if(C1.isSelected()){
                    C2.setSelected(false);
                    C3.setSelected(false);
                    C4.setSelected(false);
                    C5.setSelected(false);
                }
            });

            C2.setOnAction(e->{
                if(C2.isSelected()){
                    C1.setSelected(false);
                    C3.setSelected(false);
                    C4.setSelected(false);
                    C5.setSelected(false);
                }
            });

            C3.setOnAction(e->{
                if(C3.isSelected()){
                    C2.setSelected(false);
                    C1.setSelected(false);
                    C4.setSelected(false);
                    C5.setSelected(false);
                }
            });

            C4.setOnAction(e->{
                if(C4.isSelected()){
                    C2.setSelected(false);
                    C3.setSelected(false);
                    C1.setSelected(false);
                    C5.setSelected(false);
                }
            });

            C5.setOnAction(e->{
                if(C5.isSelected()){
                    C2.setSelected(false);
                    C3.setSelected(false);
                    C4.setSelected(false);
                    C1.setSelected(false);
                }
            });
            
            SubmitBtn.setOnMouseClicked(e->{
                        JOptionPane.showMessageDialog(null,"Feedback is set to the System.Pls Enter Exit Button");
                    });
            
            SubmitBtn.setOnAction(e->{
                try{
                    
                File file = new File("CustomerFeedback.txt");
                PrintWriter output = new PrintWriter(file);
                FileOutputStream output1 = new FileOutputStream("CustomerFeedback.dat",true);
                DataOutputStream outputData = new DataOutputStream(output1);
                CustomerFeedback = descriptionTA.getText();

                if(C1.isSelected()){
                    outputData.writeUTF("Very Good");
                    output.println("Very Good");
                }

                if(C2.isSelected()){
                    outputData.writeUTF("Good");
                    output.println("Good");
                }

                if(C3.isSelected()){
                    outputData.writeUTF("Normal");
                    output.println("Normal");
                }

                if(C4.isSelected()){
                    outputData.writeUTF("Poor");
                    output.println("Poor");
                }

                if(C5.isSelected()){
                    outputData.writeUTF("Worst");
                    output.println("Worst");
                }

                outputData.writeUTF(CustomerFeedback);
                output.println(CustomerFeedback);
                output.close();
                output1.close();

                FileInputStream input = new FileInputStream("CustomerFeedback.dat");
                DataInputStream inputData = new DataInputStream(input);
                while(inputData.available()>0){
                    System.out.println(inputData.readUTF());
                }
                inputData.close();
                }catch(FileNotFoundException A){
                    System.out.println("File no Found");
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            Scene scene = new Scene(pane, 320, 330);
            primaryStage.setTitle("Customer Feedback");
            primaryStage.setScene(scene);
            primaryStage.showAndWait();
       }
}
