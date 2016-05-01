package com.mtomoskozi.sugarapp.network;

import java.util.List;

import com.mtomoskozi.sugarapp.model.Person;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PeopleApi {
  
  /**
   * 
   * 
   * @return Call<List<Person>>
   */
  
  @GET("people")
  Call<List<Person>> peopleGet();

  /**
   *
   *
   * @param data
   * @return Call<Void>
   */

  @GET("people/add/{data}")
  Call<Void> peopleAddDataGet(
          @Path("data") String data
  );
  
}
