/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 2:53:07 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.ctrl
* File: Ctrl
* Description:
*
* ****************************************
 */
package csci205_final_project.ctrl;

import csci205_final_project.model.Enemy;
import csci205_final_project.model.Fighter;
import csci205_final_project.model.Model;
import csci205_final_project.model.Projectile;
import csci205_final_project.model.Tower;
import csci205_final_project.model.TowerEnum;
import csci205_final_project.model.ViewObj;
import csci205_final_project.view.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author emb038
 */
public class Ctrl {
    Random random = new Random();

    View theView;
    Model theModel;
    static boolean inWave;
    double DT = 0.02; //Frame duration in seconds
    double ZPS = 2; //average zombies per second
    ArrayList<Fighter> fighters = new ArrayList<Fighter>();
    ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public Ctrl(Model theModel, View theView) {
        this.theModel = theModel;
        this.theView = theView;

        setKeyBindings();
        start();
        setWaveButtonAction();
    }

    public void setKeyBindings() {
        EventHandler<KeyEvent> keyEvent = (new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                System.out.println(ke.getEventType());
                if (ke.getEventType().equals(KeyEvent.KEY_PRESSED)) {
                    if (ke.getCode().equals(KeyCode.RIGHT)) {
                        theModel.getPlayer().setMoveDirection(0);
                        theModel.getPlayer().setSpeed(1);
                    }
                    if (ke.getCode().equals(KeyCode.UP)) {
                        theModel.getPlayer().setMoveDirection(270);
                        theModel.getPlayer().setSpeed(1);
                    }
                    if (ke.getCode().equals(KeyCode.LEFT)) {
                        theModel.getPlayer().setMoveDirection(180);
                        theModel.getPlayer().setSpeed(1);
                    }
                    if (ke.getCode().equals(KeyCode.DOWN)) {
                        theModel.getPlayer().setMoveDirection(90);
                        theModel.getPlayer().setSpeed(1);
                    }
                    if (ke.getCode().equals(KeyCode.M)) {
                        theView.setTempTower(TowerEnum.MINIGUN);
                    }
                    if (ke.getCode().equals(KeyCode.L)) {
                        theView.setTempTower(TowerEnum.LASER);
                    }
                    if (ke.getCode().equals(KeyCode.C)) {
                        theView.setTempTower(TowerEnum.CANNON);
                    }
                    if (ke.getCode().equals(KeyCode.A)) {
                        theView.setTempTower(TowerEnum.MISSLE_LAUNCHER);
                    }

                }
                if (ke.getEventType().equals(KeyEvent.KEY_RELEASED)) {
                    theModel.getPlayer().setSpeed(0);
                }
            }

        });

        theView.getScene().setOnKeyPressed(keyEvent);
        theView.getScene().setOnKeyReleased(keyEvent);

        theView.getGameRoot().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double mouseX = event.getSceneX();
                double mouseY = event.getSceneY();

                if (theView.getTempTower() != null) {
                    new Tower(mouseX, mouseY, theView.getTempTower());
                    theView.setTempTower(null);
                } else {
                    theModel.getPlayer().fighter.fire(null);
                }
            }

        });
        theView.getGameRoot().setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                theView.setMouse(event.getSceneX(), event.getSceneY());
            }

        });
    }

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public void start() {
        PauseTransition wait = new PauseTransition(Duration.seconds(DT));
        wait.setOnFinished((e) -> {
            this.frame();
            wait.playFromStart();
        });
        wait.play();
    }

    public void frame() {
        ArrayList<ViewObj> viewObjs = theView.getViewObjs();
        for (ViewObj viewObj : viewObjs) {
            viewObj.frame(DT);
        }
        for (Fighter fighter : fighters) {
            fighter.update(DT, fighters);
        }
        for (int i = 0; i < projectiles.size(); i++) {
            i -= projectiles.get(i).update(DT, fighters);
        }
        if (random.nextDouble() <= DT * ZPS && inWave) {
            new Enemy(
                    random.nextDouble() * ((Pane) theView.getGameRoot()).getWidth(),
                    random.nextDouble() * ((Pane) theView.getGameRoot()).getHeight());
        }
        ZPS += 0; //adaptive difficulty
    }

    public void removeFighter(Fighter fighter) {
        fighters.remove(fighter);
    }

    public void removeProjectile(Projectile projectile) {
        projectiles.remove(projectile);
    }

    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    public double convertX(double x) {
        int tileSize = 50;
        return x - (x % tileSize);
    }

    public double convertY(double y) {
        int tileSize = 50;
        return y - (y % tileSize);
    }

    public void setEvents() {
        setHandler("startWave");
        setHandler("createTower");
    }

    public void setHandler(String id) {
        theView.getMenuRoot().lookup("#" + id).addEventHandler(
                MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Ctrl.handle(id);
                } catch (Exception ex) {

                }
            }
        });
    }

    public static void handle(String id) throws IOException, ClassNotFoundException {
        System.out.println("Handling: " + id + " click");
        switch (id) {
            case "startWave":
                Ctrl.startWave();
                break;
            case "createTower":
                break;
        }
    }

    public static void startWave() {
        //should be inWave=true
        inWave = !inWave;
        //other stuff
    }

    private void setWaveButtonAction() {
        Button waveButton = ((Button) theView.getMenuRoot().lookup("#startWave"));
        waveButton.addEventHandler(ActionEvent.ACTION,
                                   new EventHandler<ActionEvent>() {
                               @Override
                               public void handle(ActionEvent event) {
                                   startWave();
                               }

                           });
    }

}
