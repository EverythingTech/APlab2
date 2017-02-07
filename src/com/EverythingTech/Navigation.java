package com.EverythingTech;

import java.io.BufferedReader;
import java.io.FileReader;

public class Navigation {

    public static void main(String[] args) {

        int [][] board = new int[10][10];
        char [] moves = null;
        Point p = new Point();
        int initX = 0;
        int initY = 0;
        int length = 0;
        boolean error = false;

        // File Input
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            reader.mark(Short.MAX_VALUE);
            while(reader.readLine() != null){
                length++;
            } // while
            reader.reset();
            initX = Integer.parseInt(reader.readLine()) - 1;
            initY = Integer.parseInt(reader.readLine()) - 1;
            length -= 2;
            moves = new char[length];
            for(int i = 0; i < length; i++){
                moves[i] = Character.toUpperCase(reader.readLine().charAt(0));
            } // for
            reader.close();
        } catch (Exception e){
            System.out.println("Invalid Data. ");
            error = true;
            System.exit(0);
        } // try catch

        // initializes the board with starting coordinate 1
        // ends the program if garbage is given
        init(board, p, initX, initY);

        // goes through every move and apply the changes
        for(char m : moves){
            if (m == 'N'){
                if(!north(board, p)){
                    System.out.println("Boundary reached. Can't move further North. ");
                    error = true;
                    break;
                } // if
            } else if (m == 'E'){
                if(!east(board, p)){
                    System.out.println("Boundary reached. Can't move further East. ");
                    error = true;
                    break;
                } // if
            } else if (m == 'W'){
                if(!west(board, p)){
                    System.out.println("Boundary reached. Can't move further West. ");
                    error = true;
                    break;
                } // if
            } else if (m == 'S'){
                if(!south(board, p)){
                    System.out.println("Boundary reached. Can't move further South. ");
                    error = true;
                    break;
                } // if
            } // if else if
        } // for

        // Outputs the sum of the board if no error
        if(!error) {
            System.out.println("Success! \nsum: " + sum(board));
            printBoard(board);
        }

    } // main

    // initializes the board
    private static void init(int[][] board, Point p, int initX, int initY){
        if(!p.setX(initX) || !p.setY(initY)){
            System.out.println("Initialization failed. Boundary reached. ");
            System.exit(0);
        } // if

        board[p.getY()][p.getX()] = 1;

    } // init

    // calculates the sum of every element in the board
    private static int sum(int[][] board){
        int sum = 0;

        // sum of rolls
        for(int c = 0; c < 10; c ++){
            for(int r = 0; r < 10; r++){
                sum += board[c][r];
            } // for
        } // for
        return sum;
    } // sum

    private static boolean north (int[][] board, Point p){
        boolean stat = p.setY(p.getY()-1);
        if(stat) move(board, p);
        return stat;
    } // north

    private static boolean east (int[][] board, Point p){
        boolean stat = p.setX(p.getX()+1);
        if(stat) move(board, p);
        return stat;
    } // east

    private static boolean west (int[][] board, Point p){
        boolean stat = p.setX(p.getX()-1);
        if(stat) move(board, p);
        return stat;
    } // west

    private static boolean south (int[][] board, Point p){
        boolean stat = p.setY(p.getY()+1);
        if(stat) move(board, p);
        return stat;
    } // south

    // makes the move
    private static void move (int[][] board, Point p){
        if (board[p.getY()][p.getX()] == 0) {
            board[p.getY()][p.getX()] = 1;
        } else {
            board[p.getY()][p.getX()] *= 2;
        } // if else
    } // move

    // For diagnostics only
    private static void printBoard(int [][] board){
        System.out.println("-----PRINTBOARD----");
        for(int c = 0; c < 10; c ++) {
            for (int r = 0; r < 10; r++) {
                System.out.print(board[c][r] + " ");
            } // for
            System.out.println();
        } // for
        System.out.println("-------------------");
    } // printBoard


} // Navigation
