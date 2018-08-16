/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.GetColor;

/**
 * Add your docs here.
 */
public class ColorSensor extends Subsystem {
  
  public I2C colorSensor = new I2C(I2C.Port.kOnboard, 0x3C);

  public int getColor(){
      int color = 0;
      SmartDashboard.putBoolean("ColorBool", colorSensor.write(0x04, color));
      return color;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new GetColor());
  }
}
