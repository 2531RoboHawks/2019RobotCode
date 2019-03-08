package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

  public static Joystick joystick_right = new Joystick(0);// attack 3 right
  public static Joystick joystick_left = new Joystick(1);// attack 3 left
  public static Joystick gamepad = new Joystick(2);// gamepad

  // joystick buttons
  public static final int LIFT_TRIGGER_BUTTON = 1;
  public static final int PLACE_BUTTON = 3;
  public static final int GRAB_CARGO_BUTTON = 4;
  public static final int GRAB_HATCH_BUTTON = 5;
  public static final int SHIFT_DRIVE_BUTTON = 2;

  // joystick axies
  public static final int X_AXIS = 0;
  public static final int Y_AXIS = 1;
  public static final int AUX_AXIS = 2;

  // gamepad buttons
  public static final int LOAD_HATCH_HEIGHT_BUTTON = 6;
  public static final int LOAD_CARGO_HEIGHT_BUTTON = 5;
  public static final int SCORE_CARGOSHIP_BUTTON = 3;
  public static final int SCORE_ROCKET_LOW_BUTTON = 2;
  public static final int SCORE_ROCKET_MID_BUTTON = 1;
  public static final int SCORE_ROCKET_HIGH_BUTTON = 4;
  public static final int RETURN_BUTTON = 10;

  public OI() {
    System.out.println("OI Constructed");
  }
}
