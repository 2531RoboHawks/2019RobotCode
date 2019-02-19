package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class PlaceCargo extends Command {

  private boolean done;
  private long endtime, time;

  public PlaceCargo(long time) {
    requires(Robot.intake);
    this.time = time;
  }

  public PlaceCargo() {
    requires(Robot.intake);
    time = 0;
  }

  @Override
  protected void initialize() {
    System.out.println("-> Place Cargo");
    done = false;
  }

  @Override
  protected void execute() {
    Robot.intake.setMotor(-0.5);
    if (!RobotMap.cargoDetectionSwitch.get() && (time != 0)) {
      if (endtime < System.currentTimeMillis()) {
        done = true;
      }
    } else {
      endtime = System.currentTimeMillis() + time;
    }
  }

  @Override
  protected boolean isFinished() {
    return done && (time != 0);
  }

  @Override
  protected void end() {
    Robot.intake.stop();
    System.out.println("-! Place Cargo");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
