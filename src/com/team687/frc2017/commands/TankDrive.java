package com.team687.frc2017.commands;

import com.team687.frc2017.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Tank drive with squared inputs
 */

public class TankDrive extends Command{

    public TankDrive() {
    	// subsystem dependencies
        requires(Robot.drive);
    }

	@Override
	protected void initialize() {
		SmartDashboard.putString("Current Command", "TankDrive");
		Robot.drive.stopDrive();
	}

	@Override
	protected void execute() {
		double leftPow = Robot.drive.squareInput(Robot.oi.getDriveJoyL());
		double rightPow = Robot.drive.squareInput(Robot.oi.getDriveJoyR());
		Robot.drive.setPower(leftPow, rightPow);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.drive.stopDrive();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}