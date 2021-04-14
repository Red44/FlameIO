package de.flamefoxes.flameio.find;

public interface IBracketOperator {

  IFind  andB();

  IFind orB();

  IFind  xorB();

  IFind  norB();

  IFind notB();

}
