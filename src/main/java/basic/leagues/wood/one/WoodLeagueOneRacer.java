package basic.leagues.wood.one;

import basic.leagues.Movement;
import basic.leagues.PodRacer;

public class WoodLeagueOneRacer implements PodRacer {
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
        } else if (nextCheckpointDist < 2000) {
            movement.thrust = nextCheckpointDist * 100 / 2000;
        } else {
            movement.thrust = 100;
        }

        return movement;
    }
}