package com.example.economist_clone.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.economist_clone.MainActivity;
import com.example.economist_clone.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText mEtEmail,mEtPassword;
    private Button mBtnLogin;
    private ProgressDialog progressBarDialog;
    private FirebaseAuth firebaseAuth;
    private TextView mTvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();
        mEtEmail=findViewById(R.id.etEmailLogin);
        mEtPassword=findViewById(R.id.etPasswordLogin);
        mBtnLogin=findViewById(R.id.btnLogin);
        mTvSignUp=findViewById(R.id.tvSignUp);
        progressBarDialog=new ProgressDialog(this);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        mTvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
    }
    private void Login() {
        String email=mEtEmail.getText().toString();
        String password=mEtPassword.getText().toString();
        if(TextUtils.isEmpty(email)){
            mEtEmail.setError("Enter your email");
            return;
        }
        else if(TextUtils.isEmpty(password)){
            mEtPassword.setError("Enter your password");
            return;
        }


        progressBarDialog.setMessage("Please wait...");
        progressBarDialog.show();
        progressBarDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Successfully Login",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,"LogIn fail!",Toast.LENGTH_SHORT).show();

                }
                progressBarDialog.dismiss();
            }
        });

    }

}