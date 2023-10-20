
Autor: Konrad Laskowski 

# Zawody Strzeleckie

Witam w aplikacji służącej do symulacji Dorocznych Zawodach Strzeleckich

# Opis

Celem zawodów jest strzelanie do tarczy w kształcie prostokąta. Tarcza jest podzielona na r wierszy i `c kolumn, składając się z r x c kwadratowych pól. Każde pole jest albo czarne albo białe, gdzie w każdej kolumnie są dokładnie dwa białe pola. 

Aby uznać serię strzałów za poprawną, zawodnik musi trafić dokładnie w jedno białe pole w każdej kolumnie, nie pozostawiając żadnego wiersza bez trafionego białego pola.

Aplikacja pomaga zawodnikowi znaleźć poprawną serię strzałów, jeśli taka istnieje.

# Funkcje

- Wczytywanie liczby bloków danych z pliku 'SHO.IN', gdzie każdy blok zawiera opis jednej tarczy.
- Sprawdzanie czy istnieje poprawna seria strzałów dla każdej tarczy.
- Zapisywanie wyników w pliku 'SHO.OUT'.

# Wymagania:

- Java JDK 17 lub nowsza
- Maven (zalecana wersja 3.x)

# Instalacja i uruchomienie:

1. Sklonuj repozytorium:
  
   git clone 

2. Przejdź do folderu projektu:

   cd my-app


3. Skompiluj i zbuduj projekt:
   
   mvn clean install
   

4. Uruchom aplikację:
   
   mvn exec:java

# Testy:

Aby uruchomić testy, użyj poniższego polecenia w katalogu głównym projektu:

   mvn test

