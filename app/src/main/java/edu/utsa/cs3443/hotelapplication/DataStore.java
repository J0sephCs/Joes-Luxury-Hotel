package edu.utsa.cs3443.hotelapplication;

import android.provider.ContactsContract;

public class DataStore {

    public static DataStore instance;
    public String email;

    public DataStore(){

    }

    public static synchronized DataStore getInstance(){
        if(instance == null){
            instance= new DataStore();
        }
        return instance;
    }

    public void setEmail(String email){
        this.email= email;
    }

    public String getEmail(){return email;}
}
