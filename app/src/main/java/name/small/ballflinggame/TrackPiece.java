package name.small.ballflinggame;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Random;

import obstacles.Obstacle;
import physics.PhysicsState;

public abstract class TrackPiece extends GameObject {
    protected ArrayList<Obstacle> toDraw;
    protected ArrayList<TrackPiece> canGenerate;
    protected Point screenDims;
    protected Point trackPieceDims;
    protected Point halfSlice;
    protected Point thirdSlice;
    protected Point quarterSlice;
    protected Random rand;

    public TrackPiece (double xPos, double yPos, Point screenDims) {
        super(xPos, yPos);
        this.screenDims = screenDims;
        toDraw = new ArrayList<>();
        canGenerate = new ArrayList<>();
        rand = new Random();
        setUpTrackSpecs();
        setConsts();
        setUpTrack();
        setUpCanGenerateArray();
    }

    // method for defining all of the track pieces which will be drawn
    abstract void setUpTrack ();

    abstract void setUpTrackSpecs ();

    abstract void setUpCanGenerateArray (); // this is used to make instances of

    private void setConsts () {
        halfSlice = new Point(trackPieceDims.x / 2, trackPieceDims.y / 2);
        thirdSlice = new Point(trackPieceDims.x / 3, trackPieceDims.y / 3);
        quarterSlice = new Point(trackPieceDims.x / 4, trackPieceDims.y / 4);
    }

    public TrackPiece setRandomNextPiece (Vector2<Double> spawnPos) {
        int randMax = canGenerate.size();
        TrackPiece tp = canGenerate.get(rand.nextInt(randMax));
        spawnPos.y -= tp.getHeight();
        tp.setPos(spawnPos);
        return tp;
    }

    public boolean outOfBounds () {
        double y = pos.y;
        return y < - screenDims.y * 2;
    }

    public boolean checkCollisions (Ball b) {
        return false;
    }

    abstract Vector2<Integer> getBounceDir (Ball b, PhysicsState physics); // return null when no bounce direction needed

    public double getHeight () {
        return trackPieceDims.y;
    }

}
