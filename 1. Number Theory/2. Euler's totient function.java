/*
 Notes:

 Euler's totient function¶
Euler's totient function, also known as phi-function  
$\phi (n)$ , counts the number of integers between 1 and  
$n$  inclusive, which are coprime to  
$n$ . Two numbers are coprime if their greatest common divisor equals  
$1$  ( 
$1$  is considered to be coprime to any number).

Here are values of  
$\phi(n)$  for the first few positive integers:

 
 */


 int phi(int n) {
    int result = n;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            while (n % i == 0)
                n /= i;
            result -= result / i;
        }
    }
    if (n > 1)
        result -= result / n;
    return result;
}