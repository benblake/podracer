package basic.leagues;

public interface PodRacer {
    Movement calculateMovement(
            int x,
            int y,
            int nextCheckpointX,
            int nextCheckpointY,
            int nextCheckpointDist,
            int nextCheckpointAngle,
            int opponentX,
            int opponentY
    );
}
