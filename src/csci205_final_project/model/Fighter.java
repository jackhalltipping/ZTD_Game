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
* File: Fighter
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;

/**
 *
 * @author emb038
 */
public class Fighter {

    SimpleDoubleProperty x;
    SimpleDoubleProperty y;
    Image image;

    public Fighter(double x, double y, Image image) {
	this.x = new SimpleDoubleProperty(x);
	this.y = new SimpleDoubleProperty(y);
	this.image = image;
    }

    public double getX() {
	return x.getValue();
    }

    public double getY() {
	return y.getValue();
    }

    public Image getImage() {
	return image;
    }

}
