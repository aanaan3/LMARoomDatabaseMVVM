package com.aanaan3.lma.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDAO {

  @Insert
  void insert(Category category);

  @Update
  void update(Category category);

  @Delete
  void delete(Category category);

  @Query("SELECT * FROM CATEGORIES_TABLE")
  LiveData<List<Category>> getAllCategory();

}