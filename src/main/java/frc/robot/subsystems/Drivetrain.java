/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ShannonDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  
  WPI_TalonSRX right1;
  WPI_TalonSRX right2;
  WPI_VictorSPX left1;
  WPI_VictorSPX left2;

  private DifferentialDrive arcadeDrive;
  
  public void DriveTrain(){
    right1 = new WPI_TalonSRX(RobotMap.right_1);
    right2 = new WPI_TalonSRX(RobotMap.right_2);
    left1 = new WPI_VictorSPX(RobotMap.left_1);
    left2 = new WPI_VictorSPX(RobotMap.left_2);

    left1.setInverted(true);
    left2.setInverted(true);

    SpeedControllerGroup leftSide = new SpeedControllerGroup(left1, left2);
    SpeedControllerGroup rightSide = new SpeedControllerGroup(right1, right2);

    arcadeDrive = new DifferentialDrive(leftSide, rightSide);
  }

  public void shannonDrive(double x, double turn){
    arcadeDrive.arcadeDrive(x, turn);
  }

  @Override
  public void initDefaultCommand() {
   setDefaultCommand(new ShannonDrive());
  }
}
