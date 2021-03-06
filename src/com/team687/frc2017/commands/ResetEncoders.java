package com.team687.frc2017.commands;

import com.team687.frc2017.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Reset encoders.
 * 
 * @author tedlin
 *
 */

public class ResetEncoders extends Command {

    public ResetEncoders() {
	requires(Robot.drive);
    }

    @Override
    protected void initialize() {
	SmartDashboard.putString("Current Command", "Reset Encoders");
	Robot.drive.resetEncoders();
    }

    @Override
    protected void execute() {
	Robot.drive.resetEncoders();
    }

    @Override
    protected boolean isFinished() {
	return Robot.drive.getRightPosition() == 0 && Robot.drive.getLeftPosition() == 0;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

}
