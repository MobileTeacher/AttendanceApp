package io.github.mobileteacher.attendanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    boolean attending = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dateText = findViewById(R.id.date_label);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        dateText.setText(df.format(Calendar.getInstance().getTime()));

    }

    public void registerAttendance(View view) {
        Button button = (Button) view; // conversão explícita - "casting"

        if (attending){
            button.setText(getString(R.string.checkin_button_text));
            checkout();
        } else {
            button.setText(getString(R.string.checkout_button_text));
            checkin();
        }
        attending = !attending;
    }

    public void checkin(){
        TextView checkinTimeText = findViewById(R.id.checkin_time);

        Date now = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("HH:mm");
        checkinTimeText.setText(df.format(now));

        Toast.makeText(this, "CHECK IN", Toast.LENGTH_LONG).show();
    }

    public void checkout(){
        TextView checkoutTimeText = findViewById(R.id.checkout_time);

        Date now = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("HH:mm");
        checkoutTimeText.setText(df.format(now));
        Toast.makeText(this, "CHECK OUT", Toast.LENGTH_LONG).show();
    }
}
