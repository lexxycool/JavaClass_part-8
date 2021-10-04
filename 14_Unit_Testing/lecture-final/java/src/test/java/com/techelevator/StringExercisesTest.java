package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringExercisesTest {

    @Test
    public void makeAbba_pass_in_hi_and_bye_returns_hibyebyehi(){
        //Arrange
        StringExercises stringExercises = new StringExercises();

        //Act
        String actual = stringExercises.makeAbba("hi", "bye");
        String expected = "hibyebyehi";

        //Assert
        Assert.assertEquals(expected, actual);

    }

}