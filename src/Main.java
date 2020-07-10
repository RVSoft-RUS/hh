import java.util.List;

public class Main {
    public static void main(String[] args) {
        HH_Searcher searcher = new HH_Searcher();
        List<Vacancy> list = searcher.getVacancies("Москва");
        list.forEach(x ->
        {
            if (x.getSalary().length() > 1) {
                System.out.println(x);
                System.out.println(x.parseMinMaxSalary() + " , min=" + x.minSalary() + " , max=" + x.maxSalary());
            }
        });
    }
}
