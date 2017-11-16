package com.team687.frc2017.commands;

import com.team687.frc2017.Constants;
import com.team687.frc2017.Robot;
import com.team687.frc2017.utilities.NerdyMath;
import com.team687.frc2017.utilities.PGains;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Turn to a specified angle (no vision, absolute)
 * 
 * @author tedlin
 * 
 */

public class TurnToAngle extends Command {

    private double m_desiredAngle;
    private double m_startTime, m_timeout;
    private double m_error;

    private boolean m_isHighGear;

    private PGains m_rotPGains;

    public TurnToAngle(double angle, boolean isHighGear) {
	m_desiredAngle = angle;
	m_timeout = 10; // default timeout is 10 seconds
	m_isHighGear = isHighGear;

	requires(Robot.drive);
    }

    /**
     * @param angle
     * @param isHighGear
     * @param timeout
     */
    public TurnToAngle(double angle, boolean isHighGear, double timeout) {
	m_desiredAngle = angle;
	m_timeout = timeout;
	m_isHighGear = isHighGear;

	// subsystem dependencies
	requires(Robot.drive);
    }

    @Override
    protected void initialize() {
	SmartDashboard.putString("Current Command", "TurnToAngle");
	m_startTime = Timer.getFPGATimestamp();

	if (m_isHighGear) {
	    Robot.drive.shiftUp();
	    m_rotPGains = Constants.kRotHighGearPGains;
	} else if (!m_isHighGear) {
	    Robot.drive.shiftDown();
	    m_rotPGains = Constants.kRotLowGearPGains;
	}
    }

    @Override
    protected void execute() {
	double robotAngle = (360 - Robot.drive.getCurrentYaw()) % 360;
	m_error = -m_desiredAngle - robotAngle;
	m_error = (m_error > 180) ? m_error - 360 : m_error;
	m_error = (m_error < -180) ? m_error + 360 : m_error;

	double power = m_rotPGains.getP() * m_error;
	power = NerdyMath.threshold(power, m_rotPGains.getMinPower(), m_rotPGains.getMaxPower());

	Robot.drive.setPower(power, power);
    }

    @Override
    protected boolean isFinished() {
	return Math.abs(m_error) <= Constants.kDriveRotationTolerance
		|| Timer.getFPGATimestamp() - m_startTime > m_timeout;
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
