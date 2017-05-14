package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shih-Chun on 2017-05-10.
 */
public class ComputerPlayer {

    private String secretNumber;


    public ComputerPlayer(){
        secretNumber = "";
    }

    public String setSecretNumber(){

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < 10; i++){

            temp.add(i);

        }

        Collections.shuffle(temp);

        for (int i = 0; i < 4; i++){

            secretNumber += temp.get(i).toString();
        }



        System.out.println(secretNumber);
        return secretNumber;

    }

    public String getSecretNumber(){

        return secretNumber;

    }



}
