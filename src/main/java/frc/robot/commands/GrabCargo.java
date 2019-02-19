package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class GrabCargo extends Command {

  private boolean done;
  private long endtime;

  public GrabCargo() {
    requires(Robot.intake);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Grab Cargo");
    done = false;
  }

  @Override
  protected void execute() {
    Robot.intake.setMotor(0.5);
    if (RobotMap.cargoDetectionSwitch.get()) {
      if (endtime < System.currentTimeMillis()) {
        done = true;
      }
    } else {
      endtime = System.currentTimeMillis() + 800;
    }
  }

  @Override
  protected boolean isFinished() {
    return done;
  }

  @Override
  protected void end() {
    Robot.intake.stop();
    System.out.println("-! Grab Cargo");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
