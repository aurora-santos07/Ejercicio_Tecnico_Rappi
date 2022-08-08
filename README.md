# Ejercicio_Tecnico_Rappi
This repository contains an Android project that consumes a list of uncoming movies, top rated movies and recomended movies from https://developers.themoviedb.org services,k also show movie details and plays the movie's trailer selected

1. ¿En qué consiste el principio de responsabilidad única? ¿Cuál es su propósito?
  Consiste en que las clases o módulos deben cumplir con el único propósito para el que fueron hechos, lo que iimplica que si debe modificarse por más de una sola razón, 
  este principio no se está cumpliendo. Es importante para que el proyecto sea fácilmente mantenible, testeable y escalable

2. ¿Qué características tiene, según su opinión, un “buen” código o código limpio?
  Debe ser fácil de leer, las capas de modelo y vista deben ser fácilmente diferenciables y debe ser fácil de probar

3. Detalla cómo harías todo aquello que no hayas llegado a completar.
  Para el funcionamiento offline de la aplicación haría uso de Room para almacenar las respuestas de los servicios que se consumen para mostrar los listados de las películas
  Si al tratar de cargar estas listas no se contara con conexión a internet se consultaría la base, al contar con conexión se actualizaríala información y al consultar los detalles
  de las películas y obtener los links de los trailers se almacenarían para ser visualizados en caso de no tener el dispositivo con acceso a internet.
