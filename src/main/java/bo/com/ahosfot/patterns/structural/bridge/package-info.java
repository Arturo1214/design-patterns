package bo.com.ahosfot.patterns.structural.bridge;
/***
 Bridge es un patrón de diseño estructural que divide la lógica de negocio o una clase muy grande
 en jerarquías de clases separadas que se pueden desarrollar independientemente.

 Una de estas jerarquías (a menudo denominada Abstracción) obtendrá una referencia a
 un objeto de la segunda jerarquía (Implementación). La abstracción podrá delegar
 algunas (en ocasiones, la mayoría) de sus llamadas al objeto de las implementaciones.
 Como todas las implementaciones tendrán una interfaz común, serán intercambiables dentro de la abstracción.
 * **/