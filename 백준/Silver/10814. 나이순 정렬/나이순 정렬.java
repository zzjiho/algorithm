import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person implements Comparable<Person> {
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int compareTo(Person o) {
        return this.age - o.age; // 나이순으로 오름차순
    }
}

public class Main {

    static void solution(ArrayList<Person> person) {
        Collections.sort(person);

        for (Person x : person) {
            System.out.println(x.age + " " + x.name);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        ArrayList<Person> person = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            person.add(new Person(a, b));
        }

        solution(person);
    }
}