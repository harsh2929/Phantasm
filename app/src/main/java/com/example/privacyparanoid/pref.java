package com.example.vesalius;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class pref {
    static Context emptycontext;
    static SharedPreferences wipeKeyStorage;


 public pref(Context context){
     emptycontext=context;
     wipeKeyStorage = emptycontext.getSharedPreferences("WipeKeyStorage",MODE_PRIVATE);

 }
    public pref(){
        wipeKeyStorage = emptycontext.getSharedPreferences("WipeKeyStorage",MODE_PRIVATE);

    }

public void setKey(Long l){
    SharedPreferences.Editor wipeKeyEditor = wipeKeyStorage.edit();
     wipeKeyEditor.putLong("dangerous_wipe_key",l);
     wipeKeyEditor.commit();
 }
public long getKey(){
    long dangerous_wipe_key=wipeKeyStorage.getLong("dangerous_wipe_key",0);
    return dangerous_wipe_key;

}
}
