package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.LimeLight;
import frc.robot.LimeLight.CameraMode;

public class LimeLightCamCommand extends CommandBase {  
    public LimeLightCamCommand() {
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (LimeLight.CameraState == CameraMode.eDriver) {
        LimeLight.setCameraMode(CameraMode.eVision);
      }
      else {
        LimeLight.setCameraMode(CameraMode.eDriver);
      }
      
      end(false);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}