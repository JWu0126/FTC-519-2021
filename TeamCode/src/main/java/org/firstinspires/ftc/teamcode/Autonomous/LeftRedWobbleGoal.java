package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.BaseAutonomous;

import org.firstinspires.ftc.teamcode.Autonomous.LeftRedSquareFinder;

@Autonomous (name = "LeftRedWobbleGoal", group = "Not Main")
public class LeftRedWobbleGoal extends BaseAutonomous {

    // I have no idea what I did here, but there aren't any errors... so idk
    LeftRedSquareFinder leftRedSquareFinder = new LeftRedSquareFinder() {
        @Override
        public void loop() {

        }
    };

    LeftRedStartingLineWobbleToFarGoal farGoalRunner = new LeftRedStartingLineWobbleToFarGoal();
    LeftRedStartingLineWobbleToMedGoal medGoalRunner = new LeftRedStartingLineWobbleToMedGoal();
    LeftRedStartingWobbleToShortGoal shortGoalRunner = new LeftRedStartingWobbleToShortGoal();

    LeftRedSquareFinder.location whereToGo;

    @Override
    public void init() {
        super.init();
        leftRedSquareFinder.initialize();
    }

    @Override
    public void start() {
        whereToGo = leftRedSquareFinder.findSquare();
        super.start();
    }

    @Override
    public void loop() {

        // all of the loop methods still have @Override annotations on them, do I need those?
        // I'm not totally sure how to structure all of this
        // I think this works? It kinda makes sense in my head...
        switch (whereToGo) {
            case FAR:
                farGoalRunner.loop();
                break;

            case MED:
                medGoalRunner.loop();
                break;

            case CLOSE:
                shortGoalRunner.loop();
                break;
        }

    }
}
