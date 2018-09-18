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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ShannonDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  
  //talons are 2, victors are 1
  WPI_TalonSRX left2;
  WPI_TalonSRX right2;
  WPI_VictorSPX left1;
  WPI_VictorSPX right1;

  private DifferentialDrive arcadeDrive;
  
  public void DriveTrain(){
    left2 = new WPI_TalonSRX(RobotMap.left_2);
    right2 = new WPI_TalonSRX(RobotMap.right_2);
    left1 = new WPI_VictorSPX(RobotMap.left_1);
    right1 = new WPI_VictorSPX(RobotMap.right_1);

    //left1.setInverted(true);
    //right1.setInverted(true);

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

  public void printMotorControllers(){
    SmartDashboard.putNumber(left1.getName(), left1.get());
    SmartDashboard.putNumber(left2.getName(), left2.get());
    SmartDashboard.putNumber(right1.getName(), right1.get());
    SmartDashboard.putNumber(right2.getName(), right2.get());
  }
}
