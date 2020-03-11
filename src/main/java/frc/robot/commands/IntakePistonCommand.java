package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.subsystems.IntakeSubsystem;

// power cell pickup

public class IntakePistonCommand extends CommandBase {
    public static enum Piston {
      Down,
      Up,
    }
    public static Piston State;

    private boolean done;
  
    public IntakePistonCommand(IntakeSubsystem subsystem) {
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
      if (State == Piston.Up) {
        IntakeSubsystem.sol.set(DoubleSolenoid.Value.kForward);
        State = Piston.Down;
      }
      else {
        IntakeSubsystem.sol.set(DoubleSolenoid.Value.kReverse);
        State = Piston.Up;
      }
      
      done = true;
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return done;
    }
}