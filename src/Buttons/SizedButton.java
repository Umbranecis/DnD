package Buttons;

import javafx.scene.control.Button;

public class SizedButton extends Button {
    public SizedButton (String t){
        this.setPrefSize(400, 100);
        this.setText(t);
    }

    public SizedButton (){
        this.setPrefSize(400, 100);
    }
}
