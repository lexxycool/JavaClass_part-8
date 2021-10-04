package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopsAndArrayExercisesTest {

    @Test
    public void middleWay_pass_in_array_1_2_3_and_4_5_6_returns_2_5(){
        //Arrange
        LoopsAndArrayExercises loopsAndArrayExercises =
                new LoopsAndArrayExercises();
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        //Act
        int[] actual = loopsAndArrayExercises.middleWay(a, b);
        int[] expected = {2, 5};

        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void middleWay_pass_in_9_9_9_and_7_5_3_returns_9_5(){
        //Arrange
        LoopsAndArrayExercises loopsAndArrayExercises =
                new LoopsAndArrayExercises();

        //Act
        int[] actual = loopsAndArrayExercises.middleWay(new int[]{9, 9, 9},
                new int[] {7, 5, 3});
        int[] expected = {9, 5};

        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void maxEnd3_pass_in_4_9_11_returns_11_11_11(){
        //Arrange
        LoopsAndArrayExercises loopsAndArrayExercises =
                new LoopsAndArrayExercises();
        int[] a = { 4, 9, 11};

        //Act
        int[] actual = loopsAndArrayExercises.maxEnd3(a);
        int[] expected = {11, 11, 11};

        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

}