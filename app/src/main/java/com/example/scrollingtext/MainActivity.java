package com.example.scrollingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText dp1;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp1 = (EditText) findViewById(R.id.dp);
        calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateCalendar();
            }
            private  void updateCalendar(){
                String format = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);

                dp1.setText(sdf.format(calendar.getTime()));
            }
        };
        dp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                new DatePickerDialog(MainActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
        }

        });


    }


    public void onRadioButtonClicked(View view) {
    }

    public void onCheckboxClicked(View view) {
    }

    public void OK(View view) {

                EditText  name = (EditText) findViewById(R.id.name);
                EditText sid = (EditText) findViewById(R.id.student_id);
                EditText idc = (EditText) findViewById(R.id.id_card);
                EditText phone = (EditText) findViewById(R.id.phone_number);
                EditText email = (EditText) findViewById(R.id.email);

                if(name.getText().toString().equals("") )
                {
                    name.setError("T??n kh??ng ???????c b??? tr???ng");
                }
                else if(sid.getText().toString().equals("")){
                    sid.setError("MSSV kh??ng ???????c b??? tr???ng");
                }
                else if(idc.getText().toString().equals("")){
                    idc.setError("CCCD kh??ng ???????c b??? tr???ng");
                }
                else if(phone.getText().toString().equals("")){
                    phone.setError("S??T kh??ng ???????c b??? tr???ng");
                }
                else  if(email.getText().toString().equals("")){
                    email.setError("Email kh??ng ???????c b??? tr???ng");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Th??nh c??ng", Toast.LENGTH_SHORT).show();
                }
            }
}