package comwidgettst.example.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter myIntentFilter;
    private AnotherBroadcastReceiver anotherBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myIntentFilter = new IntentFilter();
        myIntentFilter.setPriority(90);
        myIntentFilter.addAction("comwidgettst.example.broadcasttest.MY_BROADCAST");
        anotherBroadcastReceiver = new AnotherBroadcastReceiver();
        registerReceiver(anotherBroadcastReceiver,myIntentFilter);
    }

    class AnotherBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"在另一处接收到广播",Toast.LENGTH_SHORT).show();
        }
    }
}
