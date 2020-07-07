package com.calculator.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView, prev;
    private String mText;
    private SpannableStringBuilder mSSBuilder;
   private static double x = 0.0;
   private static double  y = 0.0;
   static double mulsum=1;
   static double divsum=1;
    int c = 0;
    double sum = 0.0;
    String operator2 = new String();

    Button zero, dot, exp, ans, equal, one, two, three, plush, minus, four, five, six, mult, div, seven, eight, nine, del, ac;

    Button superxy, superxtwo, coss, signn, tann, lnn, logg, first, second, pi,root,mod,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = findViewById(R.id.zero);
        dot = findViewById(R.id.dot);
        exp = findViewById(R.id.exp);
        ans = findViewById(R.id.ans);
        equal = findViewById(R.id.equal);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        plush = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        four = findViewById(R.id.four);
        six = findViewById(R.id.six);
        five = findViewById(R.id.five);
        mult = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        del = findViewById(R.id.del);
        ac = findViewById(R.id.ac);
        age=findViewById(R.id.ageid);

        zero.setOnClickListener(this);
        dot.setOnClickListener(this);
        exp.setOnClickListener(this);
        ans.setOnClickListener(this);
        equal.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        plush.setOnClickListener(this);
        minus.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        del.setOnClickListener(this);
        ac.setOnClickListener(this);
        age.setOnClickListener(this);

        textView = findViewById(R.id.textviewid);
        prev = findViewById(R.id.previd);
