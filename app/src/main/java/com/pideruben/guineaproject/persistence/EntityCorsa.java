package com.pideruben.guineaproject.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "corse")
public class EntityCorsa {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int nCorsa;
    public boolean isOnRoad;
    public String data;

    public EntityCorsa(int nCorsa, boolean isOnRoad, String data){
        this.nCorsa = nCorsa;
        this.isOnRoad = isOnRoad;
        this.data = data;
    }

}
