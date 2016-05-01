package com.mtomoskozi.sugarapp.unittests;


import com.mtomoskozi.sugarapp.BuildConfig;
import com.mtomoskozi.sugarapp.RobolectricDaggerTestRunner;
import com.mtomoskozi.sugarapp.android.DaggerMockSugarAppApplicationComponent;
import com.mtomoskozi.sugarapp.android.MockSugarAppApplicationComponent;
import com.mtomoskozi.sugarapp.android.SugarAppApplication;
import com.mtomoskozi.sugarapp.interactor.PeopleInteractor;
import com.mtomoskozi.sugarapp.model.Person;
import com.mtomoskozi.sugarapp.network.mock.PeopleMock;
import com.mtomoskozi.sugarapp.view.ViewModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import static com.mtomoskozi.sugarapp.TestHelper.setTestInjector;
import static org.junit.Assert.*;

/**
 * Created by Máté on 01/05/2016.
 */
@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class PersonUnitTest {

    @Inject
    public PeopleInteractor interactor;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        interactor = new PeopleInteractor();
    }

    @Test
    public void getterTest() throws Exception {
        String name = "lala";
        Person p = new Person(name);
        assertEquals(p.getName().equals(name), true);
    }

    @Test
    public void mockGetTest() throws Exception {
        PeopleMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            List<Person> p = interactor.getPeopleFromNetwork();
            assertEquals(p.get(0).getName(), PeopleMock.testP1.getName());
            assertEquals(p.get(1).getName(), PeopleMock.testP2.getName());
        }
    }

    @Test
    public void mockAddTest() throws Exception {
        PeopleMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            Person n = new Person("lófül ezredes");
            interactor.addPersonToNetwork(n);
            List<Person> p = interactor.getPeopleFromNetwork();
            assertEquals(p.get(1).getName(), PeopleMock.testP1.getName());
            assertEquals(p.get(2).getName(), PeopleMock.testP2.getName());
            assertEquals(p.get(0).getName(), n.getName());
        }
    }
}
