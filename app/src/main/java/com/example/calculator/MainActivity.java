package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    int h=0,pos=0,hs=0;String jup="",history="";double var1=0,var2=0,var3=0;boolean hst=false,repeat=false;
    String ar="";
    private Handler mHandler=new Handler();
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eigth;
    private Button nine;
    private Button zero;
    private Button equal;
    private Button plus;
    private Button sub;
    private Button mul;
    private Button div;
    private Button dec;
    private Button cl;
    private Button rem;
    private Button brc1;
    private Button brc2;
    private Button pow;
    private Button pi;
    private Button e;
    private Button fac;
    private Button deg;
    private Button sin;
    private Button cos;
    private Button tan;
    private Button log;
    private Button ncr;
    private Button npr;
    private Button hist;
    private Button binv;
    private Button vr1;
    private Button vr2;
    private Button vr3;
    private Button arR;
    private Button arL;
    private TextView l;
    private TextView frc;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIviews();
        ncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrow();
                resetHistory(v);
                String u=l.getText().toString();
                if(u.length()>0)
                    if(u.charAt(u.length()-1)=='P' || u.charAt(u.length()-1)=='C')
                        u=u.substring(0,u.length()-1);
                l.setText(u+"C");
                update("C");}

        });
        npr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                arrow();
                String u=l.getText().toString();
                if(u.length()>0)
                    if(u.charAt(u.length()-1)=='P' || u.charAt(u.length()-1)=='C')
                        u=u.substring(0,u.length()-1);
                l.setText(u+"P");
                update("P");}

        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                arrow();
                zero();
                l.setText(l.getText().toString()+"0");
                update("0");}

        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();
                arrow();
                l.setText(l.getText().toString()+"1");update("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();
                arrow();
                l.setText(l.getText().toString()+"2");
                update("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();
                arrow();
                l.setText(l.getText().toString()+"3");
                update("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();
                arrow();
                l.setText(l.getText().toString()+"4");
                update("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();
                arrow();
                l.setText(l.getText().toString()+"5");
                update("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();
                arrow();
                l.setText(l.getText().toString()+"6");
                update("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();
                arrow();
                l.setText(l.getText().toString()+"7");update("7");
            }
        });
        eigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();
                arrow();
                l.setText(l.getText().toString()+"8");update("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                zero();arrow();
                l.setText(l.getText().toString()+"9");update("9");
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+".");update(".");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                String u=l.getText().toString();
                if(u.length()>0)
                {
                    if(u.charAt(u.length()-1)=='+')
                        u=u.substring(0,u.length()-1)+"+";
                    else if(u.charAt(u.length()-1)=='-')
                        u=u.substring(0,u.length()-1)+"-";
                    else
                        u=u+"+";
                }
                else
                    u=u+"+";
                l.setText(u);
                update("+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                String u=l.getText().toString();
                if(u.length()>0)
                {
                    if(u.charAt(u.length()-1)=='-')
                        u=u.substring(0,u.length()-1)+"+";
                    else if(u.charAt(u.length()-1)=='+')
                        u=u.substring(0,u.length()-1)+"-";
                    else
                        u=u+"-";
                }
                else
                    u=u+"-";
                l.setText(u);
                update("-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"*");
                update("*");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"/");
                update("/");
            }
        });
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frc.setText("");ar="";
                l.setText("");l.scrollTo(0,0);
                resetHistory(v);
            }
        });
        /*rem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                resetHistory();
                if(event.getAction()== MotionEvent.ACTION_DOWN)
                    return false;
                else
                    stopRepeating(v);
                return true;
            }
        });*/
        rem.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                resetHistory(v);
                repeat=true;
                frc.setText("");
                startRepeating(v);
                return true;
            }
        });
        rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!repeat) {
                    resetHistory(v);arrow();
                    String temp = l.getText().toString();
                    if (temp.length() > 0)
                        removeFunc(temp);
                }
                stopRepeating(v);
                update("");
            }
        });
        brc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"(");
                update("(");
            }
        });
        brc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+")");
                update(")");
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"^");
                update("^");
            }
        });
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"π");
                update("π");
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"e");update("e");
            }
        });
        vr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"α");update("α");
            }
        });
        vr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"β");update("β");
            }
        });
        vr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"γ");update("γ");
            }
        });
        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+"!");update("!");
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+(sin.getText().toString()));
                update((sin.getText().toString()));
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+(cos.getText().toString()));
                update((cos.getText().toString()));
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+(tan.getText().toString()));
                update((tan.getText().toString()));
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                l.setText(l.getText().toString()+(log.getText().toString()));
                update((log.getText().toString()));
            }
        });
        deg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);arrow();
                h=(h+1)%2;
                if(h==0)
                    deg.setText("deg");
                else
                    deg.setText("rad");
                update("");
            }
        });
        binv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                if((sin.getText().toString()).equals("sin"))
                {
                    sin.setText("asin");
                    cos.setText("acos");
                    tan.setText("atan");
                    log.setText("ln");
                }
                else
                {
                    sin.setText("sin");
                    cos.setText("cos");
                    tan.setText("tan");
                    log.setText("log");
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRepeating(v);
                hs=0;ar="";
                l.scrollTo(0,0);
                frc.scrollTo(0,0);
                if(l.getText().toString().length()>0)
                {
                    if(l.getText().toString().charAt(0)!='#')
                        if(special()) {
                            if(!hst && frc.getText().toString().length()>0)
                            {history=remarrow(l.getText().toString())+"\n"+history;hst=true;save("History",history);}
                            frc.setText("");
                            l.setText(jup);
                            if (jup.indexOf('E') == -1 && jup.indexOf('.') != -1)
                                frc.setText(toFraction(Double.parseDouble(jup)));
                        }
                }



            }

        });
        hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRepeating(v);
                if(history.length()>0){
                    hst=true;
                    hs++;
                    if(hst)
                    {
                        int c=0,fl=0;
                        String w="";
                        for(int i=0;i<history.length();i++)
                        {
                            char ch=history.charAt(i);
                            if(ch=='\n')
                            {
                                c++;
                                if(c==hs)
                                {
                                    l.setText(w);
                                    update("");
                                    fl=1;break;
                                }
                                w="";

                            }
                            else
                                w=w+ch;
                        }
                        if(fl==0)
                        {
                            resetHistory(v);
                            l.setText("");
                            frc.setText("");
                        }
                    }

                }}
        });
        hist.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                resetHistory(v);
                history="";
                save("History",history);
                Toast.makeText(getApplicationContext(), "History Deleted",Toast.LENGTH_LONG).show();
                return true;
            }
        });
        vr1.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                resetHistory(v);
                double vl=0;boolean fl=true;
                try{
                    if(l.getText().toString().indexOf("e")!=-1)
                        throw new Exception();
                    vl=Double.parseDouble(remarrow(l.getText().toString()));
                }
                catch(Exception e1)
                {
                    try {
                        vl=Double.parseDouble(frc.getText().toString());
                    }
                    catch(Exception e2){fl=false;}
                }
                if(fl)
                {
                    var1=vl;
                    savevar();
                    Toast.makeText(getApplicationContext(), "α Changed",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Can not Change",Toast.LENGTH_LONG).show();
                return true;
            }
        });
        vr2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                resetHistory(v);
                double vl=0;boolean fl=true;
                try{
                    if(l.getText().toString().indexOf("e")!=-1)
                        throw new Exception();
                    vl=Double.parseDouble(remarrow(l.getText().toString()));
                }
                catch(Exception e1)
                {
                    try {
                        vl=Double.parseDouble(frc.getText().toString());
                    }
                    catch(Exception e2){fl=false;}
                }
                if(fl)
                {
                    var2=vl;
                    savevar();
                    Toast.makeText(getApplicationContext(), "β Changed",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Can not Change",Toast.LENGTH_LONG).show();
                return true;
            }
        });
        vr3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                resetHistory(v);
                double vl=0;boolean fl=true;
                try{
                    if(l.getText().toString().indexOf("e")!=-1)
                        throw new Exception();
                    vl=Double.parseDouble(remarrow(l.getText().toString()));
                }
                catch(Exception e1)
                {
                    try {
                        vl=Double.parseDouble(frc.getText().toString());
                    }
                    catch(Exception e2){fl=false;}
                }
                if(fl)
                {
                    var3=vl;
                    savevar();
                    Toast.makeText(getApplicationContext(), "γ Changed",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Can not Change",Toast.LENGTH_LONG).show();
                return true;
            }
        });
        arL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                String k=l.getText().toString();
                if(k.length()>0)
                {
                    if(k.charAt(0)=='#')
                        l.setText("");
                    else
                        l.setText(arrowshift(l.getText().toString()));
                }

            }
        });
        arR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetHistory(v);
                String k=l.getText().toString();
                if(k.length()>0)
                {
                    int pos=k.indexOf("|");
                    if(k.charAt(0)=='#')
                        l.setText("");
                    else if(pos==-1)
                        l.setText(k+"|");
                    else if(pos!=k.length()-1)
                    {
                        String tm="",kt=k.substring(0,pos)+k.substring(pos+1);
                        while(kt.indexOf("|")!=pos)
                        {
                            tm=kt;
                            kt=arrowshift(kt);
                        }
                        l.setText(tm);
                    }
                }
            }
        });
    }
    private void setupUIviews()
    {
        one=(Button)findViewById(R.id.b1);
        two=(Button)findViewById(R.id.b2);
        three=(Button)findViewById(R.id.b3);
        four=(Button)findViewById(R.id.b4);
        five=(Button)findViewById(R.id.b5);
        six=(Button)findViewById(R.id.b6);
        seven=(Button)findViewById(R.id.b7);
        eigth=(Button)findViewById(R.id.b8);
        nine=(Button)findViewById(R.id.b9);
        zero=(Button)findViewById(R.id.b0);
        equal=(Button)findViewById(R.id.be);
        plus=(Button)findViewById(R.id.bp);
        sub=(Button)findViewById(R.id.bs);
        mul=(Button)findViewById(R.id.bm);
        div=(Button)findViewById(R.id.bd);
        dec=(Button)findViewById(R.id.bds);
        cl=(Button)findViewById(R.id.bC);
        rem=(Button)findViewById(R.id.bx);
        brc1=(Button)findViewById(R.id.bbr1);
        brc2=(Button)findViewById(R.id.bbr2);
        pow=(Button)findViewById(R.id.bpow);
        pi=(Button)findViewById(R.id.bpi);
        e=(Button)findViewById(R.id.bee);
        fac=(Button)findViewById(R.id.bfac);
        deg=(Button)findViewById(R.id.bdeg);
        sin=(Button)findViewById(R.id.bsin);
        cos=(Button)findViewById(R.id.bcos);
        tan=(Button)findViewById(R.id.btan);
        log=(Button)findViewById(R.id.blog);
        l=(TextView)findViewById(R.id.lt);
        frc=(TextView)findViewById(R.id.frac);
        name=(TextView)findViewById(R.id.name);
        ncr=(Button)findViewById(R.id.bncr);
        npr=(Button)findViewById(R.id.bnpr);
        hist=(Button)findViewById(R.id.hist);
        binv=(Button)findViewById(R.id.binv);
        vr1=(Button)findViewById(R.id.v1);
        vr2=(Button)findViewById(R.id.v2);
        vr3=(Button)findViewById(R.id.v3);
        arR=(Button)findViewById(R.id.ra);
        arL=(Button)findViewById(R.id.la);
        l.setMovementMethod(new ScrollingMovementMethod());
        frc.setMovementMethod(new ScrollingMovementMethod());
        frc.setHorizontallyScrolling(true);
        history=load("History");
        loadvar();




    }
    String remarrow(String s)
    {
        int pos=s.indexOf("|");
        if(pos==-1)
            return s;
        else if(pos==s.length()-1)
            return s.substring(0,pos);
        else
            return s.substring(0,pos)+s.substring(pos+1);
    }
    void arrow()
    {
        String k=l.getText().toString();
        int pos=k.indexOf("|");
        if(pos==-1)
            ar="";
        else if(pos==k.length()-1)
        {
            l.setText(k.substring(0,pos));
            ar="|";
        }
        else
        {
            l.setText(k.substring(0,pos));
            ar=k.substring(pos);
        }
    }
    void savevar()
    {
        save("Variables",""+var1+"\n"+var2+"\n"+var3+"\n");
    }
    void loadvar()
    {
        String data=load("Variables");
        //l.setText(data);
        String t="";int c=0;
        for(int i=0;i<data.length();i++)
        {
            char ch=data.charAt(i);
            if(ch=='\n')
            {
                c++;
                switch(c)
                {
                    case 1:var1=Double.parseDouble(t);break;
                    case 2:var2=Double.parseDouble(t);break;
                    case 3:var3=Double.parseDouble(t);break;
                }
                t="";
            }
            else
                t=t+ch;
        }
    }
    void resetHistory(View v)
    {
        stopRepeating(v);
        hst=false;
        hs=0;
    }
    boolean special()
    {

        if(jup.charAt(0)=='#')
        {
            String k=l.getText().toString();
            if(k.indexOf("////1!")==0)
            {
                String kn=k.substring(6);
                long n=0;
                try {
                    n=Long.parseLong(kn);
                }
                catch (Exception exp){
                    return true;
                }
                l.setText("#"+noFactors(n));
                frc.setText("");
                jup="";
                return false;
            }
            else if(k.equals("////13!"))
            {
                if(name.getText().toString().length()==0)
                    name.setText("MADE   BY   TANMAY");
                else
                    name.setText("");
                l.setText("");
                jup="";
                return false;
            }
            else if(k.equals("////22!"))
            {
                var1=0;var2=0;var3=0;
                savevar();
                Toast.makeText(getApplicationContext(), "Variables Reset",Toast.LENGTH_LONG).show();
                l.setText("");
                jup="";
                return false;
            }
            else if(k.equals("////19!"))
            {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("",history);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "History Copied to ClipBoard",Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }
    String noFactors(long n)
    {
        String fc1="",fc2="";
        byte r=1;
        if(n<0)
        {n=Math.abs(n);r++;}
        int c=0;long k=n;
        for(long i=1;i<k;i++)
        {

            if(n%i==0)
            {
                k=n/i;
                c=c+((k!=i)?2:1)*r;
                if(r==2)
                    fc1=","+((k!=i)?(-k)+",":"")+(-i)+fc1;
                fc2=fc2+","+i+((k!=i)?","+k:",");
            }


        }
        if(fc1.length()>0)
            fc1=fc1.substring(1);
        if(fc2.length()>0)
            fc2=fc2.substring((fc1.length()>0)?0:1,fc2.length()-((k*k==n)?1:0));
        return c+"\n"+fc1+fc2;
    }
    String arrowshift(String k)
    {
        int pos=k.indexOf("|");
        if(pos==-1)
        {
            k=k+"|";
            pos=k.length()-1;
        }
        else if(pos==0)
            return k;
        String u=k.substring(0,pos);
        String ut="",ul="";
        if(u.length()>=3)
            ut=u.substring(u.length()-3);
        if(u.length()>=2)
            ul=u.substring(u.length()-2);
        if(ut.equals("sin")||ut.equals("cos")||ut.equals("tan")||ut.equals("log"))
            u=u.substring(0,u.length()-3);
        else if(ul.equals("ln"))
            u=u.substring(0,u.length()-2);
        else
            u=u.substring(0,u.length()-1);
        if(u.length()>0)
            if(u.charAt(u.length()-1)=='a')
                u=u.substring(0,u.length()-1);
        return (k.substring(0,u.length())+"|"+k.substring(u.length(),pos)+k.substring(pos+1));
    }
    void removeFunc(String u)
    {
        String ut="",ul="";
        if(u.length()>=3)
            ut=u.substring(u.length()-3);
        if(u.length()>=2)
            ul=u.substring(u.length()-2);
        if(ut.equals("sin")||ut.equals("cos")||ut.equals("tan")||ut.equals("log"))
            u=u.substring(0,u.length()-3);
        else if(ul.equals("ln"))
            u=u.substring(0,u.length()-2);
        else
            u=u.substring(0,u.length()-1);
        if(u.length()>0)
            if(u.charAt(u.length()-1)=='a')
                u=u.substring(0,u.length()-1);
        l.setText(u);
    }
    void zero()
    {
        if(l.getText().toString().equals("0"))
            l.setText("");
    }
    void update(String txt)
    {

        frc.setText("");
        String bkl=l.getText().toString();
        l.setText(bkl+((ar.length()>0)?ar.substring(1):""));
        String up=l.getText().toString();boolean hash=true;
        if(up.length()>0)
        {
            if(up.charAt(0)=='#')
            {
                l.setText(txt);up=txt;hash=false;
                ar=txt+ar;
            }
            jup = calc(up);
            if ((!jup.equals(up)) && jup.charAt(0) != '#')
                frc.setText(jup);

        }
        l.setText(((hash)?bkl:"")+ar);
        int sclamt=l.getLayout().getLineTop(l.getLineCount())-l.getHeight();
        if(sclamt>0)
            l.scrollTo(0,sclamt);
        else
            l.scrollTo(0,0);
        frc.scrollTo(0,0);
    }
    String bracket(String s)
    {
        if(s.charAt(0)=='#')
            return s;
        int f=-1,l=-1;
        s=s.trim()+" ";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                f=i;
            else if(ch==')')
            {
                l=i;
                break;
            }
        }
        if(f==-1 && l==-1)
            return s;
        else if(f!=-1 && l!=-1)
        {
            String dmas1=dmas(s.substring(f+1,l));
            if(dmas1.charAt(0)=='#')
                s=dmas1;
            else
                s=s.substring(0,f)+dmas1+s.substring(l+1);
        }
        else
        {
            s="#Bracket Mismatched";
        }
        return(bracket(s));
    }
    String muldiv(String s)
    {
        double p=1.0;
        String t="";
        s=s.trim()+"*";
        int sg=1;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='*' || ch=='/')
            {
                if(sg==1)
                    p=p*Double.parseDouble(t);
                else
                    p=p/Double.parseDouble(t);
                if(ch=='*')
                    sg=1;
                else
                    sg=2;
                t="";
            }
            else
                t=t+ch;
        }
        s=p+"";
        return s;
    }
    String plusminus(String s)
    {
        double ss=0.0;
        String t="0",k="+-*/^";
        s="0+"+s.trim();
        int sg=0;
        if(s.charAt(0)!='+' && s.charAt(0)!='-')
            s="+"+s;
        s=" "+s+"+";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='E')
            {
                t=t+ch;
                if(s.charAt(i+1)=='-')
                {
                    i++;
                    t=t+"-";
                }
                else if(s.charAt(i+1)=='+')
                {
                    i++;
                }

            }
            else if((ch=='+' || ch=='-')&& k.indexOf(s.charAt(i-1))==-1)
            {
                t=pow(t);
                t=muldiv(t);
                if(sg==1)
                    ss=ss+Double.parseDouble(t);
                else if(sg==2)
                    ss=ss-Double.parseDouble(t);
                if(ch=='+')
                    sg=1;
                else
                    sg=2;
                t="";
            }
            else
                t=t+ch;
        }
        s=ss+"";
        return s;
    }
    String dmas(String s)
    {
        s=trigo(s);
        s=fac(s);
        s=nCrnPr(s);
        if(s.charAt(0)=='#')
            return s;
        String sg="+-*/^CP",k="0123456789+-*/().^CPE";
        s=s.trim();
        if(s.equals("+#Inappropriate Sign Usage"))
            return"#Inappropriate Sign Usage";
        if(sg.indexOf(s.charAt(s.length()-1))!=-1)
        {
            return"#Inappropriate Sign Usage";
        }
        if(s.charAt(0)=='*' || s.charAt(0)=='/' || s.charAt(0)=='^'|| s.charAt(0)=='C'|| s.charAt(0)=='P')
        {
            return "#Inappropriate Sign Usage";
        }
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(k.indexOf(ch)==-1)
            {
                return"#Unidentified Symbol";
            }
        }
        s=plusminus(s);
        return s;
    }
    String dcr(String s)
    {
        if(s.charAt(0)=='#')
            return s;
        double n=Double.parseDouble(s);
        if((int)n==n)
            s=(int)n+"";
        return s;
    }
    String calc(String s)
    {
        try {
            s = pie(s);
            s = inverse(s);
            s = error(s);
            s = bracket(s);
            s = dmas(s);
            s = dcr(s);
            return s;
        }
        catch(Exception err)
        {
            return "#Invalid Sign Usage";
        }
    }
    String error(String s)
    {
        if(s.charAt(0)=='#')
            return s;
        s=" "+s+" ";
        String x="+-",y="*/^",z="gnsz",zz="sctl";
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(x.indexOf(c)!=-1)
                if(x.indexOf(s.charAt(i-1))!=-1)
                {
                    return"#Inappropriate Sign Usage";
                }
            if(y.indexOf(c)!=-1)
                if(x.indexOf(s.charAt(i-1))!=-1 || y.indexOf(s.charAt(i-1))!=-1)
                {
                    return"#Inappropriate Sign Usage";
                }
            if(i>1 && i<s.length()-2)
            {
                if(c=='(' && x.indexOf(s.charAt(i-1))==-1 && y.indexOf(s.charAt(i-1))==-1 && s.charAt(i-1)!='(' && z.indexOf(s.charAt(i-1))==-1 && s.charAt(i-1)!='C' && s.charAt(i-1)!='P')
                {
                    s=s.substring(0,i)+"*"+s.substring(i);
                    i--;
                    continue;
                }
                if(c==')' && x.indexOf(s.charAt(i+1))==-1 && y.indexOf(s.charAt(i+1))==-1 && s.charAt(i+1)!=')'&& s.charAt(i+1)!='!' && s.charAt(i+1)!='C' && s.charAt(i+1)!='P' )
                {
                    s=s.substring(0,i+1)+"*"+s.substring(i+1);
                    i--;
                    continue;
                }
                if((zz.indexOf(c)!=-1 && (x+y+"o(").indexOf(s.charAt(i-1))==-1) && s.charAt(i-1)!='C' && s.charAt(i-1)!='P')
                {
                    s=s.substring(0,i)+"*"+s.substring(i);
                    i--;
                    continue;
                }
            }
        }
        return s.trim();
    }
    String pow(String s)
    {
        s="["+s.trim()+"]";
        String k="*/^[]";
        while(s.indexOf('^')!=-1)
        {
            int r=s.lastIndexOf('^');
            String n1="",n2="";
            int i,j;
            for(i=r+1;i<s.length();i++)
            {
                char ch=s.charAt(i);
                if(k.indexOf(ch)!=-1)
                    break;
                else
                    n1=n1+ch;
            }
            for(j=r-1;j>0;j--)
            {
                char ch=s.charAt(j);
                if(k.indexOf(ch)!=-1)
                    break;
                else
                    n2=ch+n2;
            }
            double p=Math.pow(Double.parseDouble(n2),Double.parseDouble(n1));
            s=s.substring(0,j+1)+p+s.substring(i);
        }
        s=s.substring(1,s.length()-1);
        return s;
    }
    String inverse(String s)
    {
        if(s.indexOf("asin")!=-1)
            s=s.substring(0,s.indexOf("asin"))+"sIn"+s.substring(s.indexOf("asin")+4);
        else if(s.indexOf("acos")!=-1)
            s=s.substring(0,s.indexOf("acos"))+"cOz"+s.substring(s.indexOf("acos")+4);
        else if(s.indexOf("atan")!=-1)
            s=s.substring(0,s.indexOf("atan"))+"tAn"+s.substring(s.indexOf("atan")+4);
        else if(s.indexOf("ln")!=-1)
            s=s.substring(0,s.indexOf("ln"))+"lOg"+s.substring(s.indexOf("ln")+2);
        else
            return s;
        return inverse(s);
    }
    String trigo(String s)
    {
        if(s.charAt(0)=='#')
            return s;
        String t="tan",c="cos",si="sin",lo="log",q,vt="tAn",vc="cOz",vsi="sIn",vlo="lOg";
        s=s.trim();
        if(s.indexOf(t)>-1)
            q=t;
        else if(s.indexOf(vt)>-1)
            q=vt;
        else if(s.indexOf(c)>-1)
            q=c;
        else if(s.indexOf(vc)>-1)
            q=vc;
        else if(s.indexOf(si)>-1)
            q=si;
        else if(s.indexOf(vsi)>-1)
            q=vsi;
        else if(s.indexOf(lo)>-1)
            q=lo;
        else if(s.indexOf(vlo)>-1)
            q=vlo;
        else
            return s;
        int p=s.indexOf(q);String e="+-*/^!CP",ee="+-0123456789.";
        if("*/^CP".indexOf(s.charAt(p+3))!=-1)
            return "#Inappropriate Sign Usage";
        if(ee.indexOf(s.charAt(p+3))==-1)
            return s;
        String n="";int i;
        for(i=p+3;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='E' && i!=s.length()-1)
            {
                n=n+ch;
                char pch=s.charAt(i+1);
                if(pch=='+' || pch=='-')
                {
                    n=n+pch;
                    i++;
                }
            }
            else if((ch=='+' || ch=='-') && i==p+3 )
                n=n+ch;
            else if(e.indexOf(ch)!=-1)
                break;
            else if(ee.indexOf(ch)==-1)
                return "#Unidentified Symbol";
            else
                n=n+ch;
        }
        double v=Double.parseDouble(n);
        if((q.equals(si) || q.equals(c) || q.equals(t)) && h==0)
            v=Math.toRadians(v);
        if(q.equalsIgnoreCase("log"))
            if(v<0)
                s="#Domain Error";
            else
                s=s.substring(0,p)+((q.equals("log"))?Math.log10(v):Math.log(v))+s.substring(i);
        else if(q.equals("sin"))
            s=s.substring(0,p)+(100+Math.sin(v)-100)+s.substring(i);
        else if(q.equals("cos"))
            s=s.substring(0,p)+(100+Math.cos(v)-100)+s.substring(i);
        else if(q.equals("tan"))
            s=s.substring(0,p)+(100+Math.tan(v)-100)+s.substring(i);
        else if(q.equals("sIn"))
            s=s.substring(0,p)+(100+((h==0)?Math.toDegrees(Math.asin(v)):Math.asin(v))-100)+s.substring(i);
        else if(q.equals("cOz"))
            s=s.substring(0,p)+(100+((h==0)?Math.toDegrees(Math.acos(v)):Math.acos(v))-100)+s.substring(i);
        else if(q.equals("tAn"))
            s=s.substring(0,p)+(100+((h==0)?Math.toDegrees(Math.atan(v)):Math.atan(v))-100)+s.substring(i);
        if(s.indexOf("NaN")>-1)
            return "#NaN";
        return trigo(s);
    }
    String nCrnPr(String s)
    {
        s=s.trim();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='C' || ch=='P')
            {
                String ns="0123456789.";
                String n="",r="";
                int x,y;
                for(x=i-1;x>=0;x--)
                {
                    char cch=s.charAt(x);
                    if(ns.indexOf(cch)>-1)
                        n=cch+n;
                    else
                        break;
                }
                for(y=i+1;y<s.length();y++)
                {
                    char cch=s.charAt(y);
                    if(ns.indexOf(cch)>-1)
                        r=r+cch;
                    else if(y==i+1 && cch=='+')
                        r=r+cch;
                    else
                        break;
                }

                double nn=Double.parseDouble(n);
                double nr=Double.parseDouble(r);
                if(nn<nr || (long)nn!=nn || (long)nr!=nr)
                    return "#MathError";
                if(ch=='C')
                    s=s.substring(0,x+1)+nCr((long)nn,(long)nr)+s.substring(y);
                else
                    s=s.substring(0,x+1)+nPr((long)nn,(long)nr)+s.substring(y);
                i=-1;

            }
        }
        return s;
    }
    String pie(String s)
    {
        if(s.charAt(0)=='#')
            return s;
        s=s.trim();
        String t="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='e')
                t=t+"("+Math.E+")";
            else if(ch=='π')
                t=t+"("+Math.PI+")";
            else if(ch=='α')
                t=t+"("+var1+")";
            else if(ch=='β')
                t=t+"("+var2+")";
            else if(ch=='γ')
                t=t+"("+var3+")";
            else
                t=t+ch;
        }
        return t;
    }
    String fac(String s)
    {
        if(s.charAt(0)=='#')
            return s;
        s=s.trim()+" ";
        if("+-*/^".indexOf(s.charAt(0))==-1)
            s="+"+s;
        int p=s.indexOf("!"),q=p;
        if("0123456789.".indexOf(s.charAt(p+1))!=-1)
            s=s.substring(0,p+1)+"*"+s.substring(p+1);
        if(p==-1)
            return s;
        else if(p==0)
            return "#Inappropriate Sign Usage";
        String t="";
        for(int i=p-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if("+-*/^CP".indexOf(ch)!=-1)
            {q=i;break;}
            else if(Character.isDigit(ch) || ch=='.')
                t=ch+t;
            else
                return "#Unidentified Symbol";
        }
        if(t.length()==0 || t.equals("."))
            return "#Inappropriate Sign Usage";
        Double l=Double.parseDouble(t);
        if((long)(l*1.0)!=l)
            return "#Domain Error";
        else if(l>65)
            return "#Value Too Large";
        long f=1;
        for(;l>0;l--)
            f=f*(long)(l*1.0);
        s=s.substring(0,q+1)+f+s.substring(p+1);
        return fac(s);
    }
    long nCr(long n,long r)
    {
        double f=1.0;

        for(long i=r+1;i<=n;i++)
            f=f*i;
        for(long i=1;i<=n-r;i++)
            f=f/i;
        return (long)f;
    }
    long nPr(long n,long r)
    {
        double f=1.0;

        for(long i=n-r+1;i<=n;i++)
            f=f*i;
        return (long)f;
    }


    String toFraction(double x){

        if (x < 0){
            return "-" + toFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1; h1 = a*h1+h2; h2 = aux;
            aux = k1; k1 = a*k1+k2; k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);

        return ((int)h1)+((k1==1.0)?"":"/"+((int)k1));
    }
    public void save(String FILE_NAME,String text) {

        FileOutputStream fos = null;
        FILE_NAME=FILE_NAME+".txt";

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String load(String FILE_NAME) {
        FileInputStream fis = null;
        FILE_NAME=FILE_NAME+".txt";
        String r="";
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            r=sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return r;
    }
    public void startRepeating(View v) {
        //mHandler.postDelayed(mToastRunnable, 5000);
        Toast.makeText(getApplicationContext(), "Auto-Remove Activated",Toast.LENGTH_LONG).show();
        mToastRunnable.run();
    }

    public void stopRepeating(View v) {
        if(repeat)
        {
            mHandler.removeCallbacks(mToastRunnable);
            ar="";
        }
        repeat=false;
    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            arrow();
            String temp=l.getText().toString();
            if(temp.length()>0)
                removeFunc(temp);
            l.setText(l.getText().toString()+ar);
            if(l.getText().length()-ar.length()>0)
            mHandler.postDelayed(this, 1250);
        }
    };
}

