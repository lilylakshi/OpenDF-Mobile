package score.gsoc.opendf.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import score.gsoc.opendf.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        EditText password = (EditText) findViewById(R.id.login_password_text);
        password.setTransformationMethod(new PasswordTransformationMethod());

        changeButtonTypeFace();
    }

    public void authenticateUser(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void changeButtonTypeFace() {
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Semibold.ttf");
        loginButton.setTypeface(typeface, 1);
    }
}
