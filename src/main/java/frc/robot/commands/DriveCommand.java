package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
    private boolean arcadeDrive = false;
    private String drive;
  
    public DriveCommand(DriveSubsystem subsystem) {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      // when the command is called, set arcadeDrive equal to the opposite of arcadeDrive (defaults to arcade drive)
      arcadeDrive = !arcadeDrive;
      
      //SmartDashboard.putString("Drivebase", drive); // "drive" may not update quick enough..
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      DriveSubsystem.dDrive.arcadeDrive(Constants.JoystickY() / Constants.kSpeedDriveDecrement, Constants.JoystickZ() / Constants.kSpeedDriveDecrement);
      // when limelight is controlling, it will setup driving automatically.
      /*if (!Constants.LimeLightControlling) {
        if (arcadeDrive) {
          // arcade drive on joystick
          DriveSubsystem.dDrive.arcadeDrive(Constants.JoystickY() / Constants.kSpeedDriveDecrement, Constants.JoystickZ() / Constants.kSpeedDriveDecrement);
          drive = "Arcade";
        }
        else {
          // tank drive on XB360
          DriveSubsystem.dDrive.tankDrive(Constants.XboxLY() / Constants.kSpeedDriveDecrement, Constants.XboxRY() / Constants.kSpeedDriveDecrement);
          drive = "Tank";
        }
      }*/
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