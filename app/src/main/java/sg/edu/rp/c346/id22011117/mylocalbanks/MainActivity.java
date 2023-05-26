package sg.edu.rp.c346.id22011117.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String DBSNumber = "18001111111";
    private static final String OCBCNumber = "18003633333";
    private static final String UOBNumber = "18002222121";

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");


            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "DBS is chosen", Toast.LENGTH_SHORT).show();
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "OCBC is chosen", Toast.LENGTH_SHORT).show();
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "UOB is chosen", Toast.LENGTH_SHORT).show();
                return true;
            }

            return super.onContextItemSelected(item);
        }


        tvDBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { dialPhoneNumber(DBSNumber); }
        });

        tvOCBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { dialPhoneNumber(OCBCNumber); }
        });

        tvUOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { dialPhoneNumber(UOBNumber); }
        });
        return true;
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(dialIntent);
    }
}

