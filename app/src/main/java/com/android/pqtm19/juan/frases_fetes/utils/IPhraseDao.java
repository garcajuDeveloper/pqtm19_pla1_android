package com.android.pqtm19.juan.frases_fetes.utils;

import com.android.pqtm19.juan.frases_fetes.models.Phrase;

import java.util.List;

public interface IPhraseDao {

    List<Phrase> getPopularPhrasesList();
    List<Phrase> getTipsList();
    Phrase getPhraseById(int phraseId);
}
