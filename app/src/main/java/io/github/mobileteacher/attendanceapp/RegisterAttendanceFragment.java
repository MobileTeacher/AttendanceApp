package io.github.mobileteacher.attendanceapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.github.mobileteacher.attendanceapp.models.AttendanceCard;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterAttendanceFragment extends Fragment {

    Button registerButton;
    boolean attending = false;
    TextView checkinTimeText;
    TextView checkoutTimeText;
    AttendanceCard attendanceCard;

    FirebaseDatabase firebaseRef;


    public RegisterAttendanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_register_attendance,
                                    container, false);

        registerButton = root.findViewById(R.id.register_button);
        checkinTimeText = root.findViewById(R.id.checkin_time);
        checkoutTimeText = root.findViewById(R.id.checkout_time);


        firebaseRef = FirebaseDatabase.getInstance();


        attendanceCard = new AttendanceCard();
        attendanceCard.setStatus("Falta");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (attending){
                    // faz check-out
                    registerButton.setText(getString(R.string.checkin_button_text));
                    registerTime(checkoutTimeText);
                    Log.d("SAVE DATA", attendanceCard.getDay());
                    saveAttendanceStatus();
                } else {
                    registerButton.setText(getString(R.string.checkout_button_text));
                    registerTime(checkinTimeText);
                }
                attending = !attending;
            }
        });


        return root;
    }

    public void registerTime(TextView textView){
        Date now = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("HH:mm");
        DateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd");
        if (attending){ //se está presente, fazemos checkout

            attendanceCard.setCheckout(now.getTime());
            attendanceCard.setStatus("Presente");
        } else {
            attendanceCard.setDay(dayFormat.format(now));
            attendanceCard.setCheckin(now.getTime());
        }

        textView.setText(df.format(now));
    }

    public void saveAttendanceStatus(){
        DatabaseReference databaseRef = firebaseRef.getReference()
                            .child("Attendances").child("AL1");

        databaseRef.push().setValue(attendanceCard);
    }

}
