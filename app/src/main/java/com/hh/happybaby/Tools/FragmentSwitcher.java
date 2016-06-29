package com.hh.happybaby.Tools;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.hh.happybaby.R;

/**
 * 用于Fragment之间的跳转
 * 暂时只有简单的跳转功能，可以带参数跳转
 */
public class FragmentSwitcher {
    /*
     *一个用于Fragment之间跳转的静态函数,直接通过FragmentSwitcher.switchFragment(param1,param2)调用
     *参数:
     * FragmentManager fmManager -- 在Activity或Fragment类中声明
     * Fragment fragment -- 即将跳转到的Fragment
     * Bundle bundle -- 用于传递信息
     */
    public static void switchFragment(FragmentManager fmManager, Fragment fragment, Bundle bundle){
        FragmentTransaction ftTransaction=fmManager.beginTransaction();
        ftTransaction.replace(R.id.layout_fragmentsContainer,fragment);
        fragment.setArguments(bundle);
        ftTransaction.commit();
    }

}
