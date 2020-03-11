/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.LimeLight;
import frc.robot.OI;
import frc.robot.LimeLight.CameraMode;
import frc.robot.LimeLight.LightMode;
import frc.robot.subsystems.DriveSubsystem;

public class LimeLightAutoCommand extends CommandBase {
  private LightMode returnLightState;
  private CameraMode returnCamState;

  public LimeLightAutoCommand() {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Constants.LimeLightControlling = true;

    returnLightState = LimeLight.LightState;
    if (LimeLight.LightState != LightMode.eOn) {
      LimeLight.setLedMode(LightMode.eOn);
    }

    returnCamState = LimeLight.CameraState;
    if (LimeLight.CameraState != CameraMode.eVision) {
      LimeLight.setCameraMode(CameraMode.eVision);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("LimeLight Controlling", Constants.LimeLightControlling);
      
    double Kp = -0.1;

    double headingError = LimeLight.getTx();
    double steeringAdjust = Kp * headingError;

    DriveSubsystem.left = OI.getJoystickZ() + steeringAdjust;
    DriveSubsystem.right = OI.getJoystickZ() - steeringAdjust;

    DriveSubsystem.dDrive.arcadeDrive(OI.getJoystickY(), DriveSubsystem.left + DriveSubsystem.right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSubsystem.left = 0;
    DriveSubsystem.right = 0;
    
    LimeLight.setLedMode(returnLightState);
    LimeLight.setCameraMode(returnCamState);

    Constants.LimeLightControlling = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
