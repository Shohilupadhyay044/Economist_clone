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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.economist_clone.MainActivity;
import com.example.economist_clone.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private EditText mEtEmail,mEtPassword,mEtConfirmPassword;
    private Button mBtnSignUp;
    private ProgressDialog progressBarDialog;
    private FirebaseAuth firebaseAuth;
    private TextView mTvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth=FirebaseAuth.getInstance();
        mEtEmail=findViewById(R.id.etEmail);
        mEtPassword=findViewById(R.id.etPassword);
        mEtConfirmPassword=findViewById(R.id.etConfirmPassword);
        mBtnSignUp=findViewById(R.id.btnSignUp);
        mTvLogin=findViewById(R.id.tvLogin);
        progressBarDialog=new ProgressDialog(this);
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }

    private void Register() {
        String email=mEtEmail.getText().toString();
        String password=mEtPassword.getText().toString();
        String confirmPassword=mEtConfirmPassword.getText().toString();
        if(TextUtils.isEmpty(email)){
            mEtEmail.setError("Enter your email");
            return;
        }
         else if(TextUtils.isEmpty(password)){
            mEtPassword.setError("Enter your password");
            return;
        }
        else if(TextUtils.isEmpty(confirmPassword)){
            mEtConfirmPassword.setError("Confirm your password");
            return;
        }
        else if(!password.equals(confirmPassword)){
            mEtConfirmPassword.setError("Different Password");
            return;
        }
        else if(password.length()<4){
            mEtPassword.setError("Length should be > 4");
            return;
        }
        else if(!isValidEmail(email)){
            mEtEmail.setError("Invalid Email");
            return;
        }
        progressBarDialog.setMessage("Please wait...");
        progressBarDialog.show();
        progressBarDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this,"Successfully registered",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(SignUpActivity.this,"Sign up fail!",Toast.LENGTH_SHORT).show();

                }
                progressBarDialog.dismiss();
            }
        });

    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target)&& Patterns.EMAIL_ADDRESS.matcher(target).matches());

    }
}