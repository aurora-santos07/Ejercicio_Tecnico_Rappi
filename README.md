# Ejercicio_Tecnico_Rappi
This repository contains an Android project that consumes a list of uncoming movies, top rated movies and recomended movies from https://developers.themoviedb.org services,k also show movie details and plays the movie's trailer selected

1. ¿En qué consiste el principio de responsabilidad única? ¿Cuál es su propósito?
  Consiste en que las clases o módulos deben cumplir con el único propósito para el que fueron hechos, lo que iimplica que si debe modificarse por más de una sola razón, 
  este principio no se está cumpliendo. Es importante para que el proyecto sea fácilmente mantenible, testeable y escalable

2. ¿Qué características tiene, según su opinión, un “buen” código o código limpio?
  Debe ser fácil de leer, las capas de modelo y vista deben ser fácilmente diferenciables y debe ser fácil de probar

3. Detalla cómo harías todo aquello que no hayas llegado a completar.
  Agregaría los unit test del repository, viewmodels y usecases
  Cambiaría la caché de retrofit por Room para almacenar los datos de los servicios y consultando los servicios para actualizar esta información cada vez que se 
  entre a la aplicación y se cuente con conexión a internet, en todo momento se mostraría la información de la base de datos
