package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ConveyorSubsystem.Stage;
import edu.wpi.first.wpilibj2.command.CommandBase;

// TODO: utilize time of flight sensors -- CREATE ALGORITHM FOR HOLDING 5 BALLS!!

public class ConveyorCommand extends CommandBase {
  public ConveyorCommand(ConveyorSubsystem subsystem) {
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
    if (OI.getTriggerRightAxis()) {
      ConveyorSubsystem.horizontalMotor.set(Constants.kSpeedConveyorFwd);
      ConveyorSubsystem.verticalMotor.set(Constants.kSpeedConveyorRev);
    }
    else if (OI.getTriggerLeftAxis()) {
      ConveyorSubsystem.horizontalMotor.set(Constants.kSpeedConveyorRev);
      ConveyorSubsystem.verticalMotor.set(Constants.kSpeedConveyorFwd);
    }
    else {
      ConveyorSubsystem.horizontalMotor.set(0);
      ConveyorSubsystem.verticalMotor.set(0);
    }

    // suck balls in with XB_RT (must be positive)
    //ConveyorSubsystem.verticalMotor.set(Math.abs(Constants.XboxRT() / Constants.kSpeedConveyorDecrement));
    //ConveyorSubsystem.horizontalMotor.set(Math.abs(Constants.XboxRT() / Constants.kSpeedConveyorDecrement));

    // push balls out with XB_LT (must be negative)
    /*double val = Constants.XboxLT() / Constants.kSpeedConveyorDecrement;
    if (val >= 0) {
      val = -val;
    }

    ConveyorSubsystem.verticalMotor.set(val);
    ConveyorSubsystem.horizontalMotor.set(val);*/




    // waiting and pickupMotor is spinning to receive balls.
    /*if (ConveyorSubsystem.State == Stage.Wait && IntakeSubsystem.intakeMotor.get() > 0) {
      ConveyorSubsystem.State = Stage.First;
    }

    if (ConveyorSubsystem.State == Stage.First && IntakeSubsystem.intakeMotor.get() > 0) {
      ConveyorSubsystem.verticalMotor.set(Constants.kSpeedConveyorFwd);

      // cannot see ball
      while (ConveyorSubsystem.tof1.getRange() > Constants.kTOFHalfDist) {
        // wait
      }

      // can see ball
      while (ConveyorSubsystem.tof1.getRange() < Constants.kTOFHalfDist) {
        // wait
      }

      ConveyorSubsystem.verticalMotor.set(0);

      ConveyorSubsystem.State = Stage.Second;
    }*/

    
    /*while (true) {
      // pickupMotor is sucking in balls.
      if (IntakeSubsystem.intakeMotor.get() > 0) {
        if (ConveyorSubsystem.State == Stage.First) {
          ConveyorSubsystem.verticalMotor.set(Constants.kSpeedConveyorFwd);
          
          ConveyorSubsystem.State = Stage.WaitForBall;
          ConveyorSubsystem.ReturnState = Stage.Second;
        }
        if (ConveyorSubsystem.State == Stage.WaitForBall) {
          // can see ball
          if (ConveyorSubsystem.tof1.getRange() < Constants.kTOFHalfDist) {
            ConveyorSubsystem.State = Stage.WaitForNoBall;
          }
        }
        if (ConveyorSubsystem.State == Stage.WaitForNoBall) {
          // cannot see ball
          if (ConveyorSubsystem.tof1.getRange() > Constants.kTOFHalfDist) {
            ConveyorSubsystem.State = ConveyorSubsystem.ReturnState;
          }
        }
      }
    }*/
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
