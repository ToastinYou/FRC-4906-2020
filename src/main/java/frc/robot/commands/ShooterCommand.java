package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {
    public ShooterCommand(ShooterSubsystem subsystem) {
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
      if (Constants.XboxControl.getYButton()) {
        ShooterSubsystem.leftMotor.set(Constants.kSpeedShooterFwd);
      }
      /*else if (Constants.XboxControl.getBumper(Hand.kRight)) {
        ShooterSubsystem.leftMotor.set(Constants.kSpeedShooterRev);
      }*/
      else {
        ShooterSubsystem.leftMotor.set(0);
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