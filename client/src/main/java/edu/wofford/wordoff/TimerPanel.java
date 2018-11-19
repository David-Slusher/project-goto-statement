package edu.wofford.wordoff;

import java.util.*;
import java.util.List;
import java.io.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

/**
* Timer Panel
* Implements a JPanel with a countdown timer for use with the JFrame generated by
* the AnagramsGUI class. When the timer reactes zero the JButton and JTextField
* objects within the AnagramsGUI window are disabled.
*/
public class TimerPanel extends JPanel implements ActionListener {
  private Timer countdownTimer;
  private int currentTime;
  private int startTime;
  private int difficulty;
  private String selectedWord;
  private JPanel timerPanel;
  private JLabel timeBox;
  private AnagramsGUI mainFrame;

/**
* Action preformed every second once the timer has started. Continues until the
* {@code currentTime} reaches zero or the {@code stopTimer()} method is called.
*/
  public void actionPerformed(ActionEvent event) {
    currentTime -= 1;
    timeBox.setText(String.format("%02d:%02d", currentTime / 60, currentTime % 60));
    if(currentTime <= 0) {
      countdownTimer.stop();
      mainFrame.disableButtonAndTextField();
      mainFrame.showLeaderboadDialog();
    }
	}

/**
* Default Constructor.
* The default constructor calls the
* {@link #TimerPanel(int, AnagramsGUI) TimerPanel(startTime, mainFrame)}
* constructor with starting time 0, and the provided instance of AnagramsGUI.
*
* @param mainFrame Instance of an AnagramsGUI to be used to disable the JButton
* and JTextField, as well as to create the leaderboard dialog.
*/
  public TimerPanel(AnagramsGUI mainFrame) {
    this(0, mainFrame);
  }

/**
* Constructor with starting time and instances of JButton and JTextField.
* Initilizes the {@code startTime} and {@code currentTime} using the given
* {@code startTime} parameter. Creates a new {@code Timer} object named
* {@code countdownTimer} that call the {@code ActionListener} every second.
* two {@code JLabel} objects are created that display the String "Time Remaining"
* and the {@code currentTime} formated as "mm:ss".
*
* @param startTime The starting time of the timer.
* @param mainFrame Instance of an AnagramsGUI to be used to disable the JButton
* and JTextField, as well as to create the leaderboard dialog.
*/
  public TimerPanel(int startTime, AnagramsGUI mainFrame) {
    this.startTime = startTime;
    this.currentTime = startTime;
    this.difficulty = difficulty;
    this.countdownTimer = new Timer(1000, null);
    this.countdownTimer.addActionListener(this);
    this.mainFrame = mainFrame;

    setLayout(new GridLayout (1, 2, 30, 20));
    setBorder(new EmptyBorder(20, 30, 20, 30));
    JLabel timeRemaining = new JLabel("Time Remaining");
    timeRemaining.setBorder(new LineBorder(Color.GRAY));
    timeRemaining.setHorizontalAlignment(JLabel.CENTER);
    timeRemaining.setPreferredSize(new Dimension(20, 40));

		timeBox = new JLabel(String.format("%02d:%02d", currentTime / 60, currentTime % 60));
		timeBox.setName("timer");
    timeBox.setBorder(new LineBorder(Color.GRAY));
    timeBox.setHorizontalAlignment(JLabel.CENTER);
    timeBox.setPreferredSize(new Dimension(20, 40));
		add(timeRemaining);
		add(timeBox);
  }

/**
* Returns the {@code startTime} of the timer.
*
* @return An {@code int} representing the starting time of the
* countdown timer
*/
  public int getStartTime() {
    return startTime;
  }

/**
* Returns the {@code currentTime} of the timer.
*
* @return An {@code int} representing the current time of the
* countdown timer
*/
  public int getCurrentTime() {
    return currentTime;
  }

/**
* Sets a new {@code startTime} of the timer.
*
* @param newTime An {@code int} representing the new starting time of the
* countdown timer
*/
  public void setStartTime(int newTime) {
    this.startTime = newTime;
  }

/**
* Resets the {@code countdownTimer} by setting the {@code currentTime} to the
* {@code startTime}.
*/
  public void resetTimer() {
    this.currentTime = startTime;
  }

/**
* Starts the {@code countdownTimer}.
*/
  public void startTimer() {
    countdownTimer.start();
  }

/**
* Stops the {@code countdownTimer}.
*/
  public void stopTimer() {
    countdownTimer.stop();
  }


}
