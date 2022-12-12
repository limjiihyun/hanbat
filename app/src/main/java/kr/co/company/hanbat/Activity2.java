package kr.co.company.hanbat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
//필요한 클래스를 포함시키는 import 문장들
public class Activity2 extends AppCompatActivity{
    ListView list;//리스트 뷰 생성

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        CustomList adapter=new CustomList(Activity2.this);
        list=(ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        Float[] values= {Float.valueOf("01012345678"), Float.valueOf("0428221179"), Float.valueOf("0428220039"),
                Float.valueOf("0428259983"), Float.valueOf("0428258753"), Float.valueOf("0427197748"), Float.valueOf("0428250809")};
        ArrayAdapter<Float>list=new ArrayAdapter<Float>(
                this, R.layout.menulistitem, values);

    }
}
class CustomList<MyData> extends ArrayAdapter<String> {

    private ArrayList<MyData>data=new ArrayList<MyData>();

    private static final String[] titles = {
            "힐링외갓집",
            "헬로 베트남 쌀국수",
            "모모멘",
            "쇼랜드치킨",
            "국민 돼지 국밥",
            "은소소",
            "캠토 토스트"
    };//맛집 이름
    private static final String[] ratings = {
            "뼈다귀탕, 닭도리탕 맛집!",
            "쌀쌀한 날에는 쌀국수!",
            "뜨끈한 라멘이 먹고싶을 때",
            "당신은 지금 치킨이 먹고싶다!",
            "한밭대 국밥 원탑",
            "은근히 소소한 행복",
            "한밭대 토스트&컵밥"
    };//맛집 설명명
    private final Activity context;

    public CustomList(Activity context) {//생성자
        super(context, R.layout.menulistitem, titles);//부모클래스 생성자 호출
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {//어댑터 역할
        //layout용 xml을 View객체로 생성
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.menulistitem, null, true);
        //menulistitem.xml에서 만든 리소스를 가져온다
        ImageView imageVIew = (ImageView) rowView.findViewById(R.id.image);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView rating = (TextView) rowView.findViewById(R.id.rating);
        Button button2 = (Button) rowView.findViewById(R.id.call);
        title.setText(titles[position]);//음식점 이름 데이터를 넣어준다
        Integer[] images = {
                R.drawable.hilingoutside,
                R.drawable.vetnamoutside,
                R.drawable.momomenoutside,
                R.drawable.showoutside,
                R.drawable.pigoutside,
                R.drawable.noodleoutside,
                R.drawable.camtooutside
        };

        imageVIew.setImageResource(images[position]);
        rating.setText(ratings[position]);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String[] values= {"010-1234-5678", "042-822-1179", "042-822-0039",
                        "042-825-9983", "042-825-8753", "042-719-7748", "042-825-0809"};
                String service="tel:"+values;
                Uri uri=Uri.parse(service);
                Intent dialIntent=new Intent(Intent.ACTION_DIAL, uri);
                context.startActivity(dialIntent);
            }//전화걸기 버튼을 눌렀을 때 전화걸기 인텐트로 넘어감
        });

        return rowView;//뷰 객체 반환
    }

}


