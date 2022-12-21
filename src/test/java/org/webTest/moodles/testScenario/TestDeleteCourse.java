package org.webTest.moodles.testScenario;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDeleteCourse {
    @Factory
    public Object [] runTest() {
        List<Object> testList = new ArrayList<>();
        testList.add(new SingleTestDeleteCourse("test1", "admin", "sandbox", Boolean.TRUE));
        testList.add(new SingleTestDeleteCourse("test1", "admin", "aaaa", Boolean.FALSE));
        return testList.toArray();
    }
}

class SingleTestDeleteCourse extends TestAuxiliary {
    private String courseName;
    private String courseCatagory;
    private Boolean isSearch;
    public SingleTestDeleteCourse(final String testName, final String courseName, final String courseCatagory, final Boolean isSearch) {
        this.testCaseName = testName;
        this.courseName = courseName;
        this.courseCatagory = courseCatagory;
        this.isSearch = isSearch;
    }

    @Test
    public void run() {

    }
}

