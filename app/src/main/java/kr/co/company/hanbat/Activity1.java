package kr.co.company.hanbat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    public RadioGroup RadioGroup;
    public RadioButton radioButton2, radioButton;
    public Button button3;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        RadioGroup=findViewById(R.id.radioGroup);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton=findViewById(R.id.radioButton);
        button3=findViewById(R.id.button3);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (RadioGroup.getCheckedRadioButtonId()){
                    case R.id.radioButton2:
                        Intent intent=new Intent(Activity1.this, Activity2.class);
                        startActivity(intent);
                        //맛집을 체크하고 보기 버튼을 눌렀을 때 Activity2로 전환하는 명시적 인텐트 사용
                        break;
                    case R.id.radioButton:
                        Intent intent2=new Intent(Activity1.this, Activity3.class);
                        startActivity(intent2);
                        //카페를 체크하고 보기 버튼을 눌렀을 때 Activity3로 전환하는 명시적 인텐트 사용
                        break;
                }
            }
        };
        button3.setOnClickListener(listener);
    }
}



