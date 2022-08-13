import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersGenerator {

    // создание списка простых чисел, принимает лимит значений
    public List<Integer> getFirstPrimes(int count) {
        List<Integer> prime = new ArrayList<>();
        prime.add(0);
        prime.add(1);
        List<Integer> primes = new ArrayList<>();
        if (count > 0) {
            primes.add(2);
        }
        for (var i = 3; i < count; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
                System.out.println(i);
            }
        }
        prime.addAll(primes);
        return prime;
    }

    // метод для проверки является ли число простым, принимает число из списка
    private boolean isPrime(int n, List<Integer> primes) {
        double sqrt = Math.sqrt(n);
        for (var i = 0; i < primes.size(); i++) {
            var prime = primes.get(i);
            if (prime > sqrt) {
                return true;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
