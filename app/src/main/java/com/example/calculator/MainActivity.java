package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String ARG_CALCULATOR = "ARG_CALCULATOR";

    private Calculator calculator;

    private TextView textOfResult;
    private TextView textOfProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            calculator = new Calculator();
        } else calculator = savedInstanceState.getParcelable(ARG_CALCULATOR);

        initView();

    }

    private void initView() {

        textOfResult = findViewById(R.id.result_display);
        textOfResult.setText(String.valueOf(calculator.getValueOfResult()));

        textOfProcess = findViewById(R.id.process_display);
        textOfProcess.setText(String.valueOf(calculator.getValueOfProcess()));

        initButtonClickListeners();

    }

    private void initButtonClickListeners() {

        findViewById(R.id.btn_zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("0");
                setText();
            }
        });

        findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("1");
                setText();
            }
        });

        findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("2");
                setText();
            }
        });

        findViewById(R.id.btn_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("3");
                setText();
            }
        });

        findViewById(R.id.btn_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("4");
                setText();
            }
        });

        findViewById(R.id.btn_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("5");
                setText();
            }
        });

        findViewById(R.id.btn_six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("6");
                setText();
            }
        });

        findViewById(R.id.btn_seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("7");
                setText();
            }
        });

        findViewById(R.id.btn_eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("8");
                setText();
            }
        });

        findViewById(R.id.btn_nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addNum("9");
                setText();
            }
        });

        findViewById(R.id.btn_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addPoint();
                setText();
            }
        });

        findViewById(R.id.btn_ac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.clear();
                setText();
            }
        });

        findViewById(R.id.btn_backspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.backspace();
                setText();
            }
        });

        findViewById(R.id.btn_division).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addMainOperation('÷');
                setText();
            }
        });

        findViewById(R.id.btn_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addMainOperation('×');
                setText();
            }
        });

        findViewById(R.id.btn_subtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addMainOperation('-');
                setText();
            }
        });

        findViewById(R.id.btn_addition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addMainOperation('+');
                setText();
            }
        });

        findViewById(R.id.btn_plus_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addPlusMinus();
                setText();
            }
        });

        findViewById(R.id.btn_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addEqual();
                setText();
            }
        });

    }

    private void setText() {
        textOfResult.setText(String.valueOf(calculator.getValueOfResult()));
        textOfProcess.setText(String.valueOf(calculator.getValueOfProcess()));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(ARG_CALCULATOR, calculator);
    }
}