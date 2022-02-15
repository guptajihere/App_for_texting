package com.example.app_for_chatting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    EditText message;
   // EditText code;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone=findViewById(R.id.PhoneEt);
        message=findViewById(R.id.MessageEt);
        //code=findViewById((R.id.code));
        send=findViewById(R.id.button);

        this.setTitle("Home screen");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number=phone.getText().toString();  // This gets the number that we type in editText,converts it into a string and uses it in the next step
                String msg=message.getText().toString();
              //  String cd=code.getText().toString();

                String numberURL="https://api.whatsapp.com/send?phone=+"+ number +"&text=" +msg;  // "&text" is another url
                // this url will be common but the number after the country code won't be so we accept it in editText and convert into String

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(numberURL)); // intent is used to change application or an activity on press of a button
                // ACTION_VIEW intent is used as we want to send a Uri from one application to another
                startActivity(intent);


            }
        });

    }
}