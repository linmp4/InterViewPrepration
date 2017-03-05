package interviewpre.linmp4.com.interviewpre.UI.Material.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import interviewpre.linmp4.com.interviewpre.R;
import interviewpre.linmp4.com.interviewpre.UI.CodeView.CodeViewActivity;
import interviewpre.linmp4.com.interviewpre.UI.Material.ui.fragment.BackHandledFragment;
import interviewpre.linmp4.com.interviewpre.UI.Material.ui.fragment.MainFragment;
import interviewpre.linmp4.com.interviewpre.UI.Material.ui.fragment.SnackbarFragment;
import interviewpre.linmp4.com.interviewpre.UI.Material.ui.fragment.TextInputLayoutFragment;
import interviewpre.linmp4.com.interviewpre.Util.StringCheck;
import interviewpre.linmp4.com.interviewpre.Util.ToastUtil;

public class MaterialActivity extends AppCompatActivity implements BackHandledFragment.BackHandlerInterface {

    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.frame_content)
    FrameLayout frameContent;
    @Bind(R.id.main_content)
    CoordinatorLayout mainContent;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private BackHandledFragment selectedFragment;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
        drawerLayout.addDrawerListener(mDrawerToggle);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(navigationView);

        switchToMain();
    }

    private void switchToMain() {
        MainFragment main = new MainFragment();
        code = main.getcode();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, main).commit();
        toolbarTitle.setText("主页");
    }

    private void switchToExample() {
        TextInputLayoutFragment main = new TextInputLayoutFragment();
        code = main.getcode();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new TextInputLayoutFragment()).commit();
        toolbarTitle.setText("MD输入框");
    }

    private void switchToBlog() {
        SnackbarFragment main = new SnackbarFragment();
        code = main.getcode();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new SnackbarFragment()).commit();
        toolbarTitle.setText("Snackbar");
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_item_main:
                                switchToMain();
                                break;
                            case R.id.navigation_item_tl:
                                switchToExample();
                                break;
                            case R.id.navigation_item_snackbar:
                                switchToBlog();
                                break;
                        }
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


    @Override
    public void setSelectedFragment(BackHandledFragment backHandledFragment) {
        this.selectedFragment = backHandledFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbarmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_item_showcode:
                if (StringCheck.isEmpty(code))
                    ToastUtil.makeText(this, "未设置核心代码");
                else
                    startActivity(new Intent(this, CodeViewActivity.class)
                            .putExtra(CodeViewActivity.CODE, code));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (selectedFragment == null || !selectedFragment.onBackPressed()) {
            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        }
    }
}
