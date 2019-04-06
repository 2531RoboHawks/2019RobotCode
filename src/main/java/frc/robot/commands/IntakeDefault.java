package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class IntakeDefault extends Command {

  public IntakeDefault() {
    requires(Robot.intake);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Intake Default");
  }

  @Override
  protected void execute() {
    if (OI.joystick_right.getRawButton(OI.INTAKE_BUTTON)) {
      Robot.intake.setMotor(0.5);
    } else if (OI.joystick_right.getRawButton(OI.OUTTAKE_BUTTON)) {
      Robot.intake.setMotor(-0.5);
    } else {
      Robot.intake.stop();
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    System.out.println("-! Intake Default");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
