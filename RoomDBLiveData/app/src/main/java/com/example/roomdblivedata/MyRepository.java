package com.example.roomdblivedata;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {

    public UserDatabase userDatabase;
    public LiveData<List<User>> liveData;
    public UserDAO userDAO;

    public MyRepository(Application application) {
        userDatabase = UserDatabase.getDatabase(application);
        userDAO = userDatabase.myDao();
        liveData = userDAO.readData();
    }

    public void insert(User user){
        new InsertTask().execute(user);
    }

    public void delete(User user){
        new DeleteTask().execute(user);
    }

    public LiveData<List<User>> readData(){
        return liveData;
    }



    class InsertTask extends AsyncTask<User,Void,Void>{

        @Override
        protected Void doInBackground(User... users) {
            userDAO.insert(users[0]);
            return null;
        }
    }

    class DeleteTask extends AsyncTask<User,Void,Void>{

        @Override
        protected Void doInBackground(User... users) {
            userDAO.delete(users[0]);
            return null;
        }
    }


}
