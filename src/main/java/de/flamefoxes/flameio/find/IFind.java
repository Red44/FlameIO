package de.flamefoxes.flameio.find;

public interface IFind {

  IFindOperator eq(String name, Object value);

  IFindOperator exists(String name);

  IFindOperator exists(String... name);

  IFindOperator gt(String name,long value);

  IFindOperator lt(String name,long value);

  IFindOperator gte(String name,long value);

  IFindOperator lte(String name,long value);

  IFindOperator mod(String name,long mod);

  IFindOperator regex(String name,String pattern);

  IFindOperator text(String searchItem);

  IFindOperator eleMatch(String name);

  IFindOperator changeable(String adress);

  IFindOperator finish();

}
