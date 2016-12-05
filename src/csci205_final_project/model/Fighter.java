package csci205_final_project.model;

/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 9, 2016
* Time: 3:58:06 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Fighter
* Description:
*
* ****************************************
 */
import csci205_final_project.Game;
import csci205_final_project.ctrl.GameNoise;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * Class to denote every 
 * @author emb038
 */
public class Fighter {
    double range;
    double frrt;
    double power;
    double projSpeed;
    Image projImage;
    double health;
    int team;

    GameNoise firingNoise;

    ViewObj viewObj;

    double timer = 0;
    Fighter target;
    boolean tracks;

    double reward;

    public Fighter(double range, double frrt, double power, double projSpeed,
		   Image projImage, boolean tracks, double health, int team,
		   ViewObj viewObj, double reward) {
	this.range = range;
	this.frrt = frrt;
	this.power = power;
	this.projSpeed = projSpeed;
	this.projImage = projImage;
	this.tracks = tracks;
	this.health = health;
	this.viewObj = viewObj;
	this.team = team;
	this.reward = reward;
	this.firingNoise = new GameNoise("regularShot.mp3");

	Game.theCtrl.addFighter(this);
    }

    /**
     * Instantiates the Fighter with certain properties
     * @param range
     * @param frrt
     * @param power
     * @param projSpeed
     * @param projImage
     * @param tracks
     * @param health
     * @param team
     * @param viewObj
     * @param reward
     * @param musicFileName
     */
    public Fighter(double range, double frrt, double power, double projSpeed,
		   Image projImage, boolean tracks, double health, int team,
		   ViewObj viewObj, double reward, String musicFileName) {
	this.range = range;
	this.frrt = frrt;
	this.power = power;
	this.projSpeed = projSpeed;
	this.projImage = projImage;
	this.tracks = tracks;
	this.health = health;
	this.viewObj = viewObj;
	this.team = team;
	this.reward = reward;
	this.firingNoise = new GameNoise(musicFileName);

	Game.theCtrl.addFighter(this);
    }

    /**
     * Updates the positions of the fighters on our list
     * @param duration
     * @param fighters
     */
    public void update(double duration, ArrayList<Fighter> fighters) {
	timer -= duration;
	Fighter target = getTarget(fighters);
	if (target != null) {
	    double dir = Math.toDegrees(Math.atan2(
		    target.viewObj.getX() - viewObj.getX(),
		    target.viewObj.getY() - viewObj.getY()));
	    viewObj.setDirection(-dir + 90);
	}

	if (timer <= 0) {
	    if (target != null) {
		fire(target);
	    }
	    timer = 1.0 / frrt;
	}
    }

    /**
     * Method that gets the target of the nearest possible Fighter
     * @param fighters
     * @return
     */
    public Fighter getTarget(ArrayList<Fighter> fighters) {
	if (viewObj instanceof Enemy) {
	    return Game.theModel.getPlayer().fighter;
	}
	double minDistance = range;
	target = null;
	for (Fighter fighter : fighters) {
	    if (fighter.team != team) {
		double dist = Math.sqrt(Math.pow(
			fighter.viewObj.getX() - viewObj.getX(), 2.0) + Math.pow(
				fighter.viewObj.getY() - viewObj.getY(), 2.0));
		if (dist <= minDistance) {
		    minDistance = dist;
		    target = fighter;
		}
	    }
	}
	return target;
    }

    /**
     * Fighter fires towards the specified target
     * @param target
     */
    public void fire(Fighter target) {
	if (projImage == null && Math.hypot(
		viewObj.getX() - target.viewObj.getX(),
		viewObj.getY() - target.viewObj.getY()) <= range) {
	    target.takeDamage(power);
	} else {
            
	    firingNoise.play();
	    Projectile proj = new Projectile(viewObj.getX() + 32 * Math.cos(
		    viewObj.getDirection() * Math.PI / 180),
					     viewObj.getY() + 32 * Math.sin(
						     viewObj.getDirection() * Math.PI / 180),
					     projSpeed, power, projImage, team,
					     tracks);
	    proj.setDirection(viewObj.getDirection());
	}
    }
    
    /**
     * Fighter takes on the damage, health is decreased
     * @param power
     */
    public void takeDamage(double power) {
	health -= power;
	if (health <= 0) {
	    die();
	}
    }

    /**
     * Our Player dies and game Over screen is called
     * 
     */
    public void die() {
	Game.theView.removeViewObj(this.viewObj);
	Game.theCtrl.removeFighter(this);
	Game.theModel.addMoney(reward);
    }


}
