package de.math.vectorproductcalc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class VectorProductCalcActivity extends Activity {

	private EditText a1EditText;
	private EditText a2EditText;
	private EditText a3EditText;
	private EditText b1EditText;
	private EditText b2EditText;
	private EditText b3EditText;
	private EditText c1EditText;
	private EditText c2EditText;
	private EditText c3EditText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_product_calc);
        a1EditText = (EditText)findViewById(R.id.a1editText);
        a2EditText = (EditText)findViewById(R.id.a2editText);
        a3EditText = (EditText)findViewById(R.id.a3editText);
        b1EditText = (EditText)findViewById(R.id.b1EditText);
        b2EditText = (EditText)findViewById(R.id.b2EditText);
        b3EditText = (EditText)findViewById(R.id.b3EditText);
        c1EditText = (EditText)findViewById(R.id.c1EditText);
        c2EditText = (EditText)findViewById(R.id.c2EditText);
        c3EditText = (EditText)findViewById(R.id.c3EditText);
    }
    
    public void onCalculateButtonClick(View view) {
    	printVectorProduct();
    }
    
    
    // c1 = (a2 * b3) - (a3 * b2)
    // c2 = (a3 * b1) - (a1 * b3)
    // c3 = (a1 * b2) - (a2 * b1)
    private void printVectorProduct() {
    	double a1 = getEditTextValue(a1EditText);
    	double a2 = getEditTextValue(a2EditText);
    	double a3 = getEditTextValue(a3EditText);
    	double b1 = getEditTextValue(b1EditText);
    	double b2 = getEditTextValue(b2EditText);
    	double b3 = getEditTextValue(b3EditText);
    	
    	c1EditText.setText(round(calculate(a2, b3, a3, b2)));
    	c2EditText.setText(round(calculate(a3, b1, a1, b3)));
    	c3EditText.setText(round(calculate(a1, b2, a2, b1)));
    }
    
    private double getEditTextValue(EditText editText) {
    	if (editText.getText().toString().equals("")) {
    		return 0;
    	} else {
    		return Double.parseDouble(editText.getText().toString());
    	}
    }
    
    private String round(double a) {
    	if ((a - (int)a) == 0) {
    		return String.valueOf(Math.round(a * 100)/100);
    	} else {
    		return String.valueOf(a);
    	}
    }
    
    private double calculate(double a, double b, double c, double d) {
    	return (a * b) - (c * d);
    }
    
    public void onResetButtonClick(View view) {
    	a1EditText.setText("");
    	a2EditText.setText("");
    	a3EditText.setText("");
    	b1EditText.setText("");
    	b2EditText.setText("");
    	b3EditText.setText("");
    	c1EditText.setText("");
    	c2EditText.setText("");
    	c3EditText.setText("");
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vector_product_calc, menu);
        return true;
    }
}