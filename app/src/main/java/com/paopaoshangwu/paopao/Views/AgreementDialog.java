package com.paopaoshangwu.paopao.Views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;

import com.paopaoshangwu.paopao.R;


/**
 * Created by Administrator on 2017/4/12.
 */

public class AgreementDialog extends Dialog {

    private Context context;

    public AgreementDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setGravity(Gravity.CENTER);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.layout_agreement_dialog);


        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.height = display.getHeight()*4/5; // 设置dialog宽度为屏幕的4/5
        getWindow().setAttributes(lp);

    }

}
