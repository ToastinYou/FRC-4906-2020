package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.HangSubsystem;

public class HangCommand extends CommandBase {
    public HangCommand(HangSubsystem subsystem) {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      // DPAD UP
      if (Constants.XboxControl.getPOV(0) != -1 && !HangSubsystem.topLimit.get()) {
        HangSubsystem.hangMotorLeft.set(Constants.kSpeedHangFwd);
      }
      // DPAD DOWN
      else if (Constants.XboxControl.getPOV(180) != -1 && !HangSubsystem.bottomLimit.get()) {
        HangSubsystem.hangMotorLeft.set(Constants.kSpeedHangRev);
      }
      else {
        HangSubsystem.hangMotorLeft.set(0);
      }
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