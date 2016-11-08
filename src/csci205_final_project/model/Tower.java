/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 3:11:55 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Tower
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import javafx.scene.image.Image;

/**
 *
 * @author Jack
 */
public class Tower {

    double xCord;
    double yCord;
    Image img;

    public Tower(double xCord, double yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.img = new Image("https://s-media-cache-ak0.pinimg.com/originals/de/de/8a/dede8ae5755d9c7427b443b8af8a4939.png");
    }

    public double getxCord() {
        return this.xCord;
    }

    public double getyCord() {
        return this.yCord;
    }
    
    public Image getImage() {
        return img;
    }

}
