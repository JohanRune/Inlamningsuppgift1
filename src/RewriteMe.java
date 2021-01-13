
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/*
Inlämningsuppgit i kursen Funktionell Programmering för JAVA-programmet
För samtliga funktioner i denna fil, byt ut "throw UnSupportedException"-raden
och skriv ett pipeline-uttryck som returnerar det som ska returneras.
Streams MÅSTE användas i samtliga funktioner som lämnas in
För att testa om era funktioner funkar, kör testerna som hör till denna fil
För att bli godkänd på denna uppgift måste minst 7 av funktionerna vara implementerade.
Sigruns bedömning av denna uppgift kommer att gå till så att hon klipper in er version av denna fil
i sitt projekt och kör testerna.
Hennes kontroll om ni har klarat uppgifterna eller inte görs genom att
hon kollar att tillräckeligt många av tester går gröna. Pga detta ska ni inte ändra i någon fil
medföljande detta projekt, och inte heller metodsignaturerna i denna fil eller era tester, eftersom
ni då riskerar att påverka rättningen i negativ riktning.
 */

public class RewriteMe {

    public Database database = new Database();
    public List<Question> questions = database.getQuestions();

    //Skriv en funktioner som returnerar hur många frågor det finns i databasen?
    //fungerar
    public int getAmountOfQuestionsInDatabase(){

        return (int) questions.stream().count();

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    //Hur många frågor finns i databasen för en viss, given kategori (som ges som inparameter)
    //fungerar
    public int getAmountOfQuestionsForACertainCategory(Category category){

        return antalFrågorIKategori(category, questions);
    }

    //metod till getAmountOfQuestionsForACertainCategory
    public int antalFrågorIKategori (Category category, List<Question> lista){
        return (int) lista.stream().filter(s -> s.getCategory().equals(category)).count();
    }


    //Skapa en lista innehållandes samtliga frågesträngar i databasen
    // fungerar
    public List<String> getListOfAllQuestions(){

        return questions.stream().map (b -> b.getQuestionString()).collect(Collectors.toList());

//        throw new UnsupportedOperationException("Not supported yet.");
    }







    //Skapa en lista innehållandes samtliga frågesträngar där frågan tillhör en viss kategori
    //Kategorin ges som inparameter
    //fungerar
    public List<String> getAllQuestionStringsBelongingACategory(Category category){


        return frågorIKategori(category, questions);

        //throw new UnsupportedOperationException("Not supported yet.");

    }

    //metod till getAllQuestionStringsBelongingACategory
    public List<String> frågorIKategori (Category category, List<Question> lista){
        return lista.stream().filter(s -> s.getCategory().equals(category)).map(b -> b.getQuestionString()).collect(Collectors.toList());
    }

    //Skapa en lista av alla svarsalternativ, där varje svarsalternativ får förekomma
    // en och endast en gång i den lista som du ska returnera
    //fungerar
    public List<String> getAllAnswerOptionsDistinct(){

        //List<List<String>> listaMedListor = questions.stream().map(b -> b.getAllAnswers()).collect(Collectors.toList());
        //return listaMedListor.stream().flatMap(value -> value.stream()).distinct().collect(Collectors.toList());

        return questions.stream().map(b -> b.getAllAnswers()).collect(Collectors.toList())
                .stream().flatMap(f -> f.stream()).distinct().collect(Collectors
                        .toList());


        //        throw new UnsupportedOperationException("Not supported yet.");

    }

    //Finns en viss sträng, given som inparameter, som svarsalternativ till någon fråga i vår databas?
    //Fungerar.
    public boolean isThisAnAnswerOption(String answerCandidate){

        return questions.stream().map(l -> l.getAllAnswers())
                .collect(Collectors.toList()).stream().flatMap(f -> f.stream())
                .anyMatch(l -> l.equalsIgnoreCase(answerCandidate));
    }



    //Hur ofta förekommer ett visst svarsalternativ, givet som inparameter, i databasen
    //fungerar
    public int getAnswerCandidateFrequncy(String answerCandidate){

        return (int) questions.stream().map(l -> l.getAllAnswers())
                .collect(Collectors.toList()).stream().flatMap(f -> f.stream())
                .filter(l -> l.equalsIgnoreCase(answerCandidate)).count();
    }




    //Skapa en Map där kategorierna är nycklar och värdena är en lista
    //av de frågesträngar som tillhör varje kategori
    public Map<Category, List<String>> getQuestionGroupedByCategory(){
        // först gör om listan med frågeobjekt till en lista med kategori och frågor.


        //return questions.stream().collect(groupingBy(n -> n.));


        throw new UnsupportedOperationException("Not supported yet.");
    }



        //Skapa en funktion som hittar det svarsalternativ som har flest bokstäver, i en kategori, given som inparameter
    // OBS: Du måste använda Reduce!
    public String getLongestLettercountAnwerInAGivenCategory(Category c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public static void main(String[] args){
        RewriteMe uppg4 = new RewriteMe();

    }

}