import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        //TODO
        Collections.sort(sortedByName,Comparator.comparing(Country::getName));
        return sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        //TODO
        Collections.sort(sortedByPopulation , Comparator.comparing(Country::getPopulation).reversed());
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        //TODO
        Collections.sort(sortedByArea , Comparator.comparing(Country::getArea).reversed());
        return sortedByArea;
    }

    public void setUp() throws IOException {

        //Parse the HTML file using Jsoup
        //TODO
        File input = new File("src\\Resources\\country-list.html");
        Document doc = Jsoup.parse(input,null);

        // Extract data from the HTML
        //TODO
        Elements divs = doc.selectFirst("section#countries").select("div.col-md-4.country");

        // Iterate through each country div to extract country data
        //TODO
        for (Element div : divs) {
            String name = div.select(".country-name").text();
            String capital = div.select(".country-capital").text();
            int population = Integer.parseInt(div.select(".country-population").text());
            double area = Double.parseDouble(div.select(".country-area").text());
            Country country = new Country(name,capital,population,area);
            Parser.countries.add(country);
        }
    }

    public static void main(String[] args) {
        //you can test your code here before you run the unit tests ;)
        Parser test = new Parser();
        try {
            test.setUp();
            test.menu(test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public void menu(Parser test) throws IOException{
        System.out.println("Welcome\n");
        for (int i = 0; i < countries.size() ; i++) {
            System.out.println(i + countries.get(i).toString());
        }
        loop:
        while (true) {
            System.out.println("\nSortBy : Name - Population - Area - Back");
            Scanner in = new Scanner(System.in);
            String input = in.next();
            switch (input) {
                case "Name":
                    List<Country> name = test.sortByName();
                    FileWriter nameWriter = new FileWriter("sortByName.txt");
                    for (int i = 0; i < name.size(); i++) {
                        nameWriter.write(i + name.get(i).toString());
                    }
                    nameWriter.close();
                    System.out.println("Now a \"sortByName.txt\" file save in your computer with data you want!");
                    break;
                case "Population":
                    List<Country> population = test.sortByPopulation();
                    FileWriter populationWriter = new FileWriter("sortByPopulation.txt");
                    for (int i = 0; i < population.size(); i++) {
                        populationWriter.write(i + population.get(i).toString());
                    }
                    populationWriter.close();
                    System.out.println("Now a \"sortByPopulation.txt\" file save in your computer with data you want!");
                    break;
                case "Area":
                    List<Country> area = test.sortByArea();
                    FileWriter areaWriter = new FileWriter("sortByArea.txt");
                    for (int i = 0; i < area.size(); i++) {
                        areaWriter.write(i + area.get(i).toString());
                    }
                    areaWriter.close();
                    System.out.println("Now a \"sortByArea.txt\" file save in your computer with data you want!");
                    break;
                case "Back":
                    break loop;
                default:
                    System.out.println("You entered a wrong phrase!");
            }
        }
        System.out.println("Thanks for using^^");
    }
}
