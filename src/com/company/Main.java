package com.company;

import java.util.Scanner;
import java.util.concurrent.*;

import static java.util.concurrent.CompletableFuture.allOf;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Phaser phaser = new Phaser(2);

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        String val = "Y";
        while (val.equals("Y")){
            System.out.println("create thread?");
            val = myObj.nextLine();
            System.out.println("sleep for?");
            Integer milis = Integer.parseInt(myObj.nextLine());
            if(val.equals("Y")){
                createThread(phaser, milis);
            }
        }

    }

    private static void createThread(Phaser phaser, Integer milis) {
        var thread1 = new MyThread(phaser, milis, 1);
        thread1.start();
    }
}
