package com.google.a2developers.skillshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dd.processbutton.iml.ActionProcessButton;
import com.dd.processbutton.iml.SubmitProcessButton;

public class set_UserProfile extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {
    public static final String EXTRAS_ENDLESS_MODE = "EXTRAS_ENDLESS_MODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set__user_profile);

        final EditText username = (EditText) findViewById(R.id.username);
       // final EditText user_skills = (EditText) findViewById(R.id.user_skills);

        final ProgressGenerator progressGenerator = new ProgressGenerator( this);
        final ActionProcessButton btnSubmit = (ActionProcessButton) findViewById(R.id.btnSubmit);
        Bundle extras = getIntent().getExtras();
        if(extras != null && extras.getBoolean(EXTRAS_ENDLESS_MODE)) {
            btnSubmit.setMode(ActionProcessButton.Mode.ENDLESS);
        } else {
            btnSubmit.setMode(ActionProcessButton.Mode.PROGRESS);
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnSubmit);
                btnSubmit.setEnabled(false);
                username.setEnabled(false);
             //   user_skills.setEnabled(false);
            }
        });

    }

    @Override
    public void onComplete() {

    }
}
