package examplelibrarydesign.com.examplelibrarydesing.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import examplelibrarydesign.com.examplelibrarydesing.R;
import examplelibrarydesign.com.examplelibrarydesing.presenter.LoginPresenter;
import examplelibrarydesign.com.examplelibrarydesing.utils.Constants;
import examplelibrarydesign.com.examplelibrarydesing.view.interface_view.LoginInterface;

public class LoginActivity extends BaseActivity implements Animation.AnimationListener, View.OnClickListener, LoginInterface {

    private ImageView imgvRobot;
    private Toolbar toolbar;
    private Animation animationUp;
    private Animation animationMoveLeft;
    private LinearLayout linearLayoutContainerLogin;
    private LoginPresenter loginPresenter;
    private Button btnLogin;
    private TextInputEditText edtEmail;
    private TextInputEditText edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        castComponents();
        initComponents();

        //borrar
        edtEmail.setText("sa@gmail.com");
        edtPassword.setText("2");

        linearLayoutContainerLogin.startAnimation(animationUp);

    }

    private void castComponents() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_login);
        linearLayoutContainerLogin = (LinearLayout) findViewById(R.id.lly_container_login);
        imgvRobot = (ImageView) findViewById(R.id.imv_robot);
        btnLogin = (Button) findViewById(R.id.btn_login);
        edtEmail = (TextInputEditText) findViewById(R.id.edt_email);
        edtPassword = (TextInputEditText) findViewById(R.id.edt_password);
    }

    private void initComponents() {
        toolbar.setTitle(R.string.title_toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(LoginActivity.this, R.color.white));
        setSupportActionBar(toolbar);

        animationUp = AnimationUtils.loadAnimation(getApplication(), R.anim.slide_down);
        animationUp.setAnimationListener(LoginActivity.this);
        animationMoveLeft = AnimationUtils.loadAnimation(getApplication(), R.anim.move_left);
        animationMoveLeft.setAnimationListener(LoginActivity.this);

        loginPresenter = new LoginPresenter(LoginActivity.this);

        btnLogin.setOnClickListener(LoginActivity.this);

    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animationUp) {
            imgvRobot.setVisibility(View.VISIBLE);
            imgvRobot.startAnimation(animationMoveLeft);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == btnLogin.getId()) {
            loginPresenter.validateStringsOfEditText(edtEmail.getText().toString(),
                    edtPassword.getText().toString(), LoginActivity.this);
        }
    }


    @Override
    public void callNextActivity() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra(Constants.email, edtEmail.getText().toString());
        startActivity(intent);
    }
}
