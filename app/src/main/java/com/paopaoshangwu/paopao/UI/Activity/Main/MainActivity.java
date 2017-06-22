package com.paopaoshangwu.paopao.UI.Activity.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.paopaoshangwu.paopao.Adapter.ViewPagerAdapter;
import com.paopaoshangwu.paopao.App;
import com.paopaoshangwu.paopao.Base.BaseActivity;
import com.paopaoshangwu.paopao.Constants;
import com.paopaoshangwu.paopao.Factory.MainFactory;
import com.paopaoshangwu.paopao.R;
import com.paopaoshangwu.paopao.Views.CanBanScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.vp_main)
    CanBanScrollViewPager vpMain;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;

    private Handler handler = new Handler();
    boolean isExit = false;
    private boolean isNeedCheck = true;//是否需要检查权限
    private static final int PERMISSON_REQUESTCODE = 0;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < rgMain.getChildCount(); i++) {
            Fragment fragment = MainFactory.createFragment(i);
            fragments.add(fragment);
        }
        vpMain.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        //底部按钮选中事件
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < group.getChildCount(); i++) {
                    if (group.getChildAt(i).getId() == checkedId) {
                        //处理监听
                        findViewById(checkedId).setTag(i);
                        findViewById(checkedId).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int which = (int) v.getTag();
                                vpMain.setCurrentItem(which);
                            }
                        });
                    }
                }
            }
        });
        vpMain.setOffscreenPageLimit(2);
        //当ViewPager滑动的时候,让底部的RadioGroup也跟着滑动
        vpMain.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                ((RadioButton) rgMain.getChildAt(position)).setChecked(true);
            }
        });
    }

    @Override
    public MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }


    /**
     * 弹出下载提示框
     *
     * @param msg 对话框提示信息
     * @param url APP下载地址
     */
    private void showDialog(String msg, String url) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("找到新版本，是否下载");
        dialog.setMessage(msg)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //download(url);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }


    /**
     * 点击两次返回键退出应用
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit) {
                finish();
            } else {
                isExit = true;
                Toast.makeText(App.getContext(), "再点一次退出应用", Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
            }
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (isNeedCheck) {
            checkPermissions(Constants.NEED_PERMISSIONS);
        }
    }

    private void checkPermissions(String... permissions) {
        List<String> needRequestPermissonList = findDeniedPermissions(permissions);
        if (null != needRequestPermissonList && needRequestPermissonList.size() > 0) {
            ActivityCompat.requestPermissions(this, needRequestPermissonList.toArray(new String[needRequestPermissonList.size()]), PERMISSON_REQUESTCODE);
        }
    }

    /**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     * @since 2.5.0
     */
    private List<String> findDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissonList = new ArrayList<>();
        for (String perm : permissions) {
            if (ContextCompat.checkSelfPermission(this,
                    perm) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    this, perm)) {
                needRequestPermissonList.add(perm);
            }
        }
        return needRequestPermissonList;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] paramArrayOfInt) {
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(paramArrayOfInt)) {
                showMissingPermissionDialog();
                isNeedCheck = false;
            }
        }
    }

    /**
     * 检测是否说有的权限都已经授权
     *
     * @param grantResults
     * @return
     * @since 2.5.0
     */
    private boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 显示提示信息
     *
     * @since 2.5.0
     */
    private void showMissingPermissionDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("当前应用缺少必要权限。\n\n请点击\"设置\" - \"应用\" - \"权限\" - 打开所需权限。");

        // 拒绝, 退出应用
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        builder.setPositiveButton("设置",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startAppSettings();
                    }
                });

        builder.setCancelable(false);

        builder.show();
    }

    /**
     * 启动应用的设置
     *
     * @since 2.5.0
     */
    private void startAppSettings() {
        Intent intent = new Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }
}
