package Database;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Models.Travel;

/**
 * Created by shafi on 7/21/2017.
 */

public class FirebaseHandler {

    private DatabaseReference mdb = FirebaseDatabase.getInstance().getReference();

    public FirebaseHandler(){

    }

    public void addOnline (Travel travel, String userName){
        try{
            mdb.child("users").child(userName).setValue(travel);
        }catch (Exception E){
            Log.v ("exception. ", "Firebase handler");
        }
    }

}
