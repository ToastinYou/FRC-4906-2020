/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public final class OI {
	public static XboxController XboxControl = new XboxController(0);

	public static boolean getAButton() {
		return XboxControl.getAButton();
	}

	public static boolean getXButton() {
		return XboxControl.getXButton();
	}

	public static boolean getYButton() {
		return XboxControl.getYButton();
	}

	public static boolean getBButton() {
		return XboxControl.getBButtonReleased();
	}

	public static boolean getStickRightAxisUp() {
		return XboxControl.getY(Hand.kRight) > 0.5;
	}

	public static boolean getStickRightAxisDown() {
		return XboxControl.getY(Hand.kRight) < -0.5;
	}

	public static boolean getDpadUp() {
		return XboxControl.getPOV() == 0;
	}

	public static boolean getDpadRight() {
		return XboxControl.getPOV() == 90;
	}

	public static boolean getDpadDown() {
		return XboxControl.getPOV() == 180;
	}

	public static POVButton getDpadDownObject() {
		return new POVButton(XboxControl, 180);
	}

	public static boolean getDpadLeft() {
		return XboxControl.getPOV() == 270;
	}

	public static boolean getStickLeftAxisUp() {
		return XboxControl.getY(Hand.kLeft) > 0.5;
	}
	
	public static boolean getStickLeftAxisDown() {
		return XboxControl.getY(Hand.kLeft) < -0.5;
	}

	public static boolean getBackButton() {
		return XboxControl.getBackButton();
	}

	public static boolean getBumperLeft() {
		return XboxControl.getBumper(Hand.kLeft);
	}

	public static boolean getTriggerLeftAxisPressed() {
		return XboxControl.getTriggerAxis(Hand.kLeft) > 0.5;
	}

	public static double getTriggerLeftAxis() {
		double leftTriggerAxis = XboxControl.getTriggerAxis(Hand.kLeft);

		if (leftTriggerAxis > 0.5)
		{
			return leftTriggerAxis;
		}

		return 0;
	}

	public static boolean getStartButton() {
		return XboxControl.getStartButtonReleased();
	}

	public static Button getStartButtonObject() {
		return new JoystickButton(XboxControl, 8);
	}

	public static boolean getTriggerRightAxisPressed() {
		return XboxControl.getTriggerAxis(Hand.kRight) > 0.5;
	}

	public static double getTriggerRightAxis() {
		double rightTriggerAxis = XboxControl.getTriggerAxis(Hand.kRight);
		
		if (rightTriggerAxis > 0.5)
		{
			return rightTriggerAxis;
		}

		return 0;
	}

	public static boolean getBumperRight() {
		return XboxControl.getBumper(Hand.kRight);
	}


	public static Joystick JoystickControl = new Joystick(1);

	public static double getJoystickY() {
		return JoystickControl.getY();
	}

	public static double getJoystickZ() {
		return JoystickControl.getZ();
	}

	public static boolean getJoystickLimeLightLED() {
		return JoystickControl.getRawButton(1);
	}

	public static boolean getJoystickLimeLightCAM() {
		return JoystickControl.getRawButton(2);
	}

	public static boolean getJoystickLowGear() {
		return JoystickControl.getRawButton(3);
	}

	public static boolean getJoystickHighGear() {
		return JoystickControl.getRawButton(4);
	}

	public static boolean getJoystickAutomation() {
		return JoystickControl.getRawButton(11);
	}
}
