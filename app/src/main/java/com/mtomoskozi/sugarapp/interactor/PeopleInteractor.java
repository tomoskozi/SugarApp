package com.mtomoskozi.sugarapp.interactor;

import com.mtomoskozi.sugarapp.android.SugarAppApplication;
import com.mtomoskozi.sugarapp.model.prod.PeopleDbModel;
import com.mtomoskozi.sugarapp.model.Person;
import com.mtomoskozi.sugarapp.network.PeopleApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Máté on 27/04/2016.
 */
public class PeopleInteractor {
        @Inject
        PeopleDbModel model;

        @Inject
        PeopleApi peopleApi;

        public PeopleInteractor() {
            SugarAppApplication.injector.inject(this);
        }

        public void addPersonToDb(Person toAdd) {
            model.insertPerson(toAdd);
        }

        public void addPersonToNetwork(Person toAdd) throws Exception {
            Response response = null;

            Call call = peopleApi.peopleAddDataGet(toAdd.getName());
            try {
                response = call.execute();
            } catch (Exception e) {
                throw new Exception("Network error on execute with post!");
            }
            if (response.code() != 200) {
                throw new Exception("Network error with post!");
            }
        }

        public List<Person> getPeopleFromDb() {
            return model.fetchPeople();
        }

        public List<Person> getPeopleFromNetwork() throws Exception {
            Response<List<Person>> response = null;

            Call<List<Person>> call = peopleApi.peopleGet();
            try {
                response = call.execute();
            } catch (Exception e) {
                throw new Exception("Network error on execute with get!");
            }
            if (response.code() != 200) {
                throw new Exception("Network error with get!");
            }

            return response.body();
        }
    }
