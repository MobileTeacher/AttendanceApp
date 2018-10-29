package io.github.mobileteacher.attendanceapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterAttendanceFragment extends Fragment {

    Button registerButton;
    boolean attending = false;
    TextView checkinTimeText;
    TextView checkoutTimeText;

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

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (attending){
                    registerButton.setText(getString(R.string.checkin_button_text));
                    registerTime(checkoutTimeText);
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
        textView.setText(df.format(now));
    }

}
