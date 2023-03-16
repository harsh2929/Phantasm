package com.example.vesalius;
//Privacy Protection by github.com/vikrantrana1996
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class mainact extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context mycontext = getApplicationContext();

        pref initialobj=new pref(mycontext);

       // Intent background_sms_listener_service = new Intent(mycontext, sms.class);
        //mycontext.startService(background_sms_listener_service);



        //For video
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openvideo();
            }
        });

        //For Data Wiping Activity
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                opendeletenow();
            }
        });
        //For activityloc
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openactivityloc();
            }
        });
        //For wiperact
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openwiperact();
            }
        });

        //For removing device admin
       Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                removeAdmin(mycontext);
            }
        });


    }

    public void openvideo(){
        Intent intent = new Intent(this, video.class);
        this.startActivity(intent);
    }
    public void opendeletenow(){
        Intent intent = new Intent(this, deletenow.class);
        this.startActivity(intent);
    }
    public void openactivityloc(){
        Intent intent = new Intent(this, activityloc.class);
        this.startActivity(intent);
    }
    public void openwiperact(){
        Intent intent = new Intent(this, wiperact.class);
        this.startActivity(intent);
    }

    public static Boolean checkAdmin(DevicePolicyManager device_policy_manager,ComponentName device_admin_receiver){
        if (device_policy_manager.isAdminActive(device_admin_receiver)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public void manageAdmin(Context context, ComponentName device_admin_receiver){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.android.settings","com.android.settings.DeviceAdminSettings"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    public void removeAdmin(Context context){

        DevicePolicyManager device_policy_manager = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName device_admin_receiver = new ComponentName(context, admin.class);
        Toast.makeText(context, "Going to remove admin!!!", Toast.LENGTH_SHORT).show();
        manageAdmin(context,device_admin_receiver);

    }
}