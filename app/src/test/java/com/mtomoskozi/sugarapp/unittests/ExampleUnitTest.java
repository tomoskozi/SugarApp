package com.mtomoskozi.sugarapp.unittests;

import com.mtomoskozi.sugarapp.model.Person;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        String name = "lala";
        Person p = new Person(name);
        assertEquals(p.getName().equals(name), true);
    }
}