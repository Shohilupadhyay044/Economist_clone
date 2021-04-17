package com.example.economist_clone.saveddatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun  addDetails(myEntity: MyEntity)

    @Query("SELECT * FROM details order by id DESC")
    fun getAllDetails(): LiveData<List<MyEntity>>

    @Query("DELETE FROM details WHERE id= :delId")
    fun deleteDetails(delId:Int)
}
