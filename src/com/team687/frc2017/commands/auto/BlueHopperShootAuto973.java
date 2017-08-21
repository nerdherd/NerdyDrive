package com.team687.frc2017.commands.auto;

import com.team687.frc2017.Constants;
import com.team687.frc2017.commands.ArcTurn;
import com.team687.frc2017.commands.DriveStraightContinuous;
import com.team687.frc2017.commands.DriveTime;
import com.team687.frc2017.commands.LiveVisionTracking;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Blue hopper auto
 * 
 * @author tedlin
 *
 */

public class BlueHopperShootAuto973 extends CommandGroup {

    public BlueHopperShootAuto973() {
	// drive to hopper with Bezier curves
	// addSequential(new DriveBezierRio(Constants.BluePathWallToHopper));
	// drive to hopper with continuous motion and arc turns
	addSequential(new DriveStraightContinuous(Constants.BluePathWallToHopperInitialDistance, 0.687, true));
	addSequential(new ArcTurn(Constants.BluePathWallToHopperArcTurnAngle, true, 0, true));
	addSequential(new DriveTime(0.971, 1.95, true));

	// back up in two motions
	// addSequential(new DriveDistancePID(Constants.BlueHopperBackUpDistance,
	// Constants.BlueHopperBackUpDistance));
	// addSequential(new TurnToAngle(Constants.BlueHopperAngleToShoot));

	// back up in one motion
	addSequential(new ArcTurn(Constants.BlueHopperAngleToShoot, false, 0, false));

	// aim
	addParallel(new LiveVisionTracking());
	// addParallel(new Shoot());
    }

}
