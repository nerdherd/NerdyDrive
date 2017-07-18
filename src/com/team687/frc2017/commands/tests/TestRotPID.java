package com.team687.frc2017.commands.tests;

import com.team687.frc2017.Constants;
import com.team687.frc2017.Robot;
import com.team687.frc2017.utilities.NerdyPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A test for rotational PID output without actuating anything
 *
 * @author tedfoodlin
 *
 */

public class TestRotPID extends Command {
	
	private NerdyPID m_rotPID;
	
    public TestRotPID() {
    	// subsystem dependencies
        requires(Robot.drive);
    }

	@Override
	protected void initialize() {
		SmartDashboard.putString("Current Command", "TestRotPID");
		
		SmartDashboard.putNumber("Rot P (test, editable)", Constants.kRotP);
		SmartDashboard.putNumber("Rot I (test, editable)", Constants.kRotI);
		SmartDashboard.putNumber("Rot D (test, editable)", Constants.kRotD);
		SmartDashboard.putNumber("Rot Min Power (test, editable)", Constants.kMinRotPower);
		SmartDashboard.putNumber("Rot Max Power (test, editable)", Constants.kMaxRotPower);
		m_rotPID = new NerdyPID(Constants.kRotP, Constants.kRotI, Constants.kRotD);
		m_rotPID.setOutputRange(Constants.kMinRotPower, Constants.kMaxRotPower);
		
		Robot.drive.stopDrive();
		Robot.drive.shiftUp();
	}

	@Override
	protected void execute() {
		double actualAngle = Robot.drive.getCurrentYaw();
		SmartDashboard.putNumber("Actual Yaw (test)", actualAngle);
		double desiredAngle = SmartDashboard.getNumber("Desired Yaw (test, editable)", 0);
		double angleError = desiredAngle - actualAngle;
		SmartDashboard.putNumber("Error Yaw (test)", angleError);
		
		double kP = SmartDashboard.getNumber("Rot P (test, editable)", 0);
		double kI = SmartDashboard.getNumber("Rot I (test, editable)", 0);
		double kD = SmartDashboard.getNumber("Rot D (test, editable)", 0);
		double kMinRotPower = SmartDashboard.getNumber("Rot Min Power (test, editable)", 0);
		double kMaxRotPower = SmartDashboard.getNumber("Rot Max Power (test, editable)", 0);
		
		m_rotPID = new NerdyPID(kP, kI, kD);
		m_rotPID.setOutputRange(kMinRotPower, kMaxRotPower);
		
		m_rotPID.setDesired(desiredAngle);
		double power = m_rotPID.calculate(actualAngle);
		SmartDashboard.putNumber("Rot PID output (test)", power);
		
		Robot.drive.stopDrive();
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
