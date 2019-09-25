package com.android.pqtm19.juan.frases_fetes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.android.pqtm19.juan.frases_fetes.databinding.ActivityDetailBinding;
import com.android.pqtm19.juan.frases_fetes.models.Phrase;
import com.android.pqtm19.juan.frases_fetes.utils.Constants;

import java.util.List;
import java.util.Random;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding bindingDetailObject;
    private List<Phrase> mPhraseList;
    private final Random randomObject = new Random();
    Phrase phraseObject;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingDetailObject = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        PhraseApplication app = (PhraseApplication) getApplication();

        mPhraseList = (getIntent().getExtras().getInt(Constants.INTENT_EXTRA_TAG) == 1) ?
                app.getmTipsList() : app.getmPopularPhrasesList();


        phraseObject = getPhraseObject();
        showPhraseResult();

        if (savedInstanceState != null){
            phraseObject = app.getPhraseById(savedInstanceState.getInt(Constants.TAG, 1));
        }

        bindingDetailObject.phraseResultTextView.setText(phraseObject.getText());
        bindingDetailObject.authorTextView.setText(phraseObject.getAutor());
        bindingDetailObject.yLoSabesImageView.setImageResource(R.drawable.julio_iglesias);

        bindingDetailObject.reloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phraseObject = getPhraseObject();
                showPhraseResult();
            }
        });

    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(Constants.TAG, phraseObject.getId());
        super.onSaveInstanceState(savedInstanceState);
    }

    private void showPhraseResult(){
        bindingDetailObject.phraseResultTextView.setText(phraseObject.getText());

        bindingDetailObject.authorTextView.setText(mPhraseList.get(randomObject
                .nextInt(mPhraseList.size())).getAutor());
    }

    private Phrase getPhraseObject(){ return mPhraseList.get(randomObject.nextInt(mPhraseList.size())); }
}

