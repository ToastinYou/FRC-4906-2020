package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.ShiftSubsystem;

public class ShiftCommand extends CommandBase {
    private String gear = "Low";
  
    public ShiftCommand(ShiftSubsystem subsystem) {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      ShiftSubsystem.sol.set(DoubleSolenoid.Value.kReverse);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (OI.getJoystickLowGear()) {
        // low gear
        ShiftSubsystem.sol.set(DoubleSolenoid.Value.kReverse);
        gear = "Low";
      }

      if (OI.getJoystickHighGear()) {
        // high gear
        ShiftSubsystem.sol.set(DoubleSolenoid.Value.kForward);
        gear = "High";
      }
      
      SmartDashboard.putString("Gear", gear); // "gear" may not update quick enough..
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