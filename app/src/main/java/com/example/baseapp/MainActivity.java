package com.example.baseapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
            R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7,
            R.id.BtnNum8, R.id.BtnNum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);

        // 더하기 버튼 이벤트
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        // 빼기 버튼 이벤트
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        // 곱하기 버튼 이벤트
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        // 나누기 버튼 이벤트
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (!num2.equals("0")) {
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                } else {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        // 숫자 버튼 초기화 및 이벤트 설정
        for (i = 0; i< numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for (i = 0; i < numBtnIDs.length; i++) {
            final int index; // 주의! 꼭 필요함
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {

                    if (edit1.isFocused()) {
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused()) {
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
