/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 29, 2016
* Time: 4:24:00 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: PlayerFighterTest
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import javafx.scene.image.Image;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jack
 */
public class PlayerFighterTest {

    public PlayerFighterTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of takeDamage method, of class PlayerFighter.
     */
    @Test
    public void testTakeDamage() {
        System.out.println("takeDamage");
        double frrt = 2;
        double power = 1;
        Image projImage = new Image(
                "file:src/csci205_final_project/view/images/bullet.png");
        double projSpeed = 750;
        double health = 100;
        Player thePlayer;
        PlayerFighter playerFighter;
        thePlayer = new Player(0, 0);
        playerFighter = new PlayerFighter(0, frrt, power, projSpeed, projImage,
                                          health, 0,
                                          thePlayer);
        double damage = 10.00;
        playerFighter.takeDamage(damage);
        assertEquals(playerFighter.getPlayerHealthProperty(), 90.0);
    }

    /**
     * Test of die method, of class PlayerFighter.
     */
//    @Test
//    public void testDie() {
//        System.out.println("die");
//        PlayerFighter instance = null;
//        instance.die();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
