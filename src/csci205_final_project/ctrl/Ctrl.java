/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 2:53:07 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.ctrl
* File: Ctrl
* Description:
*
* ****************************************
 */
package csci205_final_project.ctrl;

import csci205_final_project.model.Model;
import csci205_final_project.model.Tower;
import csci205_final_project.view.View;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author emb038
 */
public class Ctrl {
    View theView;
    Model theModel;

    public Ctrl(Model theModel, View theView) {
	this.theModel = theModel;
	this.theView = theView;
    }

    public void setKeyBindings() {
	theView.getRoot().setOnKeyPressed(new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent ke) {
		if (ke.getCode().equals(KeyCode.RIGHT)) {
		    theModel.getPlayer().move(0);
		}
		if (ke.getCode().equals(KeyCode.UP)) {
		    theModel.getPlayer().move(1);
		}
		if (ke.getCode().equals(KeyCode.LEFT)) {
		    theModel.getPlayer().move(2);
		}
		if (ke.getCode().equals(KeyCode.DOWN)) {
		    theModel.getPlayer().move(3);
		}
	    }
	});
        
        theView.getRoot().setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                double mouseX = event.getSceneX();
                double mouseY = event.getSceneY();
                Tower tower = theModel.placeTower(convertX(mouseX), convertY(mouseY));
                //ImageView imgView = new Image(tower.getImage());
            }
            
        });
    }
    
    public double convertX(double x) {
        int tileSize = 50;
        return x - (x % tileSize);
    }
    
    public double convertY(double y) {
        int tileSize = 50;
        return y - (y % tileSize);
    }
}
