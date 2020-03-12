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
      
    double Kp = -0.04;

    double headingError = LimeLight.getTx();
    double steeringAdjust = Kp * headingError;

    //System.out.println("Steering Adjust: " + steeringAdjust);

    DriveSubsystem.left = OI.getJoystickZ() + (steeringAdjust);
    DriveSubsystem.right = OI.getJoystickZ() - (steeringAdjust);

    if (steeringAdjust <= -0.6 || steeringAdjust >= 0.6) {
      DriveSubsystem.dDrive.tankDrive(DriveSubsystem.left / 1.8, DriveSubsystem.right / 1.8);
    }
    //DriveSubsystem.dDrive.arcadeDrive(OI.getJoystickY(), DriveSubsystem.left * DriveSubsystem.right);
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
    return !Constants.LimeLightControlling;
  }
}
