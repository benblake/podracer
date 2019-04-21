package basic.leagues.bronze;

import basic.leagues.Movement;
import basic.leagues.PodRacer;

import java.awt.*;

public class BronzeLeagueRacer implements PodRacer {
    private Movement movement = new Movement();
    private boolean usedBoost = false;

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
        Point heading = calculateHeading(x, y, nextCheckpointX, nextCheckpointY, nextCheckpointAngle);
        movement.directionX = heading.x;
        movement.directionY = heading.y;

        movement.boost = useBoost(nextCheckpointDist, nextCheckpointAngle);

        movement.thrust = calculateThrust(nextCheckpointAngle, nextCheckpointDist);

        return movement;
    }

    private Point calculateHeading(int x, int y, int nextCheckpointX, int nextCheckpointY, int nextCheckpointAngle) {
        Point checkpointHeading = new Point(nextCheckpointX - x, nextCheckpointY - y);

        Point rotatedHeading;
        if (nextCheckpointAngle < 45 && nextCheckpointAngle > -45) {
            double theta = nextCheckpointAngle * Math.PI / 180.0;
            rotatedHeading = new Point(
                    (int)(checkpointHeading.x * Math.cos(theta) - checkpointHeading.y * Math.sin(theta)),
                    (int)(checkpointHeading.x * Math.sin(theta) + checkpointHeading.y * Math.cos(theta))
            );
        } else {
            rotatedHeading = checkpointHeading;
        }
        rotatedHeading.x = rotatedHeading.x + x;
        rotatedHeading.y = rotatedHeading.y + y;

        return rotatedHeading;
    }

    private boolean useBoost(int nextCheckpointDist, int nextCheckpointAngle) {
        if (!usedBoost &&
                nextCheckpointDist > 3000 &&
                nextCheckpointAngle < 35 &&
                nextCheckpointAngle > -35) {
            usedBoost = true;
            return true;
        } else {
            return false;
        }
    }

    private int calculateThrust(int nextCheckpointAngle, int nextCheckpointDist) {
        if (nextCheckpointAngle > 90 || nextCheckpointAngle < -90) {
            return 0;
        } else if (nextCheckpointDist < 2000) {
            return (int)(50 * Math.pow(nextCheckpointDist / 2000, 2)) + 50;
        } else {
            return 100;
        }
    }
}