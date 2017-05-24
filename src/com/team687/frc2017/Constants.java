package com.team687.frc2017;

/**
 * Important constants 
 * If there are any magic numbers put them in here
 */

public class Constants {
	
// ----
// Cosmos
// ----

	// Distance
	public final static double kDistF = 0; 
	public final static double kDistP = 0;
	public final static double kDistI = 0;
	public final static double kDistD = 0;
	
	// Rotation
	public final static double kRotP = 0;
	public final static double kRotI = 0;
	public final static double kRotD = 0;
	public final static double kMinRotPower = 0;
	public final static double kMaxRotPower = 1.0;
	// Tolerance for closed loop DriveTurnToAngle command in degrees
	public final static double kDriveRotationTolerance = 1;
	public final static double kDriveRotationOscillationCount = 5;
	
	// Motion Profiling and Trajectories
	public final static double kMaxVelocity = 0;
	public final static double kMaxAcceleration = 0;
	public final static double kMaxJerk = 0;
	public final static double kV = 0;
	public final static double kA = 0;
	public final static double kDt = 0.01;
	public final static double kDtInMinutes = kDt/60;
	
	public final static double kWheelbaseWidth = 0;
	public final static int kTicksPerRev = 0;
	public final static double kWheelDiameter = 4/12;
	
	public final static double kDriveDistanceTolerance = 0.3; //Magic units
	public final static double kDriveFeetToEncoderUnitsR = 4.388*3/(Math.PI);
	public final static double kDriveFeetToEncoderUnitsL = 4.487*3/(Math.PI);
	public final static double kDriveStraightP = 0.018;
	
	// Teleop
	public final static double kSensitivityHigh = 0.85;
	public final static double kSensitivityLow = 0.75;
	public final static double kLeftJoystickDeadband = 0.02;
	public final static double kRightJoystickDeadband = 0.02;
	
	public final static double kShiftCurrent = 20; // Amps Per Talon
	public final static double kShiftAcceleration = 2; // Gotta make sure this is right
	public final static int kDriveCurrentLimit = 20;
	
	public final static double kDriveAlpha = 0.125; // Cheesy Drive
	
	
// ----
// Mantis
// ----
	
//	public final static double kDistF = 0; // You probably want to put value calcs here rather than the number
//	public final static double kDistP = 0;
//	public final static double kDistI = 0;
//	public final static double kDistD = 0;
//	
//	public final static double kRotP = 0;
//	public final static double kRotI = 0;
//	public final static double kRotD = 0;
//	public final static double kMinRotPower = 0;
//	public final static double kMaxRotPower = 1.0;
//	
//	// Tolerance for closed loop DriveTurnToAngle command in degrees
//	public final static double kDriveRotationTolerance = 1;
//	public final static double kDriveRotationOscillationCount = 5;
//	public final static int kDriveStationaryCount = 5;
//	
//	public final static double kMaxVelocity = 0;
//	public final static double kMaxAcceleration = 0;
//	public final static double kMaxJerk = 0;
//	public final static double kV = 0;
//	public final static double kA = 0;
//	public final static double kDt = 0.01;
//	public final static double kDtInMinutes = kDt/60;
//	
//	public final static double kWheelbaseWidth = 0;
//	public final static int kTicksPerRev = 0;
//	public final static double kWheelDiameter = 4/12;
//	
//	public final static double kShiftCurrent = 20; // Amps Per Talon
//	public final static double kShiftAcceleration = 2; // Gotta make sure this is right
//	
//	public final static double kDriveDistanceTolerance = 0.3; //Magic units
//	public final static double kDriveFeetToEncoderUnitsR = 4.388*3/(Math.PI);
//	public final static double kDriveFeetToEncoderUnitsL = 4.487*3/(Math.PI);
//	public final static double kDriveStraightP = 0.018;
//	
//	public final static double kDistancePerPulse = 0;
//	
//	public final static int kDriveCurrentLimit = 20;
//	public final static double kDriveAlpha = 0.125; 
//	
//	public final static double kSensitivityHigh = 0.85;
//	public final static double kSensitivityLow = 0.75;
//	
//	public final static double kWheelDeadband = 0.02;
//	public final static double kThrottleDeadband = 0.02;
	
}