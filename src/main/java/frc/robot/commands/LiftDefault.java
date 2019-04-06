package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class LiftDefault extends Command {

  public LiftDefault() {
    requires(Robot.lift);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Lift Default");
  }

  @Override
  protected void execute() {
    double power = 0;
    if (OI.gamepad.getRawButton(OI.LIFT_DOWN_BUTTON)) {
      power = -0.2;
    }else
    if (OI.gamepad.getRawButton(OI.LIFT_UP_BUTTON)) {
      power = 0.5;
    }else{
      power = 0.1;
    }
    Robot.lift.set(power);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.lift.stop();
    System.out.println("-! Lift Default");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
