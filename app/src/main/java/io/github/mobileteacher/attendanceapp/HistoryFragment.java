package io.github.mobileteacher.attendanceapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import io.github.mobileteacher.attendanceapp.models.AttendanceCard;
import io.github.mobileteacher.attendanceapp.models.Subject;


public class HistoryFragment extends Fragment {

    private RecyclerView historyList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_subjectslist, container, false);
        historyList =  root.findViewById(R.id.recyclerview);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = firebaseDatabase.getReference()
                                        .child("Attendances").child("AL1");

        List<AttendanceCard> attendances = new ArrayList<>();
        final HistoryAdapter adapter = new HistoryAdapter(attendances);
        historyList.setAdapter(adapter);

        databaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                AttendanceCard attendanceCard = dataSnapshot.getValue(AttendanceCard.class);
                adapter.addItem(attendanceCard);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        historyList.setLayoutManager(lm);


        return root;
    }
}
