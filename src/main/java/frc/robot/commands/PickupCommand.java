package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.PickupSubsystem;

// power cell pickup

public class PickupCommand extends CommandBase {
    private final PickupSubsystem m_subsystem;
  
    public PickupCommand(PickupSubsystem subsystem) {
      m_subsystem = subsystem;
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
      if (Constants.XboxControl.getXButton()) {
        PickupSubsystem.pickupMotor.set(1);
      }
      else {
        PickupSubsystem.pickupMotor.set(0);
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