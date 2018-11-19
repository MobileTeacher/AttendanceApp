package io.github.mobileteacher.attendanceapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.github.mobileteacher.attendanceapp.models.AttendanceCard;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    List<AttendanceCard> attendances;

    public HistoryAdapter(List<AttendanceCard> items){
        attendances = items;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.history_card, parent, false);
        HistoryViewHolder viewHolder = new HistoryViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        AttendanceCard item = attendances.get(position);

        holder.dayTextView.setText(item.getDay());
        holder.statusTextView.setText(item.getStatus());


        DateFormat df = new SimpleDateFormat("HH:mm");

        holder.checkinTextView.setText(df.format(new Date(item.getCheckin())));
        holder.checkoutTextView.setText(df.format(new Date(item.getCheckout())));

    }

    @Override
    public int getItemCount() {
        return attendances.size();
    }

    public void addItem(AttendanceCard attendanceCard){
        attendances.add(attendanceCard);
        notifyItemInserted(attendances.size()-1);
    }


    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        public TextView dayTextView;
        public TextView statusTextView;
        public TextView checkinTextView;
        public TextView checkoutTextView;

        public HistoryViewHolder(View itemView) {
            super(itemView);

            dayTextView = itemView.findViewById(R.id.day_text);
            statusTextView = itemView.findViewById(R.id.status_text);
            checkinTextView = itemView.findViewById(R.id.checkin_time);
            checkoutTextView = itemView.findViewById(R.id.checkout_time);

        }
    }
}
