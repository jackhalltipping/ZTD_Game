/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 3:33:22 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: ViewObj
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import csci205_final_project.Game;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/**
 *
 * @author emb038
 */
public class ViewObj {

    SimpleDoubleProperty x;
    SimpleDoubleProperty y;
    SimpleDoubleProperty dir = new SimpleDoubleProperty(0);
    Image image;
    StackPane sp;

    public ViewObj(double x, double y, Image image) {
	this.x = new SimpleDoubleProperty(x);
	this.y = new SimpleDoubleProperty(y);
	this.image = image;

	Game.theView.addViewObj(this);

    }

    public double getX() {
	return x.getValue();
    }

    public double getY() {
	return y.getValue();
    }

    public double getDirection() {
	return dir.getValue();
    }

    public double getMoveDirection() {
	return dir.getValue();
    }

    public SimpleDoubleProperty getXProp() {
	return x;
    }

    public SimpleDoubleProperty getYProp() {
	return y;
    }

    public SimpleDoubleProperty getDirectionProp() {
	return dir;
    }

    public Image getImage() {
	return image;
    }

    public void setDirection(double dir) {
	this.dir.set(dir);
    }

    public void frame(double duration) {
	//Overridden to update specific object
    }

    public StackPane getSp() {
	return sp;
    }

    public void setSp(StackPane sp) {
	this.sp = sp;
    }

}
