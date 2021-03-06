package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

  public static Joystick joystick_right = new Joystick(0);// attack 3 right
  public static Joystick joystick_left = new Joystick(1);// attack 3 left
  public static Joystick gamepad = new Joystick(2);// gamepad

  public static final int LIFT_UP_BUTTON = 4;
  public static final int LIFT_DOWN_BUTTON = 2;

  public static final int IN_CARGO_BUTTON = 1;
  public static final int OUT_CARGO_BUTTON = 1;

  public static final int OPEN_HATCHCLAMP_BUTTON = 6;
  public static final int CLOSE_HATCHCLAMP_BUTTON = 5;

  public static final int SHIFT_DRIVE_BUTTON = 2;

  // joystick axies
  public static final int X_AXIS = 0;
  public static final int Y_AXIS = 1;
  public static final int AUX_AXIS = 2;

  public OI() {
    System.out.println("OI Constructed");
  }
}
