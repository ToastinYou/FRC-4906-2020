package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GearboxShiftSubsystem;

public class GearboxShiftCommand extends CommandBase {
    private final GearboxShiftSubsystem m_subsystem;
    private boolean lowGear = false;
  
    public GearboxShiftCommand(GearboxShiftSubsystem subsystem) {
      m_subsystem = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      // when the command is called, set lowGear equal to the opposite of lowGear (defaults to low gear)
      lowGear = !lowGear;
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (lowGear) {
        // low gear
        GearboxShiftSubsystem.sol1.set(DoubleSolenoid.Value.kReverse);
      }
      else {
        // high gear
        GearboxShiftSubsystem.sol1.set(DoubleSolenoid.Value.kForward);
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