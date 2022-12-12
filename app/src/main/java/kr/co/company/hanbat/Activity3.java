package kr.co.company.hanbat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//필요한 클래스를 포함시키는 import 문장들
public class Activity3 extends AppCompatActivity {
    ListView list;//리스트 뷰 생성
    String[] titles={
            "INDEED",
            "DAILY",
            "SIHORU",
            "YAMS"
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        CustomList2 adapter=new CustomList2(Activity3.this);
        list=(ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id){
                Toast.makeText(getBaseContext(), titles[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
class CustomList2 extends ArrayAdapter<String>{

    private static final String[] titles = {
            "INDEED",
            "DAILY",
            "SIHORU",
            "YAMS"
    };
    private static final String[] ratings={
            "아메리카노가 가장 저렴한 곳!",
            "공부하기 좋은 카페!",
            "케이크가 맛있는 곳",
            "한가로운 시간 보내기 좋은 곳"
    };
    private final Activity context;
    public CustomList2(Activity context){//생성자
        super(context, R.layout.menulistitem, titles);//부모 클래 생성자 호출
        this.context=context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){//어댑터 역할
        LayoutInflater inflater=context.getLayoutInflater();
        //layout용 xml을 View 객체로 생성
        View rowView=inflater.inflate(R.layout.menulistitem, null, true);
        //menulistitem.xml에서 만든 리소스를 가져온다.
        ImageView imageVIew=(ImageView) rowView.findViewById(R.id.image);
        TextView title=(TextView) rowView.findViewById(R.id.title);
        TextView rating=(TextView) rowView.findViewById(R.id.rating);
        Button button2 = (Button) rowView.findViewById(R.id.call);
        title.setText(titles[position]);//음식점 이름 데이터를 넣어준다
        Integer[] images={
                R.drawable.indeepoutside,
                R.drawable.dailyoutside,
                R.drawable.sihoruoutside,
                R.drawable.yamsoutside
        };

        imageVIew.setImageResource(images[position]);
        rating.setText(ratings[position]);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String[] values= {"010-1234-5678", "042-822-1179", "042-822-0039",
                        "042-825-9983"};
                String service="tel:"+values;
                Uri uri=Uri.parse(service);
                Intent dialIntent=new Intent(Intent.ACTION_DIAL, uri);
                context.startActivity(dialIntent);
            }//전화 걸기 버튼을 눌렀을 때 전화 걸기 인텐트로 넘어감
        });
        return rowView;//뷰 객체 반환
    }
}