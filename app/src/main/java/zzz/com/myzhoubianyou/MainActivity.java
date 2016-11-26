package zzz.com.myzhoubianyou;

import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.lang.reflect.InvocationTargetException;

import zzz.com.myzhoubianyou.fragment.AroundFragment;
import zzz.com.myzhoubianyou.fragment.DiscoverFragment;
import zzz.com.myzhoubianyou.fragment.HomeFragment;
import zzz.com.myzhoubianyou.fragment.MyFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private RadioGroup mRadioGroup;
    private FrameLayout mContainer;
    private Fragment showFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_bottom_radiogroup);
        mRadioGroup.setOnCheckedChangeListener(this);
        mContainer = (FrameLayout) findViewById(R.id.main_container);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        showFragment = new HomeFragment();
        transaction.add(R.id.main_container, showFragment,HomeFragment.TAG);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_bottom_home:
                switchPage(HomeFragment.TAG,HomeFragment.class);
                break;
            case R.id.main_bottom_around:
                switchPage(AroundFragment.TAG,AroundFragment.class);
                break;
            case R.id.main_bottom_discover:
                switchPage(DiscoverFragment.TAG,DiscoverFragment.class);
                break;
            case R.id.main_bottom_my:
                switchPage(MyFragment.TAG,MyFragment.class);
                break;
        }
    }

    private void switchPage(String tag, Class<? extends Fragment> cls) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(showFragment);
        showFragment=manager.findFragmentByTag(tag);
        if (showFragment!=null) {
            transaction.show(showFragment);
        }else {
            try {
                showFragment=cls.getConstructor().newInstance();
                transaction.add(R.id.main_container,showFragment,tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
       transaction.commit();
    }
}
