package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frclib.pid.PID;

public class CrabTo extends Command {

  private double target;
  private boolean done;

  private PID pid = new PID(0.5, 0, 0, 0);

  public CrabTo(double position) {
    requires(Robot.crabAxis);
    target = position;
  }

  @Override
  protected void initialize() {
    System.out.println("-> CrabTo");
    pid.setSetpoint(target);
    pid.setOnTargetCount(10);
    pid.setOnTargetOffset(1);
    pid.setOutputLimits(-1, 1);
    done = false;
  }

  @Override
  protected void execute() {
    double position = Robot.crabAxis.getPosition();
    double power = pid.compute(position);
    if ((power > 0 && Robot.crabAxis.isAtRight()) || (power < 0 && Robot.crabAxis.isAtLeft())) {
      done = true;
      Robot.crabAxis.stop();
      return;
    }
    Robot.crabAxis.set(power);
  }

  @Override
  protected boolean isFinished() {
    return pid.onTarget() || done;
  }

  @Override
  protected void end() {
    Robot.crabAxis.stop();
    System.out.println("-! CrabTo");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
