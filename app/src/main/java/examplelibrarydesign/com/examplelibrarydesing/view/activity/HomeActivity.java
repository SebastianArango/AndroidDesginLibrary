package examplelibrarydesign.com.examplelibrarydesing.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import examplelibrarydesign.com.examplelibrarydesing.R;
import examplelibrarydesign.com.examplelibrarydesing.view.fragment.Fragment1;
import examplelibrarydesign.com.examplelibrarydesing.view.fragment.FragmentTabs;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        castComponents();
        initComponents();

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new Fragment1()).commit();

    }

    private void castComponents() {
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void initComponents() {
        toolbar.setTitle(R.string.title_toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(HomeActivity.this, R.color.white));
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
        //Setting the actionbarToggle to drawer layout
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.menu_seccion_1:
                fragment = new Fragment1();
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_2:
                fragment = new FragmentTabs();
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_3:
                callToast("seccion 3");
                break;
            case R.id.menu_opcion_1:
                callToast("opcion 1");
                break;
            case R.id.menu_opcion_2:
                callToast("seccion 1");
                break;
        }

        if (fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }

        drawerLayout.closeDrawers();

        return true;
    }

    private void callToast(String numberItemSelected) {
        Toast.makeText(HomeActivity.this, "Item seleccionado " + numberItemSelected, Toast.LENGTH_SHORT).show();
    }
}
