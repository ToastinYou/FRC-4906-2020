package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.subsystems.IntakeSubsystem;

// power cell pickup

public class IntakePistonCommand extends CommandBase {
    private static boolean intakePiston;
  
    public IntakePistonCommand(IntakeSubsystem subsystem) {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    public static void ToggleIntakePiston() {
      intakePiston = !intakePiston;

      if (!intakePiston) {
        IntakeSubsystem.sol.set(DoubleSolenoid.Value.kForward);
      }
      else {
        IntakeSubsystem.sol.set(DoubleSolenoid.Value.kReverse);
      }

    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
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