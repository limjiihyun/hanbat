package kr.co.company.hanbat;//패키지 지정

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
//필요한 클래스를 포함시키는 import문장들

//MainActivity 애플리케이션의 첫 실행 화면, 다음 액티비티로 가는 버튼
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {//처음 생성 될 때 실행
        super.onCreate(savedInstanceState);//부모클래스 지정
        setContentView(R.layout.activity_main);//액티비티 화면 지정-> activity_main.xml

    }
    public void start(View v){
        Button b=(Button)findViewById(R.id.button2);//button2가 클릭 되었을 때
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this, Activity1.class);
                startActivity(intent);//명시적 인텐트 사용하여 Activity1을 시작
                Toast.makeText(MainActivity.this, "시작하기",Toast.LENGTH_LONG).show();
            }//방송 수신자 기능 사용
        });
    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("밭맛소란 한밭대학교 상생문화 기획단인 밭슐랭 가이드 에서 인정을 받은 맛집을 소개하는 앱입니다.");
        //밭맛소를 소개하는 알림 기능사용
        alertDialogBuilder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "닫기",Toast.LENGTH_LONG).show();
            }//닫기 버튼을 누르면 방송 수신자로 "닫기"가 화면 하단에 출력됨.
        });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }
    public void blog(View v){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        switch(v.getId()){
            case R.id.button4:
                intent.setData(Uri.parse("https://m.blog.naver.com/PostList.naver?blogId=hrcc21"));
                startActivity(intent);//암시적 인텐트를 사용하여 블로그 연동
                break;
        }
    }
}