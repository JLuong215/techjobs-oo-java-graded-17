package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");


        Job job = new Job("Product tester", employer, location, positionType, coreCompetency);

        // Test that each field is set correctly
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().toString(), "ACME");
        assertEquals(job.getLocation().toString(), "Desert");
        assertEquals(job.getPositionType().toString(), "Quality control");
        assertEquals(job.getCoreCompetency().toString(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Test that equals returns false
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {


        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Expected string with formatting
        String expected = "\n" +
                "ID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        // Get the actual string representation using the toString() method
        String actual = job1.toString();

        // Compare the expected and actual strings
        assertEquals(expected, actual);
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Expected string with correct labels and data
        String expected = "\n" +
                "ID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        // Get the actual string representation using the toString() method
        String actual = job1.toString();

        // Compare the expected and actual strings
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("Web Developer", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedString1 = lineSeparator() +
                "ID: " + job1.getId() + "\n" +
                "Name: Web Developer" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + lineSeparator();
        assertEquals(job1.toString(), expectedString1);
    }

//    @Test
//    public void testToStringContainsCorrectLabelsAndData() {
//        Job job1 = new Job("TestJob", new Employer("LaunchCode"), new Location("StL"), new PositionType("TestPosition"), new CoreCompetency("test"));
//        String expectedString2 = lineSeparator()+
//                "ID: " + job1.getId() + "\n"+
//                "Name: TestJob" + "\n" +
//                "Employer: LaunchCode" + "\n" +
//                "Location: StL" + "\n" +
//                "Position Type: TestPosition" + "\n" +
//                "Core Competency: test" +lineSeparator();
//        assertEquals(job1.toString(), expectedString2);
//    }
}




