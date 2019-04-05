package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frclib.pid.PID;

public class LiftDefault extends Command {

  private PID pid = new PID(0.05, 0, 0, 0);

  public LiftDefault() {
    requires(Robot.lift);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Lift Default");
    pid.setOnTargetCount(10);
    pid.setOutputLimits(-0.8, 0.8);
    pid.setOnTargetOffset(1);
  }

  @Override
  protected void execute() {
    double power = 0;
    if (OI.gamepad.getRawButton(OI.LIFT_DOWN_BUTTON)) {
      power = -0.2;
    }
    if (OI.gamepad.getRawButton(OI.LIFT_UP_BUTTON)) {
      power = 0.5;
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
