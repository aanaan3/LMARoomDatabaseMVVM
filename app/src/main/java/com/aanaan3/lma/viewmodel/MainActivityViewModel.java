package com.aanaan3.lma.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aanaan3.lma.model.Category;
import com.aanaan3.lma.model.Course;
import com.aanaan3.lma.model.CourseShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

   // Repository
   private CourseShopRepository repository;


   // Live Data
   private LiveData<List<Category>> allCategories;
   private LiveData<List<Course>> coursesOfSelectedCategory;


   public MainActivityViewModel(@NonNull Application application) {
      super(application);

      repository = new CourseShopRepository(application);
   }

   public LiveData<List<Category>> getAllCategories(){
      allCategories = repository.getCategories();
      return allCategories;
   }

   public LiveData<List<Course>> getCoursesOfSelectedCategory(int categoryId){
      coursesOfSelectedCategory = repository.getCourses(categoryId);
      return coursesOfSelectedCategory;
   }

   public void addNewCourse(Course course){
      repository.insertCourse(course);
   }

   public void updateCourses(Course course){
      repository.updateCourse(course);
   }

   public void deleteCourse(Course course){
      repository.deleteCourse(course);
   }
}
