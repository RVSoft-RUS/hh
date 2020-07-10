import java.util.Objects;

public class Vacancy {
    private String title;
    private String salary;
    private String city;
    private String companyName;
    private String siteName;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(title, vacancy.title) &&
                Objects.equals(salary, vacancy.salary) &&
                Objects.equals(city, vacancy.city) &&
                Objects.equals(companyName, vacancy.companyName) &&
                Objects.equals(siteName, vacancy.siteName) &&
                Objects.equals(url, vacancy.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, salary, city, companyName, siteName, url);
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "title='" + title + '\'' +
                ", salary='" + salary + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", siteName='" + siteName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public int minSalary() {
        if (salary == null || salary.isEmpty()) {
            return 0;
        }
        String pSalary = parseMinMaxSalary();
        if (pSalary.startsWith("?")) {
            return 0;
        } else {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            char c = pSalary.charAt(i);
            while ( c != '-') {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
                c = pSalary.charAt(++i);
            }
            return Integer.parseInt(sb.toString());
        }
    }

    public int maxSalary() {
        if (salary == null || salary.isEmpty()) {
            return 0;
        }
        String pSalary = parseMinMaxSalary();
        if (pSalary.endsWith("?")) {
            return 0;
        } else {
            int i = 0;
            char c = pSalary.charAt(i);
            while ( c != '-') {
                c = pSalary.charAt(++i);
            }
            return Integer.parseInt(pSalary.substring(i + 1));
        }
    }

    public String parseMinMaxSalary() {
        StringBuilder sb = new StringBuilder(salary.length());
        if (salary.contains("до")) {
            sb.append("?-");
        }
        for (int i = 0; i < salary.length(); i++) {
            char c = salary.charAt(i);
            if (Character.isDigit(c) || c=='-') {
                sb.append(c);
            }
        }
        if (salary.contains("от")) {
            sb.append("-?");
        }
        return sb.toString();
    }
}
