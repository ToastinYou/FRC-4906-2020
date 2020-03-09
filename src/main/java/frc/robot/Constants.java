/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	public static boolean LimeLightControlling = false;
    
	// Controller Area Network (CAN)
	public static int kCDriveRRear = 0;	// Drive Right Rear
	public static int kCDriveRFront = 1; // Drive Right Front
	public static int kCHangRight = 2; // Hang Right
	public static int kCShooterRight = 3; // Shooter Right
	public static int kCIntake = 4; // Conveyor Vertical
	public static int kCConveyorHoriz = 5; // Conveyor Horizontal
	public static int CAN6 = 6; // Time of Flight??
	public static int CAN7 = 7; // 
	public static int CAN8 = 8; // Lime Light
	public static int CAN9 = 9; // Internet Switch
	public static int kCColor = 10; // Color Spinner
	public static int kCConveyorVert = 11; // Conveyor Horizontal
	public static int kCShooterLeft = 12; // Shooter Left
	public static int kCHangLeft = 13; // Hang Left
	public static int kCDriveLFront = 14; // Drive Left Front
	public static int kCDriveLRear = 15; // Drive Left Rear

	// PCM 0, 1 intake arm.
	// PCM 2, 3 gearbox shifter.
	// PCM 4, 5 airbrake hanger.

	// Pneumatic Control Module (PCM)
	public static int kPIntakeFwd = 0;
	public static int kPIntakeRev = 1;
	public static int kPShiftFwd = 2;
	public static int kPShiftRev = 3;
	public static int kPHangFwd = 4;
	public static int kPHangRev = 5;

	// Digital Input Output (DIO)
	public static int kDHangTop = 0; // Hang Top Limit Switch
	public static int kDHangBottom = 1; // Hang Bottom Limit Switch

	// Motor Speeds
	public static double kSpeedShooterFwd = -0.8; // Shooter Forward
	public static double kSpeedShooterRev = 0.4; // Shoter Reverse
	public static double kSpeedIntakeFwd = -0.4; // Intake Forward
	public static double kSpeedIntakeRev = 0.4; // Intake Reverse
	public static double kSpeedHangFwd = 0.4; // Hang Forward
	public static double kSpeedHangRev = -0.4; // Hang Reverse
	public static double kSpeedDriveDecrement = 2; // Speed to divide drive by.
	public static double kSpeedConveyorFwd = 0.6; // Conveyor Forward
	public static double kSpeedConveyorRev = -0.4; // Conveyor Reverse
	public static double kSpeedColor = 0.2; // Color Spinner

	// Time of Flight
	public static int kTOFHalfDist = 101; // Time of Flight distance halfway (millimeters).
}
