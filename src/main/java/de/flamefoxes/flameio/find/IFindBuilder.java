package de.flamefoxes.flameio.find;

public interface IFindBuilder {

  IFindBuilder change(String adress,Object... values);

  IFindOperator build();

}
