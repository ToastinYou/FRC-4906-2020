package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GearboxShiftSubsystem;

public class GearboxShiftCommand extends CommandBase {
    private final GearboxShiftSubsystem m_subsystem;
    private boolean lowGear = false;
    private String gear;
  
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

      SmartDashboard.putString("Gearbox", gear); // "gear" may not update quick enough..
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (lowGear) {
        // low gear
        GearboxShiftSubsystem.sol1.set(DoubleSolenoid.Value.kReverse);
        gear = "Low";
      }
      else {
        // high gear
        GearboxShiftSubsystem.sol1.set(DoubleSolenoid.Value.kForward);
        gear = "High";
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