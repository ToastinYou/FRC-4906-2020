package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangSubsystem;

public class HangAirBrakeCommand extends CommandBase {
    private boolean airBrake;
    public HangAirBrakeCommand(HangSubsystem subsystem) {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);

      // default to upward
      HangSubsystem.sol.set(DoubleSolenoid.Value.kForward);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {  
      airBrake = !airBrake;

      if (!airBrake) {
        HangSubsystem.sol.set(DoubleSolenoid.Value.kForward);
      }
      else {
        HangSubsystem.sol.set(DoubleSolenoid.Value.kReverse);
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