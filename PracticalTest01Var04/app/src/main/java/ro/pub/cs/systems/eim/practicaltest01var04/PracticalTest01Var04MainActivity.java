package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import ro.pub.cs.systems.eim.practicaltest01var04.Constants.Constants;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private EditText first;
    private EditText second;
    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private Button pressMeButton;
    private Button navigateButton;
    private TextView textView;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            String f = String.valueOf(first.getText().toString());
            String s = String.valueOf(second.getText().toString());
            switch(view.getId()) {
                case R.id.display_button:
                    textView.setText(f+s);
                    if (checkbox1.isChecked() && f.length() ==0 ) {
                        Toast.makeText(getApplicationContext(), "Trebuie completat primul" , Toast.LENGTH_LONG).show();
                    }
                    if (checkbox2.isChecked() && s.length() ==0){
                        Toast.makeText(getApplicationContext(), "Trebuie completat al doilea" , Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.navigate:
                    break;
            }


        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.LEFT_COUNT, first.getText().toString());
        savedInstanceState.putString(Constants.RIGHT_COUNT, second.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.LEFT_COUNT)) {
            first.setText(savedInstanceState.getString(Constants.LEFT_COUNT));
        }
        if (savedInstanceState.containsKey(Constants.RIGHT_COUNT)) {
            second.setText(savedInstanceState.getString(Constants.RIGHT_COUNT));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        first = (EditText)findViewById(R.id.first_edit_text);
        second = (EditText)findViewById(R.id.second_edit_text);
        pressMeButton = (Button)findViewById(R.id.display_button);
        navigateButton = (Button)findViewById(R.id.navigate);
        checkbox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkbox2 = (CheckBox)findViewById(R.id.checkBox2);
        textView = (TextView)findViewById(R.id.textView);

        pressMeButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.LEFT_COUNT)) {
                first.setText(savedInstanceState.getString(Constants.LEFT_COUNT));
            }
            if (savedInstanceState.containsKey(Constants.RIGHT_COUNT)) {
                second.setText(savedInstanceState.getString(Constants.RIGHT_COUNT));
            }
        }

    }
}