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
 * The class for all the visible objects
 * @author emb038
 */
public class ViewObj {

    SimpleDoubleProperty x;
    SimpleDoubleProperty y;
    SimpleDoubleProperty dir = new SimpleDoubleProperty(0);
    Image image;
    StackPane sp;
    
    /**
     * ViewObject class instantiation
     * @param x
     * @param y
     * @param image 
     */
    public ViewObj(double x, double y, Image image) {
	this.x = new SimpleDoubleProperty(x);
	this.y = new SimpleDoubleProperty(y);
	this.image = image;

	Game.theView.addViewObj(this);
	Game.theView.getMenuRoot().toFront();
    }

    /**
     * getter for the x coordinate
     * @return double coordinate
     */
    public double getX() {
	return x.getValue();
    }

    /**
     * getter for the y coordinate
     * @return double coordinate
     */
    public double getY() {
	return y.getValue();
    }

    /**
     * getter for the direction of the object
     * @return double value
     */
    public double getDirection() {
	return dir.getValue();
    }

    /**
     * Getter for the direction object has to move
     * @return
     */
    public double getMoveDirection() {
	return dir.getValue();
    }

    /**
     * Getter for the x coordinate property
     * @return SimpleDoubleProperty of x
     */
    public SimpleDoubleProperty getXProp() {
	return x;
    }

    /**
     * Getter for the y coordinate property
     * @return SimpleDoubleProperty of y
     */
    public SimpleDoubleProperty getYProp() {
	return y;
    }

    /**
     * Getter for the property of the Direction
     * @return SimpleDoubleProperty of the direction
     */
    public SimpleDoubleProperty getDirectionProp() {
	return dir;
    }

    /**
     * getter for the image
     * @return Image
     */
    public Image getImage() {
	return image;
    }

    /**
     * Sets the direction of the object
     * @param dir
     */
    public void setDirection(double dir) {
	this.dir.set(dir);
    }
    
    /**
     * Skeleton method which is overriden in every different type of the view object
     * @param duration 
     */
    public void frame(double duration) {
	//Overridden to update specific object
    }

    /**
     * Getter for the stack pane
     * @return the StackPane
     */
    public StackPane getSp() {
	return sp;
    }

    /**
     * Instantiates the stack pane
     * @param sp
     */
    public void setSp(StackPane sp) {
	this.sp = sp;
    }

}
