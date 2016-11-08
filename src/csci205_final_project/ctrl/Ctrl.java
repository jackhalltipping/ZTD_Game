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
import csci205_final_project.view.View;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    }
}