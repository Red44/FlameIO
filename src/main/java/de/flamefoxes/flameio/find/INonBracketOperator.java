package de.flamefoxes.flameio.find;

public interface INonBracketOperator {

  IFindOperator and();

  IFindOperator or();

  IFindOperator xor();

  IFindOperator nor();

  IFindOperator not();

}
