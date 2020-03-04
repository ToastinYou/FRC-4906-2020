package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.IndexSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

// TODO: utilize time of flight sensors -- CREATE ALGORITHM FOR HOLDING 5 BALLS!!

public class IndexCommand extends CommandBase {
  private final IndexSubsystem m_subsystem;
  
  public IndexCommand(IndexSubsystem subsystem) {
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
    // suck balls in with XB_RT (must be positive)
    IndexSubsystem.leftMotor.set(Math.abs(Constants.XboxRT() / 4));

    // push balls out with XB_LT (must be negative)
    IndexSubsystem.leftMotor.set(-(Constants.XboxLT() / 4));
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
