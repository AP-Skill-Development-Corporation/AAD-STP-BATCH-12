package com.example.roomdblivedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    public LiveData<List<User>> readData;
    public MyRepository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
        readData = repository.readData();
    }

    public void insertData(User user){
        repository.insert(user);
    }

    public void deleteData(User user){
        repository.delete(user);
    }

    public LiveData<List<User>> getData(){
        return readData;
    }

}
