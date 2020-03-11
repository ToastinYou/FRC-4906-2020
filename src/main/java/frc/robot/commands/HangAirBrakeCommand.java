package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangSubsystem;

public class HangAirBrakeCommand extends CommandBase {
  public static enum Puncher {
    Out,
    In,
  }
  public static Puncher State;
  //private static boolean airBrake;

  private boolean done;

  public HangAirBrakeCommand(HangSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  /*public static void ToggleAirBrake() {  
    airBrake = !airBrake;

    if (!airBrake) {
      HangSubsystem.sol.set(DoubleSolenoid.Value.kReverse);
    }
    else {
      HangSubsystem.sol.set(DoubleSolenoid.Value.kForward);
    }
  }*/

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (State == Puncher.In) {
      HangSubsystem.sol.set(DoubleSolenoid.Value.kForward);
      State = Puncher.Out;
    }
    else {
      HangSubsystem.sol.set(DoubleSolenoid.Value.kReverse);
      State = Puncher.In;
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