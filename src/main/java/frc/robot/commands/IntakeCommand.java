package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.subsystems.IntakeSubsystem;

// power cell pickup

public class IntakeCommand extends CommandBase {  
    public IntakeCommand(IntakeSubsystem subsystem) {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      // default pickup to upward
      IntakeSubsystem.sol.set(DoubleSolenoid.Value.kForward);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (OI.getYButton()) {
        IntakeSubsystem.intakeMotor.set(Constants.kSpeedIntakeFwd);
      }
      else if (OI.getXButton()) {
        IntakeSubsystem.intakeMotor.set(Constants.kSpeedIntakeRev);
      }
      else {
        IntakeSubsystem.intakeMotor.set(0);
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