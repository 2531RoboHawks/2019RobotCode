package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frclib.pid.PID;

public class CrabDefault extends Command {

  private PID pid = new PID(0.5, 0, 0, 0);

  private double target = 0;

  public CrabDefault() {
    requires(Robot.crabAxis);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Crab Default");
    pid.setOutputLimits(-0.5, 0.5);
    pid.setOnTargetCount(10);
    pid.setOnTargetOffset(2);
    pid.setSetpoint(0);
  }

  @Override
  protected void execute() {
    // line vision
    // DO IT HERE

    if (RobotMap.liftOnTarget && OI.joystick.getRawButton(1)) {
      pid.setSetpoint(target);
    } else {
      pid.setSetpoint(0);
    }
    // compute pid
    double power = pid.compute(Robot.crabAxis.getPosition());
    Robot.crabAxis.set(power);
    RobotMap.crabOnTarget = pid.onTarget();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.crabAxis.stop();
    System.out.println("-! Crab Default");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
