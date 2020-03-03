package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DrivebaseSubsystem;

public class DrivebaseCommand extends CommandBase {
    private final DrivebaseSubsystem m_subsystem;
    private boolean arcadeDrive = false;
  
    public DrivebaseCommand(DrivebaseSubsystem subsystem) {
      m_subsystem = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      // when the command is called, set arcadeDrive equal to the opposite of arcadeDrive (defaults to arcade drive)
      arcadeDrive = !arcadeDrive;
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (arcadeDrive) {
        // arcade drive on joystick
        DrivebaseSubsystem.dDrive.arcadeDrive(Constants.JoystickY(), Constants.JoystickZ());
      }
      else {
        // tank drive on XB360
        DrivebaseSubsystem.dDrive.tankDrive(Constants.XboxLY(), Constants.XboxRY());
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