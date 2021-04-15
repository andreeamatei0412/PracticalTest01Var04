package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ro.pub.cs.systems.eim.practicaltest01var04.Constants.Constants;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    private TextView textView1, textView2 ;
    private Button okButton, cancelButton;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ok_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;

            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        textView1 = (TextView)findViewById(R.id.text_view_1);
        textView2 = (TextView)findViewById(R.id.text_view_2);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("ceva1")) {
            String text1 = intent.getStringExtra("ceva1");
            String text2 = intent.getStringExtra("ceva2");
            textView1.setText(String.valueOf(text1));
            textView2.setText(String.valueOf(text2));
        }


        okButton = (Button)findViewById(R.id.ok_button);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
        // Enables Always-on
    }
}