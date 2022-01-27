/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import static frc.robot.Constants.DrivetrainConstants.*;

public class DriveWithJoysticks extends CommandBase {
  
  private Drivetrain drivetrain;
  private XboxController xboxJoysticks;
  
  
  public DriveWithJoysticks(Drivetrain drive, XboxController xbox) {

    drivetrain = drive;
    xboxJoysticks = xbox;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    
      //Drive using xbox joystick values
      double speedCorrection = kJoystickSpeedCorr;
      //kAutoRightSpeedCorrection is to slow down the right motors because left motors were running slower
      drivetrain.drive(speedCorrection * xboxJoysticks.getLeftY(), kAutoRightSpeedCorrection*speedCorrection * xboxJoysticks.getRightY());
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
