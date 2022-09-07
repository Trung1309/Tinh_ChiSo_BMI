package com.example.tinh_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.FileLock;

public class MainActivity extends AppCompatActivity {

    private Button button,btn_reset;
    private EditText height;
    private EditText weight;
    private TextView resuit,nhanXet;
    float chiso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        button = findViewById(R.id.btn);
        resuit = findViewById(R.id.resuit);
        nhanXet = findViewById(R.id.NhanXet);
        btn_reset = findViewById(R.id.btn_reset);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhanXet.setText("");
                resuit.setText("");
                height.setText("");
                weight.setText("");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(height.getText().length() != 0 && weight.getText().length() != 0){
                    float chieucao = Float.parseFloat(height.getText().toString())/100;
                    float canNang = Float.parseFloat(weight.getText().toString());
                    chiso = Math.round((canNang/Math.pow(chieucao,2)));
                    resuit.setText(String.valueOf(chiso));
                    if(chiso<18.5){
                        nhanXet.setText(("Trạng thái: Nhẹ cân"));
                    }else if(chiso<22.9){
                        nhanXet.setText("Trạng thái: Bình thường");
                    }else {
                        nhanXet.setText("Trạng thái: Béo phì");
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Mời bạn nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}