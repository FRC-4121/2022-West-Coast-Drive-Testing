// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;

public class ExtendClimber extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Climber m_climber;
  private XboxController xboxJoysticks;

   
  //constructor
  public ExtendClimber(Climber subsystem, XboxController xbox) {
    m_climber = subsystem;
    xboxJoysticks=xbox;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_climber.climbExtend(xboxJoysticks);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    m_climber.climbStop(xboxJoysticks);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
