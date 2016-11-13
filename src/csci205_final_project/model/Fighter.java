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
package csci205_final_project.model;

import csci205_final_project.Game;
import csci205_final_project.ctrl.gameNoise;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
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
    gameNoise firingNoise;

    ViewObj viewObj;

    double timer = 0;
    Fighter target;

    public Fighter(double range, double frrt, double power, double projSpeed,
                   Image projImage, double health, int team,
                   ViewObj viewObj, gameNoise gameNoise) {

    }

    public Fighter(double range, double frrt, double power, double projSpeed,
                   Image projImage, double health, int team,
                   ViewObj viewObj) {
        this.range = range;
        this.frrt = frrt;
        this.power = power;
        this.projSpeed = projSpeed;
        this.projImage = projImage;
        this.health = health;
        this.viewObj = viewObj;
        this.team = team;
        this.firingNoise = new gameNoise("regularShot.mp3");

        Game.theCtrl.addFighter(this);
    }

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

    private void fire(Fighter target) {
        if (projImage == null) {
            target.takeDamage(power);
        } else {
            firingNoise.play();
            Projectile proj = new Projectile(viewObj.getX(), viewObj.getY(),
                                             projSpeed, power, projImage, team,
                                             true);
            proj.setDirection(viewObj.getDirection());
        }
    }

    public void takeDamage(double power) {
        health -= power;
        if (health <= 0) {
            die();
        }
    }

    public void die() {
        Game.theView.removeViewObj(this.viewObj);
        Game.theCtrl.removeFighter(this);
    }

}
