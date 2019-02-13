package layout.milad.com.workmanagertest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_start;
    private ProgressBar prg_start;
    private TextView txt_start;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }


    private void initViews() {
        btn_start = findViewById(R.id.btn_start);
        prg_start = findViewById(R.id.prg_start);
        txt_start = findViewById(R.id.txt_start);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_start:

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        doHeavyWork();
                    }
                });

                thread.start();

                break;
        }

    }

    private void doHeavyWork() {
        String job = "";
        for (int i = 0; i <= 10000; i++) {
            job = job + i;
            final int finalI = i;


            handler.post(new Runnable() {
                @Override
                public void run() {
                    txt_start.setText(finalI / 100 + "%");
                }
            });


//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    txt_start.setText(finalI / 100 + "%");
//                }
//            });
//            Log.i("==>", "doHeavyWork: " + i /100 + "%");
        }
    }
}
