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
 *
 * @author emb038
 */
public class Model {
    Player thePlayer;
    SimpleDoubleProperty money;
    SimpleIntegerProperty wave;
    static SimpleIntegerProperty highWave;

    public Model() {
	this.money = new SimpleDoubleProperty(100);
	this.wave = new SimpleIntegerProperty(0);
        if(highWave==null){
            highWave=new SimpleIntegerProperty(0);
        }
    }

    public void addPlayer() {
	thePlayer = new Player(64, 64);
    }

    public Player getPlayer() {
	return thePlayer;
    }

    public double getMoney() {
	return money.get();
    }

    public SimpleDoubleProperty getMoneyProperty() {
	return money;
    }

    public int getWave() {
	return wave.getValue();
    }

    public void updateWave() {
	wave.setValue(wave.add(1).getValue());
        if(wave.getValue()>highWave.getValue()){
            highWave.setValue(wave.getValue());
        }
    }

    public SimpleIntegerProperty getHighWave() {
        return highWave;
    }

    public void addMoney(double deposit) {
	money.set(getMoney() + deposit);
    }

}
