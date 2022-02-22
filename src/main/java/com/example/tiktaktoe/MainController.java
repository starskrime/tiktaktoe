package com.example.tiktaktoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    Boolean order;
    int count=0;
    String btnMessage = new String("O");
    HashMap<String,Boolean> grid  = new HashMap<String,Boolean>(){{
        put("B1",false);
        put("B2",false);
        put("B3",false);
        put("B4",false);
        put("B5",false);
        put("B6",false);
        put("B7",false);
        put("B8",false);
        put("B9",false);
    }};


    @FXML
    protected void onButtonClick(ActionEvent event) {
        count++;
        final Node node = (Node) event.getSource();

        final String buttonId = node.getId();

        final Button button = (Button) event.getSource();;
        button.setId(buttonId);
        button.setDisable(true);
        if (isUser(count)){
            btnMessage = "X";
        }else {
            btnMessage = "O";
        }
        button.setText(btnMessage);
        grid.put(buttonId,true);
        System.out.println(isFinished());
    }

    boolean isUser (int number){
        if (order == null){
            order = false;
        }
        if (number % 2 == 0){
            return false;
        }
        return true;
    }
        public boolean isFinished(){
        Boolean status = true;
        for ( Boolean key : grid.values()){
            status = status & key;
        }
        return status;
}




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}