package io.github.mobileteacher.attendanceapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.mobileteacher.attendanceapp.models.Subject;

public class SubjectAdapter extends RecyclerView.Adapter {

    List<Subject> subjects;


    public SubjectAdapter(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public SubjectAdapter(Subject[] subjects){
        this.subjects = new ArrayList<>();
        for (Subject sub: subjects){
            this.subjects.add(sub);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =   LayoutInflater.from(parent.getContext()).
                inflate(R.layout.subject_card, parent, false);

        return new SubjectViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Subject subject = subjects.get(position);

        SubjectViewHolder subjectViewHolder = (SubjectViewHolder) holder;
        subjectViewHolder.subjectNameTextView.setText(subject.getName());
        subjectViewHolder.professorNameTextView.setText(subject.getProfessor());
        subjectViewHolder.daysTextView.setText(subject.getDay());
        subjectViewHolder.attendanceRateTextView.setText(String.format("%.1f%%", subject.getAttendanceRate()));

    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }


    public static class SubjectViewHolder extends RecyclerView.ViewHolder {

        public TextView subjectNameTextView;
        public TextView professorNameTextView;
        public TextView daysTextView;
        public TextView attendanceRateTextView;
        public SubjectViewHolder(View itemView) {
            super(itemView);

            subjectNameTextView = itemView.findViewById(R.id.subject_name);
            professorNameTextView = itemView.findViewById(R.id.professor_name);
            daysTextView = itemView.findViewById(R.id.subject_days);
            attendanceRateTextView = itemView.findViewById(R.id.attendance_rate);

        }
    }

}
