package com.android.pqtm19.juan.frases_fetes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.pqtm19.juan.frases_fetes.databinding.ActivityMainBinding;
import com.android.pqtm19.juan.frases_fetes.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bindingObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingObject = DataBindingUtil.setContentView(this,R.layout.activity_main);

        bindingObject.tipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { sendIntent(1); }
        });

        bindingObject.phraseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { sendIntent(2); }
        });
    }

    private void sendIntent(int value){
        Intent toDetailActivityIntent = new Intent(MainActivity.this,
                DetailActivity.class);

        toDetailActivityIntent.putExtra(Constants.INTENT_EXTRA_TAG, value);
        startActivity(toDetailActivityIntent);
    }
}
