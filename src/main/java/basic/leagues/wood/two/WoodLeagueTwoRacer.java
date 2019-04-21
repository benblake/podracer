package basic.leagues.wood.two;

import basic.leagues.Movement;
import basic.leagues.PodRacer;

public class WoodLeagueTwoRacer implements PodRacer {
    private Movement movement = new Movement();

    @Override
    public Movement calculateMovement(
            int x,
            int y,
            int nextCheckpointX,
            int nextCheckpointY,
            int nextCheckpointDist,
            int nextCheckpointAngle,
            int opponentX,
            int opponentY
    ) {
        movement.boost = false;
        movement.directionX = nextCheckpointX;
        movement.directionY = nextCheckpointY;

        if (nextCheckpointAngle > 90 || nextCheckpointAngle < -90) {
            movement.thrust = 0;
        } else {
            movement.thrust = 100;
        }

        return movement;
    }
}