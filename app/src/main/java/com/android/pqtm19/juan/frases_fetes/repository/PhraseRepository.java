package com.android.pqtm19.juan.frases_fetes.repository;

import com.android.pqtm19.juan.frases_fetes.models.Phrase;
import com.android.pqtm19.juan.frases_fetes.utils.Constants;
import com.android.pqtm19.juan.frases_fetes.utils.IPhraseDao;

import java.util.ArrayList;
import java.util.List;

public class PhraseRepository implements IPhraseDao {

    private List<Phrase> mPhraseRepository;

    public PhraseRepository(){
        mPhraseRepository = new ArrayList<>();
        mPhraseRepository.add(new Phrase(1, "A bocajarro","Anònim" , Constants.PHRASE));
        mPhraseRepository.add(new Phrase(2, "Vísteme despacio que tengo prisa","Anònim" ,
                Constants.TIP));
        mPhraseRepository.add(new Phrase(3, "Hablar por los codos","Anònim" ,
                Constants.PHRASE));
        mPhraseRepository.add(new Phrase(4, "Al pan,pan y al vino, vino.","Anònim" ,
                Constants.TIP));
        mPhraseRepository.add(new Phrase(5, "Como gato panza arriba","Anònim" ,
                Constants.PHRASE));
        mPhraseRepository.add(new Phrase(6, "Disciplina espartana","Anònim" ,
                Constants.PHRASE));
        mPhraseRepository.add(new Phrase(7, "Díme con quién andas y si está buena me la mandas!",
                "Anònim", Constants.TIP));
        mPhraseRepository.add(new Phrase(8, "Si quieres que algo salga bien, hazlo tú mismo!!",
                "Anònim", Constants.TIP));
    }

    public List<Phrase> getPopularPhrasesList(){ return setFilter(Constants.PHRASE); }

    public List<Phrase> getTipsList(){
        return setFilter(Constants.TIP);
    }

    @Override
    public Phrase getPhraseById(int phraseId) {

        for(Phrase phraseInmPhraseRepository : mPhraseRepository){
            if (phraseInmPhraseRepository.getId() == phraseId) {
                return phraseInmPhraseRepository;
            }
        }
        return mPhraseRepository.get(1);
    }

    private List<Phrase> setFilter(int type) {
        List<Phrase> resultList = new ArrayList<>();

        for(Phrase phraseInmPhraseRepository: mPhraseRepository){
            if(phraseInmPhraseRepository.getType() == type) { resultList.add(phraseInmPhraseRepository); }
        }
        return resultList;
    }
}
