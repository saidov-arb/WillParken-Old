package com.willparken.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.willparken.R;
import com.willparken.model.SerializationFactory;
import com.willparken.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        User iUser = new User("DaFirstName","DaLastName",null,"Kanonenstraße 187",800234123,"admin@gmail.com",User.encryptPassword("admin"));
//        iUser.save();
//        SerializationFactory.getInstance().persist(getApplicationContext());

//        SerializationFactory.getInstance().restore(getApplicationContext());
//        User iUser = User.selectByEmailPassword("admin@gmail.com","admin");

    }
}