package project.enf.com.mypockettraveller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Database.DatabaseOpenHelper;
import Models.Travel;
import Utilities.UtilityFunctions;

public class InputNewTravel extends AppCompatActivity {

    private EditText location, title, description, duration , tags;
    private RatingBar rating;
    private Button submit;
    private DatabaseOpenHelper dba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_new_travel);

        initialize();
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addToDatabase();
                Toast.makeText(InputNewTravel.this, "Added to database successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(InputNewTravel.this, MainActivity.class);
                startActivity(i);
                InputNewTravel.this.finish();
            }
        });

    }

    public void initialize(){
        location = (EditText) findViewById(R.id.inputLocationInput);
        title = (EditText) findViewById(R.id.locationTitleInput);
        description = (EditText) findViewById(R.id.inputDescriptionDescription);
        duration = (EditText) findViewById(R.id.inputDurationDuration);
        tags = (EditText) findViewById(R.id.inputTagInput);
        rating = (RatingBar) findViewById(R.id.inputRatingRating);
        submit = (Button) findViewById(R.id.inputSubmitButton);
    }

    public void addToDatabase(){
        dba = new DatabaseOpenHelper(getApplicationContext());
        dba.addTravel(createTravel());
    }

    public Travel createTravel(){
        UtilityFunctions utility = new UtilityFunctions();
        Travel travel = new Travel();

        travel.setTitle(title.getText().toString());
        int ratingInt = (int) rating.getRating();
        travel.setRating(ratingInt);
        travel.setDuration(utility.properRatingGet(duration.getText().toString()));
        travel.setLocation(location.getText().toString());
        travel.setDescription(description.getText().toString());

        //creating current date well formatted string
        DateFormat formatDate = new SimpleDateFormat("dd/MM/yyy");
        Date today = new Date();
        String dateAdded = formatDate.format(today).toString();
        travel.setDateAdded(dateAdded);

        //get tags
        travel.setTags(utility.tagSplitter(tags.getText().toString()));

        return travel;
    }
}
