// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.Command
import frc.robot.commands.DriveRobot
import frc.robot.subsystems.DrivetrainSubsystem

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the [Robot]
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private val controller = XboxController(0)
  private val leftMotor = CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless)
  private val rightMotor = CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless)
  private val m_drivetrainSubsystem = DrivetrainSubsystem(leftMotor, rightMotor, controller)
  private val m_driveCommand = DriveRobot(m_drivetrainSubsystem, controller)

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  init {
    // Configure the button bindings
    configureButtonBindings()
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a [GenericHID] or one of its subclasses ([ ] or [XboxController]), and then
   * passing it to a [ ].
   */
  private fun configureButtonBindings() {
    m_drivetrainSubsystem.defaultCommand = m_driveCommand
  }

  /**
   * Use this to pass the autonomous command to the main [Robot] class.
   *
   * @return the command to run in autonomous
   */
  public val driveCommand: Command
    get() = // An ExampleCommand will run in autonomous
    m_driveCommand
}
