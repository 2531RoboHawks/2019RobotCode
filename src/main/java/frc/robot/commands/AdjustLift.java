package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class AdjustLift extends Command {

  private double a = 0;
  private boolean done = false;

  public AdjustLift(double change) {
    a = change;
  }

  @Override
  protected void initialize() {
    System.out.println("-> Adjust Lift");
    done = false;
  }

  @Override
  protected void execute() {
    RobotMap.liftAdjustment += a;
    done = true;
  }

  @Override
  protected boolean isFinished() {
    return done && RobotMap.liftOnTarget;
  }

  @Override
  protected void end() {
    System.out.println("-! Adjust Lift");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
