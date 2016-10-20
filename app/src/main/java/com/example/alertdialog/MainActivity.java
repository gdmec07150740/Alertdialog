package com.example.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tView;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog);
        tView=(TextView)this.findViewById(R.id.textView1);
        Button button1= (Button) this.findViewById(R.id.button1);
        Button button2= (Button) this.findViewById(R.id.button2);
        Button button3= (Button) this.findViewById(R.id.button3);
        Button button4= (Button) this.findViewById(R.id.button4);
        Button button5= (Button) this.findViewById(R.id.button5);
        Button button6= (Button) this.findViewById(R.id.button6);
        Button button7= (Button) this.findViewById(R.id.button7);

        View.OnClickListener listener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog1();
                        break;
                    case R.id.button3:
                        dialog1();
                        break;
                    case R.id.button4:
                        dialog1();
                        break;
                    case R.id.button5:
                        dialog1();
                        break;
                    case R.id.button6:
                        dialog1();
                        break;
                    case R.id.button7:
                        dialog1();
                        break;
                }
            }
        };

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
    }

    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener lis1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        dialog.show();
    }

    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener lis2 =new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="我很忙";
                        break;
                    case  DialogInterface.BUTTON_NEGATIVE:
                        str="我挺闲";
                        break;
                    case  DialogInterface.BUTTON_NEUTRAL:
                        str="不算忙";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"我挺闲",lis2);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"我很忙",lis2);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"不算忙",lis2);
        dialog.show();
    }
    public void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("感想");
        dialog.setMessage("请输入获奖的感想");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        final EditText et1=new EditText(this);
        dialog.setView(et1);

        DialogInterface.OnClickListener lis3= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("获奖感想"+et1.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis3);
        dialog.show();
    }
    public void dialog4(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];

        DialogInterface.OnMultiChoiceClickListener lis4= new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder =new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bSelect,lis4);
        dialog=builder.create();
        dialog.setTitle("多选框");

        DialogInterface.OnClickListener lis4_1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for(int i=0;i<bSelect.length;i++){
                    str=str+"\n"+item[i];
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis4_1);
        dialog.show();
    }
    public void dialog5(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];

        DialogInterface.OnClickListener lis5= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<bSelect.length;i++){
                    if (i!=which){
                        bSelect[i]=false;
                    }else{
                        bSelect[i]=true;
                    }
                }
            }
        };
        builder =new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,lis5);
        dialog.setTitle("单选");
        DialogInterface.OnClickListener lis5_1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for (int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis5_1);
        dialog.show();
    }
    public void dialog6(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];

        DialogInterface.OnClickListener lis6= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了："+item[which];
                tView.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,lis6);
        dialog=builder.create();
        dialog.setTitle("列表");

        DialogInterface.OnClickListener lis6_1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis6_1);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater li=getLayoutInflater();
        View layout=li.inflate(R.layout.mylayout,null);
        final EditText et= (EditText) layout.findViewById(R.id.et);

        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);

        DialogInterface.OnClickListener lis7= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("你输入的是："+et.getText().toString());
            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis7);
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"取消",lis7);
        dialog.show();
        dialog.show();
    }

}
