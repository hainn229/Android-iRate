package com.example.i_rate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ed_name,  ed_date, ed_time, ed_owner, ed_address;
    private Button btn_submit;
    private AwesomeValidation awesomeValidation;

    Spinner Spinner_type, Spinner_cost, Spinner_clean, Spinner_service, Spinner_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_date = (EditText) findViewById(R.id.ed_date);
        ed_time = (EditText) findViewById(R.id.ed_time);
        ed_owner = (EditText) findViewById(R.id.ed_owner);
        ed_address = (EditText) findViewById(R.id.ed_address);


        btn_submit = (Button) findViewById(R.id.btn_submit);

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.ed_name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.ed_date, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);
        awesomeValidation.addValidation(this, R.id.ed_time, "^(0?[1-9]|1[0-2]):[0-5][0-9]$", R.string.timeerror);
        awesomeValidation.addValidation(this, R.id.ed_owner, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.ownererror);
        awesomeValidation.addValidation(this, R.id.ed_address, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.addresserror);

        Spinner_type = findViewById(R.id.sp_type);
        Spinner_cost = findViewById(R.id.sp_cost);
        Spinner_service = findViewById(R.id.sp_rate_service);
        Spinner_food = findViewById(R.id.sp_rate_food);
        Spinner_clean = findViewById(R.id.sp_rate_clean);
        runSp_type();
        runSp_cost();
        runSp_rate_service();
        runSp_rate_food();
        runSp_rate_clean();

        btn_submit.setOnClickListener(this);
    }

    private void runSp_cost() {
        ArrayAdapter<String> cost = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_cost));
        Spinner_cost.setAdapter(cost);
    }

    private void runSp_type() {
        ArrayAdapter<String> type = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_type));
        Spinner_type.setAdapter(type);
    }

    private void runSp_rate_service() {
        ArrayAdapter<String> service = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_service));
        Spinner_service.setAdapter(service);
    }

    private void runSp_rate_food() {
        ArrayAdapter<String> food = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_food));
        Spinner_food.setAdapter(food);
    }

    private void runSp_rate_clean() {
        ArrayAdapter<String> clean = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_clean));
        Spinner_clean.setAdapter(clean);
    }

    private void noftForm() {
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Successfull!", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View view) {
        if (view == btn_submit) {
            noftForm();
        }
    }
}