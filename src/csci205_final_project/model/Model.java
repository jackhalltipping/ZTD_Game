/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 2:52:55 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Model
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Model class in the MVC system
 * @author emb038
 */
public class Model {
    Player thePlayer;
    SimpleDoubleProperty money;
    SimpleIntegerProperty wave;
    static SimpleIntegerProperty highWave;

    /**
     * instantiation of the Model
     */
    public Model() {
	this.money = new SimpleDoubleProperty(100);
	this.wave = new SimpleIntegerProperty(0);
        if(highWave==null){
            highWave=new SimpleIntegerProperty(0);
        }
    }

    /**
     * Adds the player to the Model
     */
    public void addPlayer() {
	thePlayer = new Player(64, 64);
    }

    /**
     * Getter for the player
     * @return
     */
    public Player getPlayer() {
	return thePlayer;
    }

    /**
     * getter for the Money
     * @return double, amount of money available
     */
    public double getMoney() {
	return money.get();
    }

    /**
     * Getter for the money property
     * @return SimpleDoubleProperty of the money
     */
    public SimpleDoubleProperty getMoneyProperty() {
	return money;
    }

    /**
     * Getter for the Wave
     * @return integer wave number
     */
    public int getWave() {
	return wave.getValue();
    }

    /**
     * Updates the Wave
     */
    public void updateWave() {
	wave.setValue(wave.add(1).getValue());
        if(wave.getValue()>highWave.getValue()){
            highWave.setValue(wave.getValue());
        }
    }

    /**
     * Getter for the wave property
     * @return SimpleIntegerProperty of the wave
     */
    public SimpleIntegerProperty getHighWave() {
        return highWave;
    }

    /**
     * Adds money
     * @param deposit
     */
    public void addMoney(double deposit) {
	money.set(getMoney() + deposit);
    }

}