// for scientific calculation
        superxy = findViewById(R.id.superxyid);
        superxtwo = findViewById(R.id.supertwoid);
        coss = findViewById(R.id.cosid);
        signn = findViewById(R.id.signid);
        tann = findViewById(R.id.tanid);
        lnn = findViewById(R.id.lnid);
        logg = findViewById(R.id.logid);
        first = findViewById(R.id.firstbaid);
        second = findViewById(R.id.firstbbid);
        root=findViewById(R.id.rootid);
        pi = findViewById(R.id.hypid);
        mod=findViewById(R.id.modid);

        superxy.setOnClickListener(this);
        mod.setOnClickListener(this);
        root.setOnClickListener(this);
        superxtwo.setOnClickListener(this);
        coss.setOnClickListener(this);
        signn.setOnClickListener(this);
        tann.setOnClickListener(this);
        lnn.setOnClickListener(this);
        logg.setOnClickListener(this);
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        pi.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.ageid)
        {
            startActivity(new Intent(MainActivity.this,AgeCalculator.class));
        }

        String n = new String();
        String m = new String();

        String newdata = new String();
        String olddata = new String();
        String operator = new String();
        try {

            if (view.getId() == R.id.mul) {
                n += "X";
                m = textView.getText().toString();
                // prev.setText(m+"x");
                textView.setText(m + n);
                olddata = m;
                x = Double.parseDouble(olddata);
                if (c == 0)
                {
                    y = x;//not work
                    mulsum=x;
                    Log.e("c=0: y=",""+y);
                    Log.e("c=0 x=",""+x);
                }

                if (c > 0)
                {
                    y *= x;//not work
                    mulsum*=x;
                    Log.e("c>0 y= ",""+y);
                    Log.e("c>0 x= ",""+x);
                }

                operator = "X";
                operator2 = operator;
                prev.setText(y + "x");
                Log.e("mul y=",""+y);
                Log.e("mul x= ",""+x);
            }
            if (view.getId()==R.id.modid)
            {
                n += "mod";
                m = textView.getText().toString();
                //  prev.setText(m+"%");
                textView.setText(m + n);
                olddata = m;
                x = Double.parseDouble(olddata);
                if (c == 0)
                    y = x;
                if (c > 0)
                    y %= x;
                operator = "%";
                operator2 = operator;
                prev.setText(y+" mod");
            }

            if(view.getId()==R.id.rootid)
            {
                n += "√";
                operator = "√";
                operator2 = operator;
                m = textView.getText().toString();
                textView.setText(m + n);
                olddata = m;
                x = Double.parseDouble(olddata);
                y = x;
                y = Math.sqrt(y);
                textView.setText("" + y);
                prev.setText("√"+x);


            }
            if (view.getId() == R.id.supertwoid) {
                n += "^";
                m = textView.getText().toString();
                textView.setText(m + n);
                olddata = m;
                x = Double.parseDouble(olddata);
                y = x;
                y = Math.pow(y, 2);

                textView.setText("" + y);
                prev.setText(x + "^2");

                operator = "^2";
                operator2 = operator;

            }
            if (view.getId() == R.id.superxyid) {
                n += "^";
                m = textView.getText().toString();
                textView.setText(m + n);
                olddata = m;
                x = Double.parseDouble(olddata);
                if (c == 0)
                    y = x;
                else
                    y = Math.pow(y, x);

                operator = "^";
                operator2 = operator;
                prev.setText("" + y + "^");
            }

            if (view.getId() == R.id.firstbaid) {
              /*  n += "(";
                m = textView.getText().toString();
                textView.setText(m + n);*/
                Toast.makeText(getApplicationContext(), "unable", Toast.LENGTH_SHORT).show();

            }
            if (view.getId() == R.id.hypid) {
                n += "3.14159265358979";
                m = textView.getText().toString();
                textView.setText(m + n);

            }
            if (view.getId() == R.id.firstbbid) {

                Toast.makeText(getApplicationContext(), "unable", Toast.LENGTH_SHORT).show();

            }
            if (view.getId() == R.id.signid) {

                n += "sin ";
                m = textView.getText().toString();
                textView.setText(m + n);

                operator = "sin";
                operator2 = operator;

            }

            if (view.getId() == R.id.cosid) {
                n += "cos ";
                m = textView.getText().toString();
                textView.setText(m + n);

                operator = "cos";
                operator2 = operator;
            }

            if (view.getId() == R.id.tanid) {
                n += "tan ";
                m = textView.getText().toString();
                textView.setText(m + n);

                operator = "tan";
                operator2 = operator;
            }

            if (view.getId() == R.id.logid) {
                n += "log ";
                m = textView.getText().toString();
                textView.setText(m + n);

                operator = "log";
                operator2 = operator;
            }
            if (view.getId() == R.id.lnid) {
                n += "ln ";
                m = textView.getText().toString();
                textView.setText(m + n);

                operator = "ln";
                operator2 = operator;
            }
            if (view.getId() == R.id.zero) {
                n += "0";
                m = textView.getText().toString();
                textView.setText(m + n);
                x = 0;
                y = 0;
            }
            if (view.getId() == R.id.dot) {
                n += ".";
                m = textView.getText().toString();
                textView.setText(m + n);
            }
            if (view.getId() == R.id.exp) {

            }
            if (view.getId() == R.id.ans) {


            }


            if (view.getId() == R.id.one) {
                n += "1";
                m = textView.getText().toString();
                textView.setText(m + n);
            }
            if (view.getId() == R.id.two) {
                n += "2";
                m = textView.getText().toString();
                textView.setText(m + n);
            }
            if (view.getId() == R.id.three) {
                n += "3";
                m = textView.getText().toString();
                textView.setText(m + n);
            }
            if (view.getId() == R.id.plus) {

                n += "+";
                m = textView.getText().toString();

                textView.setText(m + n);
                olddata = m;
                x = Double.parseDouble(olddata);
                if (c == 0)
                    y = x;
                if (c > 0)
                    y += x;
                operator = "+";
                operator2 = operator;
                prev.setText(y + "+");

            }
            if (view.getId() == R.id.minus) {
                n += "-";
                m = textView.getText().toString();
                //  prev.setText(m+"-");
                textView.setText(m + n);
                olddata = m;
                x = Double.parseDouble(olddata);
                if (c == 0) {
                    y = x;
                    sum = x;
                }

                if (c > 0) {
                    y = sum - x;
                    sum = y;

                }
                operator = "-";
                operator2 = operator;
                prev.setText(y + "-");

            }
            if (view.getId() == R.id.four) {
                n += "4";
                m = textView.getText().toString();
                textView.setText(m + n);

            }
            if (view.getId() == R.id.five) {
                n += "5";
                m = textView.getText().toString();
                textView.setText(m + n);
            }
            if (view.getId() == R.id.six) {
                n += "6";
                m = textView.getText().toString();
                textView.setText(m + n);
            }

            if (view.getId() == R.id.div) {

              /*  n += "/";
                m = textView.getText().toString();
                textView.setText("");
                prev.setText(prev.getText() + m + n);

                double value = Double.parseDouble(m);
               // Toast.makeText(getApplicationContext(), "" + value + " " + sum, Toast.LENGTH_SHORT).show();
                sum /= value;

                operator = "/";
                operator2 = operator;*/

                n += "/";
                m = textView.getText().toString();
                // prev.setText(m+"/");
                textView.setText(m + n);
                olddata = m;
                x = Double.parseDouble(olddata);
                if (c == 0)
                {
                    divsum=x;
                    y = x;
                }

                if (c > 0)
                {
                    divsum/=x;
                    y /= x;
                }

                operator = "/";
                operator2 = operator;
                prev.setText(y + "/");


            }
            if (view.getId() == R.id.seven) {
                n += "7";
                m = textView.getText().toString();
                textView.setText(m + n);

            }
            if (view.getId() == R.id.eight) {
                n += "8";
                m = textView.getText().toString();
                textView.setText(m + n);
            }
            if (view.getId() == R.id.nine) {
                n += "9";
                m = textView.getText().toString();
                textView.setText(m + n);

            }
            if (view.getId() == R.id.del) {
                m = textView.getText().toString();

                if (m.contains("NumberFormat Error")) {
                    textView.setText("");
                    y = 0;
                } else {
                    if (m.length() != 0)
                        textView.setText(m.substring(0, m.length() - 1));

                }

            }
            if (view.getId() == R.id.ac) {
                textView.setText("");
                prev.setText("");
                x = 0;
                y = 0;
            }

            if (view.getId() == R.id.equal) {
                try {
                    m = textView.getText().toString();
                    char s = m.charAt(0);


                    if (s != 's' && s != 'c' && s != 't' && s != 'l') {
                        if (m.contains("+") || m.contains("-") || m.contains("*") || m.contains("/")) {
                        } else {
                            try {
                                x = Double.parseDouble(m);
                                Log.e("equal x=: ",""+x);
                                Log.e("equal y=: ",""+y);
                            } catch (Exception e) {
                                //Toast.makeText(getApplicationContext(), "call", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    if (operator2.equals("sin")) {

                        try {
                            StringBuilder si = new StringBuilder();
                            si.append(m);
                            si.reverse();
                            if (si.length() > 4) {
                                StringBuilder num = new StringBuilder();
                                num.append(si.substring(0, si.length() - 4));
                                num.reverse();

                                try {
                                    x = Double.parseDouble(num.toString());
                                    //  prev.setText(textView.getText().toString());
                                    textView.setText(" " + Math.sin(Math.toRadians(x)));
                                } catch (Exception e) {
                                    textView.setText("error");
                                    prev.setText("");
                                }

                            }
                        } catch (Exception e) {
                            textView.setText("error");
                        }
                    }

                    if (operator2.equals("cos")) {
                        boolean flag = true;
                        try {

                            StringBuilder si = new StringBuilder();
                            si.append(m);
                            si.reverse();
                            if (si.length() > 4) {
                                StringBuilder num = new StringBuilder();
                                num.append(si.substring(0, si.length() - 4));
                                num.reverse();
                                try {
                                    x = Double.parseDouble(num.toString());

                                    if (x == 90.0) {
                                        textView.setText("0.0");
                                    } else {
                                        textView.setText(" " + Math.cos(Math.toRadians(x)));
                                    }
                                } catch (Exception e) {
                                    textView.setText("error");
                                    prev.setText("");
                                }
                            }
                        } catch (Exception e) {
                            textView.setText("error");
                        }
                    }

                    if (operator2.equals("tan")) {
                        boolean flag = true;
                        try {

                            StringBuilder si = new StringBuilder();
                            si.append(m);
                            si.reverse();
                            if (si.length() > 4) {
                                StringBuilder num = new StringBuilder();
                                num.append(si.substring(0, si.length() - 4));

                                num.reverse();
                                try {
                                    x = Double.parseDouble(num.toString());
                                    if (x == 90.0) {
                                        textView.setText("∞");
                                    } else {
                                        textView.setText(" " + Math.tan(Math.toRadians(x)));
                                    }
                                } catch (Exception e) {
                                    textView.setText("error");
                                    prev.setText("");
                                }

                            }

                        } catch (Exception e) {
                            textView.setText("error");
                        }
                    }

                    if (operator2.equals("log")) {
                        boolean flag = true;
                        try {

                            StringBuilder si = new StringBuilder();
                            si.append(m);
                            si.reverse();
                            if (si.length() > 4) {
                                StringBuilder num = new StringBuilder();
                                num.append(si.substring(0, si.length() - 4));

                                num.reverse();

                                try {
                                    x = Double.parseDouble(num.toString());
                                    textView.setText(" " + Math.log10(x));
                                } catch (Exception e) {
                                    textView.setText("error");
                                    prev.setText("");
                                }

                            }
                        } catch (Exception e) {
                            textView.setText("error");
                        }
                    }

                    if (operator2.equals("ln")) {
                        boolean flag = true;
                        try {

                            StringBuilder si = new StringBuilder();
                            si.append(m);
                            si.reverse();
                            if (si.length() > 3) {
                                StringBuilder num = new StringBuilder();
                                num.append(si.substring(0, si.length() - 3));


                                num.reverse();

                                try {
                                    x = Double.parseDouble(num.toString());
                                    textView.setText(" " + Math.log(x));
                                } catch (Exception e) {
                                    textView.setText("error");
                                    prev.setText("");
                                }
                            }

                        } catch (Exception e) {
                            textView.setText("error");
                        }
                    }


                    //   x = Double.parseDouble(m);
                    //textView.setText("");
                    //  prev.setText("");
                    if (operator2.equals("+")) {
                        y += x;
                        prev.setText("");
                        textView.setText("" + (y));
                    }
                    if (operator2.equals("-")) {
                        y = sum - x;
                        sum = y;
                        prev.setText("");
                        textView.setText("" + (y));
                    }
                    if (operator2.equals("X")) {
                        Log.e("before mul ",""+y);
                        y *= x;//not work
                        mulsum*=x;
                        prev.setText("");
                        textView.setText("" + (mulsum));
                        Log.e("after mul",""+y);

                    }
                    if (operator2.equals("/")) {
                        y /= x;//not work
                        divsum/=x;
                        prev.setText("");
                        textView.setText("" + (divsum));
                    }
                    if (operator2.equals("%")) {
                        y %= x;
                        prev.setText("");
                        textView.setText("" + (y));
                    }
                    if (operator2.equals("^")) {
                        y = Math.pow(y, x);
                        prev.setText("");
                        textView.setText("" + (y));
                    }
                    if (operator2.equals("^2")) {
                        prev.setText("");
                        // textView.setText("" + (y));
                    }
                    if (operator2.equals("√"))
                    {
                        prev.setText("");
                    }


                    c = 0;


                } catch (Exception e) {
                    textView.setText("error");
                    prev.setText("");
                 //   Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_LONG).show();
                }
            }

        } catch (Exception e) {

         // Toast.makeText(getApplicationContext(),"call",Toast.LENGTH_SHORT).show();
            textView.setText("");
            prev.setText("");

        }
        switch (operator) {
            case "+": {
                c++;
                textView.setText("");
                break;
            }
            case "-": {
                c++;
                textView.setText("");
                break;
            }
            case "X": {
                c++;
                textView.setText("");
                break;
            }
            case "/": {
                c++;
                textView.setText("");
                break;
            }
            case "^": {
                c++;
                textView.setText("");
                break;
            }
            case "%": {
                c++;
                textView.setText("");
                break;
            }

        }

    }
}

