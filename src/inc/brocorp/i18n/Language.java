package inc.brocorp.i18n;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Language {

    private String language;

    public Language(String language){
        this.language = language;
    }

    public static ObservableList<Language> getLanguageList() {
        Language ru_lang = new Language("Русский");
        Language en_lang = new Language("English");

        ObservableList<Language> list 
                = FXCollections.observableArrayList(ru_lang, en_lang);

        return list;
    }

    @Override
    public String toString(){
        return this.language;
    }
}
