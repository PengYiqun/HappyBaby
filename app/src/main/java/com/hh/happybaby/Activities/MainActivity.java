package com.hh.happybaby.Activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hh.happybaby.Fragments.BabyAppointmentFragment;
import com.hh.happybaby.Fragments.BabyEntertainmentFragment;
import com.hh.happybaby.Fragments.BabyKnowledgeFragment;
import com.hh.happybaby.Fragments.BabyRecordFragment;
import com.hh.happybaby.R;
import com.hh.happybaby.Tools.FragmentSwitcher;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by PengYiqun on 2016/6/29.
 * App的主界面Activity
 *
 */

//因为用了AndroidAnnotation框架的原因,所有代码中用到MainActivity.class的地方要写成 MainActivity_.class
//主要是考虑到侧滑菜单和其他地方会有另外的Activity,从那里跳转到MainActivity的时候要注意一下
@EActivity
public class MainActivity extends Activity {
     //绑定主页面顶部标题栏和底部功能菜单栏的所有控件
    //不要在这里添加其他变量了
    @ViewById(R.id.btn_footer_babyknowledge)
    ImageButton btnBabyKnowledge;
    @ViewById(R.id.btn_footer_babyrecord)
    ImageButton btnBabyRecord;
    @ViewById(R.id.btn_footer_babyappointment)
    ImageButton btnBabyAppointment;
    @ViewById(R.id.btn_footer_babyentertainment)
    ImageButton btnBabyEntertainment;
    @ViewById(R.id.btn_header_add)
    ImageButton btnAdd;
    @ViewById(R.id.btn_header_delete)
    ImageButton btnDelete;
    @ViewById(R.id.btn_header_back)
    ImageButton btnBack;
    @ViewById(R.id.btn_header_set)
    ImageButton btnSet;
    @ViewById(R.id.btn_header_list)
    ImageButton btnList;
    @ViewById(R.id.btn_header_user)
    ImageButton btnUser;
    @ViewById(R.id.header_text)
    TextView tvHeader;

    //一个Fragment管理器,管理所有Fragment
    FragmentManager fmManager=getFragmentManager();

    //定义所有Fragment
    BabyAppointmentFragment fBabyAppointment=new BabyAppointmentFragment();
    BabyEntertainmentFragment fBabyEntertainment=new BabyEntertainmentFragment();
    BabyKnowledgeFragment fBabyKnowledge=new BabyKnowledgeFragment();
    BabyRecordFragment fBabyRecord=new BabyRecordFragment();

    //尽量不要在这里写代码了
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    //初始化用户界面
    //除非修改初始界面,不要修改这个函数
    public void initUI(){
        initButtons();
        tvHeader.setTypeface(Typeface.createFromAsset(getAssets(),"cartoon.tiff"));
        tvHeader.setText("育儿知识");
        btnBabyKnowledge.setBackgroundResource(R.drawable.white_babyknowledge);
        btnUser.setVisibility(View.VISIBLE);
        FragmentSwitcher.switchFragment(fmManager,fBabyKnowledge,null);
    }

    //初始化顶端和底部的按钮
    //除非修改按钮种类、样式,不要修改这个函数
    public void initButtons(){
        btnBabyAppointment.setBackgroundResource(R.drawable.black_babyappointment);
        btnBabyEntertainment.setBackgroundResource(R.drawable.black_babyentertainment);
        btnBabyKnowledge.setBackgroundResource(R.drawable.black_babyknowlegde);
        btnBabyRecord.setBackgroundResource(R.drawable.black_babyrecord);
        btnAdd.setVisibility(View.GONE);
        btnSet.setVisibility(View.GONE);
        btnDelete.setVisibility(View.GONE);
        btnBack.setVisibility(View.GONE);
        btnUser.setVisibility(View.GONE);
        btnList.setVisibility(View.GONE);
    }

    //处理所有按钮的点击事件,
    //除非修改按钮种类,不要修改这个函数
    @Click({R.id.btn_footer_babyentertainment,R.id.btn_footer_babyappointment,R.id.btn_footer_babyrecord,
            R.id.btn_footer_babyknowledge,R.id.btn_header_add,R.id.btn_header_back,R.id.btn_header_delete,
            R.id.btn_header_list,R.id.btn_header_set,R.id.btn_header_user})
    public void onButtonClicked(View v){
        initButtons();
        switch(v.getId()){
            case R.id.btn_footer_babyappointment:
                btnBabyAppointment.setBackgroundResource(R.drawable.white_babyappointment);
                btnUser.setVisibility(View.VISIBLE);
                btnDelete.setVisibility(View.VISIBLE);
                btnAdd.setVisibility(View.VISIBLE);
                tvHeader.setText("健康预约");
                FragmentSwitcher.switchFragment(fmManager,fBabyAppointment,null);
                break;
            case R.id.btn_footer_babyentertainment:
                btnBabyEntertainment.setBackgroundResource(R.drawable.white_babyentertainment);
                tvHeader.setText("宝宝娱乐");
                FragmentSwitcher.switchFragment(fmManager,fBabyEntertainment,null);
                break;
            case R.id.btn_footer_babyknowledge:
                btnBabyKnowledge.setBackgroundResource(R.drawable.white_babyknowledge);
                btnUser.setVisibility(View.VISIBLE);
                tvHeader.setText("育儿知识");
                FragmentSwitcher.switchFragment(fmManager,fBabyKnowledge,null);
                break;
            case R.id.btn_footer_babyrecord:
                btnBabyRecord.setBackgroundResource(R.drawable.white_babyrecord);
                btnUser.setVisibility(View.VISIBLE);
                btnSet.setVisibility(View.VISIBLE);
                btnAdd.setVisibility(View.VISIBLE);
                tvHeader.setText("育儿记录");
                FragmentSwitcher.switchFragment(fmManager,fBabyRecord,null);
                break;
            case R.id.btn_header_add:

                break;
            case R.id.btn_header_back:

                break;
            case R.id.btn_header_delete:

                break;
            case R.id.btn_header_list:

                break;
            case R.id.btn_header_set:

                break;
            case R.id.btn_header_user:

                break;
            default:
                break;
        }
    }
}
