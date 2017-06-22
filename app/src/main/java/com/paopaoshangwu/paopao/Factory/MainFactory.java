package com.paopaoshangwu.paopao.Factory;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.paopaoshangwu.paopao.UI.Fragment.Errand.ErrandFragment;
import com.paopaoshangwu.paopao.UI.Fragment.Takeout.TakeoutFragment;
import com.paopaoshangwu.paopao.UI.Fragment.Mine.MineFragment;

/**
 * Created by Administrator on 2017/4/7.
 */

public class MainFactory {
    private static final int FRAGMENT_HOME = 0;     //主页
    private static final int FRAGMENT_ORDER = 1;    //订单
    private static final int FRAGMENT_MINE = 2;     //我的
    //SparseArray:key是整形的key,根据整形的key来获取一个对象,效率比较高.
    private static SparseArray<Fragment> fragments = new SparseArray<>();

    //创建一个工厂方法,用来创建一个Fragment对象
    public static Fragment createFragment(int index) {
        //从集合中获取
        Fragment fragment = fragments.get(index);
        if (fragment == null) {
            switch (index) {
                case FRAGMENT_HOME:
                    fragment = new TakeoutFragment();
                    break;
                case FRAGMENT_ORDER:
                    fragment = new ErrandFragment();
                    break;
                case FRAGMENT_MINE:
                    fragment = new MineFragment();
                    break;
            }
            //存到集合中
            fragments.put(index, fragment);
        }

        return fragment;
    }
}
