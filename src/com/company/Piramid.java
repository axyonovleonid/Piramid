package com.company;

public class Piramid {

    public static void main(String[] args) {

        try {
            if(args.length != 2) 
                throw new IllegalArgumentException("Incorrect arguments");

            int rowPos = Integer.parseInt(args[0]);
            int colPos = Integer.parseInt(args[1]);

            if(colPos > rowPos || rowPos < 0 || colPos < 0)
                throw new IllegalArgumentException("Incorrect arguments");

            Double[][] positions = new Double[rowPos + 1][];
            for(int i = 0; i <= rowPos; i++){
                positions[i] = new Double[i+1];
            }

//-Xmx1024m -Xms256m
//Должна же быть какая-то формула, которая дает правильное решение за О(1)

            System.out.println("Prepare has started!");
            int leftBound = 0;
            positions[0][0] = 0.0;
            for(int row = 0; row <= rowPos; row++){
                if(row>(rowPos-colPos) && (rowPos-colPos) > 0)leftBound++;
                for(int pos = leftBound; pos <= colPos && pos <= row; pos++){
                    if(2*pos > rowPos)
                        positions[row][pos] = positions[row][pos-row];
                    else if (row != 0) {
                        if(pos == 0)
                            positions[row][pos] = (1 + positions[row-1][pos])/2;
                        else if(pos == row)
                            positions[row][pos] = (1 + positions[row-1][pos-1])/2;
                        else
                            positions[row][pos] = (positions[row - 1][pos-1]+ positions[row - 1][pos]+2)/2;
                    }
    
                }
            }

            System.out.println(positions[rowPos][colPos]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
