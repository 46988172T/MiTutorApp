package com.mitutor.mitutorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mitutor.mitutorapp.transformation.CircleTransform;
import com.squareup.picasso.Picasso;

public class MyProfileActivity extends AppCompatActivity {

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    TextView userName;
    ImageView userPicture;
    ImageView background;

    String name = user.getDisplayName();
    String picture = user.getPhotoUrl().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_my_profile);
        setSupportActionBar(myToolbar);

        userName = (TextView) findViewById(R.id.user_name);
        userName.setText(name);
        userPicture = (ImageView) findViewById(R.id.user_picture);
        Picasso.with(this).load(picture).transform(new CircleTransform(50, 0)).into(userPicture);


    }
}
