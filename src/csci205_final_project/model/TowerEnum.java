/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 10, 2016
* Time: 4:19:18 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: TowerEnum
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

/**
 *
 * @author Matt
 */
public enum TowerEnum {
    MINIGUN("Minigun", 5, 1, 500, 200, false, "MinigunTowerImage",
            "MinigunProjectileImage"),
    CANNON("Cannon", 1, 4, 250, 500, false, "CannonTowerImage",
           "CannonProjectileImage"),
    MISSLE_LAUNCHER("Missile Launcher", 1, 1, 500, 200, true,
                    "MissileLauncherTowerImage",
                    "MissileLauncherProjectileImage"),
    LASER("Laser", 100, 3, 2000, 300, false, "LaserTowerImage",
          "LaserProjectileImage"),
    SNIPER("Sniper", 1, 1000, 1000, 100, false, "LaserTowerImage",
           "LaserProjectileImage");

    TowerEnum(String Name, double frrt, double power, double projSpeed,
              double health, boolean tracks, String image, String projImage) {

    }

}
