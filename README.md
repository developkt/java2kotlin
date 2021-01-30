# java2kotlin
> Der praktische Umsteiger-Guide von Java zu Kotlin mit dem Spring Boot Framework

Dieses Repository beinhaltet das Demoprojekt, das in meinem Udemy Kurs
[Kotlin für Spring Boot Java-Entwickler](https://www.udemy.com/course/kotlin-fur-java-spring-boot-entwickler/) verwendet
wird.

## Lernziele

* Der praktische Guide für alle die Spring Boot mit Java nutzen, aber auf Kotlin umsteigen möchten.
* Binde Kotlin in bestehende Spring Boot Projekte ein und nutze Kotlin parallel zu Java.
* Erfahre die nützlichsten Sprachfeatures von Kotlin, die dir bei deiner täglichen Arbeit helfen.

## Themen des Online-Kurses

* Klassen, Data Classes, Enums
* Funktionen, Single Expression Functions
* Initialisierung von Klassen
* `init`, `constructor`
* Kontrollstrukturen mit `if` und `when`
* String templates
* Lambda Ausdrücke (`map`, `fold`, `forEach`)
* Variablendeklaration (`val`, `var`)
* Nullable/Non-Nullable Datatypes
* Safe Call Operator
* Helper für collections (`emptyList`, `mutableMapOf`)
* Scope Functions (`apply`)

## Allgemeines
Dieser REST Service nutzt `Spring Boot 2.4.1` und `Maven` als Build-Tool. Deshalb ist es nötig, dass ein `Java Jdk 11`,
`git`, sowie eine Entwicklungsumgebung installiert ist. In meinem Online-Kurs verwenden wir
[IntelliJ Idea Ultimate Edition](https://www.jetbrains.com/de-de/idea/download/), die 30 Tage gratis genutzt werden kann.

## Starten der Applikation
Nach einem Import in IntelliJ kann die `main` Methode der Startklasse `Java2kotlinApplication.java` ausgeführt werden.

## REST Schnittstellen
Der Service besitzt nur zwei REST Schnittstellen. Deshalb ist die Funktionalität des Services sehr limitiert.

### Customers API
Die Customers API besitzt einen `GET` Endpunkt, mit dem Kunden mit dazugehörigen Bestellungen abgefragt werden können.
```
http://localhost:8080/customers/{customerId}
```

### Price API
Mit der Price API kann für eine gegebene Order der Gesamtpreis abgefragt werden. Dazu muss ein Aufruf mit `GET` erfolgen.
```
http://localhost:8080/customers/{customerId}/orders/{orderId}/price
```
