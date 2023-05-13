package com.aanaan3.lma;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aanaan3.lma.databinding.CourseListItemBinding;
import com.aanaan3.lma.model.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

   private OnItemClickListener listener;
   private ArrayList<Course> courses = new ArrayList<>();

   @NonNull
   @Override
   public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      CourseListItemBinding courseListItemBinding = DataBindingUtil.inflate(
              LayoutInflater.from(parent.getContext()),
              R.layout.course_list_item,
              parent,
              false);
      return new CourseViewHolder(courseListItemBinding);
   }

   @Override
   public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
      Course course = courses.get(position);
      holder.mCourseListItemBinding.setCourse(course);
   }

   @Override
   public int getItemCount() {
      return null != courses? courses.size() : 0;
   }


   class CourseViewHolder extends RecyclerView.ViewHolder{

      private CourseListItemBinding mCourseListItemBinding;

      public CourseViewHolder(@NonNull CourseListItemBinding mCourseListItemBinding) {
         super(mCourseListItemBinding.getRoot());
         this.mCourseListItemBinding =mCourseListItemBinding;

         mCourseListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int clickedPosition = getAdapterPosition();

               if (listener!= null && clickedPosition != RecyclerView.NO_POSITION){
                  listener.onItemClick(courses.get(clickedPosition));
               }

            }
         });


      }


   }

   public interface OnItemClickListener{
      void onItemClick(Course course);
   }

   public void setListener(OnItemClickListener listener){
      this.listener = listener;
   }

   public void setCourses(ArrayList<Course> newCourses) {
      //this.courses = courses;
      //notifyDataSetChanged();

      final DiffUtil.DiffResult result = DiffUtil.calculateDiff
              (new CourseDiffCallback(courses,newCourses),false);

      courses = newCourses;
      result.dispatchUpdatesTo(CourseAdapter.this);
   }
}




