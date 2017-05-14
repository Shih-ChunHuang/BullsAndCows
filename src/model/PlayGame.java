package model;

import javax.swing.*;
import java.util.regex.*;

/**
 * Created by Shih-Chun on 2017-05-10.
 */
public class PlayGame {

    private String input;
    private String secretNumber;
    private int bulls;
    private int cows;


    public PlayGame(){


    }

    public boolean gameProcess(String userNumber){

        input = userNumber;

        ComputerPlayer PCPlayer = new ComputerPlayer();

        secretNumber = PCPlayer.setSecretNumber();

        boolean found = false;
        boolean loser = false;



        while (!found && !loser){

            while (!isValidInput(input)){
                input = JOptionPane.showInputDialog(null, "Please enter four digit number");

            }

            String bulls = countBulls(input, secretNumber);
            String cows = countCows(input, secretNumber);

            if (input.equals(secretNumber)){

                found = true;
                return found;

            }else {


                input = JOptionPane.showInputDialog(null, "You entered: " + input +"\nResult is: " + bulls + " bull(s) and " + cows + " cow(s). \n Try again: ");

//                    while (true) {
//
//                        if (again.equals("y")) {
//
//                            input = JOptionPane.showInputDialog(null, "Guess again. Please enter a four digit number:");
//
//                            break;
//
//                        }else if (again.equals("n")){
//                            loser = true;
//                            break;
//
//                        }else{
//
//                            JOptionPane.showMessageDialog(null, "Do you want to continue guessing? " +
//                                    "Please enter y (yes) or n (no)");
//                            break;
//
//                        }
//
//
//                    }


            }


        }

        return found;

    }

    private String countCows(String input, String secretNumber) {

        cows = 0;

        if (input.contains(secretNumber.substring(0,1))){
            cows++;
        }

        if (input.contains(secretNumber.substring(1,2))){
            cows++;
        }

        if(input.contains(secretNumber.substring(2,3))){
            cows++;
        }

        if(input.contains(secretNumber.substring(3,4))){
            cows++;
        }

        cows = cows - bulls;

        return Integer.toString(cows);
    }

    private String countBulls(String input, String secretNumber) {

        bulls = 0;

        if (input.substring(0,1).equals(secretNumber.substring(0,1))){
            bulls++;
        }

        if (input.substring(1,2).equals(secretNumber.substring(1,2))){
            bulls++;
        }

        if (input.substring(2,3).equals(secretNumber.substring(2,3))){
            bulls++;
        }

        if (input.substring(3,4).equals(secretNumber.substring(3,4))){
            bulls++;
        }


        return Integer.toString(bulls);
    }


    private boolean isValidInput(String input) {

        boolean pass = false;

        String pattern = "[0-9]+";


        boolean isDigit = input.matches(pattern);



        if (input.length() == 4 && isDigit) {
            pass = true;
            return pass;

        }else {

            return pass;

        }


    }









}
