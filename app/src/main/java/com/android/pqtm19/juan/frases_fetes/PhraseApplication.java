package com.android.pqtm19.juan.frases_fetes;

import android.app.Application;

import com.android.pqtm19.juan.frases_fetes.models.Phrase;
import com.android.pqtm19.juan.frases_fetes.repository.PhraseRepository;
import com.android.pqtm19.juan.frases_fetes.utils.IPhraseDao;

import java.util.List;

public class PhraseApplication extends Application {
    private List<Phrase> mPopularPhrasesList;
    private List<Phrase> mTipsList;
    private IPhraseDao phraseDao = new PhraseRepository();

    @Override
    public void onCreate() {
        super.onCreate();
        mPopularPhrasesList = phraseDao.getPopularPhrasesList();
        mTipsList = phraseDao.getTipsList();
    }

    public List<Phrase> getmPopularPhrasesList(){ return mPopularPhrasesList; }

    public List<Phrase> getmTipsList(){ return  mTipsList; }

    public Phrase getPhraseById(int id){ return phraseDao.getPhraseById(id);}
}
