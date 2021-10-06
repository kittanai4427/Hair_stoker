package com.example.hair1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class HomeUser extends AppCompatActivity {


    private TextView addpay1;

     ListView listview;
     String mTitle [] = {"ร้านตัดผม1", "ร้านตัดผม2"};
     String mDescription [] = {"ตัดผมชาย(เด็ก)", "ตัดผมชาย(ผู้ใหญ่)"};
    String mDescription1 [] = {"20 ก.ย 2564 16:14", "21 ก.ย 2564 14:15"};
    private int images[] = {R.drawable._514272490, R.drawable._514272490};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);




        //ส่วนแสดงข้อมูลบริการล่าสุด
        listview = findViewById(R.id.listview) ;
        // ปุ่มคลิกเพื่อไปหน้า addpay
        addpay1 = (TextView) findViewById(R.id.addpay1);



        addpay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openaddhpay();
            }
        });



        MyAdapter adapter = new MyAdapter(this,mTitle,mDescription,mDescription1, images);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent(getApplicationContext(), ServiceUser.class);
                    //this intent put out 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image",images[0]);
                    intent.putExtras(bundle);

                    intent.putExtra("title",mTitle[0]);
                    intent.putExtra("description", mDescription [0]);
                    intent.putExtra("day", mDescription1[0]);
                    intent.putExtra("i",+0);
                    startActivity(intent);


                }
                if (i == 1){
                    Intent intent = new Intent(getApplicationContext(), ServiceUser.class);
                    //this intent put out 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image",images[1]);
                    intent.putExtras(bundle);

                    intent.putExtra("title",mTitle[1]);
                    intent.putExtra("description", mDescription [1]);
                    intent.putExtra("day", mDescription1[1]);

                    intent.putExtra("i",+1);
                    startActivity(intent);
                }


            }
        });



    }



    public void openaddhpay(){
        Intent pay = new Intent(HomeUser.this, Addhpay.class);
        startActivity(pay);

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        String rDescription1[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[],String description1[], int imgs[] ){
            super(c, R.layout.row, R.id.textViewT1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rDescription1 = description1;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



            LayoutInflater layoutInflater=(LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textViewT1);
            TextView myDescription = row.findViewById(R.id.textViewT2);
            TextView myDescription1 = row.findViewById(R.id.textViewT3);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            myDescription.setText(rDescription[position]);
            myDescription1.setText(rDescription1[position]);

          return row;


        }

        }



    }








