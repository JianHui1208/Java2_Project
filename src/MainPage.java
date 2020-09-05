/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
public class MainPage extends Application {

    Label address;
    TextField nameTF,emailTF,phoneNoTF,addressTF;
    RadioButton deliveryRB,eathereRB;
    Button submitBtn,exitBtn,saveBtn,searchBtn,ClearBtn;
    GridPane g1;
    HBox h1;
    String Name,Email,Phone;
    Receipt r = new Receipt();
    Image icon = new Image("Logo2.png");
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        primaryStage.getIcons().add(icon);
        pane.setStyle("-fx-background-color:ANTIQUEWHITE");
        Label L1 = new Label("Welcome To PizzaHut");
        L1.setFont(Font.font("Verdana",FontWeight.EXTRA_BOLD,50));
        L1.setTextFill(Color.RED);
        L1.setPadding(new Insets(0,0,0,95));
        pane.getChildren().add(L1);
        Label L2 = new Label("Please enter the order information.");
        L2.setFont(Font.font("Verdane",FontWeight.BOLD,30));
        L2.setTextFill(Color.BLACK);
        L2.setPadding(new Insets(80,0,0,10));
        pane.getChildren().add(L2);
        
        h1=new HBox();
        Image img1=new Image(getClass().getResource("Logo.png").toString());
        ImageView view1=new ImageView(img1);
        view1.setFitWidth(75);
        view1.setFitHeight(75);
        h1.getChildren().add(view1);
        pane.getChildren().add(h1);
        
        g1 = new GridPane();
        g1.setHgap(10);
        g1.setVgap(10);
        
        //name
        Label name=new Label("Name: ");
        g1.add(name, 0, 1);
        name.setTextFill(Color.DARKSALMON);
        name.setFont(Font.font("Agency FB",FontWeight.EXTRA_BOLD,25));
        g1.add(nameTF = new TextField(), 1, 1);
        
        //email
        Label email=new Label("Email: ");
        g1.add(email, 0, 2);
        email.setTextFill(Color.DARKSALMON);
        email.setFont(Font.font("Agency FB",FontWeight.EXTRA_BOLD,20));
        g1.add(emailTF = new TextField(), 1, 2); 
        
        //phoneNum
        Label phoneNum=new Label("Phone.No:");
        g1.add(phoneNum, 0, 3);
        phoneNum.setTextFill(Color.DARKSALMON);
        phoneNum.setFont(Font.font("Agency FB",FontWeight.EXTRA_BOLD,20));
        g1.add(phoneNoTF = new TextField(), 1, 3);
        g1.setPadding(new Insets(120,0,0,10));
        pane.getChildren().add(g1);
        
        //radio button
        ToggleGroup group = new ToggleGroup();
        eathereRB = new RadioButton("Eat Here");
        g1.add(eathereRB,0,4);
        eathereRB.setTextFill(Color.DARKSALMON);
        eathereRB.setFont(Font.font("",FontWeight.EXTRA_BOLD,15));
        eathereRB.setToggleGroup(group);
        deliveryRB = new RadioButton("Delivery");
        g1.add(deliveryRB,1,4);
        deliveryRB.setTextFill(Color.DARKSALMON);
        deliveryRB.setFont(Font.font("",FontWeight.EXTRA_BOLD,15));
        deliveryRB.setToggleGroup(group);

        //radio button function
        deliveryRB.setOnAction(e->{
           Address();
           submitBtn();
           searchBtn();
           exitBtn();
        });
        
        //radio button function
        eathereRB.setOnAction(e->{
           submitBtn();
           searchBtn();
           exitBtn();
        });
        
        Scene scene = new Scene(pane, 720, 420);
        primaryStage.setTitle("PizzaHut Ordering System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void searchBtn(){
        HBox H2 = new HBox();
        searchBtn = new Button("Search");
        ClearBtn = new Button("Clear");
        H2.getChildren().addAll(searchBtn,ClearBtn);
        searchBtn.setTextFill(Color.DARKSALMON);
        searchBtn.setFont(Font.font("",FontWeight.EXTRA_BOLD,15));
        ClearBtn.setTextFill(Color.DARKSALMON);
        ClearBtn.setFont(Font.font("",FontWeight.EXTRA_BOLD,15));
        g1.add(H2,1,6);
        searchBtn.setOnAction(e->{
            try{
                String nameStr = nameTF.getText();
                if(nameStr.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter name.");
                }else{
                    String fileName = nameStr + ".dat" ;
                    FileInputStream file = new FileInputStream(fileName);
                    DataInputStream input = new DataInputStream (file);
                    Receipt r = new Receipt();
                    r.setName(nameStr);
                    r.setEmail(input.readUTF());
                    r.setPhoneNum(input.readInt());
                    input.close();
                    emailTF.setText(String.valueOf(r.getEmail()));
                    phoneNoTF.setText(String.valueOf(r.getPhoneNum()));
                }
            }catch(FileNotFoundException A){
                JOptionPane.showMessageDialog(null,"File not exist.");
            } catch (IOException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ClearBtn.setOnAction(e->{
            emailTF.setText("");
            phoneNoTF.setText("");
        });
    }
    public void submitBtn(){
            try {
                String nameStr1=nameTF.getText();
                String emailStr1=emailTF.getText();
                String phonenoStr1=phoneNoTF.getText();
                String fileName=nameStr1+".dat";
                FileOutputStream file=new FileOutputStream(fileName);
                DataOutputStream output=new DataOutputStream(file);
                output.writeUTF(emailStr1);
                output.writeUTF(phonenoStr1);
                output.close();
                JOptionPane.showMessageDialog(null,"Record save successfully");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            g1.add(submitBtn = new Button("Submit"), 0,6);
            submitBtn.setStyle("-fx-background-color:lightgrey");
            submitBtn.setTextFill(Color.DARKSALMON);
            submitBtn.setFont(Font.font("timesroman",FontWeight.EXTRA_BOLD,15));
            submitBtn.setOnAction(e->{
                Menu m = new Menu();
                String name = nameTF.getText();
                String phone = phoneNoTF.getText();
                String email = emailTF.getText();
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter name.");
                }else if(phone.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter phone number.");
                }else if(email.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter email");
                }else{
                    r.setName(name);
                    r.setEmail(email);
                    m.start(r);
                }
                
        });
    }
    public void Address(){
           address=new Label("Address: ");
           g1.add(address, 0, 5);
           address.setTextFill(Color.DARKSALMON);
           address.setFont(Font.font("",FontWeight.EXTRA_BOLD,15));
           g1.add(addressTF = new TextField(), 1, 5);
    }
    
    
    public void exitBtn(){
            g1.add(exitBtn = new Button("Exit"), 2,6);
            exitBtn.setStyle("-fx-background-color:lightgrey");
            exitBtn.setTextFill(Color.DARKSALMON);
            exitBtn.setFont(Font.font("timesroman",FontWeight.EXTRA_BOLD,15));
            exitBtn.setOnAction(e->{
                int dialogBtn=JOptionPane.YES_OPTION;
                dialogBtn=JOptionPane.showConfirmDialog(null,"Do you want to exit?","exit",dialogBtn);
                if(dialogBtn==JOptionPane.YES_OPTION){
                    System.exit(0);
                }else if(dialogBtn==JOptionPane.NO_OPTION){
                    int dialogBtn1 = JOptionPane.YES_NO_CANCEL_OPTION;
                }
            });
    }
    public static void main(String[] args) {
        launch(args);
    }
}