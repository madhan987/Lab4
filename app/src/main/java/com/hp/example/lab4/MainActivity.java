package com.hp.example.lab4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    Button btn,btn2;
    private final int reqcode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.imageView);
        btn=(Button) findViewById(R.id.take);
        btn2=(Button) findViewById(R.id.view);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,1001);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // Toast.makeText(this,)
                //Toast.makeText(this,"Sorrywork",Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(), "sorrry.", Toast.LENGTH_SHORT).show();
               // Toast.makeText(this, "I, Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void onActivityResult(int requestcode,int resultcode,Intent data)
    {
        if(requestcode==1001)
        {
            Bitmap map=(Bitmap)data.getExtras().get("data");
            img.setImageBitmap(map);
        }
        super.onActivityResult(requestcode,resultcode,data );


    }
}
