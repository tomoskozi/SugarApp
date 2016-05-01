package com.mtomoskozi.sugarapp.model;


import com.orm.SugarRecord;
import java.util.Objects;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;


/**
 * Created by mtomoskozi on 4/15/16.
 */
//@ApiModel(description = "")
public class Person  extends SugarRecord   {

    @SerializedName("name")
    private String name = null;

    public Person() {
        name = "Default";
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     **/
    //@ApiModelProperty(value = "")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
