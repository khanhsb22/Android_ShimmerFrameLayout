package com.example.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private ArrayList<CourseModel> arrayList;
    private Context context;

    public CourseAdapter(ArrayList<CourseModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModel model = arrayList.get(position);
        holder.textView_courseName.setText(model.getCourseName());
        holder.textView_tracks.setText(model.getCourseTracks());
        holder.textView_mode.setText(model.getCourseMode());
        Picasso.get().load(model.getCourseImg()).into(holder.imageView_course);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_courseName, textView_mode, textView_tracks;
        private ImageView imageView_course;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_courseName = itemView.findViewById(R.id.textView_courseName);
            textView_mode = itemView.findViewById(R.id.textView_mode);
            textView_tracks = itemView.findViewById(R.id.textView_tracks);
            imageView_course = itemView.findViewById(R.id.imageView_course);
        }
    }
}