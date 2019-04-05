package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class WristDefault extends Command {

  public WristDefault() {
    requires(Robot.wrist);
  }

  @Override
  protected void initialize() {
    System.out.println("-> WristDefault");
  }

  @Override
  protected void execute() {
    if (OI.gamepad.getRawButton(OI.WRIST_UP_BUTTON)) {
      Robot.wrist.set(0.7);
    } else if (OI.gamepad.getRawButton(OI.WRIST_DOWN_BUTTON)) {
      Robot.wrist.set(-0.6);
    } else {
      Robot.wrist.stop();
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.wrist.stop();
    System.out.println("-! WristDefault");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
